package model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import view.GlavniProzor;

public class DataBase implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Student> listaStudenti;
	private ArrayList<Profesor> listaProfesori;
	private ArrayList<Predmet> listaPredmeti;
	
	public DataBase() {
		listaStudenti = new ArrayList<Student>();
		listaProfesori = new ArrayList<Profesor>();
		listaPredmeti = new ArrayList<Predmet>();
	}
	
	public DataBase getInst() {
		return this;
	}
	
	public ArrayList<Student> getStud(){
		return listaStudenti;
	}
	public ArrayList<Profesor> getProf(){
		return listaProfesori;
	}
	public ArrayList<Predmet> getPred(){
		return listaPredmeti;
	}
	
	public void serialize() throws IOException{
		File f = new File("BazaPodataka" + File.separator + "BazaPodataka.txt");
		f.delete();
		f.createNewFile();
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream o = new ObjectOutputStream(new BufferedOutputStream(fos));
			
			listaStudenti = GlavniProzor.getControllerStudent().getListaStudenata();
			listaProfesori = GlavniProzor.getControllerProfesor().getListaProfesora();
			listaPredmeti = GlavniProzor.getControllerPredmet().getListaPredmeta();
			
			o.writeObject(getInst());
			
			o.close();
			fos.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deserialize() throws FileNotFoundException, IOException{
        try(FileInputStream fis = new FileInputStream("BazaPodataka" + File.separator + "BazaPodataka.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);) {

            DataBase temp = new DataBase();

            temp = (DataBase) ois.readObject();
            
            GlavniProzor.getControllerStudent().setListaStudenti(temp.getStud());
            GlavniProzor.getControllerProfesor().setListaProfesori(temp.getProf());
            GlavniProzor.getControllerPredmet().setListaPredmeti(temp.getPred());

            ois.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
