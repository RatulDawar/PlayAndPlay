package TicTacToe;

import api.*;

import java.util.Iterator;


public class TicTacToeBoard implements Board{

    GameToken[][] board = new GameToken[TicTacToeConfigs.BOARD_LENGTH][TicTacToeConfigs.BOARD_WIDTH];

    @Override
    public boolean validateMove(Move move){
        return move.getCell().getRow() >= 0 && move.getCell().getRow() < TicTacToeConfigs.BOARD_LENGTH
                && move.getCell().getCol() >= 0 && move.getCell().getCol() < TicTacToeConfigs.BOARD_WIDTH
                && getTokenAtCell(move.getCell()) == null;
    }
    @Override
    public GameToken getTokenAtCell(Cell cell){
        return board[cell.getRow()][cell.getCol()];
    }

    @Override
    public void setTokenAtCell(Cell cell,GameToken symbol){
        board[cell.getRow()][cell.getCol()] = symbol;
    }


    public GameToken[][] getBoard() {
        return this.board;
    }



    public GameToken getTokenAtCell(int row,int col){
        return board[row][col];
    }


}




