/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment8;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author gordbond
 */
public class LineA extends GeometricObject implements Drawable{
    
    private double x2 = 50, y2 =40;
   
    public double getX2() {
        return x2;
    }
    
    public void setX2(double x) {
        this.x2 = x2;
    }
    
    public double getY2() {
        return y2;
    }
    
    public void setY2(double x) {
        this.y2 = y2;
    }
    
    @Override
    public void draw(GraphicsContext gc) {
       // gc.setStroke(getStrokeColor());
        //gc.setLineWidth(getLineWidth());
        gc.strokeLine(getX(), getY(), getX2(), getY2());
        
    }
    
    @Override
    public String toString(){
        return "LINE x: " + super.getX() + "y: " + super.getY() + "x2: " + getX2() + "y2: " + getY2();
    }
    
}
