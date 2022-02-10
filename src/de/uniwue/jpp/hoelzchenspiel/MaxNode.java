package de.uniwue.jpp.hoelzchenspiel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class MaxNode extends TreeNode{
    public MaxNode(int numberOfSticksLeft){
        super(numberOfSticksLeft);
    }
    @Override
    public int getValue(TreeNode parent) {
        //gibt das Maximum aller Bewertungen der Kinder zürück
        for(TreeNode child: getSuccessors()) {
            if(child.getValue(this)==1)
                return 1;
        }
        return -1;
    }
    @Override
    public TreeNode createChild(int numberOfSticksLeft) {
        return new MinNode(numberOfSticksLeft);
    }
    @Override
    public int getChildLeafValue() {
        return -1;
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
    public Collection<TreeNode> getSuccessors() {
        //Gibt die Kindknoten zurück
        ArrayList <TreeNode> successors = new ArrayList<>();
        if(numberOfSticksLeft > 3)
            successors.add(new MinNode(numberOfSticksLeft-3));
        if(numberOfSticksLeft > 2)
            successors.add(new MinNode(numberOfSticksLeft-2));
        if(numberOfSticksLeft > 1 )
            successors.add(new MinNode(numberOfSticksLeft-1));
        if(numberOfSticksLeft <= 3)
            successors.add(new Leaf());
        return successors;
    }
    @Override
    public Optional<Integer> getDrawWithHighestValueSuccessor() {
        //Gibt den Spielzug der zum Kindknoten mit der größten Bewertung führt zurück
        for (TreeNode child:getSuccessors()) {
            if(!child.getDrawWithHighestValueSuccessor().equals(Optional.empty())) //wird getestet ob das Optional getDrawWithHighestValueSuccessor leer ist
            {
                for (TreeNode max : getSuccessors()) { //Da die Kinder der Kinder Wieder +1 liefern können wir getValue anwenden
                    if (max.getValue(this) == 1)
                        return Optional.of(this.numberOfSticksLeft - child.numberOfSticksLeft);
                }
            }
        }
        return Optional.of(1);
    }
}
