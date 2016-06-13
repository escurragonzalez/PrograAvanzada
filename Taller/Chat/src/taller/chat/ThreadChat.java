package taller.chat;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ThreadChat extends Thread{
	 
	private ArrayList<Socket> user = new ArrayList<Socket>();
	
	    public ThreadChat(int id) {
	        super(String.valueOf(id));
	    }
	 
	    @Override
	    public void run() {
	    	Socket sk = null;
	    	DataInputStream in = null;
	    	DataOutputStream out=null;
	    	try {
	        	sk = new Socket("localhost",5000);
	        	user.add(sk);
				in = new DataInputStream(sk.getInputStream());
				out = new DataOutputStream(sk.getOutputStream());
				while(true){
		               String recibido = in.readUTF();
		               for(int i=0;i<user.size();i++){
		                    out = new DataOutputStream(user.get(i).getOutputStream());
		                    out.writeUTF(recibido);
		               }
		                }
				}catch (Exception e) {
					  for (int i = 0; i < user.size(); i++) {
			                if(user.get(i) == sk){
			                	user.remove(i);
			                    break;
			                } 
			            }
	            e.printStackTrace();
	        }finally{
	        	try {
					sk.close();				
					in.close();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	        
	    }
}
