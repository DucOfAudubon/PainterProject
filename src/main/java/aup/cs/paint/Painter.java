package aup.cs.paint;

public class Painter {
    private static Panel pane;

    public static void main(String[] args) {
        Painter p = new Painter();
        try{
            p.init();
            p.pane.sort();
            p.printToScreen();
        } catch (NodeOverflow no) {
            System.err.println("Elements overflow from painter");
        }
    }

    /**
     * Creates a pane and fills it with whatever Nodes you want
     * @throws NodeOverflow this happens if your Nodes are bigger than the panes they're inside of
     */
    private static void init() throws NodeOverflow {
        pane = new Panel(20,50);
        Panel pane2 = new Panel(12,40);
        try{
            pane.add(new TShape(15,5));
            pane2.add(new TShape(8,7));
            pane2.add(new LShape(5,3));
        } catch (ShapeIllegalArgumentException siae) {
            System.out.println("Could not construct shape: " + siae.getMessage());
        }
        pane.add(pane2);
    }

    /**
     * This just calls printLine for each line of the most outside Node
     */
    private static void printToScreen(){
        for(int i = 1; i <= pane.getHeight(); i++){
            pane.printLine(i);
            System.out.println("");
        }
    }
}
