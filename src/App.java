import boofcv.alg.filter.blur.BlurImageOps;
import boofcv.alg.filter.blur.GBlurImageOps;
import boofcv.gui.image.ImagePanel;
import boofcv.io.image.ConvertBufferedImage;
import boofcv.struct.image.GrayF32;
import boofcv.struct.image.GrayU8;
import boofcv.struct.image.ImageType;
import boofcv.struct.image.Planar;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class App extends JFrame {

    JPanel content;
    ImagePanel gui;
    Menu menu;

    public App() {
        //Create Gui
        super("Blur Image");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        content = new JPanel(new BorderLayout());
        gui = new ImagePanel();
        menu = new Menu(gui);
        content.add(gui, BorderLayout.CENTER);
        content.add(menu, BorderLayout.SOUTH);

        gui.addMouseListener(new MouseListener() {
            Point start = new Point();
            Point end = new Point();

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            //Get starting point of user selected area
            public void mousePressed(MouseEvent me) {
                start = me.getPoint();
            }
            @Override
            //Get ending point of user selected area
            public void mouseReleased(MouseEvent me) {
                end = me.getPoint();
                //Create a graphics2d component to edit the picture
                Graphics2D g2d = menu.upload.getImage().createGraphics();
                //Turn user selected area into a rectangle
                Rectangle captureRect = new Rectangle(start, new Dimension(end.x - start.x, end.y - start.y));
                //Put the original picture itno the graphics2d to be edited
                g2d.drawImage(menu.upload.getImage(), 0, 0, null);
                int x = Math.min(start.x, end.x);
                int y = Math.min(start.y, end.y);
                //Use the user rectangle to outline the section that needs to be blurred
                BufferedImage blurredSection = menu.upload.getImage().getSubimage(x, y, captureRect.width, captureRect.height);
                // Convert the image to GrayF32 format
                GrayF32 grayImage = ConvertBufferedImage.convertFrom(blurredSection, (GrayF32) null);
                // Create a new GrayF32 image to hold the blurred image
                GrayF32 blurredImage = new GrayF32(grayImage.width, grayImage.height);
                // Blur the image with a Gaussian kernel of size 5x5 and sigma = 1.0
                BlurImageOps.gaussian(grayImage, blurredImage, -1, (int) 4.0, null);
                // Convert the blurred image back to BufferedImage format
                BufferedImage outputImage = ConvertBufferedImage.convertTo(blurredImage, (BufferedImage) null);
                //Add the blurred image onto the graphic
                g2d.drawImage(outputImage, x, y, null);
                g2d.dispose();
                //Paint the graphic onto the gui
                gui.paintComponent(g2d);
                gui.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.add(content);
        this.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
