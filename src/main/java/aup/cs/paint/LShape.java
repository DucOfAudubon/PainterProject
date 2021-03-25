package aup.cs.paint;

public class LShape extends Shape{

    public LShape() throws ShapeIllegalArgumentException{
        this(10, 10);
    }

    /**
     * Self explanatory. If you're confused, read the exception messages?
     * @param height
     * @param width
     * @throws ShapeIllegalArgumentException
     */
    public LShape(int height, int width) throws ShapeIllegalArgumentException{
        super(height, width);
        if(width < 2) {
            throw new ShapeIllegalArgumentException("L Shapes must have a width of at least 2");
        }
        if(height < 2){
            throw new ShapeIllegalArgumentException("L Shapes must have a height of at least 2");
        }
    }

    /**
     * L Shapes are made by a left-justified vertical line as long as height - 1
     * The last line is a solid horizontal line as long as the width
     * @param line the line number. Ordinarily, this method would be looped for the whole height of the Node
     */
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
