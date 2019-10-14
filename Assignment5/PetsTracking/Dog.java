package PetsTracking;

import java.util.Date;

public class Dog extends Pet implements Boardable {

	private String size;
	private Date boardStartDate;
	private Date boardEndDate;

	public Dog(String petName, String ownerName, String color, String size) {
		super(petName, ownerName, color);
		this.size = size;
	}

	public String getSize() {
		return size;
	}

	public String toString() {
		StringBuilder sb =new StringBuilder();
		sb.append("DOG: " + "\n");
		//		sb.append(getPetName() + " owned by " + getOwnerName() + "\n");
		//		sb.append("Color: " + getColor() + "\n");
		//		sb.append("Sex: " + getSex() + "\n");
		sb.append(super.toString() + "\n");
		sb.append("Size: " + getSize());
		return sb.toString();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setBoardStart(int month, int day, int year) {
		Date s = new Date(month, day, year);
		boardStartDate = s;

	}

	@SuppressWarnings("deprecation")
	@Override
	public void setBoardEnd(int month, int day, int year) {
		Date e = new Date(month, day, year);
		boardEndDate = e;

	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean boarding(int month, int day, int year) {
		Date boardingDate = new Date(month, day, year);
		if( boardStartDate != null && boardEndDate != null ) {
			if( (boardingDate.after(boardStartDate) && boardingDate.before(boardEndDate)) || boardingDate.equals(boardStartDate) || boardingDate.equals(boardEndDate) ) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Dog d = new Dog("Spot", "Susan","White","medium");
		d.setSex(3);
		System.out.println(d.toString());
		d.setBoardStart(01, 01, 2019);
		d.setBoardEnd(03, 30, 2019);
		//System.out.println("Given data is between or equal to the start and end dates: " + d.boarding(01,15,2019));
	}

}
