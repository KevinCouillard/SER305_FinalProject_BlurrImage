import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JToolBar;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

public class Menu extends JPanel {

    public Menu() {
        super(new BorderLayout());

        JToolBar toolbar = new JToolBar();
        JButton upload = new JButton("Upload");
        JButton download = new JButton("Download");
        download.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });
        toolbar.add(upload);
        toolbar.add(download);
        add(toolbar, BorderLayout.PAGE_START);

    }

}
