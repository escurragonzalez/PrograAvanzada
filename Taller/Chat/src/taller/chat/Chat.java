package taller.chat;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Chat{

	private JFrame frame;
	private JTextField textField;
	
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
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				 int n = JOptionPane.showOptionDialog(new JFrame(), "Esta seguro de querer salir", 
					        "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
					        null, new Object[] {"Si", "No"}, JOptionPane.YES_OPTION);
					        if (n == JOptionPane.YES_OPTION) {
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
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setBounds(323, 219, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append(textField.getText()+"\n" );
				textArea.setCaretPosition(textArea.getText().length());
				textField.setText("");
			}
		});
	
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(KeyEvent.VK_ENTER== arg0.getKeyCode()){ 
				textArea.append(textField.getText()+"\n" );
				textArea.setCaretPosition(textArea.getText().length());
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
