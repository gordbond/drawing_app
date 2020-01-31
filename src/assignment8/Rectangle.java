/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment8;

import javafx.scene.canvas.GraphicsContext;

/**
 * Rectangle Object
 * @author gordbond
 */
public class Rectangle extends GeometricObject implements Drawable{
    
    /**Width and Height values**/
    private double width = 200, height = 100;
    
    /**
     * Method to retrieve the width for the rectangle object
     * @return width value for rectangle object
     */
    public double getWidth() {return width;}
    
    /**
     * Method to set the width value for the rectangle object
     * @param width value for rectangle object
     */
    public void setWidth(double width) {
        if (width <= 0) {
            System.out.println("ERROR! Width must be greater than 0. Not changed.");
        } else {
            this.width = width;
        }
    }
    
    /**
     * Method to retrieve the height for the rectangle object
     * @return height value for rectangle object
     */
    public double getHeight() {return height;}
    
    
    /**
     * Method to set the height value for the rectangle object
     * @param height value for rectangle object
     */
    public void setHeight(double height) {
        if (height <= 0) {
            System.out.println("ERROR! Height must be greater than 0. Not changed.");
        } else {
            this.height = height;
        }
    }
   
    /**
     * Method to draw the rectangle object
     * @param gc - Graphics Context 
     */
    public void draw(GraphicsContext gc) {
        gc.setFill(getFillColor());
        gc.fillRect(getX() - width / 2.0, getY() - height / 2.0, width, height);
    }
    
    /**
     * toString Method - String representation of the object
     * @return result - a String representation of the object
     */
    @Override
    public String toString() {
        return "Rectangle{" + "width=" + width + ", height=" + height + '}';
    }

}
