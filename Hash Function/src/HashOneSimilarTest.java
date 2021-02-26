import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;

public class HashOneSimilarTest {
    public static void main(String [] args ) throws IOException {
        File exampleFile = new File("similar.txt");
        FileReader readSent = new FileReader(exampleFile.getAbsolutePath());
        BufferedReader readBuff = new BufferedReader(readSent);
        HashMap<String,String> newMap = new HashMap<String,String>();
        HashMap<String, Integer> distro = new HashMap<String, Integer>();
        HashMap <Integer,Integer> stats = new HashMap<Integer,Integer>();
        String sentance;
        while ((sentance = readBuff.readLine()) != null){
            int currentProcessed = 0;
            for (int i = 0; i<sentance.length(); i++){
                if (sentance.length() == 1){
                    String translateToString = new BigInteger(String.valueOf(sentance.charAt(0)).getBytes()).toString(2);
                    int toProses = Integer.parseInt(translateToString,2);
                    currentProcessed = toProses + toProses;
                    break;
                }else {
                    String translateToString = new BigInteger(String.valueOf(sentance.charAt(i)).getBytes()).toString(2);
                    int toProses = Integer.parseInt(translateToString,2);
                    currentProcessed += toProses;

                }
            }
            String binaryAddition = Integer.toBinaryString(currentProcessed);
            String resultReverse = Integer.toBinaryString(~currentProcessed);

            if (binaryAddition.length()<8){
                binaryAddition = String.format("%8s",Integer.toBinaryString(currentProcessed)).replace(' ','0');
            }

            String finalResult = binaryAddition.substring(binaryAddition.length()-8,binaryAddition.length()) + resultReverse.substring(resultReverse.length()-8, resultReverse.length());
            newMap.put(finalResult,sentance);
            if (distro.containsKey(finalResult)){
                distro.put(finalResult,distro.get(finalResult)+1);

            }else {distro.put(finalResult,1);}
            if (stats.containsKey(distro.get(finalResult))){
                stats.put(distro.get(finalResult),stats.get(distro.get(finalResult))+1);
            }else {
                stats.put(distro.get(finalResult),1);
            }
        }
        System.out.println(newMap);
        System.out.println("Amount of hash digests produced out of 1000 random words: "+newMap.size());
        System.out.println(distro);
        System.out.println("Amount of Values - Amount Keys that have that many values attached");
        System.out.println(stats);
        System.out.println("This means that there are: ");
        System.out.println((stats.get(1)-stats.get(2))+" keys that corresponds to a single value");
        System.out.println((stats.get(2)-stats.get(3))+" keys that corresponds to two values");
        System.out.println((stats.get(3)-stats.get(4))+" keys that corresponds to three values");
        System.out.println((stats.get(4)-stats.get(5))+" keys that corresponds to four values");
        System.out.println((stats.get(5)-stats.get(6))+" keys that corresponds to five values");
        System.out.println((stats.get(6)-stats.get(7))+" keys that corresponds to six values");
        System.out.println((stats.get(7)-stats.get(8))+" keys that corresponds to seven values");
        System.out.println((stats.get(8)-stats.get(9))+" keys that corresponds to eight values");
        System.out.println((stats.get(9)-stats.get(10))+" keys that corresponds to nine values");
        System.out.println((stats.get(10)-stats.get(11))+" keys that corresponds to ten values");
        System.out.println((stats.get(11)-stats.get(12))+" keys that corresponds to eleven values");
        System.out.println((stats.get(12)-stats.get(13))+" keys that corresponds to twelve values");
        System.out.println((stats.get(13)-stats.get(14))+" keys that corresponds to thirteen values");
        System.out.println((stats.get(14)-stats.get(15))+" keys that corresponds to fourteen values");
        System.out.println((stats.get(15)-stats.get(16))+" keys that corresponds to fifteen values");
        System.out.println((stats.get(16)-stats.get(17))+" keys that corresponds to sixteen values");
        System.out.println((stats.get(17)-stats.get(18))+" keys that corresponds to seventeen values");
        System.out.println((stats.get(18)-stats.get(19))+" keys that corresponds to eighteen values");
        System.out.println((stats.get(19)-stats.get(20))+" keys that corresponds to nineteen values");
        System.out.println((stats.get(20)-stats.get(21))+" keys that corresponds to twenty values");
        System.out.println((stats.get(21)-stats.get(22))+" keys that corresponds to twenty one values");
        System.out.println((stats.get(22)-stats.get(23))+" keys that corresponds to twenty two values");
        System.out.println((stats.get(23)-stats.get(24))+" keys that corresponds to twenty three values");
        System.out.println((stats.get(24)-stats.get(25))+" keys that corresponds to twenty four values");
        System.out.println((stats.get(25)-stats.get(26))+" keys that corresponds to twenty five values");
        System.out.println((stats.get(26)-stats.get(27))+" keys that corresponds to twenty six values");
        System.out.println((stats.get(27))+" keys that corresponds to twenty seven values");



    }
}
