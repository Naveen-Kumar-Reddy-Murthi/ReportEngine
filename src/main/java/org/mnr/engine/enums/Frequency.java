package org.mnr.engine.enums;

/**
 * @author naveen.reddy
 * @version 1.0
 */
public enum Frequency {

	DAILY("D"), WEEKLY("W"), MONTHLY("M"), YEARLY("Y");

	private String flag;

	Frequency(String flag) {
		this.flag = flag;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public static void main(String... args) {
		System.out.println(Frequency.DAILY.getFlag());
	}

}
