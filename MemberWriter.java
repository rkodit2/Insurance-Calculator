/**
 * This class prints the members to the screen.
 * It saves the member to a text file,
 * a binary file, a XML file, a the JSON file.
 * It loads the members into the different files.
 * @author Rajashree Kodithyala, Michael Bernasol, Matt Espinos
 */

import java.util.ArrayList;
import java.beans.XMLEncoder;
import java.io.*;
import org.json.simple.*;

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
                //pw.println(m);
                pw.println(m.toStringTabs());
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
    public static boolean writeMembersToJSON(String fname, ArrayList<InsuranceScore> members) {
        try{
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
            JSONObject memObj;
            JSONArray array = new JSONArray();
            for(InsuranceScore s : members){
                memObj = new JSONObject();
                memObj.put("last name",s.getLastName());
                memObj.put("first name",s.getFirstName());
                memObj.put("score",s.getScore());
                memObj.put("verdict",s.getVerdict());
                array.add(memObj);
            }
            JSONObject outer = new JSONObject();
            outer.put("members",array);
            pw.println(outer.toJSONString());
            pw.close();
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }


}
