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
import javax.swing.plaf.DimensionUIResource;

public class ToolBar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ToolBar(){
		
		super(SwingConstants.HORIZONTAL);
		
		JButton btnAdd = new JButton();
		btnAdd.setMaximumSize(new Dimension(33,33));
		btnAdd.setMinimumSize(new Dimension(33,33));
		btnAdd.setPreferredSize(new Dimension(33,33));
		btnAdd.setToolTipText("Add");
		btnAdd.setMnemonic(KeyEvent.VK_A);
		btnAdd.setIcon(new ImageIcon("images/plus_button.png"));
		add(btnAdd);
		
		addSeparator();
		
		JButton btnEdit = new JButton();
		btnEdit.setMaximumSize(new Dimension(33,33));
		btnEdit.setMinimumSize(new Dimension(33,33));
		btnEdit.setPreferredSize(new Dimension(33,33));
		btnEdit.setToolTipText("Edit");
		btnEdit.setMnemonic(KeyEvent.VK_T);
		btnEdit.setIcon(new ImageIcon("images/edit_button.png"));
		add(btnEdit);
		
		addSeparator();
		
		JButton btnDelete = new JButton();
		btnDelete.setMaximumSize(new Dimension(33,33));
		btnDelete.setMinimumSize(new Dimension(33,33));
		btnDelete.setPreferredSize(new Dimension(33,33));
		btnDelete.setToolTipText("Delete");
		btnDelete.setMnemonic(KeyEvent.VK_D);
		btnDelete.setIcon(new ImageIcon("images/delete_button.png"));
		add(btnDelete);
		
		add(Box.createHorizontalGlue());
		addSeparator();
		
		JTextField searchField = new JTextField(30);
		searchField.setMaximumSize(new Dimension(350,33));
		searchField.setMinimumSize(new Dimension(350,33));
		searchField.setToolTipText("Search field");
		add(searchField);	
		
		addSeparator();
		
		JButton btnSearch = new JButton();
		btnSearch.setMaximumSize(new Dimension(33,33));
		btnSearch.setMinimumSize(new Dimension(33,33));
		btnSearch.setPreferredSize(new Dimension(33,33));
		btnSearch.setToolTipText("Search");
		btnSearch.setMnemonic(KeyEvent.VK_S);
		btnSearch.setIcon(new ImageIcon("images/search_button1.png"));
		add(btnSearch);
		
		setFloatable(false);
		setBackground(new Color(126, 125, 123));
		
	}
	
	
	

}
