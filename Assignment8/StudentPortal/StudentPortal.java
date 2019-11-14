package Assignment8;

/*Design and develop a student information system interface.

Your interface should contain the following features:
Add a new student into the system with basic information e.g. ID, name, gender, etc.
View all the student information in a table.
Please apply MVC model
Please upload the screenshot of the running interface.*/

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

@SuppressWarnings("serial")
public class StudentPortal extends JFrame{

	private JTextField firstNameTextField, secondNameTextField, idTextField, emailIdTextField, ageTextField, addressTextField, phoneNumberTextField;
	private JButton add;
	@SuppressWarnings("rawtypes")
	private JComboBox genderOptions;
	private JTable studentsTable;
	Students studentObj;
	private JLabel ID, firstName, secondName, age, gender, emilId, phoneNumber, address; 

	public StudentPortal(Students students) {
		studentObj = students;
		setTitle("Student Portal");
		createComponents();
		setLayout();
		addComponents();
		addStudentsModel();
		addBehaviours();
		display();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void createComponents() {
		Font font = new Font("TimesRoman", Font.BOLD, 20);

		idTextField = new JTextField(10);
		idTextField.setFont(font);

		firstNameTextField = new JTextField(15);
		firstNameTextField.setFont(font);

		secondNameTextField = new JTextField(15);
		secondNameTextField.setFont(font);

		ageTextField = new JTextField(5);
		ageTextField.setFont(font);

		genderOptions = new JComboBox(new String[] { "MALE", "FEMALE", "OTHERS"});

		emailIdTextField = new JTextField(20);
		emailIdTextField.setFont(font);

		phoneNumberTextField = new JTextField(10);
		phoneNumberTextField.setFont(font);

		addressTextField = new JTextField(20);
		addressTextField.setFont(font);

		add = new JButton("ADD STUDENT");
		add.setFont(font);
		add.setBackground(Color.CYAN);

		ID = new JLabel("Student ID");
		ID.setFont(font);
		ID.setForeground(Color.BLUE);

		firstName = new JLabel("First Name");
		firstName.setFont(font);
		firstName.setForeground(Color.BLUE);

		secondName = new JLabel("Second Name");
		secondName.setFont(font);
		secondName.setForeground(Color.BLUE);

		age = new JLabel("Age");
		age.setFont(font);
		age.setForeground(Color.BLUE);

		gender = new JLabel("Gender");
		gender.setFont(font);
		gender.setForeground(Color.BLUE);

		emilId = new JLabel("Email ID");
		emilId.setFont(font);
		emilId.setForeground(Color.BLUE);

		phoneNumber = new JLabel("Phone Number");
		phoneNumber.setFont(font);
		phoneNumber.setForeground(Color.BLUE);

		address = new JLabel("Address");
		address.setFont(font);
		address.setForeground(Color.BLUE);

	}

	private void setLayout() {
		Container c = this.getContentPane();
		BoxLayout gl = new BoxLayout(c,BoxLayout.Y_AXIS);
		c.setLayout(gl);	
		c.setBackground(Color.WHITE);
	}

	private void addComponents() {
		Container container = getContentPane();

		JPanel panel = new JPanel();
		panel.add(ID);
		panel.add(idTextField);
		container.add(panel);

		panel = new JPanel();
		panel.add(firstName);
		panel.add(firstNameTextField);
		panel.add(secondName);
		panel.add(secondNameTextField);
		container.add(panel);

		panel = new JPanel();
		panel.add(age);
		panel.add(ageTextField);
		container.add(panel);

		panel = new JPanel();
		panel.add(gender);
		panel.add(genderOptions);
		container.add(panel);

		panel = new JPanel();
		panel.add(emilId);
		panel.add(emailIdTextField);
		container.add(panel);

		panel = new JPanel();
		panel.add(phoneNumber);
		panel.add(phoneNumberTextField);
		container.add(panel);

		panel = new JPanel();
		panel.add(address);
		panel.add(addressTextField);
		container.add(panel);

		panel = new JPanel();
		panel.add(add);		
		container.add(panel);

	}

	private TableColumn tColumn;
	private void addStudentsModel(){
		StudentsModel model = new StudentsModel(studentObj);
		studentsTable = new JTable(model);
		JTableHeader header = studentsTable.getTableHeader();
		header.setBackground(Color.YELLOW);
		for(int i = 0; i < studentsTable.getColumnCount(); i++) {
			tColumn = studentsTable.getColumnModel().getColumn(i);
			tColumn.setCellRenderer(new ColumnColorRenderer(Color.lightGray, Color.BLACK));
		}
		JScrollPane scrollPane = new JScrollPane(studentsTable);
		Container container = getContentPane();
		container.add(scrollPane);
		setVisible(true);
	}

	class ColumnColorRenderer extends DefaultTableCellRenderer {
		Color backgroundColor, foregroundColor;
		public ColumnColorRenderer(Color backgroundColor, Color foregroundColor) {
			super();
			this.backgroundColor = backgroundColor;
			this.foregroundColor = foregroundColor;
		}
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,   boolean hasFocus, int row, int column) {
			Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			cell.setBackground(backgroundColor);
			cell.setForeground(foregroundColor);
			return cell;
		}
	}

	private void addBehaviours() {
		addListener addlsnr = new addListener();
		add.addActionListener(addlsnr);	
	}

	private void display() {
		setSize(900,700);
		setVisible(true);		
	}


	class addListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String gender = null;
			if(e.getSource() == add) {
				if(genderOptions.getSelectedItem().toString() == "MALE") {
					gender = "Male";
				}else if(genderOptions.getSelectedItem().toString() == "FEMALE") {
					gender = "Female";
				} else if(genderOptions.getSelectedItem().toString() == "OTHERS") {
					gender = "Others";
				}
				Student s = new Student(idTextField.getText(), firstNameTextField.getText(), secondNameTextField.getText(), ageTextField.getText(), gender, emailIdTextField.getText(), phoneNumberTextField.getText(), addressTextField.getText());
				studentObj.addStudent(s);
				studentsTable.updateUI();
			}	
			clearAllFields();
		}
	}

	private void clearAllFields() {
		idTextField.setText("");
		firstNameTextField.setText("");
		secondNameTextField.setText("");
		ageTextField.setText("");
		emailIdTextField.setText("");
		phoneNumberTextField.setText("");
		addressTextField.setText("");
	}

	public static void main(String[] args) {
		Students stds = new Students();
		StudentPortal sp = new StudentPortal(stds);
		sp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
