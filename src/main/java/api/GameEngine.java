package api;
import TicTacToe.TicTacToeAI;
import TicTacToe.TicTacToeBoard;
import TicTacToe.TicTacToeMove;
import TicTacToe.TicTacToeToken;
import api.GameType;
import exceptions.IllegalArgumentException;
import exceptions.IllegalMoveException;
import exceptions.IllegalStateException;

import java.util.Scanner;

public class GameEngine {
    Board board;
    GameState gameState;
    GameType gameType;
    AIEngine aiEngine;
    public GameEngine(GameType gameType){
        this.gameType = gameType;
        if(this.gameType.equals(GameType.TicTacToe)) {
            board = new TicTacToeBoard();
            this.aiEngine = new TicTacToeAI();

        }
        gameState = new GameState(false);

    }

    public void start() throws IllegalStateException, IllegalArgumentException, IllegalMoveException {
        System.out.println("Game has started");
        Player player = null;
        Player computer = null;
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
                this.move(board,player,playerMove);
                computerMove = aiEngine.suggestMove(board,computer);
                this.move(board,computer,computerMove);

            }
        }
    }

    public void move(Board board ,Player player, Move move) throws IllegalMoveException {
        if(board.validateMove(move)){
            board.setTokenAtCell(move.getCell(),player.getToken());
        }else{
            throw new IllegalMoveException();
        }
    }


}
