package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable, KeyListener {
    private Thread thread;
    private boolean isRunning;
    private InputManage inputManage;

    BufferedImage image;
    BufferedImage subImage;

    public GamePanel()
    {
        inputManage = new InputManage();
        try {
            image = ImageIO.read(new File("src/img/Textures/classic.png"));
            subImage = image.getSubimage(0,0,16,48);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g)
    {
        g.setColor(Color.CYAN);
        g.fillRect(0,0,GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);

    }
    public void startGame()
    {
        if(thread == null)
        {
            isRunning = true;
            thread = new  Thread(this);
            thread.start();
        }
    }
    @Override
    public void run()
    {
        long FPS = 60;
        long timeOneFrame = 1000 * 1000000/FPS;
        long beginTime;
        long sleepTime;

        beginTime = System.nanoTime();
        while (isRunning)
        {
            long deltaTime = System.nanoTime() - beginTime;
            sleepTime = timeOneFrame - deltaTime;

            try {
                if(sleepTime>0) {
                    Thread.sleep(sleepTime/1000000);
                }else{
                    Thread.sleep((timeOneFrame/2000000));
                }
            }catch (InterruptedException ex){}

            beginTime = System.nanoTime();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
       inputManage.processKeyPress(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        inputManage.processKeyRelease(e.getKeyCode());
    }
}
