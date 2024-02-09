package api;
import TicTacToe.*;
import api.GameType;
import exceptions.IllegalArgumentException;
import exceptions.IllegalMoveException;
import exceptions.IllegalStateException;

import java.util.Scanner;

public class GameEngine {
    Board board;
    GameType gameType;
    AIEngine aiEngine;
    RuleEngine ruleEngine;
    public GameEngine(GameType gameType){
        this.gameType = gameType;
        if(this.gameType.equals(GameType.TicTacToe)) {
            board = new TicTacToeBoard();
            this.aiEngine = new TicTacToeAI();
            ruleEngine = new TicTacToeRuleEngine();
        }

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
        this.board.displayBoardState();
        while(!ruleEngine.getGameState(board,player,computer).isGameOver()){
            Move playerMove = null;
            Move computerMove = null;
            System.out.println("Player's turn ");
            if(gameType.equals(GameType.TicTacToe)){
                int playerMoveRow = sc.nextInt();
                int playerMoveCol = sc.nextInt();
                playerMove = new TicTacToeMove(new Cell(playerMoveRow,playerMoveCol));
            }
            this.move(board,player,playerMove);
            this.board.displayBoardState();
            System.out.println("Computer's turn ");
            computerMove = aiEngine.suggestMove(board,computer);
            this.move(board,computer,computerMove);
            this.board.displayBoardState();
        }

        System.out.println(ruleEngine.getGameState(board,player,computer).getWinner().getToken().getSymbol() + " is the winner");
    }

    public void move(Board board ,Player player, Move move) throws IllegalMoveException, IllegalArgumentException {
        if(move == null){
            throw new IllegalArgumentException();
        }
        if(board.validateMove(move)){
            board.setTokenAtCell(move.getCell(),player.getToken());
        }else{
            throw new IllegalMoveException();
        }
    }


}
