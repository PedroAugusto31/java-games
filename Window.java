import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
public class Window extends Canvas{
    
    private static final long serialVersionUID = 1L;

    public JFrame frame;

    private int width = 850;
    private int height = 550;

    public Window() {
        this.setPreferredSize(new Dimension(width, height));
        initFrame();
    }

    /*
    * This method makes the window, you can put true on setResizable() but I don't like it too much,
    * setVisible() must be true
    */
    public void initFrame() {
        frame = new JFrame("Window test");
        frame.add(this);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    /*
    * Main method, make a new object to create the window and then the window will be created
    */
    public static void main(String [] args) {
        Window test = new Window();
    }

    /*
    * I hope that everything is okay and I do hope that I could help you if you had a problem with this
    * If you have any suggestion, talk to me on e-mail :)
    */
}
