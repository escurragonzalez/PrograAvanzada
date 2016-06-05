package taller.chat;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Chat{

	private JFrame frame;
	private JTextField textField;
	private Socket cliente;
    private DataInputStream in;
    private DataOutputStream out;
    private String host = "localhost";
    private String mensaje = "";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat window = new Chat();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Chat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */		
	
	public void run() {
        try{
            while(true){
                mensaje += in.readUTF();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
	

    public void enviarMsg(String msg){
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	private void initialize() {
		try{		
	        cliente = new Socket(host,5000);
	        in = new DataInputStream(cliente.getInputStream());
	        out =new DataOutputStream(cliente.getOutputStream());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		frame = new JFrame();
//		frame.addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				 int n = JOptionPane.showOptionDialog(new JFrame(), "Esta seguro de querer salir", 
//					        "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
//					        null, new Object[] {"Si", "No"}, JOptionPane.YES_OPTION);
//					        if (n == JOptionPane.YES_OPTION) {
//					        	frame.dispose();
//					        } 
//			}
//		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Chat");
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 374, 197);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setBounds(323, 219, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mensaje=textField.getText();
				textArea.append(mensaje +"\n" );
				textArea.setCaretPosition(textArea.getText().length());
				textField.setText("");
				enviarMsg(mensaje);
			}
		});
	
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(KeyEvent.VK_ENTER== arg0.getKeyCode()){ 
				mensaje=textField.getText();
				textArea.append(mensaje+"\n" );
				textArea.setCaretPosition(textArea.getText().length());
				textField.setText("");
				enviarMsg(mensaje);
				 }
			}
		});
		
//		frame.setDefaultCloseOperation(frame.DO_NOTHING_ON_CLOSE);		
		textField.setBounds(10, 220, 285, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
