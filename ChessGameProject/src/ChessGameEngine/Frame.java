package ChessGameEngine;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {

    /**
     * @return the Board
     */
    public Panel1 getBoard() {
        return Board;
    }

    /**
     * @param Board the Board to set
     */
    public void setBoard(Panel1 Board) {
        this.Board = Board;
    }

    private Panel1 Board = new Panel1();

    Frame() {
        this.setSize(605, 628);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setTitle("Chess");
        Container c = this.getContentPane();

        c.add(Board);

        this.setVisible(true);
    }
}
