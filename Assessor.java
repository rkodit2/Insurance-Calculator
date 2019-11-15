import java.util.ArrayList;

public class Assessor {
    public static int getVerdict(int age, double BMI, int bpSyst, int bpDias, String cancer, String diabetes,
                          String alzheimers) {
        int total = 0;
        if (age < 30 ) {
            total = total + 0;
        } else if (age < 45) {
            total = total + 10;
        } else if (age < 60) {
            total = total + 20;
        } else if (age > 60) {
            total = total + 30;
        } else if (18.5 <= BMI && BMI <= 24.9) {
            total = total + 0;
        } else if (25.0 <= BMI && BMI <= 29.9) {
            total = total + 30;
        } else if (30.0 <= BMI && BMI <= 34.9) {
            total = total + 75;
        } else if (120 > bpSyst && 80 > bpDias) {
            total = total + 0;
        } else if (120 <= bpSyst && bpSyst <= 129 && 80 > bpDias) {
            total = total + 15;
        } else if (130 <= bpSyst && bpSyst <= 139 || 80 <= bpDias && bpDias <= 89 ) {
            total = total + 30;
        } else if (bpSyst >= 140 || bpDias >=90) {
            total = total + 75;
        } else if (bpSyst > 180 && bpDias > 120) {
            total = total + 100;
        } else if (bpSyst > 180 || bpDias > 120) {
            total = total + 100;
        } else if (diabetes == "y") {
            total = total + 10;
        } else if (cancer == "y") {
            total = total + 10;
        } else if (alzheimers == "y") {
            total = total + 10;
        }
        return total;
    }

    public static String getRisk(int total) {
        if (total <= 20 ) {
            return "low risk";
        } else if (total <= 50 ) {
            return "moderate risk";
        } else if (total <= 75) {
            return "high risk";
        } else {
            return "uninsurable";
        }
    }

    public static double calcBMI(int weight, int height) {
        double BMI = (weight/height)*(weight/height);
        return BMI;

    }

    public static InsuranceScore memberScore(Member mem) {
        String firstname = mem.getFirstName();
        String lastname = mem.getLastName();
        int age = mem.getage(); //single person
        int height = mem.getheight();
        int weight = mem.getweight();
        int bpSyst = mem.getbpSyst();
        int bpDias = mem.getbpDias();
        String cancer = mem.getcancer();
        String diabetes = mem.getdiabetes();
        String alzheimers = mem.getalzheimers();

        double BMI = calcBMI(weight, height);
        int points = getVerdict(age, BMI, bpSyst, bpDias, cancer, diabetes, alzheimers);
        InsuranceScore score = new InsuranceScore(lastname, firstname, points, getRisk(points));
        return score;

    }
    public static ArrayList<InsuranceScore> memberScore(ArrayList<Member> membs) {
        ArrayList<InsuranceScore> scores = new ArrayList<InsuranceScore> ();
        for (Member memb : membs) {   // all the people
            scores.add(memberScore(memb));
        }
        return scores;
    }


}