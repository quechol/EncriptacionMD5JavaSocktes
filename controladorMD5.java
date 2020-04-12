import java.util.*;
import java.io.*;

public class controladorMD5{
	
	//recibira la cadena
	String MA="";
	
	int A,B,C,D;
	
	String temp,temp2;
	
	String strA ="";
	String strB ="";
	String strC ="";
	String strD ="";
	String strF ="";
	
	public controladorMD5(String MA){
			
		relleno bits = new relleno();
		
    	StringBuilder MAB = bits.obtenerBits(MA);
    	String singleString = MAB.toString();
    	String passRelleno = bits.rellenarCadena(singleString);
    	
    	bloques blocs = new bloques();
    	
    	buffers md5 = new buffers();
    	
    	String[] bloques512=blocs.crearBloques512(passRelleno);
    	for (int i=0; i<bloques512.length; i++){
    		temp=bloques512[i];
    		String[] bloques16 = blocs.crearBloques16(temp);    		
    		for (int j=0; j<32;j++){
    			temp2=bloques16[j];
    			md5.generarMD5(temp2);
    		}
    	}
    	
    	A=md5.A;
		B=md5.B;
		C=md5.C;
		D=md5.D;
		
		huella huella = new huella();
		
		strA = huella.rellenarHuella(Integer.toBinaryString(A));
    	strB = huella.rellenarHuella(Integer.toBinaryString(B));
    	strC = huella.rellenarHuella(Integer.toBinaryString(C));
    	strD = huella.rellenarHuella(Integer.toBinaryString(D));
    	
		strA = huella.Invertido(strA);
		strB = huella.Invertido(strB);
		strC = huella.Invertido(strC);
		strD = huella.Invertido(strD);
		
		strF += strD+strC+strB+strA;
			
	}

}
