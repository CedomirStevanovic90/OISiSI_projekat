package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import controller.Checker;
import controller.ControllerProfesor;
import controller.ProfesorFocusListeners;
import model.Adresa;
import model.Predmet;
import model.Profesor;

public class AddOrEditProfesor extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static AddOrEditProfesor inst;
	private Profesor professor;
	private ControllerProfesor controller;
	private static int brTacnihPolja = 0;
	static JTextField textIme, textPrezime, textDatRodj, textAdrStan, textBrTel, textEmail, textAdrKanc, textBrLicne, textGodStaza;
	public static JButton potvrdi;
	
	private ErrorDialog err;
	
	public AddOrEditProfesor(int mode, AddOrEditDialog d) {
		
		inst = this;
		controller = GlavniProzor.getControllerProfesor();
		setLayout(new BorderLayout());
		setSize(400,500);
		
		JPanel glavni = new JPanel();
		glavni.setLayout(new BoxLayout(glavni, BoxLayout.Y_AXIS));
		
		JLabel labelaIme = new JLabel("Name* ");
		textIme = new JTextField();
		textIme.setName("Name* ");
		textIme.setToolTipText("Only letters are allowed");
		
		JLabel labelaPrezime = new JLabel("Surname* ");
		textPrezime = new JTextField();
		textPrezime.setName("Surname* ");
		textPrezime.setToolTipText("Only letters are allowed");
		
		JLabel labelaDatRodj = new JLabel("Date of birth* ");
		textDatRodj = new JTextField();
		textDatRodj.setName("Date of birth* ");
		textDatRodj.setToolTipText("dd.MM.yyyy format");
		
		JLabel labelaAdrStan = new JLabel("Address* ");
		textAdrStan = new JTextField();
		textAdrStan.setName("Address* ");
		textAdrStan.setToolTipText("Street_name, Building_number/Flat_number, City, Country");
		
		JLabel labelaBrTel = new JLabel("Phone number* ");
		textBrTel = new JTextField();
		textBrTel.setName("Phone number* ");
		textBrTel.setToolTipText("NNN/NNN-NNN");
		
		JLabel labelaEmail = new JLabel("E-mail* ");
		textEmail = new JTextField();
		textEmail.setName("E-mail* ");
		textEmail.setToolTipText("Standard e-mail format"); 
		
		JLabel labelaAdrKanc = new JLabel("Office address* ");
		textAdrKanc = new JTextField();
		textAdrKanc.setName("Office address* ");
		textAdrKanc.setToolTipText("Street_name, Building_number/Flat_number, City, Country");
		
		JLabel labelaBrLicne = new JLabel("Professor ID* ");
		textBrLicne = new JTextField();
		textBrLicne.setName("Professor ID* ");
		textBrLicne.setToolTipText("NNNNNNNNN -> 9 numbers");
		
		JLabel labelaZvanje = new JLabel("Title name* ");
		String[] zvanje = {"Asistent", "Docent", "Vanredni profesor", "Redovni profesor"};
		JComboBox<String> textZvanje = new JComboBox<String>(zvanje);
		
		JLabel labelaGodStaza = new JLabel("Years of service* ");
		textGodStaza = new JTextField();
		textGodStaza.setName("Years of service* ");
		textGodStaza.setToolTipText("NN");
		
		glavni.add(createPanel(labelaIme, textIme));
		glavni.add(createPanel(labelaPrezime, textPrezime));
		glavni.add(createPanel(labelaDatRodj, textDatRodj));
		glavni.add(createPanel(labelaAdrStan, textAdrStan));
		glavni.add(createPanel(labelaBrTel, textBrTel));
		glavni.add(createPanel(labelaEmail, textEmail));
		glavni.add(createPanel(labelaAdrKanc, textAdrKanc));
		glavni.add(createPanel(labelaBrLicne, textBrLicne));
		glavni.add(createListPanel(labelaZvanje, textZvanje));
		glavni.add(createPanel(labelaGodStaza, textGodStaza));
		JLabel lab = new JLabel();
		lab.setPreferredSize(new Dimension(150, 25));
		glavni.add(lab);
		
		JPanel dugmad = new JPanel();
		
		potvrdi = new JButton("Confirm");
		dugmad.add(potvrdi);
		potvrdi.setEnabled(brTacnihPolja());
		
		JButton odustani = new JButton("Cancel");
		dugmad.add(odustani);	
		
		if(mode == AddOrEditDialog.addMode) {
			add(glavni,BorderLayout.NORTH);
			add(dugmad,BorderLayout.SOUTH);
		}
//		-------------------------------------------------------------------------------
		//Textfield listeneri :
		textPrezime.addFocusListener(new ProfesorFocusListeners());
		textIme.addFocusListener(new ProfesorFocusListeners());
		textDatRodj.addFocusListener(new ProfesorFocusListeners());
		textAdrKanc.addFocusListener(new ProfesorFocusListeners());
		textAdrStan.addFocusListener(new ProfesorFocusListeners());
		textBrTel.addFocusListener(new ProfesorFocusListeners());
		textEmail.addFocusListener(new ProfesorFocusListeners());
		textBrLicne.addFocusListener(new ProfesorFocusListeners());
		textGodStaza.addFocusListener(new ProfesorFocusListeners());
		
		if(mode == AddOrEditDialog.editMode) {
			
			int selectedProfessor = TabelaProfesori.tabelaProfesori.getSelectedRow();
			
			String editProfBrLic = (String)TabelaProfesori.tabelaProfesori.getProfesor(selectedProfessor).getBrojLicneKarte(); 
			
			professor = controller.nadjiProfesora(editProfBrLic);
			
			textPrezime.setText(professor.getPrezime());
			textIme.setText(professor.getIme());
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
			textDatRodj.setText(dtf.format(professor.getDatumRodjenja()));
			textAdrKanc.setText(professor.getAdresaKancelarije().getUlica() + "," + professor.getAdresaKancelarije().getBroj() + "," + professor.getAdresaKancelarije().getGrad() + "," + professor.getAdresaKancelarije().getDrzava());
			textAdrStan.setText(professor.getAdresaStanovanja().getUlica() + "," + professor.getAdresaStanovanja().getBroj() + "," + professor.getAdresaStanovanja().getGrad() + "," + professor.getAdresaStanovanja().getDrzava());
			textBrTel.setText(professor.getKontaktTelefon());
			textEmail.setText(professor.getEmailAdresa());
			textBrLicne.setText(professor.getBrojLicneKarte());
			textZvanje.setSelectedItem(professor.getZvanje());
			textGodStaza.setText(String.valueOf(professor.getGodineStaza()));
			
			JPanel info = new JPanel();
			info.setLayout(new BorderLayout());
			info.add(glavni,BorderLayout.NORTH);
			info.add(dugmad, BorderLayout.SOUTH);
			
			JPanel predmeti = new JPanel();
			
			
			JTabbedPane tabs = new JTabbedPane();
			tabs.addTab("Informations", info);
			tabs.addTab("Subjects", predmeti);
			add(tabs);
			
		}
		
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
				
				String ime = textIme.getText().trim().substring(0,1).toUpperCase() + textIme.getText().trim().substring(1).toLowerCase();
				String prezime = textPrezime.getText().trim().substring(0,1).toUpperCase() + textPrezime.getText().trim().substring(1).toLowerCase();
				
				DateTimeFormatter dtf;
				LocalDate datRodj = null;
				boolean done = false;
				
				String[] regExDatePoss = {"dd.MM.yyyy.", "dd.MM.yyyy", "d.MM.yyyy.", "d.MM.yyyy", "dd.M.yyyy.", "dd.M.yyyy", "d.M.yyyy.", "d.M.yyyy"};
				
				for(int i = 0; i < regExDatePoss.length; i++) {
					try {
						dtf = DateTimeFormatter.ofPattern(regExDatePoss[i]);
						datRodj = LocalDate.parse(textDatRodj.getText().trim(), dtf);
						done = true;
						break;
					}catch(Exception ex) {
						done = false;
					}
					if(done)
						break;
				}
				
				Adresa adresa = new Adresa(" ", " ", " ", " ");
				adresa.setUlica(textAdrStan.getText().trim().split(",")[0]);
				//adresa.setUlica(adresa.getUlica().trim().substring(0,1).toUpperCase() + adresa.getUlica().trim().substring(1)); Ne vredi jer ne znam koliko ima reci
				adresa.setBroj(textAdrStan.getText().trim().split(",")[1]);
				adresa.setGrad(textAdrStan.getText().trim().split(",")[2]);
				adresa.setDrzava(textAdrStan.getText().trim().split(",")[3]);

				String konTel = textBrTel.getText().trim();
				String email = textEmail.getText().trim();
				
				Adresa adresaKanc = new Adresa(" ", " ", " ", " ");
				adresaKanc.setUlica(textAdrKanc.getText().trim().split(",")[0]);
				//adresa.setUlica(adresa.getUlica().trim().substring(0,1).toUpperCase() + adresa.getUlica().trim().substring(1)); Ne vredi jer ne znam koliko ima reci
				adresaKanc.setBroj(textAdrKanc.getText().trim().split(",")[1]);
				adresaKanc.setGrad(textAdrKanc.getText().trim().split(",")[2]);
				adresaKanc.setDrzava(textAdrKanc.getText().trim().split(",")[3]);
				
				String brLicne = textBrLicne.getText().trim();
		
				String zvanje = (String) textZvanje.getSelectedItem();
				
				int godStaza = Integer.parseInt(textGodStaza.getText().trim());

				ArrayList<Predmet> spisakPredmeta = null;
				
				d.setVisible(false);
				
				if(mode == AddOrEditDialog.addMode) {
					Profesor profesor = new Profesor(prezime, ime, datRodj, adresa, konTel, email, adresaKanc, brLicne, zvanje, godStaza, spisakPredmeta);
					if(!controller.dodajProfesora(profesor))
						JOptionPane.showMessageDialog(new JFrame(), "Unsuccessful adding of a professor, the professor with that ID already exists!", "Error" ,JOptionPane.ERROR_MESSAGE);
				}
				
				if(mode == AddOrEditDialog.editMode) {
					professor.setIme(ime);
					professor.setPrezime(prezime);
					professor.setDatumRodjenja(datRodj);
					professor.setAdresaStanovanja(adresa);
					professor.setKontaktTelefon(konTel);
					professor.setEmailAdresa(email);
					professor.setAdresaKancelarije(adresaKanc);
					professor.setBrojLicneKarte(brLicne);
					professor.setZvanje(zvanje);
					professor.setGodineStaza(godStaza);
					
					if(!brLicne.equals(professor.getBrojLicneKarte())) {
						if(controller.nadjiProfesora(brLicne) != null) {
							err = new ErrorDialog("Failed to add professor, there is a professor with the same ID number!");
						}
						else
							professor.setBrojLicneKarte(brLicne);
						}
					else
						professor.setBrojLicneKarte(brLicne);
					
					}
				
				TabelaProfesori.tabelaProfesori.updateTable();
				GlavniProzor.serialize();
			}
		});
	}
	
	public static boolean brTacnihPolja() {
		if(Checker.isNameOrSurename(textIme.getText()))
			brTacnihPolja++;
		if(Checker.isNameOrSurename(textPrezime.getText()))
			brTacnihPolja++;
		if(Checker.isValidDate(textDatRodj.getText()))
			brTacnihPolja++;
		if(Checker.isValidAdrress(textAdrStan.getText()))
			brTacnihPolja++;
		if(Checker.isValidNumber(textBrTel.getText()))
			brTacnihPolja++;
		if(Checker.isValidEmail(textEmail.getText()))
			brTacnihPolja++;
		if(Checker.isValidAdrress(textAdrKanc.getText()))
			brTacnihPolja++;
		if(Checker.isValidProfessorID(textBrLicne.getText()))
			brTacnihPolja++;
		if(Checker.isValidYearOfServise(textGodStaza.getText()))
			brTacnihPolja++;
		if(brTacnihPolja == 9) {
			brTacnihPolja = 0;
			return true;
		}
		brTacnihPolja = 0;
		return false;
	}
	
	public JPanel createPanel(JLabel label, JTextField text) {
		JPanel panel = new JPanel();
		
		label.setPreferredSize(new Dimension(150, 25));
		panel.add(label);
		text.setPreferredSize(new Dimension(200, 25));
		panel.add(text);
		
		return panel;
	}
	public JPanel createListPanel(JLabel label, JComboBox<String> text) {
		JPanel panel = new JPanel();
		
		label.setPreferredSize(new Dimension(150, 25));
		panel.add(label);
		text.setPreferredSize(new Dimension(200, 25));
		panel.add(text);
		
		return panel;
	}
}
