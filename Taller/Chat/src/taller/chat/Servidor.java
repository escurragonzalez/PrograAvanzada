package taller.chat;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Servidor {

	private ArrayList<Socket> user=new ArrayList<Socket>();
	Servidor(){
		ServerSocket socket= null;
		Socket sk = null;
		DataOutputStream out = null;
		DataInputStream in = null;
		try {
			socket=new ServerSocket(5000);
			while(true){
				sk = socket.accept();
				user.add(sk);
				out = new DataOutputStream(sk.getOutputStream());
				in = new DataInputStream(sk.getInputStream());
			}
			} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				socket.close();
				sk.close();
				out.close();			
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}	

	public static void main(String[] args) {
		new Servidor();
	}
}



