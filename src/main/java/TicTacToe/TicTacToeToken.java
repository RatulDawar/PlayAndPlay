package TicTacToe;

import api.GameToken;

public class TicTacToeToken extends GameToken {

    public TicTacToeToken(String symbol){
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }
}
