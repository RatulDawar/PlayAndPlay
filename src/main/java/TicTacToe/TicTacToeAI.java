package TicTacToe;

import api.*;
import exceptions.IllegalArgumentException;
import exceptions.IllegalStateException;

import java.util.Arrays;
import java.util.Iterator;

public class TicTacToeAI implements AIEngine {


    @Override
    public Move suggestMove(Board board, Player computer) throws IllegalStateException, IllegalArgumentException {

        if(board instanceof TicTacToeBoard) {
            for (int row = 0; row < TicTacToeConfigs.BOARD_LENGTH; row++) {
                for(int col = 0;col< TicTacToeConfigs.BOARD_WIDTH;col++){
                    if(((TicTacToeBoard) board).getTokenAtCell(row,col) == null){
                        return new TicTacToeMove(new Cell(row,col));
                    }
                }
            }
            throw new IllegalStateException();

        }else{
            throw  new IllegalArgumentException();
        }
    }
}
