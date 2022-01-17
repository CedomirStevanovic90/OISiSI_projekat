package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorDialog {

	public ErrorDialog(String message) {
		JOptionPane.showMessageDialog(new JFrame(), message, "Error",JOptionPane.ERROR_MESSAGE);
	}
}
