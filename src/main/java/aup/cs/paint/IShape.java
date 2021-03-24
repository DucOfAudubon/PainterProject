package aup.cs.paint;

public class IShape extends Shape{

    public IShape() throws ShapeIllegalArgumentException{
        this(10, 10);
    }

    public IShape(int height, int width) throws ShapeIllegalArgumentException{
        super(height, width);
        if(width < 3) {
            throw new ShapeIllegalArgumentException("I Shapes must have a width of at least 3");
        }
        if(width % 2 == 0){
            throw new ShapeIllegalArgumentException("I Shapes must have an odd width");
        }
        if(height < 2){
            throw new ShapeIllegalArgumentException("I Shapes must have a height of at least 2");
        }
    }

    public void printLine(int line){
        if((line == 1) || (line == getHeight())){
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
