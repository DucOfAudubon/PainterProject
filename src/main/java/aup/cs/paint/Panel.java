package aup.cs.paint;

import java.util.ArrayList;

public class Panel extends Node{
    private ArrayList<Node> nodes;

    public Panel(){
        this(10, 10);
    }

    public Panel(int height, int width){
        super(height, width);
        this.nodes = new ArrayList<Node>();
    }

    public void add(Node nodeToAdd){
        this.nodes.add(nodeToAdd);
    }

    public void printLine(int line){
        if((line == 1) || (line == getHeight())){
            for(int i = 0; i < getWidth(); i++){
                System.out.print("-");
            }
        }
        else if(line <= getHeight()){
             System.out.print("|");
             int acc = 0;
             for (int i = 0; i < nodes.size(); i++) {
                 nodes.get(i).printLine(line-1);
                 System.out.print(" ");
                 int widthHere = nodes.get(i).getWidth();
                 acc += widthHere + 2;
             }
             int numOfSpaces = getWidth() - acc;
             String spaces = new String(new char[numOfSpaces]).replace("\0", " ");
             System.out.print(spaces);
             System.out.print("|");
        }
        else{
            String spaces2 = new String(new char[getWidth()]).replace("\0", " ");
            System.out.print(spaces2);
        }
    }
}
