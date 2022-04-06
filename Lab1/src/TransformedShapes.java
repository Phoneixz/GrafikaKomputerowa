

import java.awt.*;
import javax.swing.*;
import java.awt.geom.AffineTransform;


public class TransformedShapes extends JPanel {

	//------- For drawing ONLY while paintComponent is being executed! --------

	private Graphics2D g2; // A copy of the graphics context from paintComponent.

	/**
	 * Removes any transformations that have been applied to g2, so that
	 * it is back to the standard default coordinate system.
	 */
	private void resetTransform() {
		g2.setTransform(new AffineTransform());
	}

	

 /*void triangle(){
     int [] xpoints = {50,150,250};
     int [] ypoints  = {250,150,250};
     int nPoints = 3;
     g2.scale(2.5,2.5);
     g2.translate(0,1);
     g2.fillPolygon(xpoints, ypoints, nPoints);
    
 }*/
 
 
 void square() {
		g2.fillRect(50,50,200,200);
	}
 
 
	//-----------------------------------------------------------------------------------


	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D)g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		/*g2.setColor(Color.white);
		g2.scale(2, 2);
		square();
		*/
	
		resetTransform();
	
	
		g2.setColor(Color.red);
		g2.fillRect(50, 50, 500, 15);
		g2.fillRect(50,550, 500,15);
		g2.rotate(Math.toRadians(135), 549, 57);
		g2.fillRect(550, 50, 705, 15);
	} 

	public TransformedShapes() {
		setPreferredSize(new Dimension(600,600) );
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
	}

	public static void main(String[] args)  {
		JFrame window = new JFrame("Drawing With Transforms");
		window.setContentPane(new TransformedShapes());
		window.pack();
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation( (screen.width - window.getWidth())/2, (screen.height - window.getHeight())/2 );
		window.setVisible(true);
	}

}