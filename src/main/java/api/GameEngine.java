package api;
import TicTacToe.TicTacToeBoard;
import TicTacToe.TicTacToeMove;
import TicTacToe.TicTacToeToken;
import api.GameType;
import exceptions.IllegalMoveException;

import java.util.Scanner;

public class GameEngine {
    Board board;
    GameState gameState;
    GameType gameType;
    public GameEngine(GameType gameType){
        this.gameType = gameType;
        if(this.gameType.equals(GameType.TicTacToe)) {
            board = new TicTacToeBoard();

        }
        gameState = new GameState(false);

    }

    public void start(){
        System.out.println("Game has started");
        Player player;
        Player computer;
        if(gameType.equals(GameType.TicTacToe)){
            player = new Player(new TicTacToeToken("X"));
            computer = new Player(new TicTacToeToken("O"));
        }
        Scanner sc = new Scanner(System.in);
        while(!gameState.isGameOver()){
            Move playerMove;
            Move computerMove;
            if(gameType.equals(GameType.TicTacToe)){
                int playerMoveRow = sc.nextInt();
                int playerMoveCol = sc.nextInt();
                playerMove = new TicTacToeMove(new Cell(playerMoveRow,playerMoveCol));
                computerMove = new
            }
        }
    }

    public void move(Board board ,Player player, Move move) throws IllegalMoveException {
        if(board.validateMove(move)){
            board.setSymbolAtCell(move.getCell(),player.getToken());
        }else{
            throw new IllegalMoveException();
        }
    }


}
