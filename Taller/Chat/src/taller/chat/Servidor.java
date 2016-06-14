package taller.chat;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Servidor {

	private ArrayList<Socket> user=new ArrayList<Socket>();
	private int cant;
	private DataInputStream in;
	private DataOutputStream out;
	Servidor(){
		ServerSocket socket= null;
		Socket sk = null;
		cant=2;
		int i=0;
		try {
			if(user.size()<cant){
			socket=new ServerSocket(5000);

			while(true){
				sk = socket.accept();
				in = new DataInputStream(sk.getInputStream());
				out = new DataOutputStream(sk.getOutputStream());
				user.add(sk);
				ThreadChat hilo = new ThreadChat(sk,user,i);
				hilo.start();
				i++;
			}
			}
			} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				socket.close();
				sk.close();
				in.close();
				out.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}	

	public static void main(String[] args) {
		new Servidor();
	}
}



