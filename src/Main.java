import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Player player1 = new Player("X",true);
        Player player2 = new Player("O",false);


        Board board = new Board();

        Game game = new Game(board,player1,player2);

        game.play();

    }

}
