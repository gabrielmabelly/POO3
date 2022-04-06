package Etape1.reseau;

import java.io.File;
import java.util.Scanner;

//tested with \\SALSA.UNIV-AMU.FR\dfs\myhome_etud\DOSSIERS_WINDOWS\Documents\reseau\

public class MaxSizeRep {
	public static void main(String[]args) {
	    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter Directory Path");

	    String pathName = myObj.nextLine();  // Read user input
	    File f = new File(pathName);
	    
	    if (f.exists()) {
	    	if (f.isDirectory()) {
	    		System.out.println(allDirectory(f));
	    		

	    	}
	    }
	    else {
	    	System.out.println("no such thing");
	    }
	}
	
	public static String allDirectory(File f) {
		File fb = null;
		int maxSize = 0;
		int dirSize = 0;
		File[] listFile = f.listFiles();
		for (File f2 : listFile) {
			if (f2.isDirectory()) {
			 dirSize = sumSize(f2,0);
			 System.out.println("Directory currently checked : " + f2.getName() + " avec une taille de " + dirSize);

			 if (dirSize > maxSize) {
				 maxSize = dirSize;
				 fb = f2;
			 }
			 dirSize = 0;
			 System.out.println("current highest is : " + fb.getName() + " avec une taille de " + maxSize);
			}
		}
		
		return fb.getName() +  "avec une taille de : " + maxSize;

	}
	
	public static int sumSize(File f, int current) {
		File[] listFile = f.listFiles();
		for (File f2 : listFile) {
			if (f2.isDirectory()) {
				current += sumSize(f2,current); 
			}
			else {
				current += f2.length();
			}
		}
		System.out.println(current);
		return current;
	}
}
