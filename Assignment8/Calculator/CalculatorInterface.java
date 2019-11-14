package Assignment8;

/*Design and develop a calculator interface.
You can follow the design given by professor or have your own design.
Please upload the screenshot of the running interface.*/

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CalculatorInterface extends JFrame {

	private JTextField textField;
	private double firstNumber = 0;
	private double res = 0;
	StringBuilder sb = new StringBuilder();
	Operations opr;
	private JButton add, subtract, multiply, divide, calculate, clear, dot;
	private JButton[] number;
	boolean firstNumFlag = false;
	boolean computeFlag = false;
	private Font font;

	public CalculatorInterface() {
		setTitle("Calculator");
		createComponents();
		setLayout();
		addComponents();
		addNumBehavior();
		addDotBehavior();
		addOperationBehavior();
		addCalculateBehavior();
		addClearBehavior();
		display();
	}

	private void createComponents() {
		font = new Font("TimesRoman", Font.PLAIN, 30);

		textField = new JTextField(10);
		textField.setFont(font);

		add = new JButton("+");
		add.setBackground(Color.WHITE);
		add.setFont(font);
		subtract = new JButton("-");
		subtract.setBackground(Color.WHITE);
		subtract.setFont(font);
		multiply = new JButton("x");
		multiply.setBackground(Color.WHITE);
		multiply.setFont(font);
		divide = new JButton("/");
		divide.setBackground(Color.WHITE);
		divide.setFont(font);
		calculate = new JButton("=");
		calculate.setFont(font);
		clear = new JButton("C");
		clear.setFont(font);
		clear.setPreferredSize(new Dimension(210,45));
		dot = new JButton(".");
		dot.setFont(font);
		number = new JButton[10];
		for (int i = 0; i < 10; i++) {
			number[i] = new JButton(i + "");
			number[i].setFont(font);
		}
	}

	private void setLayout() {
		GridLayout gl = new GridLayout(6, 1);
		Container c = this.getContentPane();
		c.setLayout(gl);		
		c.setBackground(Color.darkGray);
	}

	private void addComponents() {
		Container c = getContentPane();
		c.add(textField);

		JPanel panel = new JPanel();
		panel.add(number[7]);
		panel.add(number[8]);
		panel.add(number[9]);
		panel.add(divide);
		panel.setBackground(Color.darkGray);
		c.add(panel);

		panel = new JPanel();
		panel.add(number[4]);
		panel.add(number[5]);
		panel.add(number[6]);
		panel.add(multiply);
		panel.setBackground(Color.darkGray);
		c.add(panel);

		panel = new JPanel();
		panel.add(number[3]);
		panel.add(number[2]);
		panel.add(number[1]);
		panel.add(subtract);
		panel.setBackground(Color.darkGray);
		c.add(panel);

		panel = new JPanel();
		panel.add(dot);
		panel.add(number[0]);
		panel.add(calculate);
		panel.add(add);
		panel.setBackground(Color.darkGray);
		c.add(panel);

		panel = new JPanel();
		panel.add(clear);
		panel.setBackground(Color.darkGray);
		c.add(panel);
	}


	private void addNumBehavior() { 	
		NumberListener nl = new NumberListener();
		for (int i = 0; i < 10; i++) {
			number[i].addActionListener(nl);
		}		
	}

	private void addOperationBehavior() {
		OperationsListener ol = new OperationsListener();
		add.addActionListener(ol);
		subtract.addActionListener(ol);
		multiply.addActionListener(ol);
		divide.addActionListener(ol);
	}

	private void addCalculateBehavior() {
		CalculateListener cl = new CalculateListener();
		calculate.addActionListener(cl);
	}

	private void addClearBehavior() {
		ClearListener cl = new ClearListener();
		clear.addActionListener(cl);
	}

	private void addDotBehavior() {
		DotListener dl = new DotListener();
		dot.addActionListener(dl);
	}

	private void display() {
		setSize(300, 450);
		setVisible(true);
	}

	class OperationsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!firstNumFlag) {
				if (sb.length() > 0) {
					firstNumber = Double.valueOf(sb.toString());
				}
				res = firstNumber;
				sb = new StringBuilder();
			} else {
				if (sb.length() > 0) {
					firstNumber = Double.valueOf(sb.toString());
					if (computeFlag) {
						firstNumber = res;
						sb = new StringBuilder();
						sb.append(String.valueOf(firstNumber));
					} else {
						if (opr == Operations.ADD && !computeFlag) {
							res = firstNumber + res;
							sb = new StringBuilder();
						}
						if (opr == Operations.SUBTRACT && !computeFlag) {
							res = res - firstNumber;
							sb = new StringBuilder();
						}
						if (opr == Operations.MULTIPLY && !computeFlag) {
							res = firstNumber * res;
							sb = new StringBuilder();
						}
						if (opr == Operations.DIVIDE && !computeFlag) {
							res = res / firstNumber;
							sb = new StringBuilder();
						}
					}
				}
			}

			if (e.getSource() == add) {
				opr = Operations.ADD;
			}
			if (e.getSource() == subtract) {
				opr = Operations.SUBTRACT;
			}
			if (e.getSource() == multiply) {
				opr = Operations.MULTIPLY;
			}
			if (e.getSource() == divide) {
				opr = Operations.DIVIDE;
			}

			firstNumFlag = true;
			textField.setText(String.valueOf(res));
		}
	}

	class CalculateListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if (sb.length() > 0) {
				firstNumber = Double.valueOf(sb.toString());
				if (opr == Operations.ADD) {
					res = firstNumber + res;
				}
				if (opr == Operations.SUBTRACT) {
					res = res - firstNumber;
				}
				if (opr == Operations.MULTIPLY) {
					res = firstNumber * res;
				}
				if (opr == Operations.DIVIDE) {
					res = res / firstNumber;
				}
			}
			if (!firstNumFlag) {
				textField.setText(Double.valueOf(sb.toString()) + "");				
			} else {
				textField.setText(res + "");
			}
			computeFlag = true;
		}

	}

	class DotListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			sb.append(".");	
			textField.setText(sb.toString());
			computeFlag = false;
		}
	}

	class NumberListener implements ActionListener {	
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String num = e.getActionCommand();
			sb.append(num.charAt(0));
			textField.setText(sb.toString());
			computeFlag = false;
		}
	}

	class ClearListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == clear) {
				textField.setText("");
				firstNumber = 0;
				res = 0;
				sb = new StringBuilder();
				firstNumFlag = false;
			}
		}
	}

	public static void main(String[] args) {
		CalculatorInterface calculator = new CalculatorInterface();
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}