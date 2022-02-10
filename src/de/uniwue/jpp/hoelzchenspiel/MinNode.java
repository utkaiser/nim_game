package de.uniwue.jpp.hoelzchenspiel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class MinNode extends TreeNode{
    public MinNode(int numberOfSticksLeft){
        super(numberOfSticksLeft);
    }

    @Override
    public int getValue(TreeNode parent) {
        //Gibt Minimum aller Bewertungen der Kindknoten zurück
        for (TreeNode child: getSuccessors()) {
            if(child.getValue(this)==-1)
                return -1;
        }
        return 1;
    }
    @Override
    public TreeNode createChild(int numberOfSticksLeft) {
        return new MaxNode(numberOfSticksLeft);
    }

    @Override
    public int getChildLeafValue() {
        return 1;
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
        ArrayList<TreeNode> successors = new ArrayList<>();
        if(numberOfSticksLeft > 3)
            successors.add(new MaxNode(numberOfSticksLeft-3));
        if(numberOfSticksLeft > 2)
            successors.add(new MaxNode(numberOfSticksLeft-2));
        if(numberOfSticksLeft > 1 )
            successors.add(new MaxNode(numberOfSticksLeft-1));
        if(numberOfSticksLeft <= 3)
            successors.add(new Leaf());
        return successors;
    }

    @Override
    public Optional<Integer> getDrawWithHighestValueSuccessor() {
        //Gibt den Spielzug der zum Kindknoten mit der größten Bewertung führt zurück
        for (TreeNode child:getSuccessors()) {
            if(child.getValue(this) == 1) // gibt es immer wirklich den größten Wert zurück, vergleiche MaxNode.getValue
                return Optional.of(this.numberOfSticksLeft-child.numberOfSticksLeft); // Return den zug der zu diesem Kind geführt hat
        }
        return Optional.of(1); // falls in der Forschleife nichts gefunden wird, geben wir einfach den ersten aus da alle Wege zu minus 1 führen
    }
}
