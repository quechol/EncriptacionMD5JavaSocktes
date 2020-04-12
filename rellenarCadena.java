import java.util.*;
import java.io.*;

class rellenarCadena{

	String cadena ="";
	String cadena2 ="";
	
	public StringBuilder obtenerBits(String mensaje){
    	byte[] bytes = mensaje.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes){
        	int val = b;
            for (int i = 0; i < 8; i++){
            	binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
            binary.append(' ');
        }
        return binary;
    }
    
	public rellenarCadena(String cadena){ //Cadena = cadenaDeBits
        int tamaño = cadena.length();
        int residuo = tamaño%512;
        int relleno= residuo-64;
        int k;
        k = (int) (tamaño/5l)+1;
        cadena+=1;
        for(int i=0; i<relleno;i++){
            cadena+=0;
        }

        String tam_total=obtenerBits(String.valueOf(k));
        int rellenoAB= 64-tam_total.length();
        String aux = "";
            for(int i=0; i<=rellenoAB; i++){
                 aux+=0;
            }    
            aux+=tam_total;

        String A="";
        A=aux.substring(0, (aux.length()/2));
        String B="";
        B=aux.substring((aux.length()/2)+1, aux.length());
        cadena=cadena+B+A;
        cadena2 = cadena;
    }
}
