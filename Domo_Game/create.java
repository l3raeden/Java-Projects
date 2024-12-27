import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

public class create extends JFrame implements KeyListener, ActionListener{

    JButton button;
    JLabel label;
    ImageIcon image;
    Timer timer;
    Image mush;
    
    private int xvelo = 5;
    private int yvelo = 5;
    private int x;
    private int y;


    create(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1000,700);
        this.addKeyListener(this);
        this.getContentPane().setBackground(Color.BLACK);

        label = new JLabel();
        mush = new ImageIcon("mushroom.jpg").getImage();

        label.setBounds(0,0,200,200);
        this.add(label);
        image = new ImageIcon("domo.jpg");
        label.setIcon(image);

        this.setVisible(true);

        timer = new Timer(1000, null);
        timer.start();


    }


    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch(e.getKeyChar()){
            case 'a': label.setLocation(label.getX()-10, label.getY());
                break;
            case 'w': label.setLocation(label.getX(), label.getY()-10);
                break;
            case 's': label.setLocation(label.getX(), label.getY()+10);
                break;
            case 'd': label.setLocation(label.getX()+10, label.getY());
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       System.out.println("You typed: " + e.getKeyChar());
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        x += xvelo;
        repaint();

        
    }

    public void paint(Graphics g){
        
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.drawImage(mush, 200, 200, null);
       

    }

   
}
