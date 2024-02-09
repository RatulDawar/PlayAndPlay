import api.GameEngine;
import api.GameType;
import exceptions.IllegalArgumentException;
import exceptions.IllegalMoveException;
import exceptions.IllegalStateException;

public class Main {
    public static void main(String[] args) throws IllegalStateException, IllegalMoveException, IllegalArgumentException {

        GameEngine gameEngine = new GameEngine(GameType.TicTacToe);
        gameEngine.start();

    }
}