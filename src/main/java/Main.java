import chars.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int GANG_SIZE = 10;
    public static List<Base> whiteSide;
    public static List<Base> darkSide;
    public static void main(String[] args) {
        init();

        Scanner scanner = new Scanner(System.in);

        while (true){
            ConsoleView.view();
            System.out.println("Press ENTER");
            scanner.nextLine();
        }
    }
    private static void init(){
        whiteSide = new ArrayList<>();
        darkSide = new ArrayList<>();

        int x=1;
        int y=1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)){
                case 0: whiteSide.add(new Peasant(whiteSide, x++, y)); break;
                case 1: whiteSide.add(new Robber(whiteSide, x++, y)); break;
                case 2: whiteSide.add(new Sniper(whiteSide, x++, y)); break;
                default: whiteSide.add(new Monk(whiteSide, x++, y));
            }
        }

        x=1;
        y=10;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)){
                case 0: darkSide.add(new Peasant(darkSide, x++, y)); break;
                case 1: darkSide.add(new Spearman(darkSide, x++, y)); break;
                case 2: darkSide.add(new Xbowman(darkSide, x++, y)); break;
                default: darkSide.add(new Wizard(darkSide, x++, y));
            }
        }
    }
}