import boofcv.gui.image.ImagePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class DownloadButton extends JButton {
    private Menu _menu;
    private ImagePanel panel;
    private File f;
    private int imageCount = 0;

    public DownloadButton(String text, Menu menu, ImagePanel gui) {
        super(text);
        _menu = menu;
        panel = gui;
        this.addActionListener(new DownloadButtonListener());
        this.setActionCommand(text);
    }

    private class DownloadButtonListener implements ActionListener {
        // If the button is clicked it terminates the program.
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if (e.getActionCommand().equals("Download")) {
                //change the file name depending on how many pictures have been saved
                if (imageCount > 0) {
                    f = new File("blurredImage" + imageCount + ".png");
                } else {
                    f = new File("blurredImage.png");
                }
                try {
                    //Download the new blurred png file onto the user device
                    System.out.println(panel.getImage());
                    ImageIO.write(panel.getImage(), "PNG", f);
                    imageCount++;
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }

    }
}