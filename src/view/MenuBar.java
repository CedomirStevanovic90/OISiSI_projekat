package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MenuBar(){
		
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem miNew = new JMenuItem("New", new ImageIcon("images/add_button.png"));
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		
		JMenuItem miSave = new JMenuItem("Save", new ImageIcon("images/save_button.png"));
		miSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		JMenu miOpen = new JMenu("Open");
		miOpen.setMnemonic(KeyEvent.VK_O);
		miOpen.setIcon(new ImageIcon("images/open_button.png"));
		
		JMenuItem miClose = new JMenuItem("Close", new ImageIcon("images/close_button.png"));
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		JMenuItem miStudent = new JMenuItem("Students", new ImageIcon("images/student_button.png"));
		miStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		JMenuItem miSubject = new JMenuItem("Subjects", new ImageIcon("images/subject_button.png"));
		miSubject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		
		JMenuItem miProfesor = new JMenuItem("Professors", new ImageIcon("images/professor_button.png"));
		miProfesor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		
		JMenuItem miDepartment = new JMenuItem("Departments", new ImageIcon("images/department_button.png"));
		miDepartment.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		miOpen.add(miStudent);
		miOpen.addSeparator();
		miOpen.add(miSubject);
		miOpen.addSeparator();
		miOpen.add(miProfesor);
		miOpen.addSeparator();
		miOpen.add(miDepartment);
		
		
		fileMenu.add(miNew);
		fileMenu.addSeparator();
		fileMenu.add(miSave);
		fileMenu.addSeparator();
		fileMenu.add(miOpen);
		fileMenu.addSeparator();
		fileMenu.add(miClose);
		
		JMenu editMenu= new JMenu("Edit");
		
		JMenuItem miEdit = new JMenuItem("Edit", new ImageIcon("images/edit_button.png"));
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		
		JMenuItem miDelete = new JMenuItem("Delete", new ImageIcon("images/delete_button.png"));
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		editMenu.add(miEdit);
		editMenu.addSeparator();
		editMenu.add(miDelete);
		
		JMenu helpMenu = new JMenu("Help");
		
		JMenuItem miHelp = new JMenuItem("Help", new ImageIcon("images/help_button.png"));
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		
		JMenuItem miAbout = new JMenuItem("About", new ImageIcon("images/about_button.png"));
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
		helpMenu.add(miHelp);
		helpMenu.addSeparator();
		helpMenu.add(miAbout);
		
		
		add(fileMenu);
		add(editMenu);
		add(helpMenu);
		
		
		}
		
		
	}
	
	
	
	


