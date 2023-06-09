import boofcv.gui.image.ImagePanel;

import javax.swing.*;
import java.awt.BorderLayout;

public class Menu extends JPanel {
    UploadButton upload;
    JButton download;
    ImagePanel gui;

    public Menu(ImagePanel image) {
        super(new BorderLayout());
        gui = image;
        JToolBar toolbar = new JToolBar();
        //Add the buttons
        upload = new UploadButton("Upload", this, gui);
        download = new DownloadButton("Download", this, gui);
        toolbar.add(upload);
        toolbar.add(download);
        add(toolbar, BorderLayout.PAGE_START);

    }
}
