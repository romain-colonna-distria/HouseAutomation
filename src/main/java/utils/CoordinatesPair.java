package utils;


public class CoordinatesPair {
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public CoordinatesPair(double x1, double y1){
        this.x1 = x1;
        this.y1 = y1;
    }

    public double getDistance(){
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public double getDistanceBetweenX(){
        return Math.abs(x1 - x2);
    }

    public double getDistanceBetweenY(){
        return Math.abs(y1 - y2);
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }
}
