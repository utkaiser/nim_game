package de.uniwue.jpp.hoelzchenspiel;

import java.util.Optional;

public class AIPlayer implements Player {
    @Override
    public String getName() {
        return "";
    }

    @Override
    public int takeSticks(int numberOfSticksAvailableInTheGame) {
        // Wählt den günstigsten aller Spielzüge aus
        MaxNode node = new MaxNode(numberOfSticksAvailableInTheGame);
        Optional zug = node.getDrawWithHighestValueSuccessor();
        if (zug.equals(Optional.empty()))
            return 1;
        MinNode min1 = new MinNode(numberOfSticksAvailableInTheGame-1); // Mit MinNode um zu testen ob es einen Zug gibt mit dem Man sicher gewinnt
        MinNode min2 = new MinNode(numberOfSticksAvailableInTheGame-2);
        MinNode min3 = new MinNode(numberOfSticksAvailableInTheGame-3);
        if(min1.getValue(min1)==1)
            return 1;
        if(min2.getValue(min2)==1)
            return 2;
        if(min3.getValue(min3)==1)
            return 3;
        if(zug.equals(Optional.of(1)))
            return 1;
        if(zug.equals(Optional.of(2)))
            return 2;
        return 3;
    }
}