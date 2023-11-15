import java.util.Arrays;

public class Board {


    String[][] board = new String[3][3];

    public Board(){
        for (int i = 0; i<3;i++){
            for (int j = 0; j<3 ; j++){
                board[i][j] = "-";
            }
        }
    }


    @Override
    public String toString() {
        String boardString = "";
        for (int i = 0; i<3;i++){
            boardString = boardString + "\n|";
            for (int j = 0; j<3 ; j++){
                boardString = boardString+ board[i][j]+"|" ;
            }
        }
        return boardString;
    }
}
