package Main;


import chars.*;

import java.io.IOException;
import java.util.ArrayList;


public class Main {

    public static final int TEAM_SIZE = 10;
    public static final int FIELD_SIZE = 10;

    public static int step = 1;

    public static final String[] logHeader = new String[]{"Step No", "Side", "Hero+ID", "Target", "Damage val"};
    public static Logger lg;

    static {
        try {
            lg = new Logger("log.csv", logHeader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static ArrayList<BaseHero> lightSide;
    static ArrayList<BaseHero> darkSide;

    public static void main(String[] args) throws IOException { //кнопка вкл для всей игры

        String [] request = new String [] {"Peasant", "Robber", "Sniper", "Warlock"};
        String [] request1 = new String [] {"Peasant", "Spearman", "Xbowman", "Monk"};
        Main.lightSide = Team.make(TEAM_SIZE, request, 0, 0, "Light");
        Main.darkSide = Team.make(TEAM_SIZE, request1, 0, Main.FIELD_SIZE-1, "Dark");


        do {
            Turn.orderBySpeed();
            System.out.println(ConsoleView.field());
            step++;
            lg.print();
        } while ((char) System.in.read() != 'Q');

        lg.close();


    }
}