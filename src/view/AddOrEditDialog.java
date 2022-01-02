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
		this.setSize(400, 500);
		this.setModal(true);
		this.setLocationRelativeTo(GlavniProzor.getGlavniProzor());
		
		int tab = GlavniProzor.getTabbedPane().getSelectedIndex();
		
		switch(tab) {
		case 0 : 
			//student
			if(mode == addMode)
				this.setTitle("Add student");
			
			this.add(new AddOrEditStudent(mode, this));
			break;
		case 1 :
			//za profesore
			if(mode == addMode)
				this.setTitle("Add profesor");
			
			this.add(new AddOrEditProfesor(mode, this));
			break;
		case 2 :
			// za predmete
			if(mode == addMode)
				this.setTitle("Add subject");
			
			this.add(new AddOrEditPredmet(mode, this));	
			break;
		}
		
	}
	
}