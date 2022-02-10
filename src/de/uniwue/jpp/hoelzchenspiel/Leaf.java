package de.uniwue.jpp.hoelzchenspiel;

import java.util.Collection;
import java.util.Optional;

public class Leaf extends TreeNode{

    public Leaf() {
        super(0);
    }
    @Override
    public int getValue(TreeNode parent){
        if(parent.getClass() == Leaf.class){
            throw new UnsupportedOperationException();
        }
        return parent.getChildLeafValue();
    }

    public Leaf(int numberOfSticksLeft) {
        super(numberOfSticksLeft);
    }

    @Override
    public TreeNode createChild(int numberOfSticksLeft) {
        return super.createChild(numberOfSticksLeft);
    }

    @Override
    public TreeNode createChildChecked(int sticksToTake) {
        return super.createChildChecked(sticksToTake);
    }

    @Override
    public int getNumberOfSticksLeft() {
        return super.getNumberOfSticksLeft();
    }

    @Override
    public int getChildLeafValue() {
        return super.getChildLeafValue();
    }

    @Override
    public Collection<TreeNode> getSuccessors() {
        return super.getSuccessors();
    }

    @Override
    public Optional<Integer> getDrawWithHighestValueSuccessor() {
        return super.getDrawWithHighestValueSuccessor();
    }
}
