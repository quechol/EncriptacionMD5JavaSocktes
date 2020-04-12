import java.util.*;
import java.io.*;

class buffers {
	
	String m="";
	
	int A= 0x67452301;
    int B= (int) 0xEFCDAB89L;
    int C= (int) 0x98BADCFEL;
    int D= 0x10325476;

    private static final int AA=0x67452301;
    private static final int BB=(int) 0xEFCDAB89L;
	private static final int CC=(int) 0x98BADCFEL;
	private static final int DD=0x10325476;
    
    private static final int[] T = new int[64];
    
    static
    {
      for (int i = 0; i < 64; i++){
        T[i] = (int) (long) ((1L << 32) * Math.abs(Math.sin(i + 1)));
      }
    }
	
	public int F(int x, int y, int z){
		return ((x&y)|((~x)&z));        
	}

	public int G(int x, int y, int z){
		return ((x&z)|(y));     
	}

	public int H(int x, int y, int z){
		return (x^y^z);
	}

	public int I(int x, int y, int z){
		return (y^(x|(~z)));
	}

	public int etapa1(String mensaje,int a,int b,int c,int d,int k,int s,int i){
		return a=b+((a+F(b,c,d)+mensaje.charAt(k)+T[i-1])<<s);
	}

	public int etapa2(String mensaje,int a,int b,int c,int d,int k,int s,int i){
		return a = b + ((a+G(b,c,d)+mensaje.charAt(k)+T[i-1])<<s);
	}
	public int etapa3(String mensaje,int a,int b,int c,int d,int k,int s,int i){
		return a = b + ((a+ H(b,c,d)+mensaje.charAt(k)+T[i-1])<<s);
	}
	public int etapa4(String mensaje,int a,int b,int c,int d,int k,int s,int i){
		return a = b + ((a+ I(b,c,d)+mensaje.charAt(k)+T[i-1])<<s);
	}
	
	public void generarMD5(String m){
	 A=etapa1(m,A,B,C,D,0,7,1);
	 D=etapa1(m,D,A,B,C,1,12,2);
 	 C=etapa1(m,C,D,A,B,2,17,3);
	 B=etapa1(m,B,C,D,A,3,22,4);
	 A=etapa1(m,A,B,C,D,4,7,5);
	 D=etapa1(m,D,A,B,C,5,12,6); 
	 C=etapa1(m,C,D,A,B,6,17,7);
	 B=etapa1(m,B,C,D,A,7,22,8);
	 A=etapa1(m,A,B,C,D,8,7,9);
	 D=etapa1(m,D,A,B,C,9,12,10);
	 C=etapa1(m,C,D,A,B,10,17,11);
	 B=etapa1(m,B,C,D,A,11,22,12);
	 A=etapa1(m,A,B,C,D,12,7,13);
	 D=etapa1(m,D,A,B,C,13,12,14);
	 C=etapa1(m,C,D,A,B,14,17,15);
	 B=etapa1(m,B,C,D,A,15,22,16);
     A=etapa2(m,A,B,C,D,1,5,17);
     D=etapa2(m,D,A,B,C,6,9,18);
     C=etapa2(m,C,D,A,B,11,14,19);
     B=etapa2(m,B,C,D,A,0,20,20);
     A=etapa2(m,A,B,C,D,5,5,21);
     D=etapa2(m,D,A,B,C,10,9,22);
     C=etapa2(m,C,D,A,B,15,14,23);
     B=etapa2(m,B,C,D,A,4,20,24);
     A=etapa2(m,A,B,C,D,9,5,25);
     D=etapa2(m,D,A,B,C,14,9,26);
     C=etapa2(m,C,D,A,B,3,14,27);
     B=etapa2(m,B,C,D,A,8,20,28);
     A=etapa2(m,A,B,C,D,13,5,29);
     D=etapa2(m,D,A,B,C,2,9,30);
     C=etapa2(m,C,D,A,B,7,14,31);
     B=etapa2(m,B,C,D,A,12,20,32);
     A=etapa3(m,A,B,C,D,5,4,33);
     D=etapa3(m,D,A,B,C,8,11,34);
     C=etapa3(m,C,D,A,B,11,16,35);
     B=etapa3(m,B,C,D,A,14,23,36);
     A=etapa3(m,A,B,C,D,1,4,37);
     D=etapa3(m,D,A,B,C,4,11,38);
     C=etapa3(m,C,D,A,B,7,16,39);
     B=etapa3(m,B,C,D,A,10,23,40);
     A=etapa3(m,A,B,C,D,13,4,41);
     D=etapa3(m,D,A,B,C,0,11,42);
     C=etapa3(m,C,D,A,B,3,16,43);
     B=etapa3(m,B,C,D,A,6,23,44);
     A=etapa3(m,A,B,C,D,9,4,45);
     D=etapa3(m,D,A,B,C,12,11,46);
     C=etapa3(m,C,D,A,B,15,16,47);
     B=etapa3(m,B,C,D,A,2,23,48);
     A=etapa3(m,A,B,C,D,0,6,49);
     D=etapa3(m,D,A,B,C,7,10,50);
     C=etapa3(m,C,D,A,B,14,15,51);
     B=etapa3(m,B,C,D,A,5,21,52);
     A=etapa3(m,A,B,C,D,12,6,53);
     D=etapa3(m,D,A,B,C,3,10,54);
     C=etapa3(m,C,D,A,B,10,15,55);
     B=etapa3(m,B,C,D,A,1,21,56);
     A=etapa3(m,A,B,C,D,8,6,57);
     D=etapa3(m,D,A,B,C,15,10,58);
     C=etapa3(m,C,D,A,B,6,15,59);
     B=etapa3(m,B,C,D,A,13,21,60);
     A=etapa3(m,A,B,C,D,4,6,61);
     D=etapa3(m,D,A,B,C,11,10,62);
     C=etapa3(m,C,D,A,B,2,15,63);
     B=etapa3(m,B,C,D,A,9,21,64);
 	
 	      
     A = A + AA;
     B = B + BB;
     C = C + CC;
     D = D + DD;
	}
}
