package aup.cs.paint;

public class LShape extends Shape{

    public LShape(){
        this(10, 10);
    }

    public LShape(int height, int width){
        super(height, width);
    }

    public void printLine(int line){
        if(line == getHeight()){
            for(int i = 0; i < getWidth(); i++){
                System.out.print("*");
            }
        }
        else{
            String spaces = new String(new char[getWidth()-1]).replace("\0", "-");
            System.out.print("*" + spaces);
        }
    }

}
