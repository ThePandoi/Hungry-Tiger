package hungry_tiger_;

public class Review {
	private String rev;
	private double val;
	public Review(String rev, double val) {
		this.rev = rev;
		this.val = val;
	}
	public String get_rev(){
		return rev;
	}
	public double get_val() {
		return val;
	}
}
