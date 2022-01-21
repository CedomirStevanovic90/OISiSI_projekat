package view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.AddButtonListener;
import controller.DeleteButtonListener;
import controller.EditButtonListener;
import controller.SearchButtonListener;

public class ToolBar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTextField searchField;
	
	public ToolBar(){
		
		super(SwingConstants.HORIZONTAL);
		
		JButton btnAdd = new JButton();
		btnAdd.setMaximumSize(new Dimension(30, 30));
		btnAdd.setMinimumSize(new Dimension(30, 30));
		btnAdd.setPreferredSize(new Dimension(30, 30));
		btnAdd.setToolTipText("Add");
		btnAdd.setMnemonic(KeyEvent.VK_A);
		btnAdd.setIcon(new ImageIcon("images/plus_button.png"));
		btnAdd.addActionListener(new AddButtonListener());
		add(btnAdd);
		
		addSeparator();
		
		JButton btnEdit = new JButton();
		btnEdit.setMaximumSize(new Dimension(30, 30));
		btnEdit.setMinimumSize(new Dimension(30, 30));
		btnEdit.setPreferredSize(new Dimension(30, 30));
		btnEdit.setToolTipText("Edit");
		btnEdit.setMnemonic(KeyEvent.VK_T);
		btnEdit.setIcon(new ImageIcon("images/edit_button.png"));
		btnEdit.addActionListener(new EditButtonListener());
		add(btnEdit);
		
		addSeparator();
		
		JButton btnDelete = new JButton();
		btnDelete.setMaximumSize(new Dimension(30, 30));
		btnDelete.setMinimumSize(new Dimension(30, 30));
		btnDelete.setPreferredSize(new Dimension(30, 30));
		btnDelete.setToolTipText("Delete");
		btnDelete.setMnemonic(KeyEvent.VK_D);
		btnDelete.setIcon(new ImageIcon("images/delete_button.png"));
		btnDelete.addActionListener(new DeleteButtonListener());
		add(btnDelete);
		
		add(Box.createHorizontalGlue());
		addSeparator();
		
		searchField = new JTextField(30);
		searchField.setMaximumSize(new Dimension(350, 30));
		searchField.setMinimumSize(new Dimension(350, 30));
		searchField.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				int tab = GlavniProzor.getTabbedPane().getSelectedIndex();
				switch(tab) {
				case 0:
					ToolBar.searchField.setToolTipText("<html>" + "Formati Pretrage :"
														+ "<br>" + "1. Prezime"
														+ "<br>" + "2. Prezime, Ime"
														+ "<br>" + "3. Index, Ime, Prezime" 
														+"</html>");
					break;
				case 1:
					ToolBar.searchField.setToolTipText("<html>" + "Formati Pretrage :"
							   							+ "<br>" + "1. Prezime"
							   							+ "<br>" + "2. Prezime, Ime"
							   							+"</html>");
					break;
				case 2:
					ToolBar.searchField.setToolTipText("<html>" + "Formati Pretrage :"
														+ "<br>" + "1. Naziv"
														+ "<br>" + "2. Sifra, Naziv"
														+"</html>");
					break;
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		add(searchField);
		
		JButton btnSearch = new JButton();
		btnSearch.setPreferredSize(new Dimension(30, 30));
		btnSearch.setMaximumSize(new Dimension(30, 30));
		btnSearch.setMinimumSize(new Dimension(30, 30));
		btnSearch.setToolTipText("Search");
		btnSearch.setMnemonic(KeyEvent.VK_S);
		btnSearch.setIcon(new ImageIcon("images/search_button1.png"));
		btnSearch.addActionListener(new SearchButtonListener());
		add(btnSearch);
		
		setFloatable(false);
		setBackground(new Color(175, 175, 175));
	}
}
