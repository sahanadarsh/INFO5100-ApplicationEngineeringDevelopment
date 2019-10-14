package PetsTracking;

public class Pet {

	private String petName;
	private String ownerName;
	private String color;
	protected Integer sex;
	public static final int MALE = 1;
	public static final int FEMALE = 2;
	public static final int SPAYED = 3;
	public static final int NEUTERED = 4;


	public Pet(String petName, String ownerName, String color) {
		this.petName = petName;
		this.ownerName = ownerName;
		this.color = color;
	}

	public String getPetName() {
		return petName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public String getColor() {
		return color;
	}

	public void setSex(int sexid) {
		this.sex = sexid;
	}

	public String getSex() {
		if(this.sex == MALE ) {
			return "Male";
		} else if(this.sex == FEMALE ) {
			return "Female";
		} else if(this.sex == SPAYED ) {
			return "Spayed";
		} else if(this.sex == NEUTERED ) {
			return "Neutered";
		}else {
			return "Invalid input";
		}
	}

	public String toString() {
		StringBuilder s =new StringBuilder();
		s.append(getPetName() + " owned by " + getOwnerName() + "\n");
		s.append("Color: " + getColor() + "\n");
		s.append("Sex: " + getSex());
		return s.toString();
	}

	public static void main(String[] args) {
		Pet p = new Pet("Spot", "Mary", "Black and White");
		p.setSex(1);
		System.out.println(p.toString());
	}

}
