package aup.cs.paint;

public abstract class Node {
    private int height;
    private int width;

    public Node(){
        this(10, 10);
    }

    public Node(int height, int width){
        this.height = height;
        this.width = width;
    }

    /**
     * prints to screen 1 line of the node (panel or shape)
     * @param line
     */
    public abstract void printLine(int line);

    public int getHeight(){
        return height;
    }

    public int getWidth() {
        return width;
    }
}
