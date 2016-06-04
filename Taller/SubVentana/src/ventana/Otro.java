package ventana;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Otro {

	private JFrame frame;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Otro window = new Otro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Otro() {
		initialize();
	}

	public Otro(Principal principal) {
		frame = new JFrame();
		frame.setTitle("Secundario");
		frame.setBounds(50, 50, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		JButton btnSalir = new JButton("Volver");		
		btnSalir.setBounds(100, 150, 90, 20);
		frame.getContentPane().add(btnSalir);

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				volver();
			}

			private void volver() {
				// TODO Auto-generated method stub
				principal.escribeEtiqueta(textField.getText());
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnSalir);
		textField = new JTextField();
		textField.setBounds(100, 100, 90, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(KeyEvent.VK_ENTER==arg0.getKeyCode()){
					principal.escribeEtiqueta(textField.getText());
					frame.dispose();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 50, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	}
}
