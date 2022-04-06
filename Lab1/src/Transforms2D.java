import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;
import java.io.IOException;

public class Transforms2D extends JPanel {

private class Display extends JPanel {
    
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    g2.translate(300,300);  // Moves (0,0) to the center of the display.
    int whichTransform = transformSelect.getSelectedIndex();
    
    switch(whichTransform)
    {
        case 0: break;
        case 1:
            g2.scale(0.5,0.5);
            break;

        case 2: 
        
            g2.rotate(0.5);
            break;

        case 3:
            g2.scale(0.5,0.8);
            g2.rotate(Math.toRadians(180));
            break;

        case 4:
            g2.shear(0.35,0);
            break;

        case 5:
            g2.scale(1,0.3);
            g2.translate(0,-900);
            break;

        case 6:
            g2.shear(0,-0.5);
            g2.rotate(Math.PI / 2);
            break;

        case 7:
            g2.scale(0.5, 1);
            g2.rotate(Math.PI);
            break;
        

        case 8:
            g2.rotate(Math.toRadians(30));
            g2.scale(1,0.3);
            g2.translate(0,800);
            break;

        case 9:
            g2.translate(150, 0);
            g2.shear(0, 0.25);
            g2.rotate(Math.PI);
            break;
        }



    int[] x = new int[12];
    int[] y = new int[12];
    

    for(int i=0; i<12; i++)
    {
        x[i] = (int) (150*Math.cos((2*Math.PI/12)*i));
    }
    for(int i=0; i<12; i++)
    {
        y[i] = (int) (150*Math.sin((2*Math.PI/12)*i));
    }

    Polygon dwunastokat = new Polygon(x, y, 12);
    g2.fillPolygon(dwunastokat);
    }
}

    private Display display;

    private JComboBox<String> transformSelect;

    public Transforms2D() throws IOException {

    display = new Display();
    display.setBackground(Color.BLUE);
    display.setPreferredSize(new Dimension(600,600));
    
    transformSelect = new JComboBox<String>();
    transformSelect.addItem("None");
    for (int i = 1; i <= 9; i++) {
        transformSelect.addItem("No. " + i);
    }
    transformSelect.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            display.repaint();
        }
    });
    
    setLayout(new BorderLayout(3,3));
    setBackground(Color.BLUE);
    setBorder(BorderFactory.createLineBorder(Color.BLUE,10));
    
    JPanel top = new JPanel();
    
    top.setLayout(new FlowLayout(FlowLayout.CENTER));
    top.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
    top.add(new JLabel("Transform: "));
    top.add(transformSelect);
    
    add(display,BorderLayout.CENTER);
    add(top,BorderLayout.NORTH);
    }

    public static void main(String[] args) throws IOException {
        JFrame window = new JFrame("2D Transforms");
        window.setContentPane(new Transforms2D());
        window.pack();
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation( (screen.width - window.getWidth())/2, (screen.height - window.getHeight())/2 );
        window.setVisible(true);
    }
}