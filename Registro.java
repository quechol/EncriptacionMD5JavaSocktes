import java.util.*;
import java.io.*;

//escritura
class Registro {
    String cadena ="";
    
    public Registro (String cadena)
    {
        BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			File file = new File("BD.txt");
			// Si el archivo no existe, se crea!
			if (!file.exists()) {
			    file.createNewFile();
			}
			// flag true, indica adjuntar información al archivo.
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			bw.write(cadena);
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
			    if (bw != null)
			        bw.close();
			    if (fw != null)
			        fw.close();
			} catch (IOException ex) {
			    ex.printStackTrace();
			}
		}
	}
}
