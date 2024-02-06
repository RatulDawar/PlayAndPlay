package api;

public class GameState {
    private boolean gameOver;
    private Player winner;
    GameState(boolean gameOver){
        this.gameOver = gameOver;
    }
    public boolean isGameOver() {
        return gameOver;
    }
    public Player getWinner() {
        return winner;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
