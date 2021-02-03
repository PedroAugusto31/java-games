package src;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class UsingUpdate extends Canvas implements Runnable{
    
    
    private static final long serialVersionUID = 1L;

    private int width = 850;
    private int height = 550;

    private int ballX = 60;
    private int ballY = 60;

    private BufferedImage image;

    public JFrame frame;

    //Constructor method
    public UsingUpdate() {
        this.setPreferredSize(new Dimension(width, height));
        initFrame();
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }
    
    private void initFrame() {
       JFrame frame = new JFrame("Using update");
        frame.add(this);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        UsingUpdate test = new UsingUpdate();
        new Thread(test).start();
    }
    
    //Game loop
    public void run() {
        while(true){
            //it's important to remind that the update method goes first ok?
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

    //Now I'll use this, this method is used to make things happen, this time I'll show how to make the ball go forward.
    private void update() {

        //Just increasing the ballX one by one is too slow so you can put another variable to work like the speed
    
        int speed = 5;
        //It will keep going forward until it gets to the 500th pixel.
        if(ballX <= 500) {
        //ballX++;
        ballX += speed;
        // you can put it like this too, ballX = ballX + speed;
        //It's the same thing.
      }
    }
    //Render
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = image.getGraphics();
        //Background
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, width, height);

        //I'll put the coordinates as the variables ballX and ballY to change them with the update method
        g.setColor(new Color(0, 0, 255));
        g.fillOval(ballX, ballY, 50, 50);

        g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, width, height, null);

        bs.show();
    }
}
