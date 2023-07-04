package Effect;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.security.PublicKey;

public class FrameImage {
    private String name;
    private BufferedImage image;

    public FrameImage(String name, BufferedImage image) {
        this.name = name;
        this.image = image;
    }
    public int getImageWidth()
    {
        return image.getWidth();
    }
    public int getImageHeigh()
    {
        return image.getHeight();
    }
    public void draw(Graphics2D g2, int x, int y)
    {
        g2.drawImage(image, x - image.getWidth()/2, y - image.getWidth()/2, null);
    }
    public FrameImage(FrameImage frameImage)
    {
        this.image = new BufferedImage(frameImage.getImageWidth(), frameImage.getImageHeigh(),
                                        frameImage.getImage().getType());
        Graphics g = image.getGraphics();
        g.drawImage(frameImage.getImage(), 0, 0, null);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
