import boofcv.gui.image.ImagePanel;
import javax.swing.JFrame;

public class App extends JFrame {

    ImagePanel gui = new ImagePanel();

    public App() {
        super("Blur Image");
        this.setSize(900, 900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.add(gui);
        this.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
