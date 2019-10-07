package Assignment4;

public class PsychiatristObject{

	public void examine(MoodyObject moodyobject) {
		System.out.println("How are you feeling today?");
		moodyobject.queryMood();
	}

	public void observe(MoodyObject moodyobject) {
		moodyobject.expressFeelings();
		System.out.println("Observation: " + moodyobject.toString());
	}
}
