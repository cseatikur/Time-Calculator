import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.util.concurrent.TimeUnit;


public class Calculator {

	private JFrame frmTimeCalculator;
	private JComboBox comboBox2;
	private JTextField textField1;
	private JTextField textField2;
	private JButton convertButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frmTimeCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frmTimeCalculator = new JFrame();
		frmTimeCalculator.setBackground(Color.WHITE);
		frmTimeCalculator.setTitle("Time Calculator");
		frmTimeCalculator.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\pc\\8. eclipse\\TimeCalculator\\Calculator-icon.png"));
		frmTimeCalculator.getContentPane().setBackground(new Color(51, 102, 102));
		frmTimeCalculator.setBounds(100, 100, 391, 526);
		frmTimeCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTimeCalculator.getContentPane().setLayout(null);
		
		JComboBox comboBox1 = new JComboBox();
		comboBox1.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox1.setBounds(12, 8, 149, 35);
		frmTimeCalculator.getContentPane().add(comboBox1);
		
		comboBox1.addItem("Milliseconds");
		comboBox1.addItem("Seconds");
		comboBox1.addItem("Minutes");
		comboBox1.addItem("Hours");
		comboBox1.addItem("Days");
		comboBox1.addItem("Weeks");
		comboBox1.addItem("Years");
		
		comboBox2 = new JComboBox();
		comboBox2.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox2.setBounds(12, 104, 149, 38);
		frmTimeCalculator.getContentPane().add(comboBox2);
		
		comboBox2.addItem("Milliseconds");
		comboBox2.addItem("Seconds");
		comboBox2.addItem("Minutes");
		comboBox2.addItem("Hours");
		comboBox2.addItem("Days");
		comboBox2.addItem("Weeks");
		comboBox2.addItem("Years");
		
		textField1 = new JTextField();
		textField1.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField1.setBounds(12, 56, 349, 35);
		frmTimeCalculator.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField2.setColumns(10);
		textField2.setEditable(false);
		textField2.setBounds(12, 155, 349, 38);
		frmTimeCalculator.getContentPane().add(textField2);
		
