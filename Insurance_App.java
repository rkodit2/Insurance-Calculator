/**
 *This class is the driver class.
 *@author Rajashree Kodithyala
 */
import java.util.ArrayList;
        import java.util.Scanner;

public class Insurance_App {

    public static void printStars(int howMany) {
        String stars = "";
        for (int i = 0; i < howMany; i++) {
            stars = stars + "*";
        }
        System.out.println(stars);
    }

    public static void showMenu() {
        System.out.println("Here are your choices:  ");
        System.out.println("1. List members");
        System.out.println("2. Add a new member");
        System.out.println("3. Save members");
        System.out.println("4. Load members");
        System.out.println("5. Asses members");
        System.out.println("6. Save assessments as JSON");
        System.out.println("7. Exit");
        System.out.println("Please enter the number of your choice: ");
    }

    public static void printWelcome() {
        printStars(40);
        System.out.println("         INSURANCE SCORE CARD\r\n" +
                "  This app scores a potential customer\r\n" +
                "  on various health attributes: blood\r\n" +
                "  pressure, age, height, weight, and\r\n" +
                "  family history of disease. It writes\r\n" +
                "  each member's insurance grade to a\r\n" +
                "  JSON file so that they can be easily\r\n" +
                "  shared on a web-based data exchange.\r\n");
        printStars(40);
    }

    public static void printExit() {
        printStars(50);
        System.out.println("INSURANCE SCORE CARD");
        System.out.println("THANK YOU");
    }
    /**
     * Creates the array list with the members using the object class Member.
     * For each choice, it asks for the required input.
     * Terminates the program.
     * @param args
     */
    public static void main(String[] args) {
        printWelcome();

        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("Enter the name of member file: ");
        String fname;
        fname = sc.nextLine();
        ArrayList<Member> fileMembs = MemberReader.readMembersFromFile(fname);
        int count;
        do {
            showMenu();
            choice = Integer.parseInt(sc.nextLine());
            if (choice == 1) {
                MemberWriter.printMembersToScreen(fileMembs);
            } else if (choice == 2) {
                System.out.print("Enter first and last name: ");
                String firstName = sc.next();
                String lastName = sc.nextLine().trim();
                System.out.print("Enter age: ");
                int age = sc.nextInt();
                System.out.print("Enter height in inches: ");
                int height = sc.nextInt();
                System.out.print("Enter weight in pounds: ");
                int weight = sc.nextInt();
                System.out.print("Enter blood pressure (sys and dias): ");
                int bpSys = sc.nextInt();
                int bpDias = sc.nextInt();
                sc.nextLine();
                System.out.println("Has a family member had... ");
                System.out.print("Cancer?");
                String cancer = sc.nextLine();
                System.out.print("Diabetes?");
                String diabetes = sc.nextLine();
                System.out.print("Alzheimers?");
                String alzheimers = sc.nextLine();
                fileMembs.add(new Member(lastName, firstName, age, height, weight, bpSys, bpDias, cancer, diabetes, alzheimers));
            } else if (choice == 3) {
                System.out.print("(T)ext, (B)inary, (X)ML:  ");
                String type = sc.nextLine();
                System.out.print("Enter the name of the output file:  ");
                String outFile = sc.nextLine();
                if(type.equalsIgnoreCase("T")) {
                    MemberWriter.writeMembersToTextFile(outFile, fileMembs);
                }
                else if(type.equalsIgnoreCase("B")) {
                    MemberWriter.writeMembersToBinary(outFile, fileMembs);
                }
                else if(type.equalsIgnoreCase("X")) {
                    MemberWriter.writeMembersToXML(outFile, fileMembs);
                }
                System.out.println("\nMembers Written Successfully");
            } else if (choice == 4) {
                count = 0;
                System.out.print("(T)ext, (B)inary, (X)ML:  ");
                String type = sc.nextLine();
                System.out.print("Enter the name of the input file:  ");
                String outFile = sc.nextLine();
                if(type.equalsIgnoreCase("T")) {
                    ArrayList<Member> text = MemberReader.readMembersFromFile(outFile);
                    for(int i = 0; i < text.size(); i++) {
                        count++;
                    }
                    System.out.println(count + " Members read");
                }
                else if(type.equalsIgnoreCase("B")) {
                    ArrayList<Member> binary = MemberReader.readMembersFromBinary(outFile);
                    for(Member m: binary){
                        count++;
                    }
                    System.out.println(count + " Members read");
                }

                else if(type.equalsIgnoreCase("X")) {
                    ArrayList<Member> xml = MemberReader.readMembersFromXML(outFile);
                    for(Member m: xml){
                        count++;
                    }
                    System.out.println(count + " Members read");


                }
            } else if (choice == 5) {
                ArrayList<InsuranceScore> memberResults = Assessor.memberScore(fileMembs);
                InsuranceScoreWriter.writeInsuranceScore(memberResults);

            } else if (choice == 6) {
                System.out.println("Enter name of JSON output file: ");
                String fileName = sc.nextLine();
                ArrayList<InsuranceScore> results = Assessor.memberScore(fileMembs);
                if (MemberWriter.writeMembersToJSON(fileName,results)) {
                    System.out.println("Scores were written successfully");
                }else {
                    System.out.println("Failed to write");
                }
            }

        } while (choice != 7);
        printExit();

    }

}
