import java.math.BigInteger;
import java.util.Scanner;

public class HashOne {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the password: ");
        String userInput = sc.nextLine();

        int currentProcessed = 0;
        for (int i = 0; i<userInput.length(); i++){
            if (userInput.length() == 1){
                String translateToString = new BigInteger(String.valueOf(userInput.charAt(0)).getBytes()).toString(2);
                int toProses = Integer.parseInt(translateToString,2);
                currentProcessed = toProses + toProses;
                break;
            }else {
                String translateToString = new BigInteger(String.valueOf(userInput.charAt(i)).getBytes()).toString(2);
                int toProses = Integer.parseInt(translateToString,2);
                currentProcessed += toProses;

            }
        }
        String binaryAddition = Integer.toBinaryString(currentProcessed);
        String resultReverse = Integer.toBinaryString(~currentProcessed);

        if (binaryAddition.length()<8){
            binaryAddition = String.format("%16s",Integer.toBinaryString(currentProcessed)).replace(' ','0');
        }

        String finalResult = binaryAddition.substring(binaryAddition.length()-8,binaryAddition.length()) + resultReverse.substring(resultReverse.length()-8, resultReverse.length());
        System.out.println("Your Hash is: "+finalResult);

    }
}
