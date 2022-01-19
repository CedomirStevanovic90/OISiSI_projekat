package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Checker;
import controller.ControllerStudent;
import controller.StudentFocusListeners;
import enumeracije.StatusStudenta;
import model.Adresa;
import model.Student;

public class AddOrEditStudent extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static AddOrEditStudent inst;
	private Student student;

	private ControllerStudent controller;
	private static int brTacnihPolja = 0;
	static JTextField textIme, textPrezime, textDatRodj, textAdrStan, textBrTel, textEmail, textBrIndexa, textGodUpisa;
	public static JButton potvrdi;
	private ErrorDialog err;
	
	public AddOrEditStudent(int mode, AddOrEditDialog dialog) {
		
		inst = this;
		controller = GlavniProzor.getControllerStudent();
		setLayout(new BorderLayout());
		if(mode == AddOrEditDialog.editMode)
			setPreferredSize(new Dimension(400,700));
		
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
		
		JLabel labelaBrIndexa = new JLabel("Student ID* ");
		textBrIndexa = new JTextField();
		textBrIndexa.setName("Student ID* ");
		textBrIndexa.setToolTipText("XX-YYY/ZZZZ -> XX-course, YYY-number (at least 1 digit), ZZZ-year of enrollment");
		
		JLabel labelaGodUpisa = new JLabel("Enrollment year* ");
		textGodUpisa = new JTextField();
		textGodUpisa.setName("Enrollment year* ");
		textGodUpisa.setToolTipText("yyyy format");
		
		JLabel labelaTrenutnaGod = new JLabel("Current year");
		String[] godStud = {"I (first)", "II (second)", "III (third)", "IV (fourth)"};
		JComboBox<String> textTrenutnaGod = new JComboBox<String>(godStud);
		
		JLabel labelaFinans = new JLabel("Way of financing");
		String[] data = {"Budget", "Self-financing"};
		JComboBox<String> textFinans = new JComboBox<String>(data);
		
		
		glavni.add(createPanel(labelaIme, textIme));
		glavni.add(createPanel(labelaPrezime, textPrezime));
		glavni.add(createPanel(labelaDatRodj, textDatRodj));
		glavni.add(createPanel(labelaAdrStan, textAdrStan));
		glavni.add(createPanel(labelaBrTel, textBrTel));
		glavni.add(createPanel(labelaEmail, textEmail));
		glavni.add(createPanel(labelaBrIndexa, textBrIndexa));
		glavni.add(createPanel(labelaGodUpisa, textGodUpisa));
		glavni.add(createListPanel(labelaTrenutnaGod, textTrenutnaGod));
		glavni.add(createListPanel(labelaFinans, textFinans));
		JLabel lab = new JLabel();
		lab.setPreferredSize(new Dimension(150, 25));
		glavni.add(lab);
		
		textIme.addFocusListener(new StudentFocusListeners());
		textPrezime.addFocusListener(new StudentFocusListeners());
		textDatRodj.addFocusListener(new StudentFocusListeners());
		textAdrStan.addFocusListener(new StudentFocusListeners());
		textBrTel.addFocusListener(new StudentFocusListeners());
		textEmail.addFocusListener(new StudentFocusListeners());
		textBrIndexa.addFocusListener(new StudentFocusListeners());
		textGodUpisa.addFocusListener(new StudentFocusListeners());
		
		
		JPanel dugmad = new JPanel();
		
		potvrdi = new JButton("Confirm");
		dugmad.add(potvrdi);
		potvrdi.setEnabled(brTacnihPolja());
		
		JButton odustani = new JButton("Cancel");
		dugmad.add(odustani);
		
		if(mode == AddOrEditDialog.addMode) {
			add(glavni, BorderLayout.NORTH);
			add(dugmad,BorderLayout.SOUTH);
		}
		
		if(mode == AddOrEditDialog.editMode) {
			
			int selectedStudent = TabelaStudenti.tabelaStudenti.getSelectedRow();
			String indexStudenta = (TabelaStudenti.tabelaStudenti.getValueAt(selectedStudent, 0)).toString();
				
			student = controller.nadjiStudenta(indexStudenta);
				
			textIme.setText(student.getIme());
			textPrezime.setText(student.getPrezime());
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
			textDatRodj.setText(dtf.format(student.getDatumRodjenja()));
			textAdrStan.setText(student.getAdresaStanovanja().getUlica() + "," + student.getAdresaStanovanja().getBroj() + "," + student.getAdresaStanovanja().getGrad() + "," + student.getAdresaStanovanja().getDrzava());
			textBrTel.setText(student.getKontaktTelefon());
			textEmail.setText(student.getEmailAdresa());
			textBrIndexa.setText(student.getBrojIndeksa());
			textGodUpisa.setText(student.getGodinaUpisa());
			textTrenutnaGod.setSelectedIndex(student.getTrenutnaGodStudija() - 1);
			textFinans.setSelectedItem(student.getStatus());
		
			JPanel info = new JPanel();
			info.setLayout(new BorderLayout());
			info.add(glavni,BorderLayout.NORTH);
			info.add(dugmad, BorderLayout.SOUTH);
			
//---------------------------------------------------------------------------------------------------------
			
			JPanel polozeni = new JPanel();
			polozeni.setLayout(new BoxLayout(polozeni, BoxLayout.Y_AXIS));
			JPanel btnPanel = new JPanel(new FlowLayout(10, 15, 10));
			JButton ponistiOcenu = new JButton("Ponisti ocenu");
			btnPanel.add(ponistiOcenu);
			polozeni.add(btnPanel);
			
			TabelaOcena polozeneOcene = new TabelaOcena(textBrIndexa.getText());
			JScrollPane scroll = new JScrollPane(polozeneOcene);
			scroll.setMaximumSize(new Dimension(350, 350));
			TabelaOcena.tabelaOcena.updateTable(textBrIndexa.getText());
			JPanel tabelaPanel = new JPanel();
			tabelaPanel.setLayout(new BoxLayout(tabelaPanel, BoxLayout.X_AXIS));
			JPanel sep1 = new JPanel();
			sep1.setPreferredSize(new Dimension(15,0));

			JPanel sep2 = new JPanel();
			sep2.setPreferredSize(new Dimension(15,0));
			
			tabelaPanel.add(sep1);
			tabelaPanel.add(scroll);
			tabelaPanel.add(sep2);

			polozeni.add(tabelaPanel);
			
			JPanel labPanel = new JPanel();
			labPanel.setLayout(new BoxLayout(labPanel, BoxLayout.Y_AXIS));
			
			double zaokruzenProsek = Math.round(student.getProsecnaOcena() * 100.0) / 100.0;
			JLabel prosek = new JLabel("Prosecna ocena: " + zaokruzenProsek);
			JLabel ukupnoEspb = new JLabel("Ukupno ESPB: " + controller.ukupnoEspb(student.getBrojIndeksa()));
			labPanel.add(prosek);
			labPanel.add(ukupnoEspb);
			
			JPanel donjiPanel = new JPanel(new FlowLayout(10, 200, 10));
			donjiPanel.add(labPanel);
			polozeni.add(donjiPanel);
			
//---------------------------------------------------------------------------------------------------------
			JPanel nepolozeni = new JPanel();
			nepolozeni.setLayout(new BoxLayout(nepolozeni, BoxLayout.Y_AXIS));
			
			JButton dodajPredmet = new JButton("Add");
			//dodajPredmet.addActionListener(new MyDodajPredListener());
			JButton obrisiPredmet = new JButton("Delete");
			//obrisiPredmet.addActionListener(new MyObrisiPredListener());
			JButton polaganjePredmeta = new JButton("Add grade");
			//polaganjePredmeta.addActionListener(new MyPolaganjeListener());
			
			JPanel gornjiSep = new JPanel();
			gornjiSep.setMaximumSize(new Dimension(5,5));
			nepolozeni.add(gornjiSep);
			
			JPanel buttons = new JPanel();
			buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
			JSeparator btnSep1 = new JSeparator(SwingConstants.VERTICAL);
			btnSep1.setMaximumSize(new Dimension(20,0));
			JSeparator btnSep2 = new JSeparator(SwingConstants.VERTICAL);
			btnSep2.setMaximumSize(new Dimension(5,0));
			JSeparator btnSep3 = new JSeparator(SwingConstants.VERTICAL);
			btnSep3.setMaximumSize(new Dimension(5,0));
			JSeparator btnSep4 = new JSeparator(SwingConstants.VERTICAL);
			btnSep4.setMaximumSize(new Dimension(200,0));
			
			buttons.add(btnSep1);
			buttons.add(dodajPredmet);
			buttons.add(btnSep2);
			buttons.add(obrisiPredmet);
			buttons.add(btnSep3);
			buttons.add(polaganjePredmeta);
			buttons.add(btnSep4);
			
			nepolozeni.add(buttons);
			
			JPanel cenSep = new JPanel();
			cenSep.setMaximumSize(new Dimension(5,5));
			cenSep.setPreferredSize(new Dimension(5,5));
			nepolozeni.add(cenSep);
			
			TabelaPredmeti nepoPredmeti = new TabelaPredmeti(textBrIndexa.getText());
			
			JScrollPane scrPane = new JScrollPane(nepoPredmeti);
			scrPane.setMaximumSize(new Dimension(350, 350));
			
			JPanel centralni = new JPanel();
			centralni.setLayout(new BoxLayout(centralni, BoxLayout.X_AXIS));
			JPanel sepCen1 = new JPanel();
			sepCen1.setPreferredSize(new Dimension(15,0));
			
			JPanel sepCen2 = new JPanel();
			sepCen2.setPreferredSize(new Dimension(15,0));
			
			centralni.add(sepCen1);
			centralni.add(scrPane);
			centralni.add(sepCen2);
			
			nepolozeni.add(centralni);
			

			JTabbedPane tabs = new JTabbedPane();
			tabs.addTab("Informations", info);
			tabs.addTab("Passed", polozeni);
			tabs.addTab("Unpassed", nepolozeni);
			add(tabs);
			
		}
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
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
				
				String smer = textBrIndexa.getText().trim().split("-")[0];
				String broj = textBrIndexa.getText().trim().split("-")[1];
				broj = broj.trim().split("/")[0];
				String god = textBrIndexa.getText().trim().split("/")[1];
				if(!broj.equals("0")) {
					int brNula = 0;
					for(int i = 0; i < broj.length(); i++) {
						if(broj.charAt(i) == '0')
							brNula++;
						else
							break;
					}
					broj = broj.substring(brNula);
				}
				smer = smer.toLowerCase();
				String index = smer + "-" + broj + "/" + god;
				
				String godUpisa = textGodUpisa.getText().trim();
				int trenutnaGod;
				switch((String) textTrenutnaGod.getSelectedItem()) {
					case "I (first)" : trenutnaGod = 1; break;
					case "II (second)" : trenutnaGod = 2; break;
					case "III (third)" : trenutnaGod = 3; break;
					default : trenutnaGod = 4;
				}
				
				StatusStudenta finans = StatusStudenta.B;
				if(textFinans.getSelectedItem() == "Self-financing") {
					finans = StatusStudenta.S;
				}
				
				dialog.setVisible(false);
				
				if(mode == AddOrEditDialog.addMode) {
					double prosek = 0.0;
					Student student = new Student(prezime, ime, datRodj, adresa, konTel, email, index, godUpisa, trenutnaGod, finans, prosek);
					if(!controller.dodajStudenta(student))
						JOptionPane.showMessageDialog(new JFrame(), "Unsuccessful adding of a student, the student with that ID already exists!", "Error" ,JOptionPane.ERROR_MESSAGE);
				}
				
				if(mode == AddOrEditDialog.editMode) {
					student.setIme(ime);
					student.setPrezime(prezime);
					student.setDatumRodjenja(datRodj);
					student.setAdresaStanovanja(adresa);
					student.setKontaktTelefon(konTel);
					student.setEmailAdresa(email);
					student.setGodinaUpisa(godUpisa);
					student.setTrenutnaGodStudija(trenutnaGod);
					student.setStatus(finans);
					
					if(!index.equals(student.getBrojIndeksa()))
						if(controller.nadjiStudenta(index) != null)
							err = new ErrorDialog("Failed to add student, there is a student with the same index number!");
						else
							student.setBrojIndeksa(index);
					else
						student.setBrojIndeksa(index);
					
				}
				
				TabelaStudenti.tabelaStudenti.updateTable();
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
		if(Checker.isValidIndex(textBrIndexa.getText()))
			brTacnihPolja++;
		if(Checker.isValidYear(textGodUpisa.getText()))
			brTacnihPolja++;
		if(brTacnihPolja == 8) {
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
