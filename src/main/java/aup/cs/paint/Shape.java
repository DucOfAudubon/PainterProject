package aup.cs.paint;

public abstract class Shape extends Node{

    public Shape(){
        this(10, 10);
    }

    public Shape(int height, int width){
        super(height, width);
    }
}
