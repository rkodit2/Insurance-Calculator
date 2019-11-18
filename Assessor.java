
    public static int getPointsAge(int age) {
        int agePoints = 0;
        if (age < 30 ) {
            agePoints = 0;
        } else if (age < 45) {
        	agePoints = 10;
        } else if (age < 60) {
        	agePoints = 20;
        } else if (age > 60) {
        	agePoints = 30;
        } 
        return agePoints;
    }
  
    public static int getPointsBMI(double BMI) {
    	int bmiPoints = 0;
    	if ((BMI >= 18.5) && (BMI <= 24.9)) {
            bmiPoints = 0;
        } else if ((BMI >= 25.0) && (BMI <= 29.9)) {
        	bmiPoints = 30;
        } else if ((BMI >= 30.0) && (BMI <= 34.9)) {
        	bmiPoints = 75;
        } 
    	return bmiPoints;
    }
            
    public static int getPointsBP (int bpSyst, int bpDias) {
    	int bpPoints = 0;
    	if ((120 > bpSyst) && (80 > bpDias)) {
    		bpPoints = 0;
        } else if ((120 <= bpSyst) && (bpSyst <= 129 && 80 > bpDias)) {
        	bpPoints = 15;
        } else if ((130 <= bpSyst && bpSyst <= 139) || (80 <= bpDias && bpDias <= 89 )) {
        	bpPoints = 30;
        } else if ((bpSyst >= 140) || (bpDias >=90)) {
        	bpPoints = 75;
        } else if ((bpSyst > 180) && (bpDias > 120)) {
        	bpPoints = 100;
        } else if ((bpSyst > 180) || (bpDias > 120)) {
        	bpPoints = 100;
        } 
    	return bpPoints;
    }
         
    public static int getPointsCancer(String cancer) {
    	int cancerPoints = 0;
    	if (cancer.equals("y")) {
            cancerPoints = 10;
    	} 
    	return cancerPoints;
    }
    
    public static int getPointsDiabetes(String diabetes) {
    	int diabPoints = 0;
    	if (diabetes.equals("y")) {
            diabPoints = 10;
    	} 
    	return diabPoints;
    }
    	       
    public static int getPointsAlzheimers(String alzheimers) {
    	int alzPoints = 0;
    	if (alzheimers.equals("y")) {
            alzPoints = 10;
        } 
        return alzPoints;
    }
    
    public static int getVerdict(int agePoints, int bmiPoints, int bpPoints, int cancerPoints, int diabPoints, int alzPoints) {
    	int verdict = agePoints + bmiPoints + bpPoints + cancerPoints + diabPoints + alzPoints;
    	return verdict;
    }

    public static String getRisk(int totalPoints) {
    	
        if (totalPoints <= 20 ) {
            return "low risk";
        } else if (totalPoints <= 50 ) {
            return "moderate risk";
        } else if (totalPoints <= 75) {
            return "high risk";
        } else {
            return "uninsurable";
        }
    }

    public static double calcBMI(int height, int weight) {
        double BMI = 703 * weight /(height*height);
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

        double BMI = calcBMI(height, weight);
        int pointsAge = getPointsAge(age);
        int pointsBMI = getPointsBMI(BMI);
        int pointsBP = getPointsBP(bpSyst, bpDias);
        int pointsCancer = getPointsCancer(cancer);
        int pointsDiabetes = getPointsDiabetes(diabetes);
        int pointsAlz = getPointsAlzheimers(alzheimers);
        int totalPoints = getVerdict(pointsAge, pointsBMI, pointsBP, pointsCancer, pointsDiabetes, pointsAlz);
        
        String riskPoints = getRisk(totalPoints);
        InsuranceScore score = new InsuranceScore(lastname, firstname, totalPoints, riskPoints);
        
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