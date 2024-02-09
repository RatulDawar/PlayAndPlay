package TicTacToe;

import api.*;


public class TicTacToeBoard implements Board{

    TicTacToeToken[][] board = new TicTacToeToken[TicTacToeConfigs.BOARD_LENGTH][TicTacToeConfigs.BOARD_WIDTH];

    @Override
    public boolean validateMove(Move move){
        return move.getCell().getRow() >= 0 && move.getCell().getRow() < TicTacToeConfigs.BOARD_LENGTH
                && move.getCell().getCol() >= 0 && move.getCell().getCol() < TicTacToeConfigs.BOARD_WIDTH
                && getTokenAtCell(move.getCell()) == null;
    }
    @Override
    public GameToken getTokenAtCell(Cell cell){
        return this.board[cell.getRow()][cell.getCol()];
    }

    @Override
    public void displayBoardState() {
        for(TicTacToeToken[] row : board){
            for(TicTacToeToken gameToken:row){
                System.out.print((gameToken != null ? gameToken.getSymbol() : " ") + " | ");
            }

            System.out.println();

        }
    }

    @Override
    public void setTokenAtCell(Cell cell,GameToken symbol){
        if(symbol instanceof TicTacToeToken) {
            board[cell.getRow()][cell.getCol()] = (TicTacToeToken) symbol;
        }else{
            throw new IllegalArgumentException();
        }

    }


    public GameToken[][] getBoard() {
        return this.board;
    }

    @Override
    public GameToken getTokenAtCell(int row, int col){
        return board[row][col];
    }


}




