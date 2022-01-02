package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.JTextField;

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

	private ControllerStudent controller;
	
	public AddOrEditStudent(int mode, AddOrEditDialog dialog) {
		
		inst = this;
		controller = GlavniProzor.getControllerStudent();
		setLayout(new BorderLayout());
		
		JPanel glavni = new JPanel();
		glavni.setLayout(new BoxLayout(glavni, BoxLayout.Y_AXIS));
		
		JLabel labelaIme = new JLabel("Name* ");
		JTextField textIme = new JTextField();
		textIme.setName("Name* ");
		textIme.setToolTipText("Only letters are allowed");
		
		JLabel labelaPrezime = new JLabel("Surname* ");
		JTextField textPrezime = new JTextField();
		textPrezime.setName("Surname* ");
		textPrezime.setToolTipText("Only letters are allowed");
		
		JLabel labelaDatRodj = new JLabel("Date of birth* ");
		JTextField textDatRodj = new JTextField();
		textDatRodj.setName("Date of birth* ");
		textDatRodj.setToolTipText("dd.MM.yyyy format");
		
		JLabel labelaAdrStan = new JLabel("Address* ");
		JTextField textAdrStan = new JTextField();
		textAdrStan.setName("Address* ");
		textAdrStan.setToolTipText("Street_name, Building_number/Flat_number, City, Country");
		
		JLabel labelaBrTel = new JLabel("Phone number* ");
		JTextField textBrTel = new JTextField();
		textBrTel.setName("Phone number* ");
		textBrTel.setToolTipText("NNN/NNN-NNN");
		
		JLabel labelaEmail = new JLabel("E-mail* ");
		JTextField textEmail = new JTextField();
		textEmail.setName("E-mail* ");
		textEmail.setToolTipText("Standard e-mail format");
		
		JLabel labelaBrIndexa = new JLabel("Student ID* ");
		JTextField textBrIndexa = new JTextField();
		textBrIndexa.setName("Student ID* ");
		textBrIndexa.setToolTipText("XX-YYY/ZZZZ -> XX-course, YYY-number (at least 1 digit), ZZZ-year of enrollment");
		
		JLabel labelaGodUpisa = new JLabel("Enrollment year* ");
		JTextField textGodUpisa = new JTextField();
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
		
		JButton potvrdi = new JButton("Confirm");
		dugmad.add(potvrdi);
		
		JButton odustani = new JButton("Cancel");
		dugmad.add(odustani);
		
		if(mode == AddOrEditDialog.addMode) {
			add(glavni, BorderLayout.NORTH);
			add(dugmad,BorderLayout.SOUTH);
		}
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
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
				
				TabelaStudenti.tabelaStudenti.updateTable();
				GlavniProzor.serialize();
			}
		});
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
