import boofcv.gui.image.ImagePanel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class App extends JFrame {

    JPanel content;
    ImagePanel gui;
    Menu menu;
    
    public App(){
        super("Blur Image");
        this.setSize(900,900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        content = new JPanel(new BorderLayout());
        gui = new ImagePanel();
        menu = new Menu(gui);
        content.add(gui, BorderLayout.CENTER);
        content.add(menu, BorderLayout.SOUTH);

        this.add(content);
        this.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
