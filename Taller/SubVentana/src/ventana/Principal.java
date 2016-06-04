package ventana;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frame;
	private Principal principal;
	private JLabel etiqueta = new JLabel("");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
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
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		setVentanaPrincipal(this);
		frame.setTitle("Principal");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		etiqueta.setBounds(117, 55, 46, 14);
		frame.getContentPane().add(etiqueta);
		
		JButton btnIrA = new JButton("Ir a");
		btnIrA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Otro(principal);
			}
		});
		btnIrA.setBounds(117, 107, 89, 23);
		frame.getContentPane().add(btnIrA);
	}

	public void setVentanaPrincipal(Principal miVentana) {
		   principal=miVentana;
		}

	public void escribeEtiqueta(String text){
		etiqueta.setText(text);
	}
}
