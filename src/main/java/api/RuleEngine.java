package api;

public interface  RuleEngine {

    GameState getGameState(Board board, Player player1, Player player2);
}