		convertButton = new JButton("Convert");
		convertButton.setForeground(Color.WHITE);
		convertButton.setBackground(new Color(51, 51, 51));
		convertButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertTime();
			}

			private void convertTime() {
		        try {
		            double inputTime = Double.parseDouble(textField1.getText());
		            String fromUnit = (String) comboBox1.getSelectedItem();
		            String toUnit = (String) comboBox2.getSelectedItem();
		            double convertedTime;

		            // Convert to Days as an intermediate step
		            double Days;

		            switch (fromUnit) {
		                
		                case "Milliseconds":
		                	Days = inputTime/ (1000*60*60*24);
		                    break;
		                case "Seconds":
		                	Days = inputTime/ (60*60*24);
		                    break;
		                case "Minutes":
		                	Days = inputTime/ (60*24);
		                    break;
		                
		                case "Hours":
		                	Days = inputTime/24;
		                    break;
		                case "Days":
		                	Days = inputTime;
		                    break;
		                case "Weeks":
		                	Days = inputTime*7;
		                    break;
		                case "Years":
		                	Days = inputTime *365;
		                    break;
		                default:
		                	Days = 0;
		            }

		            // Convert Days to the target unit
		            switch (toUnit) {
		            
	                case "Milliseconds":
	                	convertedTime = Days * (1000*60*60*24);
	                    break;
	                case "Seconds":
	                	convertedTime = Days * (60*60*24);
	                    break;
	                case "Minutes":
	                	convertedTime = Days * (60*24);
	                    break;
	                
	                case "Hours":
	                	convertedTime = Days *24;
	                    break;
	                case "Days":
	                	convertedTime = Days;
	                    break;
	                case "Weeks":
	                	convertedTime = Days/7;
	                    break;
	                case "Years":
	                	convertedTime = Days / 365;
	                    break;
		                default:
		                	convertedTime = 0;
		            }

		            textField2.setText(String.valueOf(convertedTime));
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(frmTimeCalculator, "Please enter a valid number!");
		        }
		    }

		});
		convertButton.setBounds(245, 420, 116, 46);
		frmTimeCalculator.getContentPane().add(convertButton);
		
		JButton btn8 = new JButton("8");
		btn8.setForeground(Color.WHITE);
		btn8.setBackground(new Color(51, 51, 51));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number= textField1.getText()+btn8.getText();
				textField1.setText(number);
			}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn8.setBounds(129, 281, 116, 46);
		frmTimeCalculator.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setForeground(Color.WHITE);
		btn9.setBackground(new Color(51, 51, 51));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number= textField1.getText()+btn9.getText();
				textField1.setText(number);
			}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn9.setBounds(245, 281, 116, 46);
		frmTimeCalculator.getContentPane().add(btn9);
		
		JButton btn4 = new JButton("4");
		btn4.setForeground(Color.WHITE);
		btn4.setBackground(new Color(51, 51, 51));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number= textField1.getText()+btn4.getText();
				textField1.setText(number);
			}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn4.setBounds(12, 328, 116, 46);
		frmTimeCalculator.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setForeground(Color.WHITE);
		btn5.setBackground(new Color(51, 51, 51));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number= textField1.getText()+btn5.getText();
				textField1.setText(number);
			}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn5.setBounds(129, 328, 116, 46);
		frmTimeCalculator.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setForeground(Color.WHITE);
		btn6.setBackground(new Color(51, 51, 51));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number= textField1.getText()+btn6.getText();
				textField1.setText(number);
			}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn6.setBounds(245, 328, 116, 46);
		frmTimeCalculator.getContentPane().add(btn6);
		
		JButton btn1 = new JButton("1");
		btn1.setForeground(Color.WHITE);
		btn1.setBackground(new Color(51, 51, 51));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number= textField1.getText()+btn1.getText();
				textField1.setText(number);
			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn1.setBounds(12, 375, 116, 46);
		frmTimeCalculator.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setForeground(Color.WHITE);
		btn2.setBackground(new Color(51, 51, 51));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number= textField1.getText()+btn2.getText();
				textField1.setText(number);
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn2.setBounds(129, 375, 116, 46);
		frmTimeCalculator.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setForeground(Color.WHITE);
		btn3.setBackground(new Color(51, 51, 51));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number= textField1.getText()+btn3.getText();
				textField1.setText(number);
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn3.setBounds(245, 375, 116, 46);
		frmTimeCalculator.getContentPane().add(btn3);
		
		JButton btn0 = new JButton("0");
		btn0.setForeground(Color.WHITE);
		btn0.setBackground(new Color(51, 51, 51));
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number= textField1.getText()+btn0.getText();
				textField1.setText(number);
			}
		});
		btn0.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn0.setBounds(129, 420, 116, 46);
		frmTimeCalculator.getContentPane().add(btn0);
		
		JButton btnDot = new JButton(".");
		btnDot.setForeground(Color.WHITE);
		btnDot.setBackground(new Color(51, 51, 51));
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number= textField1.getText()+btnDot.getText();
				textField1.setText(number);
			}
		});
		btnDot.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDot.setBounds(12, 420, 116, 46);
		frmTimeCalculator.getContentPane().add(btnDot);
		
		JButton btnc = new JButton("CE");
		btnc.setForeground(Color.WHITE);
		btnc.setBackground(new Color(51, 51, 51));
		btnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField1.setText(null);
			}
		});
		btnc.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnc.setBounds(129, 234, 116, 46);
		frmTimeCalculator.getContentPane().add(btnc);
		
		JButton btnDel = new JButton("Del");
		btnDel.setForeground(Color.WHITE);
		btnDel.setBackground(new Color(51, 51, 51));
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String backSpace =null;
				if(textField1.getText().length()>0)
				{
					StringBuilder str= new StringBuilder(textField1.getText());
					str.deleteCharAt(textField1.getText().length()-1);
					backSpace= str.toString();
					textField1.setText(backSpace);
				}
			}
		});
		btnDel.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDel.setBounds(245, 234, 116, 46);
		frmTimeCalculator.getContentPane().add(btnDel);
		
		JButton btn7 = new JButton("7");
		btn7.setForeground(Color.WHITE);
		btn7.setBackground(new Color(51, 51, 51));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number= textField1.getText()+btn7.getText();
				textField1.setText(number);
			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn7.setBounds(12, 281, 116, 46);
		frmTimeCalculator.getContentPane().add(btn7);
		frmTimeCalculator.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frmTimeCalculator.getContentPane(), comboBox1, comboBox2, textField1, textField2, convertButton, btn8, btn9, btn4, btn5, btn6, btn1, btn2, btn3, btn0, btnDot, btnc, btnDel, btn7}));
		
	}
}
