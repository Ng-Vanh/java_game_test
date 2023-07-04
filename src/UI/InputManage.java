package UI;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManage {
    public void processKeyPress(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_W:
                System.out.println("YOU PRESS W");
                break;
            case KeyEvent.VK_S:
                System.out.println("YOU PRESS S");

                break;
            case KeyEvent.VK_A:
                System.out.println("YOU PRESS A");
                break;
            case KeyEvent.VK_D:
                System.out.println("YOU PRESS D");
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("YOU PRESS SPACE");
                break;

        }
    }

    public void processKeyRelease(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_W:
                System.out.println("YOU RELEASE W");
                break;
            case KeyEvent.VK_S:
                System.out.println("YOU RELEASE S");

                break;
            case KeyEvent.VK_A:
                System.out.println("YOU RELEASE A");
                break;
            case KeyEvent.VK_D:
                System.out.println("YOU RELEASE D");
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("YOU RELEASE SPACE");
                break;

        }

    }
}