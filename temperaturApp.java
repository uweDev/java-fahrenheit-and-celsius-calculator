package temperaturApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JProgressBar;

public class temperaturApp extends JFrame {

	private JPanel contentPane;
	private JTextField fahrenheit;
	private JTextField celsius;
	private JButton btnConvert;
	private JLabel formel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					temperaturApp frame = new temperaturApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public temperaturApp() {
		setTitle("Fahrenheit Celsius Rechner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 277);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel fahrenheitLabel = new JLabel("Grad Fahrenheit:");
		fahrenheitLabel.setBounds(10, 11, 113, 19);
		contentPane.add(fahrenheitLabel);
		
		fahrenheit = new JTextField();
		fahrenheit.setBounds(10, 29, 188, 32);
		contentPane.add(fahrenheit);
		fahrenheit.setColumns(10);
		
		JLabel celsiusLabel = new JLabel("Grad Celsius:");
		celsiusLabel.setBounds(10, 90, 188, 19);
		contentPane.add(celsiusLabel);
		
		celsius = new JTextField();
		celsius.setBounds(10, 108, 188, 32);
		contentPane.add(celsius);
		celsius.setColumns(10);
		
		btnConvert = new JButton("Umrechnen");
		btnConvert.setForeground(Color.WHITE);
		btnConvert.setBackground(new Color(0, 102, 153));
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!fahrenheit.getText().equals("")){
					double fahrenheitResult, celsiusResult;
					fahrenheitResult = Double.parseDouble(fahrenheit.getText());
					celsiusResult = (fahrenheitResult - 32) * 5 / 9;
					celsius.setText(String.valueOf(celsiusResult));
					formel.setText(("Formel: (" + fahrenheitResult + "\u00B0" + "F-32)+5/9=" + celsiusResult + "\u00B0" + "C"));
				}
				else if (!celsius.getText().equals("")){
					double fahrenheitResult, celsiusResult;
					celsiusResult = Double.parseDouble(celsius.getText());
					fahrenheitResult = (celsiusResult * 9 / 5) + 32;
					fahrenheit.setText(String.valueOf(fahrenheitResult));
					formel.setText(("Formel: (" + celsiusResult + "\u00B0" + "C*9/5)+32=" + fahrenheitResult + "\u00B0" + "F"));
				}
				else {
					JOptionPane.showMessageDialog(
					null, "Bitte geben Sie einen Wert an!");
				}
			}
		});
		btnConvert.setBounds(236, 200, 188, 32);
		contentPane.add(btnConvert);
		
		formel = new JLabel("");
		formel.setBounds(10, 200, 216, 32);
		contentPane.add(formel);
		
		JButton btnEmpty = new JButton("Textfelder leeren");
		btnEmpty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fahrenheit.setText("");
				celsius.setText("");
			}
		});
		btnEmpty.setForeground(Color.WHITE);
		btnEmpty.setBackground(new Color(0, 153, 204));
		btnEmpty.setBounds(236, 157, 188, 32);
		contentPane.add(btnEmpty);
	}
}
