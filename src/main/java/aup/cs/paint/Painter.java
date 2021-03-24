package aup.cs.paint;

public class Painter {
    private static Panel pane;

    public static void main(String[] args){
        Painter p = new Painter();
        p.init();
        p.printToScreen();
    }

    public static void init(){
        pane = new Panel(20,30);
        Panel pane2 = new Panel(10,20);
        pane.add(new TShape(3,5));
        pane2.add(new TShape(8,7));
        pane2.add(new LShape(5,3));
        pane.add(pane2);

    }

    public static void printToScreen(){
        for(int i = 1; i <= pane.getHeight(); i++){
            pane.printLine(i);
        }
    }
}
