import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JToolBar;
import java.awt.BorderLayout;

public class Menu extends JPanel{
    
    public Menu(){
        super(new BorderLayout());
        
        JToolBar toolbar = new JToolBar();
        JButton upload = new JButton("Upload");
        JButton download = new JButton("Download");
        toolbar.add(upload);
        toolbar.add(download);
        add(toolbar, BorderLayout.PAGE_START);
        
    }

}
