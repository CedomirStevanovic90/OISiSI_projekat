package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import enumeracije.GodinaIzvodjenja;
import enumeracije.Semestar;
import model.Predmet;
import model.Profesor;
import model.Student;
import controller.Checker;
import controller.ControllerPredmet;
import controller.DodajProfesoraPredmetuButtonLIstener;
import controller.PredmetFocusListeners;
import controller.UkloniProfesoraSaPredmetaButtonLIstener;

public class AddOrEditPredmet extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static AddOrEditPredmet inst;
	
	private ControllerPredmet controller;
	public static int brTacnihPolja = 0;
	public static JTextField textID, textNaziv, textESPB, textProfesor;
	public static JButton potvrdi;
	public static Predmet predmet;
	public static JButton minus, plus;
	public static boolean imaProfesora;
	public static Profesor profesor;
	
	public AddOrEditPredmet(int mode, AddOrEditDialog d) {
		
		inst = this;
		controller = GlavniProzor.getControllerPredmet();
		setLayout(new BorderLayout());
		
		JPanel glavni = new JPanel();
		glavni.setLayout(new BoxLayout(glavni, BoxLayout.Y_AXIS));
		
		JLabel labelID = new JLabel("Subject ID* ");
		textID = new JTextField();
		textID.setName("Subject ID* ");
		textID.setToolTipText("Subject ID");
		
		JLabel labelaNaziv = new JLabel("Subject name* ");
		textNaziv = new JTextField();
		textNaziv.setName("Subject name* ");
		textNaziv.setToolTipText("Only letters are allowed");
		
		JLabel labelaGodIzvodjenja = new JLabel("Year* ");
		String[] godIzvodjenja = {"1", "2", "3", "4"};
		JComboBox<String> textGodIzvodjenja = new JComboBox<String>(godIzvodjenja);
		
		JLabel labelaSemestar = new JLabel("Semester* ");
		String[] semestri = {"Winter", "Summer"};
		JComboBox<String> textSemestar = new JComboBox<String>(semestri);
		
		JLabel labelaProfesor = new JLabel("Professors* ");
		textProfesor = new JTextField();
		textProfesor.setText("Professors* ");
		textProfesor.setEditable(false);
		if(mode == AddOrEditDialog.addMode)
			textProfesor.setText("Professors* ");
		textProfesor.setToolTipText("+/-, add/remove");
		plus = new JButton("+");
		
		minus = new JButton("-");
		
		JLabel labelaESPB = new JLabel("ECTS* ");
		textESPB = new JTextField();
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
		
		JPanel dugmad = new JPanel();
		
		textID.addFocusListener(new PredmetFocusListeners());
		textNaziv.addFocusListener(new PredmetFocusListeners());
		textESPB.addFocusListener(new PredmetFocusListeners());
		
		potvrdi = new JButton("Confirm");
		dugmad.add(potvrdi);
		potvrdi.setEnabled(brTacnihPolja());
		
		JButton odustani = new JButton("Cancel");
		dugmad.add(odustani);

		if(mode == AddOrEditDialog.addMode) {
			minus.setEnabled(false);
			add(glavni, BorderLayout.NORTH);
			add(dugmad, BorderLayout.SOUTH);
		}
	
		if(mode == AddOrEditDialog.editMode) {
			int selectedPredmet = TabelaPredmeti.tabelaPredmeti.getSelectedRow();
			if(selectedPredmet != -1) {
				String sifraSelectedPred = (String) TabelaPredmeti.tabelaPredmeti.getValueAt(selectedPredmet, 0);
				predmet = controller.nadjiPredmet(sifraSelectedPred);
				
				textID.setText(predmet.getSifraPredmeta());
				textNaziv.setText(predmet.getNazivPredmeta());
				
				profesor = predmet.getProfesor();
				
				if(profesor == null) {
					textProfesor.setText("Professors* ");
					minus.setEnabled(false);
				}else {
					textProfesor.setText(profesor.getIme() + " " + profesor.getPrezime());
					minus.setEnabled(true);
					plus.setEnabled(false);
				}
				
				if(predmet.getGodinaIzvodjenja() == GodinaIzvodjenja.PRVA)
					textGodIzvodjenja.setSelectedIndex(0);
				else if(predmet.getGodinaIzvodjenja() == GodinaIzvodjenja.DRUGA)
					textGodIzvodjenja.setSelectedIndex(1);
				else if(predmet.getGodinaIzvodjenja() == GodinaIzvodjenja.TRECA)
					textGodIzvodjenja.setSelectedIndex(2);
				else
					textGodIzvodjenja.setSelectedIndex(3);
				textSemestar.setSelectedItem(predmet.getSemestar());
				
				textESPB.setText(String.valueOf(predmet.getEspbPoeni()));
				
				add(glavni, BorderLayout.NORTH);
				add(dugmad, BorderLayout.SOUTH);
			}
		}
		
		plus.addActionListener(new DodajProfesoraPredmetuButtonLIstener());
		
		minus.addActionListener(new UkloniProfesoraSaPredmetaButtonLIstener());
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				d.setVisible(false);
				brTacnihPolja = 0;
			}
			
		});
		
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				String ID = textID.getText().trim();
				String naziv = textNaziv.getText().trim();
				
				GodinaIzvodjenja godina;
				switch((String) textGodIzvodjenja.getSelectedItem()) {
					case "1" : godina = GodinaIzvodjenja.PRVA; break;
					case "2" : godina = GodinaIzvodjenja.DRUGA; break;
					case "3" : godina = GodinaIzvodjenja.TRECA; break;
					default : godina = GodinaIzvodjenja.CETVRTA;
				}
				
				Semestar semestar;
				switch((String) textSemestar.getSelectedItem()) {
					case "Winter" : semestar = Semestar.ZIMSKI; break;
					default : semestar = Semestar.LETNJI;
				}
				
				int ESPB = Integer.parseInt(textESPB.getText().trim());
				
				d.setVisible(false);
				
				if(mode == AddOrEditDialog.addMode) {
					Predmet predmet = new Predmet(ID, naziv, semestar, godina, profesor, ESPB, listaPolozenih, listaNepolozenih);
					profesor.getSpisakPredmeta().add(predmet);
					if(!controller.dodajPredmet(predmet))
						JOptionPane.showMessageDialog(new JFrame(), "Unsuccessful adding of a subject, the subject with that ID already exists!", "Error" ,JOptionPane.ERROR_MESSAGE);
				}
				
				if(mode == AddOrEditDialog.editMode) {
					
					predmet.setNazivPredmeta(naziv);
					predmet.setSemestar(semestar);
					predmet.setGodinaIzvodjenja(godina);
					predmet.setEspbPoeni(ESPB);
					predmet.setProfesor(profesor);
					profesor.getSpisakPredmeta().add(predmet);
					
					if(!ID.equals(predmet.getSifraPredmeta())) {
						if(controller.nadjiPredmet(ID) != null) {
							@SuppressWarnings("unused")
							ErrorDialog err;
							err = new ErrorDialog("Failed to add subject, there is a subject with the same ID number!");
						}
						else {
							predmet.setSifraPredmeta(ID);
						}
					}	
					else {
						predmet.setSifraPredmeta(ID);
					}
					
				}
				TabelaPredmeti.tabelaPredmeti.updateTable();
				GlavniProzor.serialize();
			}
		});
	}
	public static boolean brTacnihPolja() {
		if(Checker.isSubjectID(textID.getText()))
			brTacnihPolja++;
		if(Checker.isValidSubjectName(textNaziv.getText()))
			brTacnihPolja++;
		if(Checker.isValidECTS(textESPB.getText()))
			brTacnihPolja++;
		if(brTacnihPolja == 3 && imaProfesora == true) {
			brTacnihPolja = 0;
			return true;
		}
		brTacnihPolja = 0;
		return false;
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
