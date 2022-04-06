//package thread.session4.exercices;
//
//import java.io.*;
//import java.nio.*;
//import java.nio.file.*;
//import java.nio.file.attribute.BasicFileAttributes;
//import java.time.*;
//
//public class Exercice1_FindByDate {
//
//	public static void main(String[] args) {
//
//		Path racine = Paths.get("src");
//
//		LocalDate cible=LocalDate.now();
//
//		ChercheurParDate cpd = new ChercheurParDate(racine,cible);
//		Thread sniffeur= new Thread(cpd);
//		sniffeur.start();
//
//	}
//
//}
//
//class ChercheurParDate implements Runnable {
//
//	Path racine;
//	LocalDate laDate;
//	LocalDate borneInf ;
//	LocalDate borneSup ;
//
//	public void run() {
//
//		try {
//		Files.walkFileTree(racine, new SimpleFileVisitor<Path>() {
//
//		      @Override
//		      public FileVisitResult visitFile(final Path file,
//		          final BasicFileAttributes attrs) throws IOException {
//
//		    	LocalDate lmDuFichier = LocalDate.ofInstant(attrs.lastModifiedTime().toInstant(), ZoneId.systemDefault());
//
//		        if (lmDuFichier.isAfter(borneInf) && lmDuFichier.isBefore(borneSup)) {
//					System.out.println("Fichier correpondant aux dates : " + file);
//				}
//		        return FileVisitResult.CONTINUE;
//		      }
//		    });
//
//		}
//		catch (IOException e) {e.printStackTrace();	}
//
//
//		}
//
//	public ChercheurParDate(Path racine,LocalDate cible) {
//    	this.racine=racine;
//    	this.laDate=cible;
//		borneInf = laDate.minusDays(1);
//    	borneSup = laDate.plusDays(1);
//
//	}
//
//}
