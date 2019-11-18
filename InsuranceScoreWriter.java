/**
 * This class writes the insurance
 * risk information to the screen.
 * Note: JSON writer is in the MemberWritter class.
 * @author Rajashree Kodithyala, Michael Bernasol, Matt Espinos
 */

import java.io.BufferedWriter;
        import java.io.FileWriter;
        import java.io.PrintWriter;
        import java.util.ArrayList;

public class InsuranceScoreWriter {
    public static boolean writeInsuranceScore(ArrayList<InsuranceScore> scores) {
        try{
//            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
            for(InsuranceScore s: scores){
               System.out.println(s);
            }
//            pw.close();
            return true;
        }catch(Exception ex){
            return false;
        }
    }

}