package view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class ToolBar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ToolBar(){
		
		super(SwingConstants.HORIZONTAL);
		
		JButton btnAdd = new JButton();
		btnAdd.setToolTipText("Add");
		btnAdd.setMnemonic(KeyEvent.VK_A);
		btnAdd.setIcon(new ImageIcon("images/plus_button.png"));
		add(btnAdd);
		
		addSeparator();
		
		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Edit");
		btnEdit.setMnemonic(KeyEvent.VK_T);
		btnEdit.setIcon(new ImageIcon("images/edit_button.png"));
		add(btnEdit);
		
		addSeparator();
		
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setMnemonic(KeyEvent.VK_D);
		btnDelete.setIcon(new ImageIcon("images/delete_button.png"));
		add(btnDelete);
		
		add(Box.createHorizontalGlue());
		addSeparator();
		
		JTextField searchField = new JTextField(30);
		searchField.setMaximumSize(new Dimension(350,25));
		searchField.setMinimumSize(new Dimension(350,25));
		searchField.setToolTipText("Search field");
		add(searchField);	
		
		addSeparator();
		
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setMnemonic(KeyEvent.VK_S);
		btnSearch.setIcon(new ImageIcon("images/search_button1.png"));
		add(btnSearch);
		
		setFloatable(true);
		setBackground(new Color(126, 125, 123));
		
	}
	
	
	

}
