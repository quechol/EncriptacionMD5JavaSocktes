import java.net.*;
import java.io.*;
import java.util.*;

public class Servidor{

	public static void main(String[] args){
		
		
		ServerSocket servidor = null;
		Socket sc = null;
		DataInputStream in;
		DataOutputStream out;
		String usrdescr;
		int existe;
		String usser,pass;
		String MA="";
		String MAE="";
		String MAMD5 ="";
		String huellaServidor ="";
		String huellaCliente ="";
		
		final int PUERTO = 5000;
		
		try{
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor iniciado...");
			while(true){
				
				sc = servidor.accept();
				
				System.out.println("Cliente conectado");
				System.out.println();
				
				System.out.println("Seleccion de Servicios");
				
				in = new DataInputStream(sc.getInputStream());
				out = new DataOutputStream(sc.getOutputStream());
				
				
				String opc1 = in.readUTF();
				
				int opc = Integer.parseInt(opc1);	//verificar login, registro o otro
				
				switch (opc){
				
					case 1:
						System.out.println("Login de usuario");
						//lectura de usuario
						
						String mensaje1 = in.readUTF();	//recibe usuario encriptado
						
						//System.out.println(mensaje1);	
						
						desencriptado desencripta = new desencriptado(mensaje1); //desencripta usuario
						
						usrdescr = desencripta.Dencriptadocad;	//obtiene usuario desencriptado
						
						lectura lectura = new lectura(usrdescr);	//manda a buscar el usuario en la bd
						
						existe=lectura.flag; //0 NO , 1 SI
						
						if(existe==1){
							
							out.writeUTF("1");
							System.out.println("Se encontro en la BD");
							//System.out.println("Usuario en la BD");
							usser=lectura.usuarioCad;	//obtiene el usuario de la BD
							//System.out.println(usser);
							//System.out.println("Password en la BD");
							pass=lectura.passwordCad;	//obtiene la contraseña de la BD
							//System.out.println(pass);
							//int tmp=pass.length();
							
							CreaMensajeAleatorio CreaMensajeAleatorio = new CreaMensajeAleatorio();	//crea MA sin password
							
							MA=CreaMensajeAleatorio.MA;	//obtine el MA sin la password
							
							encriptado encripta = new encriptado(MA);	//Encripta el mensaje aleatorio
							
							MAE=encripta.encriptadocad;	//Obtiene el MA encriptado
							out.writeUTF(MAE);	//envia el MAE al usuario
							
							//Añadimos la passwor al MA que se queda en el servidor
							
							ExtraccionAleatorio extraccionAleatorio = new ExtraccionAleatorio(pass,MA);
							
							//System.out.println(extraccionAleatorio.nuevoMA);
						
							//Obitiene el MD5 del usuario
							
							MAMD5=extraccionAleatorio.nuevoMA;
							
							controladorMD5 controladorMD5 = new controladorMD5(MAMD5);
							
							huellaServidor=controladorMD5.strF;
							
							System.out.println("Huella generada del Servidor: ");
							System.out.println(huellaServidor);
							
							//Recibir huella del Cliente
							
							huellaCliente= in.readUTF();
							System.out.println("Huella recibida del Cliente:");
							System.out.println(huellaCliente);
							
							//Compara Huellas
							//0 NO , 1 SI
							if (huellaServidor.equals(huellaCliente))
							{
								System.out.println("Huellas iguales");
								//out.writeUTF("Contraseña aceptada");
								out.writeUTF("1");
							}else{
								System.out.println("Huellas diferentes");
								//out.writeUTF("Contraseña rechazada");
								out.writeUTF("0");
							}
							sc.close();
							System.out.println("Cliente desconectado");
							System.out.println();
						}else if(existe==0){
							
							out.writeUTF("0");
							
							System.out.println("No se encuentra en la BD");
											
							sc.close();
							
							System.out.println("Cliente desconectado");
							System.out.println();
						}
						
					break;
					case 2:
						System.out.println("Registro de un nuevo usuario");
						
						String mensaje4 = in.readUTF();
						//System.out.println(mensaje4);
						
						desencriptado desencripta2 = new desencriptado(mensaje4); //desencripta usuario
						
						usrdescr = desencripta2.Dencriptadocad;	//obtiene usuario desencriptado
						
						lectura lectura2 = new lectura(usrdescr);	//manda a buscar el usuario en la bd
						
						existe=lectura2.flag; //0 NO , 1 SI
						
						if(existe==1){
							out.writeUTF("1");
							
							System.out.println("Usuario en BD");
							
							sc.close();
							System.out.println("Cliente desconectado");
							System.out.println();
						}else if(existe==0){
							out.writeUTF("0");
							
							System.out.println("Usuario Disponible");
							
							String mensaje5 = in.readUTF();
							
							desencriptado desencripta3 = new desencriptado(mensaje5); //desencripta usuario
						
							usrdescr = desencripta3.Dencriptadocad;
							
							Registro registro = new Registro(usrdescr);
							
							sc.close();
							System.out.println("Cliente desconectado");	
							System.out.println();
						}else{
							sc.close();
							System.out.println("Cliente desconectado");
							System.out.println();
						}
					break;
					default:
						System.out.println("Error");
						sc.close();
						System.out.println("Cliente desconectado");
						System.out.println();
					break;
					
				}//switch
				
			}
			
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
