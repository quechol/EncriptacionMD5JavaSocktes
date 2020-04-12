import java.util.*;
import java.io.*;

//escritura
class desencriptado {
    String cadena ="";
    String Dencriptadocad;
    
    public desencriptado (String cadena)
    {
        
        BufferedWriter bw = null;
		FileWriter fw = null;
		char array[]= cadena.toCharArray();
		
		for(int i =0; i<array.length; i++)
		{
			array[i]=(char)(array[i]-(char)5);
		}
		
		Dencriptadocad = String.valueOf(array);
		
	}
	
	
}
