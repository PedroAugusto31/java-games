package src;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class puttingImages extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    private int width = 750;
    private int height = 450;

    private BufferedImage testImage;
    public BufferedImage image;

    //Constructor method
    public puttingImages() {
        this.setPreferredSize(new Dimension(width, height));
        initFrame();

        try {
            //That's an image that I downloaded and I'll keep it on the folder "res".
            testImage = ImageIO.read(new File("src/res/coolImage.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    
    private void initFrame() {

        JFrame frame = new JFrame("Images");
        frame.add(this);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    //Main method
    public static void main(String [] args) {
        puttingImages test = new puttingImages();
        new Thread(test).start();
    }

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

    public void update(){

    }
    //If you putted the right path on the file, it will definitely work.
    public void render() {

        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = image.getGraphics();

        g.setColor(Color.blue);
        g.fillRect(0, 0, width, height); 

        
        g.drawImage(testImage, 40, 35, 250, 250, null);

        g.dispose();
        g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, width, height, null);

        bs.show();
    }

    //I hope that I could help anyone, it was kinda hard to put this because ImageIO is too Unisntable, and I still
    //got stuck for some time to get the right path.
}
