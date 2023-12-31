package UI;

import Effect.Animation;
import Effect.FrameImage;

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

    /* Test animation */
    FrameImage frame1, frame2, frame3;
    Animation anim;
    /*----------------------------------*/
    public GamePanel()
    {
        inputManage = new InputManage();
        /*TestAnimation*/
        try {
            BufferedImage image = ImageIO.read(new File("src/img/Textures/classic.png"));
            BufferedImage image1 = image.getSubimage(16, 0,16, 16);
            frame1 = new FrameImage("frame1", image1);

            BufferedImage image2 = image.getSubimage(16,16,16,16);
            BufferedImage image3 = image.getSubimage(16,32,16,16);
            frame2 = new FrameImage("frame2", image2);
            frame3 = new FrameImage("frame3", image3);

            anim = new Animation();
            anim.add(frame1,150*1000000);
            anim.add(frame2,150*1000000);
            anim.add(frame3,150*1000000);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
/*------------------------------------------------------------*/

    }

    @Override
    public void paint(Graphics g)
    {
        g.setColor(Color.CYAN);
        g.fillRect(0,0,GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);

        Graphics2D g2 = (Graphics2D) g;
        anim.Update(System.nanoTime());
        anim.draw( 100,100, g2);

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

            repaint();
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
