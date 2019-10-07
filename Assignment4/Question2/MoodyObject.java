package Assignment4;

public abstract class MoodyObject {

	protected abstract String getMood() ;

	protected abstract void expressFeelings();

	public void queryMood() {
       System.out.println(getMood());
	}
}
