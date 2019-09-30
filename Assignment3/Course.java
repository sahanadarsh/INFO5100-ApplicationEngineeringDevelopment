package Assignment3;

import java.util.Arrays;
import java.util.HashSet;

public class Course {
	private int courseId;
	private String courseName;
	private int maxCapacity;
	private int professorId;
	private double credits;
	private int[] studentIds;
	private int currentStudReg = 0;

	Course(int courseId){
		this.courseId = courseId;
	}
	Course(int courseId, int professorId){
		this.courseId = courseId;
		this.professorId = professorId;
	}

	Course(int courseId, int professorId, double credits){
		this.courseId = courseId;
		this.professorId = professorId;
		this.credits = credits;
	}
	public Course(int courseId, String courseName, int maxCapacity, int professorId, double credits, int[] studentIds) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.maxCapacity = maxCapacity;
		this.professorId = professorId;
		this.credits = credits;
		this.studentIds = studentIds;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {

		//courseId - should not be negative or 0
		if(courseId < 1) {
			throw new IllegalArgumentException("courseId should not be negative or 0");
		}
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {

		//courseName- should be a string with minimum length 10 and maximum 60
		if(courseName.length() < 10 || courseName.length() > 60) {
			throw new IllegalArgumentException("courseName should be a string with minimum length 10 and maximum 60");
		}
		this.courseName = courseName;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {

		//maxCapacity - should not be less than 10 greater than 100
		if(maxCapacity < 10 || maxCapacity > 100) {
			throw new IllegalArgumentException("maxCapacity should not be less than 10 greater than 100");
		}
		this.maxCapacity = maxCapacity;
		this.studentIds = new int[maxCapacity];
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		//professorId - should be a six digit integer
		int count = 0;
		if(professorId > 0) {
			int tempProfessorId = professorId;

			while(tempProfessorId != 0) {
				tempProfessorId = tempProfessorId/10;
				count++;
			}

			if(count == 6) {
				this.professorId = professorId;
			}else {
				throw new IllegalArgumentException("professorId should be a six digit integer");
			}
		}else {
			throw new IllegalArgumentException("professorId should be greater than 0");
		}

	}

	public double getCredits() {
		return credits;
	}

	public void setCredits(double credits) {

		//credits - should be a single digit but greater than 0
		if(credits > 0 && credits < 10) {
			this.credits = credits;
		}else {
			throw new IllegalArgumentException("credits should be a single digit but greater than 0");
		}
	}

	public int[] getStudentIds() {
		return studentIds;
	}

	public void setStudentIds(int[] studentIds) {
		this.studentIds = studentIds;
	}

	//registerStudent method should store all ids in studentIds array.
	public void registerStudent(int studentId) {
		if(this.currentStudReg < this.maxCapacity) {
			this.studentIds[this.currentStudReg] = studentId;
			this.currentStudReg++;
		} else {
			int[] newStudentIds = removeDuplicates(this.studentIds);
			if(newStudentIds.length == this.maxCapacity) {
				System.out.println("Maximum course capacity reached. Registration failed");	
			} else {
				this.currentStudReg = newStudentIds.length;
				this.studentIds[this.currentStudReg] = studentId;
				this.currentStudReg++;
			}
		}
	}

	public int[] removeDuplicates(int[] studentIds) {
		HashSet<Integer> studIdSet = new HashSet<Integer>();
		int idx = 0;
		for(int i = 0; i < studentIds.length; i++) {
			if (studIdSet.add(studentIds[i])) {
				studentIds[idx] = studentIds[i];
				idx++;
			}
		}
		return Arrays.copyOf(studentIds,idx);
	}

	public int groupsOfStudents(int[] studentIds) {
		//removing duplicate studentIds, then computing even sum pair count
		int[] stdNoDupl = removeDuplicates(studentIds);
		int count = 0;
		for(int i = 0; i < stdNoDupl.length; i++) {
			for(int j = i; j < stdNoDupl.length; j++) {
				if((stdNoDupl[i] + stdNoDupl[j]) % 2 == 0 ) {
					if( i != j) {
						count++;
					}
				}
			}
		}
		return count;
	}


	public static void main(String[] args) {
		Course c1 = new Course(1);
		Course c2 = new Course(2,123456);
		Course c3 = new Course(3,507698,3.5);
		int[] studentIds = {1,1,2,3,4,5,6};
		c1.setCourseId(4);
		c2.setCourseName("application");
		c3.setCredits(4.0);
		c1.setProfessorId(567234);
		c1.setMaxCapacity(20);
		c1.registerStudent(5);
		c2.groupsOfStudents(studentIds);
		c3.removeDuplicates(studentIds);
	}
}