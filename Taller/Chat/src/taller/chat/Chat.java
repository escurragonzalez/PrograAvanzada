package taller.chat;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Chat{

	private JFrame frame;
	private JTextField textField;
	private Socket cliente;
    private JTextArea textArea;
	private String mensaje;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat window = new Chat(5000,"localhost");
					window.escribe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void escribe() throws IOException, NullPointerException {
		InetAddress address = InetAddress.getLocalHost();
		String ip = address.getHostAddress();
//		InputStreamReader leer = new InputStreamReader(msj);
//		BufferedReader buffer = new BufferedReader(leer);
		String texto = this.mensaje;
		textArea.append(texto + "\n");
//		while(!texto.equals("Salir")) {
		new DataOutputStream(cliente.getOutputStream()).writeUTF(ip + ": " + texto);
//		}
		cliente.close();
	}

	/**
	 * Create the application.
	 */
	public Chat(int puerto,String ip) {
		initialize(puerto,ip);
		this.mensaje="";
	}

	/**
	 * Initialize the contents of the frame.
	 * @return 
	 */		
    
	private void initialize(int puerto,String ip) {
		try{
			
			cliente = new Socket(ip, puerto);
			new ClienteHilo(cliente).start();
		}catch(Exception e){
			e.printStackTrace();
		}

		
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				 int n = JOptionPane.showOptionDialog(new JFrame(), "Esta seguro de querer salir", 
					        "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
					        null, new Object[] {"Si", "No"}, JOptionPane.YES_OPTION);
					        if (n == JOptionPane.YES_OPTION) {					        	
					        	mensaje="salir";
					        	frame.dispose();					        	
					        } 
			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Chat");
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 374, 197);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setBounds(323, 219, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mensaje=textField.getText();
				textField.setText("");
				}
		});
	
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(KeyEvent.VK_ENTER== arg0.getKeyCode()){ 
				mensaje=textField.getText();
				textField.setText("");
				}
			}
		});
		
		frame.setDefaultCloseOperation(frame.DO_NOTHING_ON_CLOSE);		
		textField.setBounds(10, 220, 285, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
