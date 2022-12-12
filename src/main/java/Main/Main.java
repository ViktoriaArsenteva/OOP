package Main;


import chars.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        int step = 0;
        int teamSize = 10;
        int fieldSize = 10;
        String [] request = new String [] {"Light", "Peasant", "Robber", "Sniper", "Wizard"};
        String [] request1 = new String [] {"Dark", "Peasant", "Spearman", "Xbowman", "Monk"};

        Turn turn = new Turn(teamSize, request, request1, fieldSize);
        Logger lg = new Logger(turn.getMembers());
        ConsoleView view = new ConsoleView(teamSize, fieldSize, turn.getMembers());

        do {
            turn.round(step);
            lg.printDefault(step);
            System.out.println(view.show(step));
            step++;

        } while ((char) System.in.read() != 'Q');

    }
}