/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment8;



import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Main Program - Creates the GUI elements for the Drawing app
 * @author gordbond
 */
public class MainTest extends Application {
    
    //TO DO:
    //Make it so it draws within canvas
  
    //EXTRAS:
    //Add a line draw tool
    //Add a little logo
    //Add opacity
    //Add a triangle shape
    //Make it so you can place objects and move them
    //Make a brush
    //Insert a drawing
    
    
    ArrayList<GeometricObject> o;
    
    /**INSTANCE VARIABLES**/
    
    /** Button to undo last mark made **/
    private Button undoButton;
    
    /**Button to clear the canvas**/
    private Button clearButton;
    
    /**Drop down menu**/
    private ChoiceBox<String> shapes;
    
    /**Warning if no inputs for colors or size**/
    private Label check;
    
    /**Details about warning - What is specifically missing**/
    private Label details;
    
    /**Label for shapes menu**/
    private Label shapeLabel;
    
    /**Label for the size text fields**/
    private Label size;
    
    /**Label for the color text fields**/
    private Label color;
    
    /**Label for Radius**/
    private Label radiusLabel;
    
    /**Label for Height**/
    private Label heightLabel;
    
    /**Label for Width**/
    private Label widthLabel;
    
    /**Label for the red parameter**/
    private Label rLabel;
    
    /**Label for the green parameter**/
    private Label gLabel;
    
    /**Label for the blue parameter**/
    private Label bLabel;
    
    /**Model for the drawing app with most of the functionality**/
    private Model a;
    
    /**Graphics Context for drawing**/
    private GraphicsContext gc;
    
    /**Holds the most recent shape created**/
    private GeometricObject currentShape;
    
    /**Text input for red parameter**/
    private TextField r;
    
    /**Text input for green parameter**/
    private TextField g;
    
    /**Text input for blue parameter**/
    private TextField b;
    
    /**Text input for radius parameter**/
    private TextField radius;
    
    /**Text input for height parameter**/
    private TextField height;
    
    /**Text input for width parameter**/
    private TextField width;
    

    /**
     * Event handler for when the mouse is clicked.
     * Gets the X and Y values and sets them to the current shape
     * Draws the current shape where the mouse was clicked
     * @param me mouse event
     */
    private void clickHandler(MouseEvent me){
        double x = me.getX();
        double y = me.getY();
        errorMessage();
        shapeSetter();
        currentShape.setX(x);
        currentShape.setY(y);
        a.draw(gc);
    }
    
    /**
     * Event handler for when the mouse is clicked and dragged.
     * Gets the X and Y values and sets them to the current shape
     * Draws the current shape where the mouse was clicked
     * @param me mouse event
     */
    private void dragHandler(MouseEvent me){
        double x = me.getX();
        double y = me.getY();
        errorMessage();
        //if (currentShape instanceof RectangleA){ <---- Saving this for later modifications
        //    shapeSetter();
        //}
        shapeSetter();
        currentShape.setX(x);
        currentShape.setY(y);
        a.draw(gc);
    }
  
    
    /**
     * Method to redraw the canvas and current shapes/marks
     * Useful for the undo function
     */
    public void redraw(){
        gc.setFill(Color.LIGHTYELLOW);
        gc.fillRect(0, 0, 1500, 1300);
        gc.setFill(Color.SLATEGRAY);
        gc.fillRect(0, 0, 1500, 100);
        gc.setFill(Color.PINK);
        gc.fillRect(0, 830, 1500, 30);
        a.draw(gc);
    }

    /**
     * Method to determine which shape is selected and set the size and color
     * Includes a Try/Catch exception handler for if there are no inputs
     */
    private void shapeSetter(){
        try{
            check.setText("");
            String shapeSelected = shapes.getValue(); 
            switch (shapeSelected){
                case "Circle": 
                    a.createCircle();
                    currentShape = a.getShape();
                    ((Circle) currentShape).setRadius(getRadius());
                    ((Circle) currentShape).setFillColor(getR(), getG(), getB());
                    height.setText("");
                    width.setText("");
                    break;
                case "Rectangle":  
                    a.createRectangle();
                    currentShape = a.getShape();
                    ((Rectangle) currentShape).setHeight(getHeight());
                    ((Rectangle) currentShape).setWidth(getWidth());
                    ((Rectangle) currentShape).setFillColor(getR(), getG(), getB());
                    radius.setText("");
                    break;

                default: System.out.println("Shape setter method");      
            }
        }
        catch(Exception e){check.setText("WARNING: Missing inputs  ---->");}
    }
    
    
    /**
     * Event Handler for clearing the contents of the canvas.
     * Calls the model's clear method and redraws the canvas
     * @param e action event
     */
    private void clearHandler(ActionEvent e){
        a.clear();
        redraw();
    }
    
