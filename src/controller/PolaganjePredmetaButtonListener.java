package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Ocena;
import model.Predmet;
import model.Student;
import view.AddOrEditStudent;
import view.ErrorDialog;
import view.GlavniProzor;
import view.TabelaOcena;
import view.TabelaPredmeti;
import view.TabelaStudenti;

public class PolaganjePredmetaButtonListener implements ActionListener {

	static JTextField textDatumPolaganja;
	public static int brTacnihPolja = 0;
	public static JButton potvrdi;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int selectedIndex = TabelaPredmeti.nepolozeni.getSelectedRow();
		
		if(selectedIndex == -1) {
			@SuppressWarnings("unused")
			ErrorDialog error;
			error = new ErrorDialog("Greska pri izboru predmeta!");
		}else {
			String p = (String) TabelaPredmeti.nepolozeni.getValueAt(selectedIndex, 0);
			Predmet predmet = GlavniProzor.getControllerPredmet().nadjiPredmet(p);
			polaganjePredmeta(predmet);
		}

	}
	public void polaganjePredmeta(Predmet predmet) {
		JDialog polaganjePredmeta = new JDialog();
		polaganjePredmeta.setSize(300, 300);
		polaganjePredmeta.setModal(true);
		polaganjePredmeta.setResizable(false);
		polaganjePredmeta.setLocationRelativeTo(AddOrEditStudent.inst);
		polaganjePredmeta.setTitle("Upis ocene");
		
		JPanel gore = new JPanel();
		gore.setPreferredSize(new Dimension(10, 10));
		polaganjePredmeta.add(gore,BorderLayout.NORTH);

		JPanel levo = new JPanel();
		levo.setPreferredSize(new Dimension(10, 5));
		polaganjePredmeta.add(levo, BorderLayout.WEST);

		JPanel desno = new JPanel();
		desno.setPreferredSize(new Dimension(10, 5));
		polaganjePredmeta.add(desno, BorderLayout.EAST);

		potvrdi = new JButton("Potvrdi");
		potvrdi.setEnabled(false);
		
		JButton odustani = new JButton("Odustani");
		odustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

		JPanel dole = new JPanel();
		dole.add(potvrdi);
		dole.add(odustani);
		polaganjePredmeta.add(dole, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel sifraPredmeta = new JLabel();
		JTextField textSifraPredmeta = new JTextField();
		JLabel nazivPredmeta = new JLabel();
		JTextField textNazivPredmeta = new JTextField();
		JLabel ocena = new JLabel();
		String[] ocene = {"6", "7", "8", "9", "10"};
		JComboBox<String> comboStringOcena = new JComboBox<String>(ocene);
		JLabel datumPolaganja = new JLabel();
		textDatumPolaganja = new JTextField();
		textDatumPolaganja.setName("Exam* ");
		textDatumPolaganja.addFocusListener(new StudentFocusListeners());
		
		potvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				@SuppressWarnings("static-access")
				Student trenutniStudent = AddOrEditStudent.inst.student;
				
				DateTimeFormatter dtf;
				LocalDate datPolaganja = null;
				boolean done = false;
				
				String[] regExDatePoss = {"dd.MM.yyyy.", "dd.MM.yyyy", "d.MM.yyyy.", "d.MM.yyyy", "dd.M.yyyy.", "dd.M.yyyy", "d.M.yyyy.", "d.M.yyyy"};
				
				for(int i = 0; i < regExDatePoss.length; i++) {
					try {
						dtf = DateTimeFormatter.ofPattern(regExDatePoss[i]);
						datPolaganja = LocalDate.parse(textDatumPolaganja.getText().trim(), dtf);
						done = true;
						break;
					}catch(Exception ex) {
						done = false;
					}
					if(done)
						break;
				}
				Ocena ocena = new Ocena(trenutniStudent, predmet, Integer.parseInt((String) comboStringOcena.getSelectedItem()), datPolaganja);
				GlavniProzor.getControllerStudent().upisiOcenuStudentu(trenutniStudent, ocena);

				TabelaPredmeti.nepolozeni.updateTable(trenutniStudent.getBrojIndeksa());
				TabelaStudenti.tabelaStudenti.updateTable();
				TabelaOcena.tabelaOcena.updateTable(trenutniStudent.getBrojIndeksa());
				
				AddOrEditStudent.inst.updateEspbAndProsek(trenutniStudent);
				
				polaganjePredmeta.setVisible(false);
				GlavniProzor.serialize();
				
			}
			
		});
		
		JPanel sifraPredmetaPanel = createPanel(sifraPredmeta, textSifraPredmeta, "Šifra* ");
		textSifraPredmeta.setEditable(false);
		textSifraPredmeta.setText(predmet.getSifraPredmeta());

		panel.add(sifraPredmetaPanel);

		JPanel nazivPredmetaPanel = createPanel(nazivPredmeta, textNazivPredmeta, "Naziv* ");
		textNazivPredmeta.setEditable(false);
		textNazivPredmeta.setText(predmet.getNazivPredmeta());

		panel.add(nazivPredmetaPanel);
		
		JPanel ocenaPanel = createComboBox(ocena, comboStringOcena, "Ocena* ");

		panel.add(ocenaPanel);

		JPanel datumPanel = createPanel(datumPolaganja, textDatumPolaganja, "Datum* ");

		panel.add(datumPanel);
		
		polaganjePredmeta.add(panel,BorderLayout.CENTER);
		polaganjePredmeta.setVisible(true);
	}
	
	private JPanel createComboBox(JLabel lab, JComboBox<String> comboStringOcena, String ime) {
		JPanel ret = new JPanel();
		lab = new JLabel(ime);
		lab.setPreferredSize(new Dimension(50,25));
		ret.add(lab);

		comboStringOcena.setPreferredSize(new Dimension(150,25));
		ret.add(comboStringOcena);

		return ret;
	}
	public JPanel createPanel(JLabel lab, JTextField txt, String ime) {
		JPanel ret = new JPanel();
		lab = new JLabel(ime);
		lab.setPreferredSize(new Dimension(50, 25));
		ret.add(lab);

		txt.setPreferredSize(new Dimension(150, 25));
		ret.add(txt);

		return ret;
	}
	public static boolean brTacnihPolja() {
		if(Checker.isValidDateExams(textDatumPolaganja.getText()))
			brTacnihPolja++;
		if(brTacnihPolja == 1) {
			brTacnihPolja = 0;
			return true;
		}
		brTacnihPolja = 0;
		return false;
	}
}
