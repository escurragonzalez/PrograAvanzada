package taller.chat;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Servidor {

	private ArrayList<Socket> user;
	private int cantConexionesMax;
	Servidor(int puerto){
		user = new ArrayList<Socket>();
		int i=0;
		cantConexionesMax =4;
		try {
			ServerSocket socket=new ServerSocket(puerto);
			System.out.println("Servidor en linea");
			while(i<cantConexionesMax){
				Socket sk = socket.accept();
				user.add(sk);
				new ServidorHilo(sk,user,i).start();
				i++;
			}
			socket.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Servidor(5000);
	}
}



