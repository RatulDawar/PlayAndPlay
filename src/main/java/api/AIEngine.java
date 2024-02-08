package api;

import exceptions.IllegalArgumentException;
import exceptions.IllegalStateException;

public interface AIEngine {

    Move suggestMove(Board board, Player computer) throws IllegalStateException, IllegalArgumentException;
}
