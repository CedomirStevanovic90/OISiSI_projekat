package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10;
	private JPanel panel;
	
	public AboutDialog() {
		label1 = new JLabel("\t Aplikacija : Studentska sluzba");
		label2 = new JLabel();
		label3 = new JLabel("\t Aplikacija Studentska sluzba omogucava evidenciju studenata, profesora i predmeta,\t ");
		label4 = new JLabel("\t kako bi olaksala rad salterskim radnicima studentske sluzbe Fakulteta tehnickih nauka,\t ");
		label5 = new JLabel("\t Univerziteta u Novom Sadu.");
		label6 = new JLabel();
		label7 = new JLabel("\t Autori: Ivan Galic i Cedomir Stevanovic");
		label8 = new JLabel();
		label9 = new JLabel("\t Smer : Racunarstvo i automatika (Primenjene racunarske nauke i informatika)");
		label10 = new JLabel("\t Fakultet tehnickih nauka, Univerzitet u Novom Sadu");
		
		JLabel[] labels = {label1, label2, label3, label4, label5, label6, label7, label8, label9, label10};
		
		Font font = new Font("Arial", Font.ITALIC, 16);
		
		for(JLabel l : labels) {
			l.setFont(font);
		}
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(0,1));
		for(JLabel l : labels)
			panel.add(l);
		
		setModal(true);
		add(panel, BorderLayout.CENTER);
	    setTitle("O aplikaciji");
		setResizable(false);
			
	}
}
