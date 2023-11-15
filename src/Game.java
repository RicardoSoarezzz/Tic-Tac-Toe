import java.util.Objects;
import java.util.Scanner;

public class Game {

    private final Board board;

    int count = 0;
    Player currentPlayer;
    private final Player player2,player1;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;

    }
    void play() {
        int col,line;
        if(player1.isTurn()){
            currentPlayer = player1;
        } else {
            currentPlayer = player2;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("____________\nPlayer "+currentPlayer+" turn");
        System.out.println(board);
        System.out.println("Column: ");
        col = scanner.nextInt();
        System.out.println("Line: ");
        line = scanner.nextInt();

        int i = line -1;
        int j = col -1;
        if(i<0 || i>2 || j<0 || j>2){
            System.out.println("Invalid Move!");
            play();
        }

        if(!Objects.equals(board.board[i][j], "-")){
            System.out.println("Move already done");
            play();
        }else {
            count++;
            board.board[i][j]= currentPlayer.getSymbol();
            if(checkWin(currentPlayer)){
                System.out.println("Player "+currentPlayer.getSymbol()+" WON!!");
                System.out.println(board);
            } else if (count<9){
                turn();
            } else {
                System.out.println("Its a tie");
                System.out.println(board);
            }
        }



    }

    public boolean checkWin(Player player) {
        String symb = player.getSymbol();
        int count;
        for (int i = 0; i<3; i++){
            count = 0;
            for (int j = 0; j<3; j++){
                if(board.board[i][j]==symb){
                    count++;
                    if(count ==3){
                        return true;
                    }
                }
            }
        }

        for (int i = 0; i<3; i++){
            count = 0;
            for (int j = 0; j<3; j++){
                if(board.board[j][i]==symb){
                    count++;
                    if(count ==3){
                        return true;
                    }
                }
            }
        }


        if(board.board[0][0]  == symb &&  symb == board.board[1][1] && board.board[2][2] == symb){
            return true;
        }

        if(board.board[0][2]  == symb &&  symb == board.board[1][1] && board.board[2][0] == symb){
            return true;
        }


        return false;
    }


    void turn(){
        player1.setTurn(!player1.isTurn());
        player2.setTurn(!player2.isTurn());
        play();
    }

}
