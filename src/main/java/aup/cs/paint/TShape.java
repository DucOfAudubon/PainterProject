package aup.cs.paint;

public class TShape extends Shape{

    public TShape(){
        this(10, 10);
    }

    public TShape(int height, int width){
        super(height, width);
    }

    public void printLine(int line){
        if(line == 1){
            for(int i = 0; i < getWidth(); i++){
                System.out.print("*");
            }
        }
        else{
            String spaces = new String(new char[getWidth()/2]).replace("\0", "-");
            System.out.print(spaces + "*" + spaces);
        }
    }

}
