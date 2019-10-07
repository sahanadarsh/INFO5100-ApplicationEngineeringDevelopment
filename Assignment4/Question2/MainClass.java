package Assignment4;

public class MainClass {

	public static void main(String[] args) {

		PsychiatristObject psych = new PsychiatristObject();
		MoodyObject happy = new HappyObject();
		MoodyObject sad = new SadObject();

		psych.examine(happy);
		System.out.println();
		psych.observe(happy);
		System.out.println();
		psych.examine(sad);
		System.out.println();
		psych.observe(sad);
		System.out.println();
	}
}
