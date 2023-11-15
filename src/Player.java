public class Player {


    private boolean turn;

    private final String symbol;

    public Player(String symbol,boolean turn) {
        this.symbol = symbol;
        this.turn = turn;
    }


    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return getSymbol();
    }
}
