import java.util.*;
import java.io.*;

//escritura
class CreaMensajeAleatorio {
	String MA = "";
	
	public CreaMensajeAleatorio(){
	
		//String MA = "";
		char Caracter;
		Random rnd = new Random();
		for ( int ii = 0; ii < 2048; ii++)
		{
		 	int x= (int)(rnd.nextDouble() * 26 + 65);
		 	Caracter = (char)(x);
			MA += Caracter;
		}
		
		
    	
    }
}
