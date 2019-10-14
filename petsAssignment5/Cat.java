package petsAssignment5;

import java.util.Date;

public class Cat extends Pet implements Boardable {

	private String hairLength;
	private Date boardStartDate;
	private Date boardEndDate;

	public Cat(String petName, String ownerName, String color, String hairLength) {
		super(petName, ownerName, color);
		this.hairLength = hairLength;
	}

	public String getHairLength() {
		return hairLength;
	}

	public String toString() {
		StringBuilder sb =new StringBuilder();
		sb.append("CAT: "+ "\n");
		//		sb.append(getPetName() + " owned by " + getOwnerName() + "\n");
		//		sb.append("Color: " + getColor() + "\n");
		//		sb.append("Sex: " + getSex() + "\n");
		sb.append(super.toString() + "\n");
		sb.append("Hair: " + getHairLength());
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
		Cat c = new Cat("Tom", "Bob","black","short");
		c.setSex(3);
		System.out.println(c.toString());
		c.setBoardStart(01, 01, 2019);
		c.setBoardEnd(03, 30, 2019);
		//System.out.println("Given data is between or equal to the start and end dates: " + c.boarding(03, 30, 2019));
	}

}
