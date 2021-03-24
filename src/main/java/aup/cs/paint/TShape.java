package aup.cs.paint;

public class TShape extends Shape{

    public TShape() throws ShapeIllegalArgumentException{
        this(10, 10);
    }

    public TShape(int height, int width) throws ShapeIllegalArgumentException{
        super(height, width);
        if(width < 3) {
            throw new ShapeIllegalArgumentException("T Shapes must have a width of at least 3");
        }
        if(width % 2 == 0){
            throw new ShapeIllegalArgumentException("T Shapes must have an odd width");
        }
        if(height < 2){
            throw new ShapeIllegalArgumentException("T Shapes must have a height of at least 2");
        }
    }

    public void printLine(int line){
        if(line == 1){
            printWidth('*');
        }
        else if(line <= getHeight()){
            printSpaces(getWidth()/2);
            printSymbol();
            printSpaces(getWidth()/2);
        }
        else{
            printWidth(' ');
        }
    }

}
