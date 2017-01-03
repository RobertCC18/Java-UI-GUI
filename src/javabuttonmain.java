/*
 * This is KATA 2  
 * The requirements for this challenge were to build a GUI application that had a text object that blinked and a button that changed the text color
 * The text also had to be able to be moved by the mouse.
 */ 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class javabuttonmain {
public static void main( String[] args) {
	JFrame frame = new JFrame("Java application 3");
	frame.add( new HelloComponent3(" Java application 3") );
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize( 300, 300);
	frame.setVisible( true );
	
	
}
}

class HelloComponent3 extends JComponent 
	implements MouseMotionListener, ActionListener
	{
		String theMessage;
		int messageX = 125, messageY = 95;
		
		JButton theButton;
		int colorIndex; 
		static Color[] someColors = {
				Color.black, Color.red, Color.green, Color.blue, Color.magenta };
	
	public HelloComponent3( String message) {
		theMessage = message;
		theButton = new JButton("Change Color");
		setLayout(new FlowLayout());
		add( theButton);
		theButton.addActionListener(this);
		addMouseMotionListener( this);
		}
	
	public void paintComponent(Graphics g) {
		g.drawString(theMessage, messageX, messageY);	
		
	}
	
	public void mouseDragged( MouseEvent e){
		messageX = e.getX();
		messageY = e.getY();
		repaint();
		}
	
	public void mouseMoved( MouseEvent e){}
	
	public void actionPerformed( ActionEvent e) {
		if (e.getSource() == theButton)
			changeColor();
		}
	
	synchronized private void changeColor() {
		if (++colorIndex == someColors.length)
			colorIndex= 0;
		setForeground( currentColor());
		repaint();
		}
	
	synchronized private Color currentColor() {
		return someColors[colorIndex];
		}
	}