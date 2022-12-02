import chars.BaseHero;
import chars.Team;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static final int TEAM_SIZE = 10;

    public static int step = 0;
    static ArrayList<BaseHero> lightSide;
    static ArrayList<BaseHero> darkSide;

    public static void main(String[] args) throws IOException { 

        String [] request = new String [] {"Peasant", "Robber", "Sniper", "Warlock"};
        String [] request1 = new String [] {"Peasant", "Spearman", "Xbowman", "Monk"};
        Main.lightSide = Team.make(Main.TEAM_SIZE, request, 0, 0);
        Main.darkSide = Team.make(Main.TEAM_SIZE, request1, 0, Main.TEAM_SIZE-1);


       do {
               ConsoleView.field(Main.TEAM_SIZE);
               Turn.orderByClass();
               step++;
       } while ((char) System.in.read() != 'Q');




    }

}