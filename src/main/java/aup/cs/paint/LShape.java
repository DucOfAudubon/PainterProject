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
            for(int i = 0; i < getWidth(); i++){
                System.out.print("*");
            }
        }
        else if(line <= getHeight()){
            String spaces = new String(new char[getWidth()-1]).replace("\0", " ");
            System.out.print("*" + spaces);
        }
        else{
            String spaces2 = new String(new char[getWidth()]).replace("\0", " ");
            System.out.print(spaces2);
        }
    }

}
