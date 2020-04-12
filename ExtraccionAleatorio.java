import java.util.*;
import java.io.*;

class ExtraccionAleatorio {
	
	String PasswordCliente="";
	String MArecibido="";
	String nuevoMA="";
	public ExtraccionAleatorio (String PasswordCliente, String MArecibido){
		
		String aux2=".",PasswordCliente2="";
  		int tamPassCliente=0;
  		
  		PasswordCliente2=PasswordCliente+aux2;
		tamPassCliente=PasswordCliente2.length();
		
		FileReader fr = null;
		BufferedReader br = null;
		File archivo=null;
		String linea1="";
		String Salva="";
		
		int tamtam=0;
		tamtam=MArecibido.length();

		int num2=tamPassCliente+2;
		int numPrimos2[];
		numPrimos2=new int[tamPassCliente];
		int pos2=0,i2,n2=4,cont2=2;
		String cad0="";
		
		if(num2>2){
            cad0="2 - 3";
            while(cont2<num2){
                i2=2;
                while(i2<=n2){
                    if(i2==n2){
                    	cad0=cad0+" - "+n2;
                    	cont2=cont2+1;
                    	//System.out.println(n);
                		numPrimos2[pos2]=n2;
                		pos2++;
                    }else{
                    	if(n2 % i2==0){
                    	i2=n2;
                    	}
                    }
                    i2=i2+1;
                }
                n2=n2+1;
            }
		}else{
            if(num2>0){
            	if(num2==1){
                	//System.out.println("es primo 2");
            	}else{
            		//System.out.println("es primo 2, 3");
            	}
            }else{
            	//System.out.println("ingresa numeros positivos");
            }
        }

		char auxCar;
       	int pp=0;
    	char Caracter2;
    	for(int ll=0; ll<tamtam; ll++){

    		if(numPrimos2[pp]==ll && pp<tamPassCliente-1){

    			auxCar=PasswordCliente2.charAt(pp);
    			nuevoMA += auxCar;
    			pp++;
    		}else{
    			auxCar=MArecibido.charAt(ll);
    			nuevoMA+=auxCar;
    		}
    		
    	}

	}

}
