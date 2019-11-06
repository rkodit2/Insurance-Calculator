
public class Member {
private String lastName;
private String firstName;
private int age;
private int height;
private int weight;
private int bpSyst;
private int bpDias;
private String cancer;
private String diabetes;
private String alzheimers;

public String lastName() {
	return lastName;
}
public String firstName() {
	return firstName;
}
public int age() {
	return age;
}
public int height() {
	return height;
}
public int weight() {
	return weight;
}
public int bySyst() {
	return bpSyst;
}
public int bpDias() {
	return bpDias;
}
public String cancer() {
	return cancer;
}
public String diabetes() {
	return diabetes;
}
public String alzheimers() {
	return alzheimers;
}

public Member(String lastName, String firstName, int age, int height,
		int weight, int bpSyst, int bpDias, String cancer,
		String diabetes, String alzheimers) {
	this.lastName = lastName;
	this.firstName = firstName;
	this.age = age;
	this.height = height;
	this.weight = weight;
	this.bpSyst = bpSyst;
	this.bpDias = bpDias;
	this.cancer = cancer;
	this.diabetes = diabetes;
	this.alzheimers = alzheimers;
}

public String toString() {
	String member = lastName + ", " + firstName + "/nAge	" + age +
			"/nHeight	" + height + " in" + "/nWeight	" + weight + " lbs"
			+ "/nBP Syst	" + bpSyst + "/nBP Dias		" + bpDias +
			"/nCancer	" + cancer + "/nDiabetes	" + diabetes + 
			"/nAlzheimers	" + alzheimers + "-----------------------";
	return member;
}
}
