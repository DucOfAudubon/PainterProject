package aup.cs.paint;

public class IShape extends Shape{

    public IShape() throws ShapeIllegalArgumentException{
        this(10, 10);
    }

    /**
     * Self explanatory. If you're confused, read the exception messages?
     * @param height
     * @param width
     * @throws ShapeIllegalArgumentException
     */
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

    /**
     * T shapes are made by a solid horizontal line their width
     * followed by a centered vertical line as long as their height - 2
     * followed by another horizontal width-long line
     * This is accomplished by printing the horizontal lines if it's their first or last line
     * and printing a vertical centered line if not
     * @param line the line number. Ordinarily, this method would be looped for the whole height of the Node
     */
    public void printLine(int line){
        if((line == 1) || (line == getHeight())){
            printWidth('*');
        }
        else if(line <= getHeight()){
            printSpaces(getWidth()/2); //Since width is an odd int, having this on either side leaves 1 space in the center
            printSymbol();
            printSpaces(getWidth()/2);
        }
        else{
            printWidth(' ');
        }
    }

}
