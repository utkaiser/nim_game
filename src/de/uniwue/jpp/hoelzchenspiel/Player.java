package de.uniwue.jpp.hoelzchenspiel;

public interface Player {
    public int takeSticks(int numberOfSticksAvailableInTheGame);
    public String getName();
    public final int [] POSSIBLE_DRAWS = {1,2,3}; // Mögliche Züge die vom Spieler gewählt werden könnnen
}
