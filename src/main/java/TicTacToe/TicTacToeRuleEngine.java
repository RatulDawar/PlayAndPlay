package TicTacToe;

import api.*;
import exceptions.IllegalStateException;


import java.util.Optional;
import api.GameState.GameStateBuilder;



public class TicTacToeRuleEngine implements RuleEngine {

    @Override
    public GameState getGameState(Board board, Player player1, Player player2) throws IllegalStateException {
        GameToken winByRow = isRowComplete(board);
        GameToken winByCol = isColComplete(board);
        GameToken winByDiagonal = isDiagonalComplete(board);

        Optional<GameToken> winnerToken = Optional.ofNullable(winByRow)
                .or(()->Optional.ofNullable(winByCol))
                .or(()->Optional.ofNullable(winByDiagonal));
        Player winnerPlayer = null;
        boolean isGameOver = false;
        if(winnerToken.isPresent()){
            winnerPlayer = winnerToken.get().getSymbol().equals(player1.getToken().getSymbol()) ? player1 : player2;
            isGameOver = true;
        }

        return new GameStateBuilder()
                .withGameOver(isGameOver)
                .withWinner(winnerPlayer)
                .build();
    }

    public GameToken isRowComplete(Board board){
        for(int row = 0;row<TicTacToeConfigs.BOARD_LENGTH;row++){
            Optional<GameToken> firstToken = Optional.ofNullable(board.getTokenAtCell(new Cell(row, 0)));
            boolean rowComplete = true;
            for(int col = 1;col < TicTacToeConfigs.BOARD_WIDTH && firstToken.isPresent() ;col++){
                if(board.getTokenAtCell(new Cell(row,col)) == null || !firstToken.get().getSymbol().equals(board.getTokenAtCell(new Cell(row,col)).getSymbol())){
                    rowComplete = false;
                }
            }
            if(rowComplete && firstToken.isPresent())
                return firstToken.get();
        }
        return null;
    }

    public GameToken isColComplete(Board board){
        for(int col = 0;col<TicTacToeConfigs.BOARD_WIDTH;col++){
            Optional<GameToken> firstToken = Optional.ofNullable(board.getTokenAtCell(new Cell(0, col)));
            boolean colComplete = true;
            for(int row = 1;row < TicTacToeConfigs.BOARD_LENGTH && firstToken.isPresent() ;row++){
                if(board.getTokenAtCell(new Cell(row,col)) == null || !firstToken.get().getSymbol().equals(board.getTokenAtCell(new Cell(row,col)).getSymbol())){
                    colComplete = false;
                }
            }
            if(colComplete && firstToken.isPresent())
                return firstToken.get();
        }
        return null;
    }
    
    public GameToken isDiagonalComplete(Board board) throws IllegalStateException {
        Optional<GameToken> firstDiagonalToken = Optional.ofNullable(board.getTokenAtCell(new Cell(0, 0)));
        Optional<GameToken> firstReverseDiagonalToken = Optional.ofNullable(board.getTokenAtCell(new Cell(0, TicTacToeConfigs.BOARD_WIDTH - 1)));
        boolean diagonalComplete = true, revDiagonalComplete = true;
        for(int i = 0;i< TicTacToeConfigs.BOARD_LENGTH;i++){
            String diagonalSymbol = "";
            String revDiagonalSymbol = "";
            if(board.getTokenAtCell(new Cell(i,i)) != null) {
                diagonalSymbol = board.getTokenAtCell(new Cell(i, i)).getSymbol();
            }
            if(board.getTokenAtCell(new Cell(i,TicTacToeConfigs.BOARD_WIDTH - i - 1)) != null) {
                revDiagonalSymbol = board.getTokenAtCell(new Cell(i, TicTacToeConfigs.BOARD_WIDTH - i - 1)).getSymbol();
            }
            diagonalComplete &= firstDiagonalToken.isPresent() && firstDiagonalToken.get().getSymbol().equals(diagonalSymbol);
            revDiagonalComplete &= firstReverseDiagonalToken.isPresent() && firstReverseDiagonalToken.get().getSymbol().equals(revDiagonalSymbol);
        }

        if(diagonalComplete && revDiagonalComplete)throw new IllegalStateException();

        if(!diagonalComplete  && !revDiagonalComplete)return null;
        return diagonalComplete ? firstDiagonalToken.get() : firstReverseDiagonalToken.get();
    }
    
    
}


