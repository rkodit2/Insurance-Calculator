/**
 * This class reads the file by tabs.
 * It creates a new member.
 * It reads the file as a text, binary, and XML.
 * @author Rajashree Kodithyala, Michael Bernasol, Matt Espinos
 */


import java.util.*;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class MemberReader {
    public static ArrayList<Member> readMembersFromFile(String fname){
        try{
            ArrayList<Member> members = new ArrayList<Member>();
            Scanner sc = new Scanner(new File(fname));
            String line;
            String[] parts;

            while(sc.hasNextLine()){
                line = sc.nextLine();
                parts = line.split("\t");


                members.add(new Member(parts[0],parts[1],Integer.parseInt(parts[2]),
                		Integer.parseInt(parts[3]),Integer.parseInt(parts[4]),Integer.parseInt(parts[5]),Integer.parseInt(parts[6]),parts[7],parts[8],parts[9]));
            }
            sc.close();
            return members;


        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    public static ArrayList<Member> readMembersFromBinary(String fname){
    	try {
    		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname));
    		ArrayList<Member> result = (ArrayList<Member>)ois.readObject();
    		ois.close();
    		return result;
    	} catch (Exception ex) {
    		return null;
    	}
    }
    public static ArrayList<Member> readMembersFromXML(String fname){
    	try {
    		XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new FileInputStream(fname)));
    		ArrayList<Member> result = (ArrayList<Member>)dec.readObject();
    		dec.close();
    		return result;
    	} catch (Exception ex) {
    		return null;
    	}
    	}
    }