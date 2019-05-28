package hr.fer.oop.aud11.zad1;

import java.util.HashMap;
import java.util.Map;

public class GradeData {
	
	public static Map<String, Map<String, Integer>> LoadData() {
		Map<String, Integer> gradesMath = new HashMap<String, Integer>();
		gradesMath.put("Ana", 5);
		gradesMath.put("Ante", 4);
		gradesMath.put("Pero", 2);
		gradesMath.put("Dagmar", 3);
		
		Map<String, Integer> gradesCroatian = new HashMap<String, Integer>();
		gradesCroatian.put("Xu", 5);
		gradesCroatian.put("Ante", 4);
		gradesCroatian.put("Lucija", 2);
		gradesCroatian.put("Pero", 3);
		
		Map<String, Integer> gradesArt = new HashMap<String, Integer>();
		gradesArt.put("Ana", 5);
		gradesArt.put("Ante", 4);
		gradesArt.put("Pero", 3);
		gradesArt.put("Dagmar", 5);
		gradesArt.put("Lucija", 2);
		gradesArt.put("Xu", 5);
		
		Map<String, Integer> gradesChemistry = new HashMap<String, Integer>();
		gradesChemistry.put("Ana", 3);
		gradesChemistry.put("Pero", 4);
		gradesChemistry.put("Lucija", 4);
		gradesChemistry.put("Walter", 5);
		
		Map<String, Map<String, Integer>> grades = new HashMap<String, Map<String,Integer>>();
		grades.put("math", gradesMath);
		grades.put("croatian", gradesCroatian);
		grades.put("arts", gradesArt);
		grades.put("chemistsry", gradesChemistry);
		
		return grades;
	}

}
