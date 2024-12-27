import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.*;


class game extends JPanel implements ActionListener, KeyListener{

    Timer t = new Timer(5, this);

    double x = 0, y = 0;
    double x2 = 100, y2 = 100;
    double velx = 5, vely = 5;
    double velx2 = 5, vely2 = 5;

    int x3 = 0, y3 = 0;
    double velx3 = 5, vely3 = 5;
    Image image;

    public game(){
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        image = new ImageIcon("domo.jpg").getImage();
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        Rectangle2D rec = new Rectangle2D.Double(x, y, 20, 20);
        Ellipse2D oval = new Ellipse2D.Double(x2, y2, 50, 50);

        g2.drawImage(image, x3, y3, 50, 50, getFocusCycleRootAncestor());
        g2.setPaint(Color.BLUE);
        g2.fill(oval);
        g2.setPaint(Color.GREEN);
        g2.fill(rec);

        if(oval.intersects(rec)){
            x = 0;
            y = 0;
        }

    }





    public static void main(String [] args){

        game s = new game();
        JFrame f = new JFrame();

        f.getContentPane().add(s);
        s.setBackground(Color.PINK);
        f.setVisible(true);
        f.setSize(600, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }







    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_UP){
            y-=vely;
        }
        if(code == KeyEvent.VK_DOWN){
            y+=vely;
        }
        if(code == KeyEvent.VK_RIGHT){
            x+=velx;
        }
        if(code == KeyEvent.VK_LEFT){
            x-=velx;
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        x2 += velx2;
        y2 += vely2;

        x3 += velx3;
        y3 += velx3;

        if(x2 > 570 || x2 < 0){
            velx2  = -velx2;
        }
        if(y2 > 450 || y2 < 0){
            vely2 = -vely2;
        }

        if(x3 > 570 || x3 < 0){
            velx3  = -velx3;
        }
        if(y3 > 450 || y3 < 0){
            vely3 = -vely3;
        }
        repaint();


    }


}