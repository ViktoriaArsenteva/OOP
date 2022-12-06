package Main;


import chars.*;

import java.util.Collections;

public class ConsoleView {
    private static StringBuilder field = new StringBuilder();
    public static StringBuilder field() {

        if (Main.step == 1) {
            field.append(Colors.ANSI_RED);
            field.append("First step!");
            field.append(Colors.ANSI_RESET);
            field.append("\n");
        }
        else {
            field.append(Colors.ANSI_RED);
            field.append("Step: ");
            field.append(Main.step);
            field.append(Colors.ANSI_RESET);
            field.append("\n");
        }

        // Верх игровое поле
        field.append("\u250c");
        field.append(String.join("", Collections.nCopies(Main.FIELD_SIZE-1, "\u2500\u2500\u252c")));
        field.append("\u2500\u2500\u2510\n");

        // Середина игровое поле
        for (int i = 0; i < Main.FIELD_SIZE; i++) {
            ConsoleView.getCharFull(i);
            field.append("\u251c");
            field.append(String.join("", Collections.nCopies(Main.FIELD_SIZE-1, "\u2500\u2500\u253c")));
            field.append("\u2500\u2500\u2524\n");
        }

        // Низ игровое поле
        ConsoleView.getCharFull(Main.FIELD_SIZE-1);
        field.append("\u2514");
        field.append(String.join("", Collections.nCopies(Main.FIELD_SIZE-1, "\u2500\u2500\u2534")));
        field.append("\u2500\u2500\u2518\n");
        field.append("Press ENTER to continue. Press Q to exit\n");

        return field;
    }

    private static StringBuilder charTable = new StringBuilder();

    private static void getChar(int x, int y) {

        for (int i = 0; i < Main.TEAM_SIZE; i++) {
            if (Main.lightSide.get(i).getPosition().isSame(new Coordinates(x, y))) {
                if (Main.lightSide.get(i).getStatus().equals("dead")) {
                    field.append(Colors.ANSI_RED);
                    field.append(Main.lightSide.get(i).getName(), 0, 2);
                    field.append(Colors.ANSI_RESET);

                    charTable.append("    ");
                    charTable.append(Colors.ANSI_RED);
                    charTable.append(Main.lightSide.get(i).getName());
                    charTable.append(" HP: ");
                    charTable.append(Main.lightSide.get(i).getHealth());
                    charTable.append(", Status: ");
                    charTable.append(Main.lightSide.get(i).getStatus());
                    charTable.append(Colors.ANSI_RESET);
                    return;

                }
                else {
                    field.append(Colors.ANSI_BLUE);
                    field.append(Main.lightSide.get(i).getName(), 0, 2);
                    field.append(Colors.ANSI_RESET);

                    charTable.append("    ");
                    charTable.append(Colors.ANSI_BLUE);
                    charTable.append(Main.lightSide.get(i).getName());
                    charTable.append(" HP: ");
                    charTable.append(Main.lightSide.get(i).getHealth());
                    charTable.append(", Status: ");
                    charTable.append(Main.lightSide.get(i).getStatus());
                    charTable.append(Colors.ANSI_RESET);
                    return;
                }
            }
            if (Main.darkSide.get(i).getPosition().isSame(new Coordinates(x, y))) {
                if (Main.darkSide.get(i).getStatus().equals("dead")) {
                    field.append(Colors.ANSI_RED);
                    field.append(Main.darkSide.get(i).getName(), 0, 2);
                    field.append(Colors.ANSI_RESET);

                    charTable.append("    ");
                    charTable.append(Colors.ANSI_RED);
                    charTable.append(Main.darkSide.get(i).getName());
                    charTable.append(" HP: ");
                    charTable.append(Main.darkSide.get(i).getHealth());
                    charTable.append(", Status: ");
                    charTable.append(Main.darkSide.get(i).getStatus());
                    charTable.append(Colors.ANSI_RESET);
                    return;
                }
                else {
                    field.append(Colors.ANSI_GREEN);
                    field.append(Main.darkSide.get(i).getName(), 0, 2);
                    field.append(Colors.ANSI_RESET);

                    charTable.append("    ");
                    charTable.append(Colors.ANSI_GREEN);
                    charTable.append(Main.darkSide.get(i).getName());
                    charTable.append(" HP: ");
                    charTable.append(Main.darkSide.get(i).getHealth());
                    charTable.append(", Status: ");
                    charTable.append(Main.darkSide.get(i).getStatus());
                    charTable.append(Colors.ANSI_RESET);
                    return;
                }
            }
        }
        field.append("  ");
    }

    public static void getCharFull (int x) {
        field.append("\u2502");
        ConsoleView.getChar(x, 0);
        for (int y = 1; y < Main.FIELD_SIZE; y++) {
            field.append("\u2502");
            ConsoleView.getChar(x, y);
        }
        field.append(String.format("\u2502%s\n", charTable));
        charTable.delete(0, charTable.length());
    }
}
