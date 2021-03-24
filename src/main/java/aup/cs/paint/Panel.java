package aup.cs.paint;

import java.util.ArrayList;

public class Panel extends Node{
    private ArrayList<Node> nodes;

    public Panel(){
        this(10, 10);
    }

    public Panel(int height, int width){
        super(height, width);
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
        else{
             System.out.print("|");
             for (int i = 0; i < nodes.size(); i++) {
                 nodes.get(i).printLine(line-1);
             }
             System.out.println("|");
        }
    }
}
