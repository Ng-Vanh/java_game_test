package UI;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame
{
    public static final int SCREEN_WIDTH = 640;
    public static final int SCREEN_HEIGHT = 640;
    GamePanel gamePanel;

    public GameFrame()
    {
        Toolkit toolkit = this.getToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds((dimension.width - SCREEN_WIDTH)/2, (dimension.height - SCREEN_HEIGHT)/2, SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setTitle("BomberMan");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        gamePanel = new GamePanel();
        add(gamePanel);

        this.addKeyListener(gamePanel);
    }
    public void startGame()
    {
        gamePanel.startGame();
    }


    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        gameFrame.setVisible(true);
        gameFrame.startGame();
    }
}
