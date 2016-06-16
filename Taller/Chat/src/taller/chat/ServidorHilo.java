package taller.chat;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ServidorHilo extends Thread{
	 
	private ArrayList<Socket> user;
	private Socket cliente;
	private int id;
	public ServidorHilo(Socket s,ArrayList<Socket> user,int id) {
	        super(String.valueOf(id));
	        setUser(user);
	        this.id=id;
	        cliente=s;
	    }
	 
	    private void setUser(ArrayList<Socket> usr) {
	    		this.user = usr;
		}

		@Override
	    public void run() {
			try {
        	String mensaje = new DataInputStream(cliente.getInputStream()).readUTF();
			while(!mensaje.equals("salir")){
				for(Socket indice : user){
					new DataOutputStream(indice.getOutputStream()).writeUTF(mensaje);
					}
				}
			}catch (Exception e) {
            e.printStackTrace();
			}
		}
}
