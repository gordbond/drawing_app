/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment8;

import javafx.scene.paint.Color;

/**
 * Geometric Object Class.
 * Contains the essential properties for a Geometric Object
 * @author gordbond
 */
public class GeometricObject {
    /** X and Y positions **/
    private double x = 0, y = 0;
    
    /** Fill Color for Shape **/
    private Color fillColor = Color.BLACK;
   
    /**
     * Retrieves the x position
     * @return x - a double  
     */
    public double getX() { return x;}
    
    /**
     * Method to set the X position
     * @param x - double to be used for new x value
     */
    public void setX(double x) {this.x = x; }
    
    /**
     * Retrieves the y position
     * @return y - a double  
     */
    public double getY() {return y;}
    
    /**
     * Method to set the X position
     * @param x - double to be used for new x value
     */
    public void setY(double y) {this.y = y;}
    
    /**
     * Method to retrieve the fill color
     * @return fill color of this object
     */
    public Color getFillColor() {return fillColor;}
    
    /**
     * Method to set the fill color
     * @param r - int for new red parameter
     * @param g - int for new green parameter
     * @param b - int for new blue parameter
     */
    public void setFillColor(int r, int g, int b) {
        this.fillColor = Color.rgb(r, g, b);
    }
    
    /**
     * toString Method - String representation of the object
     * @return result - a String representation of the object
     */
    @Override
    public String toString() {
        return "GeometricObject{" + "x=" + x + ", y=" + y +  ", fillColor=" + fillColor + '}';
    }

}
    

