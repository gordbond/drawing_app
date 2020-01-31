/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment8;

import javafx.scene.canvas.GraphicsContext;

/**
 * Circle Object
 * @author gordbond
 */
public class Circle extends GeometricObject implements Drawable{
    
    /**Radius for the Circle Object**/
    private double radius = 40;

    /**
     * Method to retrieve the radius of the circle object
     * @return radius - the current value of the radius object
     */
    public double getRadius() {
        return radius;
    }
    
    /**
     * Method to set the radius of the circle object
     * @param radius - the value of the new radius object
     */
    public void setRadius(double radius) {
            this.radius = radius;
    }
    
    /**
     * Method to draw the circle object
     * @param gc - Graphics Context 
     */
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getFillColor());
        gc.fillOval(getX() - radius, getY() - radius, radius * 2, radius * 2);
    }
    
    /**
     * toString Method - String representation of the object
     * @return result - a String representation of the object
     */
    @Override
    public String toString() {
        return "Circle{" + "radius=" + radius + '}';
    }
    
   
}
