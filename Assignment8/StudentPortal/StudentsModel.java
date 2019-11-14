package Assignment8;

import java.util.Collection;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

class StudentsModel implements TableModel {

	private Students students;

	public StudentsModel(Students students) {
		this.students = students;
	}

	@Override
	public int getRowCount() {
		return students.getNumberOfStudents();
	}

	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0) {
			return "ID";
		} else if(columnIndex == 1) {
			return "First Name";
		}else if(columnIndex == 2) {
			return "Second Name";
		} else if(columnIndex == 3){
			return "Age";
		} else if(columnIndex == 4) {
			return "Gender";
		} else if(columnIndex == 5){
			return "Email ID";
		} else if(columnIndex == 6){
			return "Phone Number";
		}else if(columnIndex == 7){
			return "Address";
		}
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Collection<Student> s = students.getStudents();
		int row = -1;
		for (Student student : s) {
			row++;
			if (row == rowIndex) {
				if (columnIndex == 0) {
					return student.getId() ;
				}
				if (columnIndex == 1) {
					return student.getFirstName();
				}
				if (columnIndex == 2) {
					return student.getSecondName();
				}
				if (columnIndex == 3) {
					return student.getAge();
				}
				if (columnIndex == 4) {
					return student.getGender();
				}
				if (columnIndex == 5) {
					return student.getEmailId();
				}
				if (columnIndex == 6) {
					return student.getPhoneNumber();
				}
				if (columnIndex == 7) {
					return student.getAddress();
				}
			}
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

}