    /**
     * Event Handler for undoing the last mark/shape on the canvas.
     * Calls the model's undo method and redraws the canvas
     * @param e action event
     */
    private void undoHandler(ActionEvent e){
        a.undo();
        redraw();
    }
    
    /**
     * Method for determining which error is occurring and displays it for the user
     */
    private void errorMessage(){
        String result = "";
        if (r.getText().equals("") || g.getText().equals("") || b.getText().equals("")){
            result += " Missing color value.";   
        } else if ((getR() > 255 || getR()< 0)|| (getG() > 255 || getG()< 0) || (getB() > 255 || getB()< 0)){
                result += " Color values must be between 0 and 255. ";
            }  
        if (currentShape instanceof Circle && radius.getText().equals("")){
                result += " No radius value.";
        }
        if (currentShape instanceof Rectangle && height.getText().equals("")){
                result += " No height value.";
        }
        if (currentShape instanceof Rectangle && width.getText().equals("")){
                result += " No width value.";
        }
        details.setText(result);
    }
    
    /**
     * converts the text field string for the red parameter to an integer
     * @return result - the integer version of the textfield input
     */
    private int getR(){
        int result = Integer.parseInt(r.getText());
        return result;
    }
    
    /**
     * converts the text field string for the green parameter to an integer
     * @return result - the integer version of the textfield input
     */
    private int getG(){
        int result = Integer.parseInt(g.getText());
        return result;
    
        /**
     * converts the text field string for the blue parameter to an integer
     * @return result - the integer version of the textfield input
     */    
    }
    private int getB(){
        int result = Integer.parseInt(b.getText());
        return result;
    }
    
    /**
     * converts the text field string for the radius parameter to a double
     * @return result - the double version of the textfield input
     */
    private double getRadius(){
        double result = Double.parseDouble(radius.getText());
        return result;
    }
    
    /**
     * converts the text field string for the height parameter to a double
     * @return result - the double version of the textfield input
     */
    private double getHeight(){
        double result = Double.parseDouble(height.getText());
        return result;
    }
    
