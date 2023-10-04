//Name: Ivan Foo
//Student number: 10228006
//Tutorial group: T07
//Declaration: This is my progamme
//
//filename: IvanFoo_Assignment_3.java

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

class Part
{
	private String nameButton;
	private String fullName;
	private String tutorialGp;
	private String imageFile;
	
	public Part (String nameButton, String fullName, String tutorialGp, String imageFile)
	{
		this.nameButton = nameButton;
		this.fullName = fullName;
		this.tutorialGp = tutorialGp;
		this.imageFile = imageFile;
	}
	
	public String getNameButton ()
	{
		return nameButton;
	}
	
	public String getFullName ()
	{
		return fullName;
	}
	
	public String getTutorialGp ()
	{
		return tutorialGp;
	}
	
	public String getImageFile ()
	{
		return imageFile;
	}
	
	public String toString ()
	{
		return String.format ("Hi! I am participant %s%nMy name is: %s%nI am from tutorial group: %s%nMy Question: %n", 
				nameButton, fullName, tutorialGp);
	}
	
}

class Programme extends JFrame
{
	//private JFrame frame;
	private JLabel studentLabel, hostLabel;
	private JTextArea studentText, hostText;
	private JButton [ ] studentButton;
	private JButton hostButton, clearButton;
	
	public Programme ()
	{
		super ("Q & A Room");
		setSize (725, 650);
		setLayout (new FlowLayout ());
		
		ArrayList <Part> alist = new ArrayList <Part> ();
		constructAlist (alist);
		
		//images & font for student, host, clear
		ImageIcon icon = new ImageIcon ("cry.jpg");
		Image image = icon.getImage ();
		Image resize = image.getScaledInstance (50, 50, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon (resize);
		
		ImageIcon icon2 = new ImageIcon ("smile.png");
		Image image2 = icon2.getImage ();
		Image resize2 = image2.getScaledInstance (50, 50, java.awt.Image.SCALE_SMOOTH);
		icon2 = new ImageIcon (resize2);
		
		ImageIcon icon3 = new ImageIcon ("bin.jpg");
		Image image3 = icon3.getImage ();
		Image resize3 = image3.getScaledInstance (50, 50, java.awt.Image.SCALE_SMOOTH);
		icon3 = new ImageIcon (resize3);
		
		Font font = new Font (Font.MONOSPACED, Font.PLAIN, 13);
		Font buttonFont = new Font (Font.DIALOG, Font.BOLD, 13);
		
		//student label above chat box
		studentLabel = new JLabel ("Student Area");
		add (studentLabel);
		
		//student chat box
		studentText = new JTextArea (".....");
		studentText.setFont (font);
		studentText.setLineWrap (true);
		studentText.setPreferredSize (new Dimension (700, 100));
		studentText.setBackground (Color.black);
		studentText.setForeground (Color.white);
		add (studentText);
		
		//host label above chat box
		hostLabel = new JLabel ("Host Area");
		add (hostLabel);
		
		//host chat box
		hostText = new JTextArea (".....");
		hostText.setFont (font);
		hostText.setLineWrap (true);
		hostText.setPreferredSize (new Dimension (700, 100));
		hostText.setBackground (Color.BLUE);
		hostText.setForeground (Color.white);
		add (hostText);
		
		//filler spaces between host chat box and buttons
		add (Box.createHorizontalStrut(1000));
		add (Box.createHorizontalStrut(1000));
		add (Box.createHorizontalStrut(1000));
		
		//student buttons
		studentButton = new JButton [alist.size()];
		for (int i = 0; i < studentButton.length; i++)
		{
			studentButton [i] = new JButton (alist.get(i).getNameButton(), icon);
			studentButton [i].setPreferredSize (new Dimension (150, 75));
			studentButton [i].setFocusable(true);
			studentButton [i].setFont (buttonFont);
			studentButton [i].setOpaque (true);
			studentButton [i].setBackground (Color.red);
			
			final Integer innerCount = Integer.valueOf (i);
			
			studentButton[i].addActionListener (e -> {
				for (JButton btn : studentButton)
				{
					if (btn.equals(e.getSource ()))
					{
						JOptionPane.showConfirmDialog (null, alist.get(innerCount).toString () + studentText.getText (), 
								"Welcome to the chat room!",JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, 
								new ImageIcon (alist.get (innerCount).getImageFile ()));
					}
					
				}
			});
			
			studentButton [i].addMouseListener (new MouseAdapter () {
			    public void mouseEntered (MouseEvent e) {
			    	((Component) e.getSource ()).setBackground(Color.green);
			    }
			    public void mouseExited (MouseEvent e) {
			    	((Component) e.getSource ()).setBackground(Color.red);
			    }
			});
			add (studentButton [i]);
		}
		
		//host button configurations
		hostButton = new JButton ("Host", icon2);
		hostButton.setPreferredSize (new Dimension (150, 75));
		hostButton.setFont (buttonFont);
		hostButton.setOpaque (true);
		hostButton.setBackground (Color.red);
		hostButton.addActionListener (e -> {
			JOptionPane.showMessageDialog (null, hostText.getText (), 
									"I am the host", JOptionPane.INFORMATION_MESSAGE, new ImageIcon ("host.png"));
		});
		hostButton.addMouseListener (new MouseAdapter() {
		    public void mouseEntered (MouseEvent e) {
		    	hostButton.setBackground(Color.green);
		    }
		    
		    public void mouseExited (MouseEvent e) {
		    	hostButton.setBackground(Color.red);
		    }
		});
		add (hostButton);
		
		//clear button configurations
		clearButton = new JButton ("CLEAR", icon3);
		clearButton.setPreferredSize (new Dimension (150, 75));
		clearButton.setOpaque (true);
		clearButton.setFont (buttonFont);
		clearButton.setForeground (Color.red);
		clearButton.setBackground (Color.red);
		clearButton.addActionListener (e -> {
			studentText.setText ("");
			hostText.setText ("");
		});
		clearButton.addMouseListener (new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		    	clearButton.setBackground(Color.green);
		    }
		    
		    public void mouseExited (MouseEvent e) {
		    	clearButton.setBackground(Color.red);
		    }
		});
		add (clearButton);
		
		setVisible (true);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	}
	
	private void constructAlist (ArrayList <Part> alist)
	{
		Part p1 = new Part ("Student 1", "Ah Heng", "T1","1.jpg");
		Part p2 = new Part ("Student 2", "Ah Lim", "T2", "2.jpg");
		Part p3 = new Part ("Student 3", "Ah Mao", "T3", "3.jpg");
		Part p4 = new Part ("Student 4", "Ah Gou", "T4", "4.jpg");
		
		alist.add (p1);
		alist.add (p2);
		alist.add (p3);
		alist.add (p4);
	}
}

public class IvanFoo_Assignment_3 
{
	public static void main(String[] args) 
	{
		
		new Programme ();
	
	}

}
