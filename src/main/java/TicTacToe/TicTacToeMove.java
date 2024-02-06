package TicTacToe;

import api.Cell;
import api.Move;

import java.util.Scanner;

public class TicTacToeMove implements Move {
    private Cell cell;




    public TicTacToeMove(Cell cell){
        this.cell = cell;
    }
    public void Move(){
    }

    public Cell getCell() {
        return cell;
    }


}
