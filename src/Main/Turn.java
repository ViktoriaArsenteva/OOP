package Main;


import chars.*;

import java.util.ArrayList;

public class Turn {

    Team members;

    public Team getMembers() {
        return members;
    }

    public Turn(int teamSize, String [] request, String [] request1, int fieldSize) {
        this.members = new Team(teamSize, request, request1, fieldSize);
    }

    public void round (int step) {
        if (step == 0) {
            members.sortBySpeed();
        } else {
            ArrayList <BaseHero> active = members.getAlive();
            for (BaseHero h: active) h.step(members);
        }
        }
}