package TicTacToe;

import api.*;
import exceptions.IllegalStateException;

import java.util.Iterator;

public class TicTacToeRuleEngine implements RuleEngine {

    @Override
    public GameState getGameState(Board board, Player player1, Player player2) {
        return null;
    }

    public GameToken isRowComplete(Board board){
        for(int row = 0;row<TicTacToeConfigs.BOARD_LENGTH;row++){
            GameToken firstToken = board.getTokenAtCell(new Cell(row,0));
            for(int col = 1;col < TicTacToeConfigs.BOARD_WIDTH;col++){
                if(board.getTokenAtCell(new Cell(row,col)).getSymbol().equals(firstToken.getSymbol())){
                    return firstToken;
                }
            }
        }
        return null;
    }

    public GameToken isColComplete(Board board){
        for(int col = 0;col<TicTacToeConfigs.BOARD_WIDTH;col++){
            GameToken firstToken = board.getTokenAtCell(new Cell(0,col));
            for(int row = 1;row < TicTacToeConfigs.BOARD_LENGTH;row++){
                if(board.getTokenAtCell(new Cell(row,col)).getSymbol().equals(firstToken.getSymbol())){
                    return firstToken;
                }
            }
        }
        return null;
    }
    
    public GameToken isDiagonalComplete(Board board) throws IllegalStateException {
    GameToken firstDiagonalToken = board.getTokenAtCell(new Cell(0,0));
        GameToken firstReverseDiagonalToken = board.getTokenAtCell(new Cell(0,TicTacToeConfigs.BOARD_WIDTH - 1));
        boolean diagonalComplete = true, revDiagonalComplete = true;
        for(int i = 0;i< TicTacToeConfigs.BOARD_LENGTH;i++){
            String diagonalSymbol = board.getTokenAtCell(new Cell(i,i)).getSymbol();
            String revDiagonalSymbol = board.getTokenAtCell(new Cell(i,TicTacToeConfigs.BOARD_WIDTH - i - 1)).getSymbol();
            diagonalComplete &=  diagonalSymbol.equals(firstDiagonalToken.getSymbol());
            revDiagonalComplete &= revDiagonalSymbol.equals(firstReverseDiagonalToken.getSymbol());
            if(!diagonalComplete  && !revDiagonalComplete){
                return null;
            }
            
        }
        
        if(diagonalComplete && revDiagonalComplete){
            throw new IllegalStateException();
        }
        return diagonalComplete ? firstDiagonalToken : firstReverseDiagonalToken;
    }
    
    
}


