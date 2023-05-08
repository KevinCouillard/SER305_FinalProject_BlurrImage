import boofcv.gui.image.ImagePanel;

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
                JFileChooser upload = new JFileChooser();
                upload.setCurrentDirectory(new File("."));
                int res = upload.showOpenDialog(null);

                if(res == JFileChooser.APPROVE_OPTION) {
                    File path = new File(upload.getSelectedFile().getAbsolutePath());
                    //BufferedImage img = new BufferedImage(400,400,BufferedImage.TYPE_4BYTE_ABGR);
                    try {
                        BufferedImage img = ImageIO.read(path);
                        System.out.println(img);
                        panel.setImage(img);
                        panel.setCentering(true);
                        panel.repaint();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    System.out.println(path);
                }
            }
        }

    }
}
