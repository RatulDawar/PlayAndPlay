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

    public static class GameStateBuilder {
        private boolean gameOver;
        private Player winner;

        public GameStateBuilder() {
            this.gameOver = false;
            this.winner = null;
        }
        public GameStateBuilder withGameOver(boolean gameOver) {
            this.gameOver = gameOver;
            return this;
        }

        public GameStateBuilder withWinner(Player winner) {
            this.winner = winner;
            return this;
        }

        public GameState build() {
            GameState gameState = new GameState(gameOver);
            gameState.setWinner(winner);
            return gameState;
        }
    }

}



