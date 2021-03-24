package aup.cs.paint;

public class ShapeIllegalArgumentException extends Exception{

    public ShapeIllegalArgumentException(){
        super("ShapeIllegalArgument Exception: error on execution");
    }

    public ShapeIllegalArgumentException(String msg){
        super("ShapeIllegalArgument Exception: error on execution " + msg);
    }
}
