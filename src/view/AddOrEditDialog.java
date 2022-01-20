package view;

import javax.swing.JDialog;

public class AddOrEditDialog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static int addMode = 1;
	public static int editMode = 2;
	
	public AddOrEditDialog(int mode) {
		super();
		
		this.setResizable(false);
		this.setModal(true);
		
		int tab = GlavniProzor.getTabbedPane().getSelectedIndex();
		
		switch(tab) {
		case 0 : 
			//za studente
			if(mode == addMode) {
				this.setTitle("Add student");
				this.setSize(400, 500);
				this.setLocationRelativeTo(GlavniProzor.getGlavniProzor());
			}else {
				this.setTitle("Edit student");
				this.setSize(400, 450);
				this.setLocationRelativeTo(GlavniProzor.getGlavniProzor());
			}
			this.add(new AddOrEditStudent(mode, this));
			break;
		case 1 :
			//za profesore
			if(mode == addMode) {
				this.setTitle("Add professor");
				this.setSize(400, 500);
				this.setLocationRelativeTo(GlavniProzor.getGlavniProzor());
			}else {
				this.setTitle("Edit professor");
				this.setSize(400, 450);
				this.setLocationRelativeTo(GlavniProzor.getGlavniProzor());
			}
			this.add(new AddOrEditProfesor(mode, this));
			break;
		case 2 :
			// za predmete
			if(mode == addMode) {
				this.setTitle("Add subject");
				this.setSize(400, 300);
				this.setLocationRelativeTo(GlavniProzor.getGlavniProzor());
			}else {
				this.setTitle("Edit subject");
				this.setSize(400, 280);
				this.setLocationRelativeTo(GlavniProzor.getGlavniProzor());
			}
			this.add(new AddOrEditPredmet(mode, this));	
			break;
		}
		
	}
	
}