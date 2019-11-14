import java.util.ArrayList;

public class Assessor {
	public int getVerdict(age, weight, height, bpSyst, bpDias, cancer, diabetes,
	 alzheimers) {
		if () {
			
		} else if () {
			
		} else if () {
			
		} else {
			
		}
	}
	
	public memberScore memberScore(Member mem) {
		int age = mem.getage(); //single person
		int height = mem.getheight();
		int weight = mem.getweight();
		int bpSyst = mem.getbpsys();
		int bpDias = mem.getbpdias();
		String cancer = mem.getcancer();
		String diabetes = mem.getdiabetes();
		String alzheimers = mem.getalzheimers();
	}
	public ArrayList<InsuranceScore> memberScore(ArrayList<Member> membs) {
		ArrayList<InsuranceScore> scores = new ArrayList<InsuranceScore> ();
		for (Member memb : membs) {   // all the people
			scores.add(memberScore(memb));
		}
		return scores;
	} 


}
