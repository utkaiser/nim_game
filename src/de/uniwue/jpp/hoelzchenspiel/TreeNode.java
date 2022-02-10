package de.uniwue.jpp.hoelzchenspiel;
import java.util.*;


public abstract class TreeNode {
    public int numberOfSticksLeft;

    public TreeNode(int numberOfSticksLeft){
        //Konstruktor
        this.numberOfSticksLeft = numberOfSticksLeft;
        if(numberOfSticksLeft < 0){
            throw new IllegalArgumentException("The numberOfSticksLeft is less than 0.");
        }
    }
    public TreeNode createChild(int numberOfSticksLeft){
        //Wenn diese Methode nicht überschrieben wird, wird die Exception geworfen
            throw new UnsupportedOperationException();
    }
    public TreeNode createChildChecked(int sticksToTake){
        // Falls der Zug gültig ist, wird Kindknoten in abhängigkeit des Types mit numberOfSticksLeft zurückgegeben
        if(sticksToTake <= 0 || sticksToTake > 3 ){
            throw new IllegalArgumentException("This is an invalid draw");
        }else if(getNumberOfSticksLeft() < sticksToTake){
            throw new IllegalArgumentException("numberOfSticksLeft can't be less than 0");

        }else if(getNumberOfSticksLeft()==sticksToTake){
            return new Leaf(0);

        }else if (this.getClass() == MaxNode.class){
            return new MinNode(getNumberOfSticksLeft()-sticksToTake);
        }else{
            return new MaxNode(getNumberOfSticksLeft()-sticksToTake);
        }
    }
    public abstract int getValue(TreeNode parent); //wird in Max, MinNode und Leaf überschrieben
    public int getNumberOfSticksLeft(){
        return numberOfSticksLeft;
    }
    public int getChildLeafValue() {
            throw new UnsupportedOperationException(); //Wenn nicht überschrieben wird
    }
    public Collection <TreeNode> getSuccessors(){
        // wird in Max und MinNode überschrieben
        ArrayList <TreeNode> successors = new ArrayList<>();
        return successors;
    };
    public Optional <Integer> getDrawWithHighestValueSuccessor(){
        return Optional.empty(); // Falls es Leaf sonst wird es in Max und MinNode überschrieben

    }

}

