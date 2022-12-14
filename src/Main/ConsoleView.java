package Main;


import chars.*;

import java.util.Collections;


public class ConsoleView {
    private StringBuilder field;
    private StringBuilder charTable = new StringBuilder();
    private int fieldSize;
    private int teamCount;
    private Team members;

    public ConsoleView(int fieldSize, int teamCount, Team members) {
        this.field = new StringBuilder();
        this.fieldSize = fieldSize;
        this.teamCount = teamCount;
        this.members = members;
    }

    public StringBuilder show(int step) {

        field.delete(0, field.length());

        if (step == 0) {
            field.append(Colors.ANSI_RED);
            field.append("First step!");
            field.append(Colors.ANSI_RESET);
            field.append("\n");
        }
        else {
            field.append(Colors.ANSI_RED);
            field.append("Step: ");
            field.append(step);
            field.append(Colors.ANSI_RESET);
            field.append("\n");
        }

        field.append("\u250c");
        field.append(String.join("", Collections.nCopies(fieldSize-1, "\u2500\u2500\u252c")));
        field.append("\u2500\u2500\u2510\n");

        for (int i = 0; i < fieldSize-1; i++) {
            this.getCharFull(i);
            field.append("\u251c");
            field.append(String.join("", Collections.nCopies(fieldSize-1, "\u2500\u2500\u253c")));
            field.append("\u2500\u2500\u2524\n");
        }

        this.getCharFull(fieldSize-1);
        field.append("\u2514");
        field.append(String.join("", Collections.nCopies(fieldSize-1, "\u2500\u2500\u2534")));
        field.append("\u2500\u2500\u2518\n");
        field.append("Press ENTER to continue. Press Q to exit\n");

        return field;
    }

    private void getChar(int x, int y) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getPosition().isSame(new Coordinates(x, y))) {
                if (members.get(i).getStatus().equals("dead")) {
                    field.append(Colors.ANSI_RED);
                    field.append(members.get(i).getName(), 0, 2);
                    field.append(Colors.ANSI_RESET);

                    charTable.append("    ");
                    charTable.append(Colors.ANSI_RED);
                    charTable.append(members.get(i).getName());
                    charTable.append(" HP: ");
                    charTable.append(members.get(i).getHealth());
                    charTable.append(", Status: ");
                    charTable.append(members.get(i).getStatus());
                    charTable.append(Colors.ANSI_RESET);
                    return;

                }
                if(members.get(i).getFraction().equals(
                        members.getFraction(0))) {
                    field.append(Colors.ANSI_BLUE);
                    field.append(members.get(i).getName(), 0, 2);
                    field.append(Colors.ANSI_RESET);

                    charTable.append("    ");
                    charTable.append(Colors.ANSI_BLUE);
                    charTable.append(members.get(i).getName());
                    charTable.append(" HP: ");
                    charTable.append(members.get(i).getHealth());
                    charTable.append(", Status: ");
                    charTable.append(members.get(i).getStatus());
                    charTable.append(Colors.ANSI_RESET);
                    return;
                }
                if(members.get(i).getFraction().equals(
                        members.getFraction(1))) {
                    field.append(Colors.ANSI_GREEN);
                    field.append(members.get(i).getName(), 0, 2);
                    field.append(Colors.ANSI_RESET);

                    charTable.append("    ");
                    charTable.append(Colors.ANSI_GREEN);
                    charTable.append(members.get(i).getName());
                    charTable.append(" HP: ");
                    charTable.append(members.get(i).getHealth());
                    charTable.append(", Status: ");
                    charTable.append(members.get(i).getStatus());
                    charTable.append(Colors.ANSI_RESET);
                    return;
                }
            }
        }
        field.append("  ");
    }

    private void getCharFull (int x) {
        field.append("\u2502");
        this.getChar(x, 0);
        for (int y = 1; y < fieldSize; y++) {
            field.append("\u2502");
            this.getChar(x, y);
        }
        field.append(String.format("\u2502%s\n", charTable));
        charTable.delete(0, charTable.length());
    }
}
