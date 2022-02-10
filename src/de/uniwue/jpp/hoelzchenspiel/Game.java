package de.uniwue.jpp.hoelzchenspiel;

public class Game {
    public Player p1;
    public Player p2;
    public int currentPlayer;
    public int initialNumberOfSticks;
    public  int numberOfSticksAvailableInTheGame;
    public Game(int initialNumberOfSticks, Player p1, Player p2){
        //Konstruktor
        this.p1 = p1;
        this.p2 = p2;
        this.initialNumberOfSticks = initialNumberOfSticks;
    }
    public Player play(){
        //Methode steuert Spielablau, und gibt den Spieler zurück der gewonnen hat
        int n = initialNumberOfSticks;
        int k = p1.takeSticks(n);
        currentPlayer = 0;
        numberOfSticksAvailableInTheGame = n - k;
        k = p2.takeSticks(n-k);
        numberOfSticksAvailableInTheGame = n-k-k;

        while(numberOfSticksAvailableInTheGame > 0){
            if(currentPlayer % 2 == 0){
                k= p1.takeSticks(numberOfSticksAvailableInTheGame);
                numberOfSticksAvailableInTheGame -= k;
            }else{
                k= p2.takeSticks(numberOfSticksAvailableInTheGame);
                numberOfSticksAvailableInTheGame -= k;
            }
            currentPlayer++;
        }
        if(currentPlayer%2 == 0){
            return p1;
        }else{
            return p2;
        }
    }
    public static void main(String[] args){
        //instanziiert das spiel
        int initalNumberOfSticks = 15; // Für dieses Bsp gewählt, gilt auch für die folgenden Namen
        Game Spiel = new Game(initalNumberOfSticks, new HumanPlayer("Musterfrau"),new HumanPlayer("Mustermann"));
        Spiel.play();
    }

}
