package aup.cs.paint;

import java.util.ArrayList;

public abstract class Node implements Cloneable{
    private int height;
    private int width;
    protected char printSymbol; //This will be the character used to represent the Node. Made it a Node variable so that if you want something other than Shapes, you can redesign it

    /**
     * I figure a default size of 10 is fine
     */
    public Node(){
        this(10, 10);
    }

    /**
     * Self-explanatory
     * @param height
     * @param width
     */
    public Node(int height, int width){
        this.height = height;
        this.width = width;
    }

    /**
     * This prints out one instance of the appropriate symbol for the Node
     */
    protected void printSymbol(){
        System.out.print(printSymbol);
    }

    /**
     * This prints a line of the called character the width of the Node
     * @param c
     */
    protected void printWidth(char c){
        for(int i = 0; i < getWidth(); i++){
            System.out.print(c);
        }
    }

    /**
     * Nodes take up space even where they don't have other characters printed
     * this allows for that space
     * @param numOfSpaces is the size of the space needed to print
     */
    protected void printSpaces(int numOfSpaces){
        String spaces = new String(new char[numOfSpaces]).replace("\0", " ");
        System.out.print(spaces);
    }

    /**
     * This is really for Nodes like Panels, which have interiors bordered by walls of |
     * Wow it really bothers me that | is italicized
     * Like, I know it should be, because this is italics, but its whole thing is being straight vertical
     * Anyway, it's not a /
     * This method prints a left wall |
     * Then it prints the line lines of any contained Nodes to this Node
     * It uses line - 1 because the first line of this Node is probably a ceiling of some kind
     * This is, after all, an interior
     * It also prints spaces between contained Nodes
     * It then prints a number of spaces to make up the difference between what's been printed and the actual width of the Node
     * @param nodes an ArrayList of the contained Nodes in the interior
     * @param line
     */
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
     * Pretty basic cloning method
     * Takes a node, makes a shallow clone, then replaces the fields with new but identical fields
     * @return
     * @throws CloneNotSupportedException
     */
    public Node clone() throws CloneNotSupportedException {
        Node clonedNode = (Node) super.clone();
        clonedNode.height = this.height;
        clonedNode.width = this.width;
        return clonedNode;
    }

    /**
     * prints to screen 1 line of the node (panel or shape)
     * Probably calls all the other methods
     * @param line the line number. Ordinarily, this method would be looped for the whole height of the Node
     */
    public abstract void printLine(int line);

    /**
     * Most Nodes won't have a real sort method that does anything
     * but for the purpose of recursion, they need a sort method that does nothing
     */
    public void sort(){}

    public int getHeight(){
        return height;
    }

    public int getWidth() {
        return width;
    }
}
