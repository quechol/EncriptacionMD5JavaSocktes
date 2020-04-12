import java.util.*;
import java.io.*;

class huella {
	String huella="";
	
	public static String rellenarHuella(String huella){

		if(huella.length()!=32){
			do{
				huella="0"+huella;
			}while(huella.length()!=32);
		}
		return huella;
	}


	public static String Invertido(String huella){
		String str = "";
		int i,tam;

		tam = huella.length();

		for(i=tam-1;i>=0;i--){
			str = str + huella.charAt(i);
		}

		return str;

	}


}
