package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import enumeracije.GodinaIzvodjenja;
import enumeracije.Semestar;
import model.Predmet;
import model.Profesor;
import model.Student;

//import controller.ControllerPredmet;

public class AddOrEditPredmet extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static AddOrEditPredmet inst;
	
//	private ControllerPredmet controller;
	
	public AddOrEditPredmet(int mode, AddOrEditDialog d) {
		
		inst = this;
//		controller = GlavniProzor.getControllerPredmet();
		setLayout(new BorderLayout());
		setSize(400,500);
		
		JPanel glavni = new JPanel();
		glavni.setLayout(new BoxLayout(glavni, BoxLayout.Y_AXIS));
		
		JLabel labelID = new JLabel("Subject ID* ");
		JTextField textID = new JTextField();
		textID.setName("Subject ID* ");
		textID.setToolTipText("Subject ID");
		
		JLabel labelaNaziv = new JLabel("Name* ");
		JTextField textNaziv = new JTextField();
		textNaziv.setName("Name* ");
		textNaziv.setToolTipText("Only letters are allowed");
		
		JLabel labelaGodIzvodjenja = new JLabel("Year* ");
		String[] godIzvodjenja = {"1", "2", "3", "4"};
		JComboBox<String> textGodIzvodjenja = new JComboBox<String>(godIzvodjenja);
		
		JLabel labelaSemestar = new JLabel("Semester* ");
		String[] semestar = {"Winter", "Summer"};
		JComboBox<String> textSemestar = new JComboBox<String>(semestar);
		
		Profesor profesor = null;
		JLabel labelaProfesor = new JLabel("Professors* ");
		JTextField textProfesor = new JTextField();
		textProfesor.setName("Professors* ");
		textProfesor.setToolTipText("+/-, add/remove");
		JButton plus = new JButton("+");
		JButton minus = new JButton("-");
		
		JLabel labelaESPB = new JLabel("ECTS* ");
		JTextField textESPB = new JTextField();
		textESPB.setName("ECTS* ");
		textESPB.setToolTipText("Only numbers are allowed");
		
		ArrayList<Student> listaPolozenih = null;
		ArrayList<Student> listaNepolozenih = null;
		
		glavni.add(createPanel(labelID, textID));
		glavni.add(createPanel(labelaNaziv, textNaziv));
		glavni.add(createListPanel(labelaGodIzvodjenja, textGodIzvodjenja));
		glavni.add(createListPanel(labelaSemestar, textSemestar));
		glavni.add(profPanel(labelaProfesor, textProfesor, plus, minus));
		glavni.add(createPanel(labelaESPB, textESPB));
		JLabel lab = new JLabel();
		lab.setPreferredSize(new Dimension(150, 25));
		glavni.add(lab);
		
		JPanel dugmad = new JPanel();
		
		JButton potvrdi = new JButton("Confirm");
		dugmad.add(potvrdi);
		JButton odustani = new JButton("Cancel");
		dugmad.add(odustani);
		
		if(mode == AddOrEditDialog.addMode) {
			add(glavni, BorderLayout.NORTH);
			add(dugmad, BorderLayout.SOUTH);
		}
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				glavni.setVisible(false);
			}
			
		});
		
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}
	
	public JPanel createPanel(JLabel label, JTextField text) {
		JPanel panel = new JPanel();
		
		label.setPreferredSize(new Dimension(100, 25));
		panel.add(label);
		
		text.setPreferredSize(new Dimension(250, 25));
		panel.add(text);
		
		return panel;
	}
	public JPanel createListPanel(JLabel label, JComboBox<String> text) {
		JPanel panel = new JPanel();
		
		label.setPreferredSize(new Dimension(100, 25));
		panel.add(label);
		
		text.setPreferredSize(new Dimension(250, 25));
		panel.add(text);
		
		return panel;
	}
	public JPanel profPanel(JLabel labelaProfesor, JTextField textProf, JButton plus, JButton minus) {
		JPanel panel = new JPanel();
		
		labelaProfesor.setPreferredSize(new Dimension(100, 25));
		panel.add(labelaProfesor);
		
		textProf.setPreferredSize(new Dimension(160, 25));
		panel.add(textProf);
		
		plus.setPreferredSize(new Dimension(41, 25));
		panel.add(plus);
		minus.setPreferredSize(new Dimension(39, 25));
		panel.add(minus);
		
		return panel;
	}
}
