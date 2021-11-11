package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GlavniProzor extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	GlavniProzor(){
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		setSize(screenWidth * 3/4, screenHeight * 3/4);
		setTitle("Studentska služba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		ImageIcon image = new ImageIcon("images/university.png");
		setIconImage(image.getImage());
		
		MenuBar menu = new MenuBar();
		setJMenuBar(menu);
		
	}
	

}
