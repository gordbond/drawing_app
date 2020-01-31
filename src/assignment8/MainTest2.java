/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment8;



import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
//import static javafx.application.Application.launch;
/**
 *
 * @author gordbond
 */
public class MainTest2 extends Application {
    
    //TO DO:
    //Make it look nice
    //Undo function
    //Error Handling
    //Documentation
    //EXTRAS:
    //Add a line draw tool
    //Add Clear function
    
    
    ArrayList<GeometricObject> o;
    
    Button okButton;
    Button undoButton;
    Button clearButton;
    ChoiceBox<String> shapes;
    Label check;
    Label shapeLabel;
    Label size;
    Label color;
    Label radiusLabel;
    Label heightLabel;
    Label widthLabel;
    Label rLabel;
    Label gLabel;
    Label bLabel;
    Model2 a;
    GraphicsContext gc;
    GeometricObject currentShape;
    TextField r;
    TextField g;
    TextField b;
    TextField radius;
    TextField height;
    TextField width;
    
   
    
   /**
    * A method to reset the game and start a new one
    * Called when the "New Game" button is pressed
    * @param e 
    */
    private void clickHandler(MouseEvent me){
        double x = me.getX();
        double y = me.getY();
        //shapeSetter();
        currentShape.setX(x);
        currentShape.setY(y);
      
        a.draw(gc);
        
    }

    
    
    private void dragHandler(MouseEvent me){
        
        double x = me.getX();
        double y = me.getY();
        //shapeSetter();
        currentShape.setX(x);
        currentShape.setY(y);
        
        a.draw(gc);
    }
    
