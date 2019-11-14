package Assignment8;

import java.util.ArrayList;
import java.util.Collection;

public class Students {

	Collection<Student> students = new ArrayList<Student>();

	public Collection<Student> getStudents() {
		return students;
	}

	public void addStudent(Student stdt) {
		students.add(stdt);
	}

	public int getNumberOfStudents() {
		return getStudents().size();
	}

}
