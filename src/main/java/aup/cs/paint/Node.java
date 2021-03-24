package aup.cs.paint;

import java.util.ArrayList;

public abstract class Node {
    private int height;
    private int width;
    private char printSymbol;

    public Node(){
        this(10, 10);
    }

    public Node(int height, int width){
        this.height = height;
        this.width = width;
    }

    protected void printSymbol(){
        System.out.print(printSymbol);
    }

    protected void printWidth(char c){
        for(int i = 0; i < getWidth(); i++){
            System.out.print(c);
        }
    }

    protected void printSpaces(int numOfSpaces){
        String spaces = new String(new char[numOfSpaces]).replace("\0", " ");
        System.out.print(spaces);
    }

    protected void printInterior(ArrayList<Node> nodes, int line){
        System.out.print("|");
        int acc = 0;
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).printLine(line-1);
            if(i < nodes.size() + 1){
                System.out.print(" ");
            }
            int widthHere = nodes.get(i).getWidth();
            acc += widthHere + 2;
        }
        int numOfSpaces = getWidth() - acc;
        printSpaces(numOfSpaces);
        System.out.print("|");
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