    /*
    private void dragEndHandler(MouseDragEvent md){
        ((LineA) currentShape).setX2(md.getX());
        ((LineA) currentShape).setY2(md.getY());
    }
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
    
    
    
    
    private void shapeSetter(){
        String shapeSelected = shapes.getValue(); 
        check.setText(shapeSelected);
        switch (shapeSelected){
            case "Circle": 
                a.createCircle();
                currentShape = a.getShape();
                ((Circle) currentShape).setRadius(getRadius());
                ((Circle) currentShape).setFillColor(getR(), getG(), getB());
                
                System.out.println(a.toString());
                check.setText(a.toString());
                break;
            case "Rectangle":  
                a.createRectangle();
                currentShape = a.getShape();
                ((Rectangle) currentShape).setHeight(getHeight());
                ((Rectangle) currentShape).setWidth(getWidth());
                ((Rectangle) currentShape).setFillColor(getR(), getG(), getB());
                a.printList();
                System.out.println(a.toString());
                check.setText(a.toString());
                
                break;
            
            default: System.out.println("ERROR in OK Handler");
                
        }
    }
    
    private void clearHandler(ActionEvent e){
        gc.setFill(Color.LIGHTYELLOW);
        gc.fillRect(0, 0, 1500, 1300);
        gc.setFill(Color.SLATEGRAY);
        gc.fillRect(0, 0, 1500, 100);
        gc.setFill(Color.PINK);
        gc.fillRect(0, 830, 1500, 30);
        a.clear();
    }
    
    private void okHandler(ActionEvent e){
        shapeSetter();
    }
    
    private void undoHandler(ActionEvent e){
        a.undo();
        redraw();
        
    }
    
    private int getR(){
        int result = Integer.parseInt(r.getText());
        return result;
        
    }
    private int getG(){
        int result = Integer.parseInt(g.getText());
        return result;
        
    }
    private int getB(){
        int result = Integer.parseInt(b.getText());
        return result;
    }
    
    private double getRadius(){
        double result = Double.parseDouble(radius.getText());
        return result;
    }
    
    private double getHeight(){
        double result = Double.parseDouble(height.getText());
        return result;
    }
    
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
        // TODO: Add your GUI-building code here

        // 1. Create the model
        o = new ArrayList();
        o.add( new Circle() );
        o.add( new Rectangle() );
        
        // 2. Create the GUI components
        
        okButton = new Button("OK");
        undoButton = new Button("Undo");
        clearButton = new Button("Clear");
        shapes = new ChoiceBox<>();
        shapes.getItems().addAll("Circle","Rectangle"); //,"Line" <---try to add this
        shapes.setValue("Circle");
        check = new Label("Nothing Selected");
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
        a = new Model2();
        // 3. Add components to the root
        root.getChildren().addAll(c, okButton, undoButton, clearButton, shapes, check, r, g, b,radius, width, height, shapeLabel, size, color, radiusLabel, heightLabel, widthLabel, rLabel, gLabel, bLabel);
        // 4. Configure the components (colors, fonts, size, location)
        
        gc.setFill(Color.LIGHTYELLOW);
        gc.fillRect(0, 0, 1500, 1300);
        gc.setFill(Color.SLATEGRAY);
        gc.fillRect(0, 0, 1500, 100);
        gc.setFill(Color.PINK);
        gc.fillRect(0, 830, 1500, 30);
        
        okButton.relocate(1210, 20);
        okButton.setPrefSize(60, 60);
        undoButton.relocate(1280, 20);
        undoButton.setPrefSize(60, 60);
        clearButton.relocate(1350, 20);
        clearButton.setPrefSize(60, 60);
        check.setStyle("-fx-font-family:Courier New;-fx-text-fill: #fff;-fx-font-size: 10");
        shapeLabel.relocate(200,20);
        shapeLabel.setStyle("-fx-font-family:Courier New;-fx-text-fill: #fff;-fx-font-size: 24");
        shapes.relocate(200, 50);
        check.relocate(20, 835);
        color.relocate(900, 20);
        color.setStyle("-fx-font-family:Courier New;-fx-text-fill: #fff;-fx-font-size: 24");
        rLabel.relocate(900, 55);
        rLabel.setStyle("-fx-font-family:Courier New;-fx-text-fill: #fff;-fx-font-size: 20");
        r.relocate(930, 50);
        r.setPrefSize(50, 30);
        gLabel.relocate(990, 55);
        gLabel.setStyle("-fx-font-family:Courier New;-fx-text-fill: #fff;-fx-font-size: 20");
        g.relocate(1020, 50);
        g.setPrefSize(50, 30);
        bLabel.relocate(1080, 55);
        bLabel.setStyle("-fx-font-family:Courier New;-fx-text-fill: #fff;-fx-font-size: 20");
        b.relocate(1110, 50);
        b.setPrefSize(50, 30);
        size.relocate(380, 20);
        size.setStyle("-fx-font-family:Courier New;-fx-text-fill: #fff;-fx-font-size: 24");
        radiusLabel.relocate(380, 55);
        radiusLabel.setStyle("-fx-font-family:Courier New;-fx-text-fill: #fff;-fx-font-size: 20");
        radius.relocate(470, 50);
        radius.setPrefSize(60, 30);
        heightLabel.relocate(540, 55);
        heightLabel.setStyle("-fx-font-family:Courier New;-fx-text-fill: #fff;-fx-font-size: 20");
        height.relocate(630, 50);
        height.setPrefSize(60, 30);
        widthLabel.relocate(700, 55);
        widthLabel.setStyle("-fx-font-family:Courier New;-fx-text-fill: #fff;-fx-font-size: 20");
        width.relocate(780, 50);
        width.setPrefSize(60, 30);
        // 5. Add Event Handlers and do final setup
        c.addEventHandler(MouseEvent.MOUSE_CLICKED, this::clickHandler);
        okButton.setOnAction(this::okHandler);
        undoButton.setOnAction(this::undoHandler);
        clearButton.setOnAction(this::clearHandler);
        //c.addEventHandler(MouseEvent.MOUSE_RELEASED, this::releaseHandler);
        //c.addEventHandler(MouseEvent.MOUSE_PRESSED, this::pressHandler);
        c.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::dragHandler);
        //c.addEventHandler(MouseDragEvent.MOUSE_DRAG_RELEASED, this::dragEndHandler);
        //c.addEventHandler(MouseEvent.MOUSE_MOVED, this::moveHandler);
        //c.addEventHandler(MouseEvent.MOUSE_ENTERED, this::enterHandler);
        //c.addEventHandler(MouseEvent.MOUSE_EXITED, this::exitHandler);
        
        
        // 6. Show the stage
        stage.show();
        
    }
    
    
    
    
    
    
    
    
    
    
        /**
     * Start method (use this instead of main).
     *
     * @param stage The FX stage to draw on
     * @throws Exception
     */
    /*
    @Override
    public void start(Stage stage) throws Exception {
        
        
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(1400, 1300); // Set canvas Size in Pixels
        stage.setTitle("Draw"); // Set window title
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        ArrayList<GeometricObjectA> objs = new ArrayList<>();
        
        
        objs.add( new CircleA() );
        objs.add( new RectangleA() );
        
        
        objs.get(0).setX(80);
        objs.get(1).setX(250);
        
      
        
        
        //Is this thing a Circle...yes? draw it
        for ( GeometricObjectA g : objs) {
            if (g instanceof CircleA) {
                //((Circle) objs.get(0)).draw(gc);
                ((CircleA) g).draw(gc);
                System.out.println(((CircleA) g));
            }else if (g instanceof RectangleA) {
                ((RectangleA) g).draw(gc);
                System.out.println(((RectangleA) g));
            }
        }
        
          stage.show();
        
    }
    */
    /**
     * The actual main method that launches the app.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}