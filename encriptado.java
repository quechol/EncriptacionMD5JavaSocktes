import java.util.*;
import java.io.*;

//escritura
class encriptado {
    String cadena ="";
    String encriptadocad;
    
    public encriptado (String cadena)
    {
        
        BufferedWriter bw = null;
		FileWriter fw = null;
		char array[]= cadena.toCharArray();
		
		for(int i =0; i<array.length; i++)
		{
			array[i]=(char)(array[i]+(char)5);
		}
		
		encriptadocad = String.valueOf(array);
		
	}
	
	
}
