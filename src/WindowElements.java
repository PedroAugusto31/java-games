package src;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class WindowElements extends Canvas implements Runnable{

    private static final long serialVersionUID = 1L;

    private int width = 850;
    private int height = 550;

    private BufferedImage image;

    public JFrame frame;

    //Constructor method
    public WindowElements() {
        this.setPreferredSize(new Dimension(width, height));
        initFrame();
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }
    
    private void initFrame() {
       JFrame frame = new JFrame("Window with elements");
        frame.add(this);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        WindowElements test = new WindowElements();
        new Thread(test).start();
    }
    
    //this is the game loop, it's a prety simple one just to make it work
    public void run() {
        while(true){
            update();
            render();
            requestFocus();
            try{
                Thread.sleep(1000/60);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //I'm not going to use this now, but I'll show you how to do things with this method later :)
    private void update() {

    }
    //The method that we use to put things on the screen
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = image.getGraphics();
        //Kinda making the "background"
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, width, height);

        //This part is to put a blue ball on the screen
        g.setColor(new Color(0, 0, 255));
        g.fillOval(60, 60, 50, 50);

        g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, width, height, null);

        bs.show();
    }

}
