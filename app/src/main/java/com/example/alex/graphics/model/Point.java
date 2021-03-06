package com.example.alex.graphics.model;

import java.io.Serializable;

public class Point implements Serializable {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public void operetion(double a, double b, double c, double d, double p, double q, double m, double n, double s){
        double x1 = x;
        double y1 = y;
        this.x = (a*x1+c*y1+m)/(x1*p+y1*q+s);
        this.y = (b*x1+d*y1+n)/(x1*p+y1*q+s);
    }

    public float getX() {
        return (float) x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public float getY() {
        return (float) y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void scale(double scale) {
        x *= (1 + scale);
        y *= (1 + scale);
    }

    public void rotate(double angle) {

        x = x * Math.cos(angle) + y * Math.sin(angle);
        y = -x * Math.sin(angle) + y * Math.cos(angle);
    }

    public void shift(double x1, double y1) {
        x += x1;
        y += y1;
    }

    public Point morf(double t, Point p){
        return new Point(x*(1-t) + p.x*t, y*(1-t) + p.y*t);
    }

    public Point mid(Point p){
        return new Point((x+p.x)/2, (y+p.y)/2);
    }
}
