/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment8;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;

/**
 * Model of the Drawing
 * @author gordbond
 */
public class Model {
    
    /**Array List Containing Geometric Objects**/
    public ArrayList<GeometricObject> o;
    
    /**
     * Constructor for Model.
     * No arguments, creates a new ArrayList
     */
    public Model (){o = new ArrayList<>();}
    
    /**
     * Method to draw each Geometric Object in the ArrayList "o"
     * @param gc 
     */
    public void draw(GraphicsContext gc){
        int i = o.size() - 1;// the index value for the last item in the array o
        for ( GeometricObject g : o) {
            if (g.getY() > 110 && g.getY() < 820 ){
                if (g instanceof Circle) {
                    ((Circle) g).draw(gc);
                }else if (g instanceof Rectangle) {
                    ((Rectangle) g).draw(gc);
                }
            }
        }
    }
    
    /**
     * Method to remove all the items from the ArrayList o
     */
    public void clear(){ o = new ArrayList<>();}
    
    
    /**
     * Method to remove the last object in the ArrayList o
     */
    public void undo(){
        int last = o.size() -1;// the index value of the last item in the ArrayList o
        o.remove(last);   
    }
    
    /**
     * Method to return the last Geometric Object in the ArrayList o
     * @return shape - the last Geometric Object in the ArrayList o
     */
    public GeometricObject getShape(){
        GeometricObject shape;// Local variable holding the last GeometricObjectA in the ArrayList o 
        int i = o.size() - 1;// the index value of the last item in the ArrayList o
        shape = o.get(i); 
        return shape;
    }
    
    /**
     * Method to create a new Circle Object and add it to the ArrayList o
     */
    public void createCircle(){o.add(new Circle());}
    
    /**
     * Method to create a new Rectangle Object and add it to the ArrayList o
     */
    public void createRectangle(){o.add(new Rectangle());}
    
    /**
     * Method to create a new Line Object and add it to the ArrayList o
     * THIS HAS NOT YET BEEN ADDED INTO THE PROGRAM
     */
    public void createLine(){o.add(new LineA());}
    
    
    /**
     * toString Method - String representation of the object
     * @return result - a String representation of the object
     */
    @Override
    public String toString(){
        String result = "";
        for (GeometricObject g : o){
            result += g.toString() + " ";
        }
        return result;
    }
}

