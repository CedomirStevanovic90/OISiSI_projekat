package controller;

import java.util.ArrayList;

import model.Student;

public class ControllerStudent {
	
	ArrayList<Student> listaStudenti;
	
	public ControllerStudent() {
		listaStudenti = new ArrayList<Student>();
	}
	
	public ArrayList<Student> getListaStudenata(){
		return this.listaStudenti;
	}
	
	public boolean dodajStudenta(Student student) {
		if(listaStudenti.isEmpty()) {
			listaStudenti.add(student);
			return true;
		}	
		for(Student temp: listaStudenti) {
			if(temp.getBrojIndeksa().equals(student.getBrojIndeksa())) {
				return false;
			}			
		}
		listaStudenti.add(student);
		return true;
	}
	
	public Student nadjiStudenta(String index) {
		Student ret = null;
		for(Student s : listaStudenti)
			if(s.getBrojIndeksa().equals(index))
				ret = s;
		return ret;
	}
	
	public void setListaStudenti(ArrayList<Student> listaStudenti) {
		this.listaStudenti = listaStudenti;
	}

	public void obrisiStudenta(String indexStudenta) {
		// TODO Auto-generated method stub
		for(Student s : listaStudenti)
			if(s.getBrojIndeksa().equals(indexStudenta)) {
				listaStudenti.remove(s);
				break;
			}
	}
}
