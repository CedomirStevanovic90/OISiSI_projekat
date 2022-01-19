package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Predmet;
import model.Student;
import view.AddOrEditStudent;
import view.GlavniProzor;
import view.TabelaPredmeti;

public class DodajPredmetButtonListener implements ActionListener {

	DefaultListModel<String> defaultListModel;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dodajPredStudentu(AddOrEditStudent.student); 
	}
	
	public void dodajPredStudentu(Student student){
		JDialog dodajPredStudentu = new JDialog();
		dodajPredStudentu.setSize(300,300);
		dodajPredStudentu.setModal(true);
		dodajPredStudentu.setResizable(false);
		dodajPredStudentu.setLocationRelativeTo(AddOrEditStudent.inst);
		dodajPredStudentu.setTitle("Dodaj predmete");
		
		dodajPredStudentu.setLayout(new BorderLayout());
		
		JPanel gore = new JPanel();
		gore.setPreferredSize(new Dimension(5,5));
		dodajPredStudentu.add(gore, BorderLayout.NORTH);
		
		JPanel dole = new JPanel();
		JButton dodaj = new JButton("Dodaj");
		JButton odustani = new JButton("Odustani");
		dole.add(dodaj);
		dole.add(odustani);
		dodajPredStudentu.add(dole,BorderLayout.SOUTH);
		
		JPanel levo = new JPanel();
		levo.setPreferredSize(new Dimension(5,5));
		dodajPredStudentu.add(levo, BorderLayout.WEST);
		
		JPanel desno = new JPanel();
		desno.setPreferredSize(new Dimension(5,5));
		dodajPredStudentu.add(desno, BorderLayout.EAST);
		
		JList<String> listaPredmeta = new JList<String>();
		defaultListModel = new DefaultListModel<String>();
		String row;
		for(Predmet p : GlavniProzor.getControllerPredmet().getListaPredmeta()) {
			if(!GlavniProzor.getControllerStudent().proveriPred(student, p)) {
				row = p.getSifraPredmeta() + " - " + p.getNazivPredmeta();
				defaultListModel.addElement(row);
			}
		}
		
		listaPredmeta.setModel(defaultListModel);
		
		JPanel panel = new JPanel();
		JScrollPane jScrollPane = new JScrollPane(listaPredmeta);
		jScrollPane.setPreferredSize(new Dimension(270, 200));
		panel.add(jScrollPane);
		dodajPredStudentu.add(panel, BorderLayout.CENTER);
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dodajPredStudentu.setVisible(false);
			}
		});
		dodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int idxPredmeta[] = listaPredmeta.getSelectedIndices();
				ArrayList<String> selectedPredmeti = new ArrayList<String>();
				String predmeti[];
				for(int i : idxPredmeta) {
					predmeti = defaultListModel.get(i).split(" - ");
					selectedPredmeti.add(predmeti[0]);
				}
				
				GlavniProzor.getControllerStudent().dodajNepolozenePredmete(selectedPredmeti, student);
				
				TabelaPredmeti.nepolozeni.updateTable(student.getBrojIndeksa());
				GlavniProzor.serialize();
				
				dodajPredStudentu.setVisible(false);
			}
		});
		dodajPredStudentu.setVisible(true);
	}
}
