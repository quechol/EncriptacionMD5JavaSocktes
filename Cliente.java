import java.net.*;
import java.io.*;
import java.util.*;

public class Cliente{

	
	public static void main(String[] args){
	
		final String HOST ="127.0.0.1";		
		final int PUERTO = 5000;
		
		DataInputStream in;
		DataOutputStream out;
		
		int respServer,opc,respServerHuella;
		
		Scanner tl = new Scanner(System.in);
		
		String cad1,cad2,cad3,cad4,cad5,cad6,cadencriptadasimple;
		String MAE,MAMD5="";
		String huellaCliente ="";
		String opcS="";
		
		
		try{
			Socket sc = new Socket(HOST, PUERTO);
			
			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			
			//out.writeUTF("Hola mundo desde el cliente");
			
			System.out.println("1.- Login");
			System.out.println("2.- Registro");
			opcS=tl.nextLine();
			//numEntero = Integer. parseInt(numCadena);
			opc = Integer.parseInt(opcS);
			//tl.skip("\n");
			/*char c=opcS.charAt(0);
			int ascii = (int) c;
			opc=ascii-*/
			
			if(opc==1){
			
				out.writeUTF("1");
			
				System.out.println("Usuario:");
				
				cad1 = tl.nextLine();	//lee usuario
				
				encriptado encripta = new encriptado(cad1);	//manda a encriptar la cadena
					
				cadencriptadasimple = encripta.encriptadocad; //obtiene la cadena encriptada
			
				out.writeUTF(cadencriptadasimple);	//manda la cadena encriptada al servidor
				
				String mensaje1 = in.readUTF();	//obtiene respuesta del servidor en busqueda en la BD
						
				respServer = Integer.parseInt(mensaje1);	//vemos el resultado
				
				if(respServer==1){
					
					MAE = in.readUTF();	//Obtiene el MAE del servidor
					
					desencriptado desencripta = new desencriptado(MAE); //desencripta MAE
					
					String MASer=desencripta.Dencriptadocad;
										
					System.out.println("Contraseña: ");
				
					cad2 = tl.nextLine();	//lee contraseña
					
					ExtraccionAleatorio extraccionAleatorio = new ExtraccionAleatorio(cad2,MASer);
					
					//System.out.println(extraccionAleatorio.nuevoMA);
					
					//llamar a funcion md5
					
					MAMD5=extraccionAleatorio.nuevoMA;
					
					controladorMD5 controladorMD5 = new controladorMD5(MAMD5);
					
					huellaCliente=controladorMD5.strF;
					
					//enviar md5
					
					out.writeUTF(huellaCliente);
					
					//recibir respuesta del servidor con el md5
					
					String mensajeHuella = in.readUTF();	//obtiene respuesta del servidor en busqueda en la BD
						
					respServerHuella = Integer.parseInt(mensajeHuella);	//vemos el resultado
					
					if(respServerHuella==1){
					
						System.out.println("L O G I N  E X I T O S O");
					
					}else{
						
						System.out.println("E R R O R");
						System.out.println("Usuario o Contraseña no validos");
						
					}
					
					sc.close();
					
				}else if(respServer==0){
				
					System.out.println("Contraseña: ");
					cad2 = tl.nextLine();
					
					System.out.println("E R R O R");
					System.out.println("Usuario o Contraseña no validos");
					
					sc.close();
				}else{
					sc.close();
				}
				
			}else if(opc==2){
				
				out.writeUTF("2");
				System.out.println("Registro");
				
				System.out.println("Ingresa Usuario");
				cad4 = tl.nextLine();
				System.out.println("Ingresa Contraseña");
				cad5 = tl.nextLine();
				
				encriptado encripta = new encriptado(cad4);
				cadencriptadasimple = encripta.encriptadocad;
				
				out.writeUTF(cadencriptadasimple);
				String mensaje1 = in.readUTF();	//obtiene respuesta del servidor en busqueda en la BD
						
				respServer = Integer.parseInt(mensaje1);	//vemos el resultado
				
				if(respServer==0){
					cad6=cad4+","+cad5;
					encriptado encripta2 = new encriptado(cad6);
					cadencriptadasimple = encripta2.encriptadocad;
					out.writeUTF(cadencriptadasimple);
					
					System.out.println("R E G I S T R O  E X I T O S O");
					sc.close();
				}else if(respServer==1){
					System.out.println("E R R O R");
					System.out.println("Usuario ya registrado");
					sc.close();
				
				}else{
					sc.close();
				}
				
				
			}else{
				out.writeUTF("3");
				System.out.println("E R R O R");
				System.out.println("OPCION INCORRECTA");
			}//switch
			
		}catch (IOException e){
			e.printStackTrace();
		}
	
	}
}
