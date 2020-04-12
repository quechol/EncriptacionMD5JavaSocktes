import java.util.*;
import java.io.*;

class lectura {	
	String[] parts;
	String usuarioCad;
	String passwordCad;
	String cadena ="";
	int flag;	
	//busqueda en la BD
   	public  lectura (String cadena)
   	{
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		int cont=0;

		boolean contiene = false;
		
		Scanner tl = new Scanner(System.in);

		try {

		    archivo = new File ("BD.txt");
		    fr = new FileReader (archivo);
		    br = new BufferedReader(fr);

		    String linea;
		   	while((linea=br.readLine())!=null){
		        
	        	if (linea.contains(cadena)) {   
                    contiene = true;
                    
                    String[]parts = linea.split(",");
	        		usuarioCad = parts[0];
	        		passwordCad = parts[1];

                }
		    }
		    
		    if(!contiene){ 
				flag =0;
                //no se ha encontrado en el archivo
            }else{
            	flag=1;
            }
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{                    
				if( null != fr ){   
					fr.close();     
				}                  
			}catch (Exception e2){ 
				e2.printStackTrace();
			}
		}
	}
}
