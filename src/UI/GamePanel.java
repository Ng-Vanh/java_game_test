package UI;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    private Thread thread;
    private boolean isRunning;


    @Override
    public void paint(Graphics g)
    {
        int x = GameFrame.SCREEN_WIDTH / 2-50;
        int y = GameFrame.SCREEN_HEIGHT/2-50;
        int diameter = 100;
        g.setColor(Color.CYAN);
        g.fillOval(x,y,diameter,diameter);
        //g.fillRect(0,0,GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);
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

        int cnt = 1;
        beginTime = System.nanoTime();
        while (isRunning)
        {
            System.out.println("Run: " + (cnt++));

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

}
