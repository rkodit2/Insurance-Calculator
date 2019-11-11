import java.util.ArrayList;
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
            return true;
        }catch(Exception ex){
            return false;
        }
    }


    //function to write to binary


    //function to write to xml

    //function to write to JSON

}
