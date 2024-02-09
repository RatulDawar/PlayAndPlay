package api;

import exceptions.IllegalStateException;

public interface  RuleEngine {

    GameState getGameState(Board board, Player player1, Player player2) throws IllegalStateException;
}
