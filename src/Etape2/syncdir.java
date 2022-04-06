package tp3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class syncdir {
	public static void main(String[]args) throws IOException {
		File dsource = new File(args[0]);
		File ddest = new File(args[1]);
		int critere = Integer.parseInt(args[2]);
		if (dsource.exists() && dsource.isDirectory()) {
			if (ddest.exists() && ddest.isDirectory()) {
				synchro(dsource,ddest,critere);
				System.out.println("synchro is done");
			}
			else{
				System.err.println("problem with destination directory");
			}
		}
		else{
			System.err.println("problem with source directory");
		}
		
	}
	
	//rechercher dans chaque source & destinations pour faire les copies, pas d'erase
	public static void synchro(File f1, File f2, int critere) throws IOException {
		switch(critere) {
		case 0:
			synchBigger(f1,f2);
			synchBigger(f2,f1);
			//synchro en gardant le plus lourd en cas de conflit
			break;
		case 1:
			synchOlder(f1,f2);
			synchOlder(f2,f1);
			//synchro en gardant le + recent en cas de conflit
			break;
		case 2: 
			synchFirstPrio(f1,f2);
			synchFirstPrio(f2,f1);
			//gardera les donn�es contenus dans dir1 si les noms sont similaires entre fichiers
			break;
		case 3: 
			synchFirstPrio(f2,f1);
			synchFirstPrio(f1,f2);
			//gardera les donn�es contenus dans dir2 si les noms sont similaires entre fichiers
			break;
		 default:
			break;
		}

	}
	
	public static void synchBigger (File f1, File f2) throws IOException {
		File[] listFile = f1.listFiles();
			for (File f : listFile) {
				if (f.isDirectory()) {
					File f3 = new File(f2.getAbsolutePath() + "\\"+f.getName());
					if (f3.exists() == false) {
					boolean b = f3.mkdir();
					}
					synchBigger(f,f3);
				}
				else {File f4 = new File(f2.getAbsolutePath()+"\\"+f.getName());
					if (f4.exists()) {
						if (f.length()  > f4.length()) {
							copieFile(f,f4);
						}
					}
					else {
						copieFile(f,f4);
					}
				}
			}
	}
	
	public static void synchFirstPrio (File f1, File f2) throws IOException {
		File[] listFile = f1.listFiles();
			for (File f : listFile) {
				if (f.isDirectory()) {
					File f3 = new File(f2.getAbsolutePath() + "\\"+f.getName());
					if (f3.exists() == false) {
					boolean b = f3.mkdir();
					}
					synchFirstPrio(f,f3);
				}
				else {
					File f4 = new File(f2.getAbsolutePath()+"\\"+f.getName());
						copieFile(f,f4);
				}
			}
	}


	public static void synchOlder (File f1, File f2) throws IOException {
		File[] listFile = f1.listFiles();
			for (File f : listFile) {
				if (f.isDirectory()) {
					File f3 = new File(f2.getAbsolutePath() + "\\"+f.getName());
					if (f3.exists() == false) {
					boolean b = f3.mkdir();
					}
					synchOlder(f,f3);
				}
				else {
					File f4 = new File(f2.getAbsolutePath()+"\\"+f.getName());
					if (f4.exists()) {
						if (f.lastModified() > f4.lastModified()) {
							copieFile(f,f4);
						}
					}
					else {
						copieFile(f,f4);
					}
				}
			}
	}
	
	public static void copieFile(File source, File dest) throws IOException {
		FileInputStream in = new FileInputStream(source);
		FileOutputStream out = new FileOutputStream(dest);

		while (in.available() != 0) {
			out.write(in.read());
		}
		in.close();
		out.close();
		
	}

}
