import java.io.BufferedWriter;
        import java.io.FileWriter;
        import java.io.PrintWriter;
        import java.util.ArrayList;

public class InsuranceScoreWriter {
    public static boolean writeInsuranceScore(String fname, ArrayList<InsuranceScore> scores) {
        try{
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
            for(InsuranceScore s: scores){
                pw.println(s);
            }
            pw.close();
            return true;
        }catch(Exception ex){
            return false;
        }
    }

}