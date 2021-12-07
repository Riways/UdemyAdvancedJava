package Toys;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

enum Action {
    KAMEN, NOJNICY, BUMAGA
}


public class RockPaperScissors {
    public static final int ROUNDS = 3; //change


    public static void main(String[] args) {
        Player vanya = new Player("Vanya");
        Player kostya = new Player("Kostya");
        new GameMaster(vanya, kostya);
    }
}

class Filler {
    public static void listFiller(List<Action> actionList, int fillCount) {
        Random r = new Random();
        for (int i = 0; i < fillCount; i++) {
            int r2 = r.nextInt(3);
            if (r2 == 0) {
                actionList.add(Action.KAMEN);
            } else if (r2 == 1) {
                actionList.add(Action.NOJNICY);
            } else if (r2 == 2) {
                actionList.add(Action.BUMAGA);
            }
        }
    }
}

class Player {
    private final String name;
    private int winsCounter = 0;
    private List<Action> lst = new LinkedList<>();

    {

        Filler.listFiller(lst, RockPaperScissors.ROUNDS);
    }

    public Player(String name) {
        this.name = name;
    }

    public int getWinsCounter() {
        return winsCounter;
    }

    public void setWinsCounter(int winsCounter) {
        this.winsCounter = winsCounter;
    }

    public String getName() {
        return name;
    }

    public List<Action> getLst() {
        return lst;
    }

}


class GameMaster extends Thread {
    Player player1;
    Player player2;

    GameMaster(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.start();
    }

    private void printWinner(Player winner, Player loser, Action actionPlayer1, Action actionPlayer2){

        System.out.println(winner.getName() + " drops " + actionPlayer1 + " and ..." );
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(loser.getName() + " drops " + actionPlayer2 + '\n');
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(winner.getName().toUpperCase() + " wins this round" + '\n' );
        winner.setWinsCounter(winner.getWinsCounter() + 1);
        System.out.println(winner.getName() + " wins " + winner.getWinsCounter() + " games!" + '\n');
    }

    private void printDraw(Player player1, Player player2, Action actionPlayer1, Action actionPlayer2){
        System.out.println(player1.getName() + " drops " + actionPlayer1 + " and ..." );
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(player2.getName() + " drops " + actionPlayer2 + '\n');
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("...draw..." + '\n');
    }

    @Override
    public void run() {
        int rounds = RockPaperScissors.ROUNDS;
        for (int i = 0; i < rounds; i++) {
            Action action1 = player1.getLst().get(i);
            Action action2 = player2.getLst().get(i);
            if (action1 == Action.BUMAGA && action2 == Action.KAMEN ||
                    action1 == Action.KAMEN && action2 == Action.NOJNICY ||
                    action1 == Action.NOJNICY && action2 == Action.BUMAGA) {
                printWinner(player1, player2, action1, action2);
            } else if (action1 == action2) {
                printDraw(player1, player2, action1, action2);
            } else {
                printWinner(player2, player1, action2, action1);
            }
            if (i > rounds /2) {
                if (player1.getWinsCounter() > player2.getWinsCounter() &&  player1.getWinsCounter() >= (RockPaperScissors.ROUNDS /2 + 1) ) {
                    System.out.println(player1.getName() + " WINS THIS GAME!!!");
                    return;
                } else if (player2.getWinsCounter() > player1.getWinsCounter() && player2.getWinsCounter() >= (RockPaperScissors.ROUNDS /2 + 1)) {
                    System.out.println(player2.getName().toUpperCase() + " WINS THIS GAME!!!");
                    return;
                } else {
                    //System.out.println(" !!EXTRA ROUND!! ");
                    Filler.listFiller(player1.getLst(), 1);
                    Filler.listFiller(player2.getLst(), 1);
                    rounds++;
                }
            }
        }
    }
}

