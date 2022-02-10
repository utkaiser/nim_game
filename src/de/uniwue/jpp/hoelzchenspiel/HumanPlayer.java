package de.uniwue.jpp.hoelzchenspiel;

import java.util.*;

public class HumanPlayer implements Player {
    public String name;

    public HumanPlayer(String name){
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public int takeSticks(int numberOfSticksAvailableInTheGame) {
        //Anzahl der zu ziehenden Hölzchen wird über die Standardeingabe eingelesen
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Wie viele Sticks ziehen Sie?");
            choice = sc.nextInt();
        }while(choice!=1 && choice !=2 && choice!=3 && choice > numberOfSticksAvailableInTheGame);
        return choice;
    }
}
