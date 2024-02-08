package api;

public class Player {

    GameToken token;
    Player(GameToken gameToken){
        this.token = gameToken;
    }
    public GameToken getToken() {
        return token;
    }
}
