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
    private ImagePanel panel;
    public UploadButton(String text, Menu menu, ImagePanel gui) {
        super(text);
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
                    BufferedImage inputImage = null;
                    try {
                        inputImage = ImageIO.read(new File(upload.getSelectedFile().getAbsolutePath()));
                    } catch (IOException i) {
                        i.printStackTrace();
                    }

                    // Convert the image to GrayF32 format
                    GrayF32 grayImage = ConvertBufferedImage.convertFrom(inputImage, (GrayF32) null);

                    // Create a new GrayF32 image to hold the blurred image
                    GrayF32 blurredImage = new GrayF32(grayImage.width, grayImage.height);

                    // Blur the image with a Gaussian kernel of size 5x5 and sigma = 1.0
                    BlurImageOps.gaussian(grayImage, blurredImage, -1, (int) 4.0, null);

                    // Convert the blurred image back to BufferedImage format
                    BufferedImage outputImage = ConvertBufferedImage.convertTo(blurredImage, (BufferedImage) null);

                    // Save the blurred image to a file
//                    File outputFile = new File("blurred_image.jpg");
//                    try {
//                        ImageIO.write(outputImage, "jpg", outputFile);
//                    } catch (IOException i) {
//                        i.printStackTrace();
//                    }

                    panel.setImage(outputImage);
                    panel.setCentering(true);
                    panel.repaint();
                }
            }
        }
    }
}