    /**
     * converts the text field string for the width parameter to a double
     * @return result - the double version of the textfield input
     */
    private double getWidth(){
        double result = Double.parseDouble(width.getText());
        return result;
    }
    
    
    /**
     * A method which creates the GUI 
     * @param stage
     * @throws java.lang.Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 1500, 1300); // set the size here
        stage.setTitle("Mouse Events"); // set the window title here
        stage.setScene(scene);
        Canvas c = new Canvas(1500, 1300);
        gc = c.getGraphicsContext2D();
        

        // 1. Create the model
        a = new Model(); 
        
        // 2. Create the GUI components
        
        undoButton = new Button("Undo");
        clearButton = new Button("Clear");
        shapes = new ChoiceBox<>();
        shapes.getItems().addAll("Circle","Rectangle"); //,"Line" <---try to add this
        shapes.setValue("Circle");
        check = new Label("Nothing Selected");
        details = new Label("");
        shapeLabel = new Label("SHAPE");
        size = new Label("SIZE");
        color = new Label("COLOUR");
        radiusLabel =new Label("Radius:");
        heightLabel =new Label("Height:");
        widthLabel =new Label("Width:");
        rLabel = new Label("r:");
        gLabel = new Label("g:");
        bLabel = new Label("b:");
        r = new TextField();
        g = new TextField();
        b = new TextField();
        radius = new TextField();
        height = new TextField();
        width = new TextField();
        
        // 3. Add components to the root
        root.getChildren().addAll(c, undoButton, clearButton, shapes, check, details, r, g, b,radius, width, height, shapeLabel, size, color, radiusLabel, heightLabel, widthLabel, rLabel, gLabel, bLabel);
        //okButton, <----- Not sure if I want an OK button

        // 4. Configure the components (colors, fonts, size, location)
        
        gc.setFill(Color.LIGHTYELLOW);//set background color
        gc.fillRect(0, 0, 1500, 1300); //create background 
        gc.setFill(Color.SLATEGRAY); //set top menu bar color
        gc.fillRect(0, 0, 1500, 100); //create top menu bar
        gc.setFill(Color.PINK); //set bottom alert bar color
        gc.fillRect(0, 830, 1500, 30); //create bottom alert bar
       
        undoButton.relocate(1220, 20); //move undo button to top menu bar
        undoButton.setPrefSize(60, 60); 
        clearButton.relocate(1310, 20); //move clear button to top menu bar
        clearButton.setPrefSize(60, 60);
        check.relocate(20, 835); //move warning to lower alert bar
        check.setStyle("-fx-font-family:Courier New;-fx-text-fill: #ff0000;-fx-font-size: 12"); //set font styles for warning
        details.relocate(250, 835); //move warning details to lower alert bar 
        details.setStyle("-fx-font-family:Courier New;-fx-text-fill: #ff0000;-fx-font-size: 12");
        shapeLabel.relocate(200,20);  //move shape menu label to upper menu bar
        shapeLabel.setStyle("-fx-font-family:Courier New;-fx-text-fill: #fff;-fx-font-size: 24");
        shapes.relocate(200, 50); //move shape menu to upper menu bar
        color.relocate(900, 20); //move color parameters label to upper menu bar
        color.setStyle("-fx-font-family:Courier New;-fx-text-fill: #fff;-fx-font-size: 24");
        rLabel.relocate(900, 55); //move red parameter label to upper menu bar
        rLabel.setStyle("-fx-font-family:Courier New;-fx-text-fill: #fff;-fx-font-size: 20");
        r.relocate(930, 50); //move red parameter textfield to upper menu bar
        r.setPrefSize(50, 30);
        gLabel.relocate(990, 55); //move green parameter label to upper menu bar
        gLabel.setStyle("-fx-font-family:Courier New;-fx-text-fill: #fff;-fx-font-size: 20");
        g.relocate(1020, 50); //move green parameter textfield to upper menu bar
        g.setPrefSize(50, 30);
        bLabel.relocate(1080, 55);//move blue parameter label to upper menu bar
        bLabel.setStyle("-fx-font-family:Courier New;-fx-text-fill: #fff;-fx-font-size: 20");
        b.relocate(1110, 50);//move blue parameter textfield to upper menu bar
        b.setPrefSize(50, 30);
        size.relocate(380, 20);//move size label to upper menu bar
        size.setStyle("-fx-font-family:Courier New;-fx-text-fill: #fff;-fx-font-size: 24");
        radiusLabel.relocate(380, 55);//move radius parameter label to upper menu bar
        radiusLabel.setStyle("-fx-font-family:Courier New;-fx-text-fill: #fff;-fx-font-size: 20");
        radius.relocate(470, 50); //move radius parameter textfield to upper menu bar
        radius.setPrefSize(60, 30);
        heightLabel.relocate(540, 55); //move height parameter label to upper menu bar
        heightLabel.setStyle("-fx-font-family:Courier New;-fx-text-fill: #fff;-fx-font-size: 20");
        height.relocate(630, 50);//move height parameter textfield to upper menu bar
        height.setPrefSize(60, 30);
        widthLabel.relocate(700, 55);//move width parameter label to upper menu bar
        widthLabel.setStyle("-fx-font-family:Courier New;-fx-text-fill: #fff;-fx-font-size: 20");
        width.relocate(780, 50);//move width parameter textfield to upper menu bar
        width.setPrefSize(60, 30);
        
        // 5. Add Event Handlers
        /**Event handler calls clickHandler when mouse clicked**/
        c.addEventHandler(MouseEvent.MOUSE_CLICKED, this::clickHandler); 
        
        /**Event handler calls undoHandler when undo button pressed**/
        undoButton.setOnAction(this::undoHandler);
        
       /**Event handler calls clearHandler when clear button pressed**/
        clearButton.setOnAction(this::clearHandler);
        
        /**Event handler calls dragHandler when mouse is dragged**/
        c.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::dragHandler);
        
        
        // 6. Show the stage
        stage.show();
        
    }
    
    /**
     * The actual main method that launches the app.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}