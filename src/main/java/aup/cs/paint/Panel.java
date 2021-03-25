package aup.cs.paint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Panel extends Node{
    private ArrayList<Node> nodes;
    private int containedWidth = 1; //This is how we'll make sure the contained Nodes aren't too large

    public Panel(){
        this(10, 10);
    }

    public Panel(int height, int width){
        super(height, width);
        this.nodes = new ArrayList<Node>();
    }

    /**
     * Adds a Node to be contained within the panel
     * @param nodeToAdd
     * @throws NodeOverflow If the Node is too big for the Panel to hold, considering its other Nodes and the spaces in between
     * Still working out bugs with the exact numbering. Needs to consider walls '|', contained Nodes, and 1 space between each one but not after the last node
     */
    public void add(Node nodeToAdd) throws NodeOverflow {
        nodes.add(nodeToAdd);
        containedWidth += nodeToAdd.getWidth() + 1;
        if(containedWidth >= getWidth() - 1 || nodeToAdd.getHeight() >= getHeight() - 1){
            throw new NodeOverflow();
        }
    }

    /**
     * For this print line, it prints a line of - for the first and last lines
     * Otherwise, it prints the interior
     * If it's contained by something larger, it will print spaces beneath it because that's our current implementation
     * No Nodes on top of one another
     * @param line the line number. Ordinarily, this method would be looped for the whole height of the Node
     */
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

    /**
     * Uses an anonymous Comparator to sort the contained Nodes by height
     * Then, calls sort on each contained Node, so that any contained Panels also get sorted
     */
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
