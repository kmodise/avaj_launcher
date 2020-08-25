package writetofile;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteToFile {
    private static boolean firstSimulation;

	private void FileWriters() {
    }//THIS

	public static void puttofileln(String str){
		if (!firstSimulation){
			try{
				FileWriter fileWriterObj = new FileWriter("C:\\Users\\the-kb\\Documents\\avaj_launcher\\src\\scenario.txt");    
				fileWriterObj.flush();
				fileWriterObj.close();
			}catch (Exception e){
                System.out.println("Unable clear file");
                
			}
			firstSimulation = true;
		}
		try{
		BufferedWriter bufferedWriterObj = new BufferedWriter(new FileWriter("C:\\Users\\the-kb\\Documents\\avaj_launcher\\src\\scenario.txt", true)); 
			bufferedWriterObj.write(str + "\n");
			bufferedWriterObj.close();
		}catch (Exception e){
            System.out.println("Unable To Open file");
		}
	}

	public static void puttofile(String str){
		if (!firstSimulation){
			try{
				FileWriter fileWriterObj = new FileWriter("C:\\Users\\the-kb\\Documents\\avaj_launcher\\src\\scenario.txt");    
				fileWriterObj.flush();
				fileWriterObj.close();
			}catch (Exception e){
				 System.out.println("Unable clear file");
			}
			firstSimulation = true;
		}
		try{
			BufferedWriter bufferedWriterObj = new BufferedWriter(new FileWriter("C:\\Users\\the-kb\\Documents\\avaj_launcher\\src\\scenario.txt", true)); 
			bufferedWriterObj.write(str);
			bufferedWriterObj.close();
		}catch (Exception e){
			 System.out.println("Unable To Open file");
		}
	}
}