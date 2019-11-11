import java.util.ArrayList;
import java.beans.XMLEncoder;
import java.io.*;
public class MemberWriter {



	//prints members to screen

    public static void printMembersToScreen(ArrayList<Member> members){
        for(Member m: members){
            System.out.println(m);
        }
    }


    //function to write members to a tab-delimited file
    public static boolean writeMembersToTextFile(String fname, ArrayList<Member> members){
        try{
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
            for(Member m: members){
                pw.println(m);
            }
            pw.close();
            System.out.println("\nMembers Written Successfully");
            return true;
        }catch(Exception ex){
            return false;
        }
    }


    //function to write to binary
    public static boolean writeMembersToBinary(String fname, ArrayList<Member> members){
    	try {
    		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname));
    		oos.writeObject(members);
    		oos.close();
    		System.out.println("\nMembers Written Successfully");
    		return true;
    	} catch (Exception ex) {
    		return false;
    	}
    }

    //function to write to xml
    public static boolean writeMembersToXML(String fname, ArrayList<Member> members) {
    	try {
    		XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new 
    				FileOutputStream(fname)));
    		enc.writeObject(members);
    		enc.close();
    		System.out.println("\nMembers Written Successfully");
    		return true;
    	} catch (Exception ex) {
    		return false;
    	}
    }
    //function to write to JSON

}
