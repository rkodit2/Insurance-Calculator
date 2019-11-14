/**
 * This class creates the Member.
 * It includes setters and getters for each part of the file.
 * It creates the the instance and toString function that formats each Member.
 * @author Rajashree
 *
 */
import java.io.Serializable;
public class Member implements Serializable {
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
    public int getage() {
        return age;
    }
    public int getheight() {
        return height;
    }
    public int getweight() {
        return weight;
    }
    public int getbySyst() {
        return bpSyst;
    }
    public int getbpDias() {
        return bpDias;
    }
    public String getcancer() {
        return cancer;
    }
    public String getdiabetes() {
        return diabetes;
    }
    public String getalzheimers() {
        return alzheimers;
    }
    //public constructor for XML
    public Member(){
        lastName = "";
        firstName = "";
        age = 0;
        height = 0;
        weight = 0;
        bpSyst = 0;
        bpDias = 0;
        cancer = "";
        diabetes = "";
        alzheimers = "";
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
        String member = lastName + ", " + firstName + "\nAge	" + age +
                "\nHeight	" + height + " in" + "\nWeight	" + weight + " lbs"
                + "\nBP Syst	" + bpSyst + "\nBP Dias		" + bpDias +
                "\nCancer	" + cancer + "\nDiabetes	" + diabetes +
                "\nAlzheimers	" + alzheimers + "\n----------------------- \n";
        return member;
    }
}
