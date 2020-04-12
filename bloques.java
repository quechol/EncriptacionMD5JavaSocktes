import java.util.*;
import java.io.*;

class bloques {

	String cadena="";
	
	public String[] crearBloques512(String cadena){
    	int bloque= cadena.length()/512;
    	String A[] = new String[bloque];
    	//System.out.println("Numero de bloques: "+bloque);
    	for(int i=0;i<bloque;i++){
        	A[i]= cadena.substring((cadena.length()/bloque)*i,(cadena.length()/bloque)*(i+1));
    	}
    	return A;
    }
  
    public String[] crearBloques16(String cadena) {
    	int bloque= cadena.length()/16;
        String A[] = new String[bloque];
        for(int i=0;i<bloque;i++){
            A[i]= cadena.substring((cadena.length()/bloque)*i,(cadena.length()/bloque)*(i+1));
        }
        return A;
    }
}
