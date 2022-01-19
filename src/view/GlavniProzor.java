package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.ControllerPredmet;
import controller.ControllerProfesor;
import controller.ControllerStudent;
import model.DataBase;

public class GlavniProzor extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static TabbedPane tabbedPane;
	static GlavniProzor glavniProzor;
	static StatusBar statusBar;
	static ControllerStudent controllerStudent = new ControllerStudent();
	static ControllerProfesor controllerProfesor = new ControllerProfesor();
	static ControllerPredmet controllerPredmet = new ControllerPredmet();
	static DataBase dataBase;
	
	GlavniProzor(){
		
		glavniProzor = this;
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
		
		dataBase = new DataBase();
		try {
			dataBase.deserialize();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		MenuBar menu = new MenuBar();
		setJMenuBar(menu);
		
		ToolBar toolbar = new ToolBar();
		Dimension d = getSize();
		toolbar.setPreferredSize(new Dimension(d.width, 40));
		add(toolbar, BorderLayout.NORTH);
		
		statusBar = new StatusBar();
		add(statusBar, BorderLayout.SOUTH);
		
		tabbedPane = new TabbedPane();
		statusBar.updateStatusBar(tabbedPane.getSelectedIndex());
		tabbedPane.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				statusBar.updateStatusBar(tabbedPane.getSelectedIndex());
			}
		});
		add(tabbedPane, BorderLayout.CENTER);
		
		
	}
	
	public static TabbedPane getTabbedPane() {
		if(tabbedPane == null)
			tabbedPane = new TabbedPane();
		return tabbedPane;
	}
	public static GlavniProzor getGlavniProzor() {
		if(glavniProzor == null)
			glavniProzor = new GlavniProzor();
		return glavniProzor;
	}
	
	public static ControllerStudent getControllerStudent() {
		return controllerStudent;
	}
	public static ControllerProfesor getControllerProfesor() {
		return controllerProfesor;
	}
	public static ControllerPredmet getControllerPredmet() {
		return controllerPredmet;
	}
	
	public static void serialize() {
		try {
			dataBase.serialize();
		}catch(Exception exc){
			exc.printStackTrace();
		}
	}

	
}
