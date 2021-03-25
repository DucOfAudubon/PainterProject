package aup.cs.paint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Panel extends Node{
    private ArrayList<Node> nodes;
    private int containedWidth = 1;

    public Panel(){
        this(10, 10);
    }

    public Panel(int height, int width){
        super(height, width);
        this.nodes = new ArrayList<Node>();
    }

    public void add(Node nodeToAdd) throws NodeOverflow {
        nodes.add(nodeToAdd);
        containedWidth += nodeToAdd.getWidth() + 1;
        if(containedWidth >= getWidth() - 1 || nodeToAdd.getHeight() >= getHeight() - 1){
            throw new NodeOverflow();
        }
    }

    public void printLine(int line){
        if((line == 1) || (line == getHeight())){
            printWidth('-');
        }
        else if(line <= getHeight()){
            printInterior(nodes, line);
        }
        else{
            printSpaces(getWidth());
        }
    }

    @Override
    public void sort(){
        Collections.sort(nodes, new Comparator<Node>(){
            public int compare(Node n1, Node n2) {
                return n1.getHeight() - n2.getHeight();
            }
        });
        for(Node n : nodes){
            n.sort();
        }
    }
}
