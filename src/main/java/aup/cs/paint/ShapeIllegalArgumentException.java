package aup.cs.paint;

public class ShapeIllegalArgumentException extends Exception{

    public ShapeIllegalArgumentException(){
        super("ShapeIllegalArgument Exception: ");
    }

    public ShapeIllegalArgumentException(String msg){
        super("ShapeIllegalArgument Exception: " + msg);
    }
}
