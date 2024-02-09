package api;

import TicTacToe.TicTacToeMove;
import exceptions.IllegalMoveException;

public interface Board {

    boolean validateMove(Move move);
    void setTokenAtCell(Cell cell, GameToken symbol);

    GameToken getTokenAtCell(Cell cell);

    void displayBoardState();

    GameToken getTokenAtCell(int row, int col);
}
