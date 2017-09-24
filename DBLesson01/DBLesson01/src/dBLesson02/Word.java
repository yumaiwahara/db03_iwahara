package dBLesson02;

public class Word{
	private String english;
	private String japanese;

	public Word(String english, String japanese) {
		super();
		this.english = english;
		this.japanese = japanese;
	}

	public String toString() {
		return "英単語:" + this.english + " 日本語：" + this.japanese;
	}

	/**
	 * @return english
	 */
	public String getEnglish() {
		return english;
	}

	/**
	 * @param english セットする english
	 */
	public void setEnglish(String english) {
		this.english = english;
	}

	/**
	 * @return japanese
	 */
	public String getJapanese() {
		return japanese;
	}

	/**
	 * @param japanese セットする japanese
	 */
	public void setJapanese(String japanese) {
		this.japanese = japanese;
	}
}