import boofcv.alg.filter.blur.BlurImageOps;
import boofcv.gui.image.ImagePanel;
import boofcv.io.image.ConvertBufferedImage;
import boofcv.struct.image.GrayF32;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UploadButton extends JButton {
    private Menu _menu;
    private ImagePanel panel;
    private BufferedImage img;
    public UploadButton(String text, Menu menu, ImagePanel gui) {
        super(text);
        _menu = menu;
        panel = gui;
        this.addActionListener(new UploadButtonListener());
        this.setActionCommand(text);
    }

    private class UploadButtonListener implements ActionListener
    {
        //If the button is clicked it terminates the program.
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO Auto-generated method stub
            if(e.getActionCommand().equals("Upload"))
            {
                //Asks the user to select a file
                JFileChooser upload = new JFileChooser();
                upload.setCurrentDirectory(new File("."));
                int res = upload.showOpenDialog(null);
                //run once the user has selected a file
                if(res == JFileChooser.APPROVE_OPTION) {
                    //get the path of the file
                    File path = new File(upload.getSelectedFile().getAbsolutePath());
                    try {
                        //turn the file into an image
                        img = ImageIO.read(path);
                        System.out.println(img);
                        //paint the image to the gui
                        panel.setImage(img);
                        //panel.setCentering(true);
                        panel.repaint();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    System.out.println(path);
                }
            }
        }

    }
    //returns the current image
    public BufferedImage getImage() {
        return img;
    }
}
