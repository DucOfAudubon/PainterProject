package aup.cs.paint;

public class LShape extends Shape{

    public LShape() throws ShapeIllegalArgumentException{
        this(10, 10);
    }

    public LShape(int height, int width) throws ShapeIllegalArgumentException{
        super(height, width);
        if(width < 2) {
            throw new ShapeIllegalArgumentException("L Shapes must have a width of at least 2");
        }
        if(height < 2){
            throw new ShapeIllegalArgumentException("L Shapes must have a height of at least 2");
        }
    }

    public void printLine(int line){
        if(line == getHeight()){
            printWidth('*');
        }
        else if(line <= getHeight()){
            printSymbol();
            printSpaces(getWidth()-1);
        }
        else{
            printWidth(' ');
        }
    }

}
