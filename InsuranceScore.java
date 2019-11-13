public class InsuranceScore {
	private String lastName;
	private String firstName;
	private int score;
	private String verdict;
	
	public String getLastName() {
		return lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public int getScore() {
		return score;
	}
	public String getVerdict() {
		return verdict;
	}
	public InsuranceScore(String lastName, String firstName, int score,
			String verdict) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.score = score;
		this.verdict = verdict;
	}
	public String toString() {
		String assessment = "Here are the insurance assessments\n" +
				"Name:			"+ lastName + ", " + firstName +
				"\nScore:			" + score + "\nVerdict:			"
				+ verdict;
		return assessment;
		
				
	}

}
