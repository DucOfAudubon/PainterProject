package aup.cs.paint;

public class Painter {
    private static Panel pane;

    public static void main(String[] args) {
        Painter p = new Painter();
        try{
            p.init();
            p.printToScreen();
        } catch (NodeOverflow no) {
            System.err.println("Elements overflow from painter");
        }
    }

    private static void init() throws NodeOverflow {
        pane = new Panel(20,30);
        Panel pane2 = new Panel(10,20);
        try{
            pane.add(new TShape(3,5));
            pane2.add(new TShape(8,7));
            pane2.add(new LShape(5,3));
        } catch (ShapeIllegalArgumentException siae) {
            System.out.println("Could not construct shape: " + siae.getMessage());
        }
        pane.add(pane2);
    }

    private static void printToScreen(){
        for(int i = 1; i <= pane.getHeight(); i++){
            pane.printLine(i);
        }
    }
}
