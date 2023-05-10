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
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class App extends JFrame {

    JPanel content;
    ImagePanel gui;
    Menu menu;
    
    public App(){
        super("Blur Image");
        this.setSize(600,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        content = new JPanel(new BorderLayout());
        gui = new ImagePanel();
        menu = new Menu(gui);
        content.add(gui, BorderLayout.CENTER);
        content.add(menu, BorderLayout.SOUTH);

//        gui.addMouseMotionListener(new MouseMotionAdapter() {
//            Point start = new Point();
//            @Override
//            public void mouseMoved(MouseEvent me) {
//                start = me.getPoint();
//            }
//            @Override
//            public void mouseDragged(MouseEvent me) {
//                Point end = me.getPoint();
////                Rectangle captureRect = new Rectangle(start, new Dimension(end.x - start.x, end.y
////                        - start.y));
//                int x = Math.min(start.x, end.x);
//                int y = Math.min(start.y, end.y);
//                int width = Math.abs(end.x - start.x);
//                int height = Math.abs(end.y - start.y);
//                BufferedImage blurredSection = menu.upload.getImage().getSubimage(x, y, width, height);
//                Planar<GrayU8> input = ConvertBufferedImage.convertFrom(blurredSection, true, ImageType.pl(3, GrayU8.class));
//                Planar<GrayU8> blurred = input.createSameShape();
//                // size of the blur kernel. square region with a width of radius*2 + 1
//                int radius = 8;
//                // Apply gaussian blur using a procedural interface
//                GBlurImageOps.gaussian(input, blurred, -1, radius, null);
//                gui.setImage(ConvertBufferedImage.convertTo(blurred, null, true));
//                gui.repaint();
//            }
//        });

        this.add(content);
        this.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
