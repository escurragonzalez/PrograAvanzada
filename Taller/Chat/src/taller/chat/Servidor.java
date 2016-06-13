package taller.chat;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Servidor {

	private ArrayList<Socket> user=new ArrayList<Socket>();
	Servidor(){
		ServerSocket socket= null;
		Socket sk = null;
		int i=0;
		try {
			socket=new ServerSocket(5000);
			while(true){
				sk = socket.accept();
				user.add(sk);
				ThreadChat hilo = new ThreadChat(sk,user,i);
				hilo.start();
				i++;
			}
			} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				socket.close();
				sk.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}	

	public static void main(String[] args) {
		new Servidor();
	}
}



