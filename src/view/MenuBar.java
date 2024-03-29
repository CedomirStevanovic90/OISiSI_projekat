package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.AddButtonListener;
import controller.DeleteButtonListener;
import controller.EditButtonListener;

public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MenuBar(){
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		JMenuItem miNew = new JMenuItem("New", new ImageIcon("images/add_button.png"));
		miNew.setMnemonic(KeyEvent.VK_N);
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		miNew.addActionListener(new AddButtonListener());
		
		JMenuItem miSave = new JMenuItem("Save", new ImageIcon("images/save_button.png"));
		miSave.setMnemonic(KeyEvent.VK_S);
		miSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		JMenu miOpen = new JMenu("Open");
		miOpen.setMnemonic(KeyEvent.VK_O);
		miOpen.setIcon(new ImageIcon("images/open_button.png"));
		
		JMenuItem miClose = new JMenuItem("Close", new ImageIcon("images/close_button.png"));
		miClose.setMnemonic(KeyEvent.VK_C);
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		miClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String [] options = {"Yes", "No"};
				int code = JOptionPane.showOptionDialog(null, "Do you want to close the application?", "Application closing", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);

		         if(code == JOptionPane.YES_OPTION){
		        	System.exit(0);
		         }
			}
		});
		
		JMenuItem miStudent = new JMenuItem("Students", new ImageIcon("images/student_button.png"));
		miStudent.setMnemonic(KeyEvent.VK_S);
		miStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		JMenuItem miSubject = new JMenuItem("Subjects", new ImageIcon("images/subject_button.png"));
		miSubject.setMnemonic(KeyEvent.VK_U);
		miSubject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		
		JMenuItem miProfesor = new JMenuItem("Professors", new ImageIcon("images/professor_button.png"));
		miProfesor.setMnemonic(KeyEvent.VK_P);
		miProfesor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		
		JMenuItem miDepartment = new JMenuItem("Departments", new ImageIcon("images/department_button.png"));
		miDepartment.setMnemonic(KeyEvent.VK_D);
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
		editMenu.setMnemonic(KeyEvent.VK_E);
		
		JMenuItem miEdit = new JMenuItem("Edit", new ImageIcon("images/edit_button.png"));
		miEdit.setMnemonic(KeyEvent.VK_E);
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		miEdit.addActionListener(new EditButtonListener());
		
		JMenuItem miDelete = new JMenuItem("Delete", new ImageIcon("images/delete_button.png"));
		miDelete.setMnemonic(KeyEvent.VK_D);
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		miDelete.addActionListener(new DeleteButtonListener());
		
		editMenu.add(miEdit);
		editMenu.addSeparator();
		editMenu.add(miDelete);
		
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);
		
		JMenuItem miHelp = new JMenuItem("Help", new ImageIcon("images/help_button.png"));
		miHelp.setMnemonic(KeyEvent.VK_H);
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		
		JMenuItem miAbout = new JMenuItem("About", new ImageIcon("images/about_button.png"));
		miAbout.setMnemonic(KeyEvent.VK_A);
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		miAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {	
				AboutDialog about = new AboutDialog();
				about.pack();
				about.setLocationRelativeTo(null);
				about.setVisible(true);
			}
		});
		
		helpMenu.add(miHelp);
		helpMenu.addSeparator();
		helpMenu.add(miAbout);
		
		
		add(fileMenu);
		add(editMenu);
		add(helpMenu);
		
		
		}
		
		
	}
	
	
	
	


