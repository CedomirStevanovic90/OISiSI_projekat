package controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Checker {
	
	public static String[] regExDatePoss = {"dd.MM.yyyy.", "dd.MM.yyyy", "d.MM.yyyy.", "d.MM.yyyy", "dd.M.yyyy.", "dd.M.yyyy", "d.M.yyyy.", "d.M.yyyy"};
	
	public static boolean isNameOrSurename(String str) {
		str = str.toLowerCase();
		str = str.trim();
		String regEx = "\\p{L}+";
		if(str.matches(regEx))
			return true;
		return false;
	}
	public static boolean isValidDate(String str) {
		boolean suc = false;		
		str = str.trim();
		DateTimeFormatter dataTimeFormatter;
		LocalDate date = null;
		String[] parts = str.split("\\.");
		
		for(int i = 0; i < regExDatePoss.length; i++) {
			try {
				dataTimeFormatter = DateTimeFormatter.ofPattern(regExDatePoss[i]);
				date = LocalDate.parse(str, dataTimeFormatter);
				suc = true;
				break;
			}catch(Exception e) {
				suc = false;
			}
			if(suc)
				break;
		}
		
		if(suc)
			if(date.getYear() < 1920)
				suc = false;
		
		if(suc)
			if(date.getYear() > (LocalDateTime.now().getYear() - 16))
				suc = false;
		
		if(suc) {
			switch(parts[1]) {
				case "1" :
				case "3" :
				case "5" :
				case "7" :
				case "8" :
				case "10" :
				case "12" : {
					if(Integer.parseInt(parts[0]) <= 0 || Integer.parseInt(parts[0]) >= 32)
						suc = false;
					break;
				}
				case "4" :
				case "6" :
				case "9" :
				case "11" :{
					if(Integer.parseInt(parts[0]) <= 0 || Integer.parseInt(parts[0]) >= 31)
						suc = false;
					break;
				}
				case "2" :{
					if(date.getYear() % 4 == 0) {
						if(Integer.parseInt(parts[0]) <= 0 || Integer.parseInt(parts[0]) >= 29)
							suc = false;
					}else {
						if(Integer.parseInt(parts[0]) <= 0 || Integer.parseInt(parts[0]) >= 28)
							suc = false;
					}
					break;
				}	
			}
		}
		
		return suc;
	}
	public static boolean isValidAdrress(String str) {
		str = str.toLowerCase();
		str = str.trim();
		
		if(str.matches("([\\s]?[\\p{L}]+)*[,][\\s]*[0-9]{1,4}[/][0-9]{1,3}[,]([\\s][\\p{L}]+)*[,]([\\s][\\p{L}]+)*")) { 
			//Mise Dimitrijevica Bate Ima Vise, 1234/123, Novi Sad, Republika Srpska
			return true;}
		return false;
	}
	public static boolean isValidNumber(String str) {
		str = str.trim();
		if(str.matches("[0-9]{3}[/][0-9]{3,4}[-][0-9]{3,4}"))
			return true;
		return false;
	}
	public static boolean isValidEmail(String str) {
		str = str.trim();
		str = str.toLowerCase();
		if(str.matches("[a-zA-Z0-9.]*@((((\\bgmail\\b)|(\\byahoo\\b)|(\\bhotmail\\b))[.](\\bcom\\b))|((\\buns\\b)[.](\\bac\\b)[.](\\brs\\b)))")) //bag podrzava i velika slova tako i ostali resiti***
			return true;
		return false;
	}
	public static boolean isValidIndex(String str) {
		str = str.trim();
		if(str.matches("[a-zA-Z]{2}[-][0-9]{1,3}[/][2]{1}[0]{1}[0,1,2]{1}[0-9]{1}"))
			return true;
		return false;
	}
	public static boolean isValidYear(String str) {
		str = str.trim();
		if(!str.matches("[2]{1}[0]{1}[0,1,2]{1}[0-9]{1}"))
			return false;
		if(1990 <= Integer.parseInt(str) && Integer.parseInt(str) <= Calendar.getInstance().get(Calendar.YEAR))
			return true;
		return false;
	}
	public static boolean isValidProfessorID(String str) {
		str = str.trim();
		if(str.matches("[0-9]{9}"))
			return true;
		return false;
	}
	public static boolean isValidYearOfServise(String str) {
		str = str.trim();
		if(!str.matches("[0-9]{1}[0-9]{1}"))
			return false;
		if(Integer.parseInt(str) >=  0 && Integer.parseInt(str) <=  65)
			return true;
		return false;
	}
	public static boolean isSubjectID(String str) {
		str = str.trim();
		if(str.matches("[a-zA-Z]+[0-9]+"))
			return true;
		return false;
	}
	public static boolean isValidECTS(String str) {
		str = str.trim();
		if(str.matches("[1-9]+[0-9]*"))
			return true;
		return false;
	}
	
}
