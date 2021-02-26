import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TestAll {
    public static void main (String [] args) throws IOException {
        int choice;
        Scanner sc=new Scanner(System.in);
        System.out.println("Pick one of the following options (enter the number)");
        System.out.println("1.Encrypt Caesar Cipher\t2.Decrypt Caesar Cipher\t3.Encrypt Rail Fence\t4.Decrypt Rail Fence");
        choice=sc.nextInt();
        if (choice==1){
            System.out.println("The key should be a single char between a-y (lowercase letters) for best usage");
            System.out.println("Enter Key");
            char key=sc.next().charAt(0);
            System.out.println("Enter File Path To read");
            String folderRead=sc.next();
            System.out.println("Enter File Path To write");
            String folderWrite=sc.next();

            File sample=new File(folderRead);
            File sample2=new File(folderWrite);
            if (sample.exists()&&sample2.exists()){
            CeaserEncr encrCea=new CeaserEncr(folderRead,folderWrite,key);
            encrCea.encriptMain();}
            else {
                System.out.println("File Doesn't Exists");

            }

        }else if (choice==2){
            System.out.println("Enter Key");
            char key=sc.next().charAt(0);
            System.out.println("Enter File Path To read");
            String folderRead=sc.next();
            System.out.println("Enter File Path To write");
            String folderWrite=sc.next();

            File sample=new File(folderRead);
            File sample2=new File(folderWrite);
            if (sample.exists()&&sample2.exists()){
            CeaserDecr decriptCea=new CeaserDecr(folderRead,folderWrite,key);
            decriptCea.decriptMain();}
            else {
                System.out.println("File Doesn't Exists");

            }
        }
        else if (choice==3){
            System.out.println("The key should be a single char between e-n (lowercase letters) for best usage");
            System.out.println("Enter Key");
            char key=sc.next().charAt(0);
            System.out.println("Enter File Path To read");
            String folderRead=sc.next();
            System.out.println("Enter File Path To write");
            String folderWrite=sc.next();

            File sample=new File(folderRead);
            File sample2=new File(folderWrite);
            if (sample.exists()&&sample2.exists()){
                RailEncrypt encript=new RailEncrypt(folderRead,folderWrite,key);
            encript.railMain();}else {
                System.out.println("File Doesn't Exists");
            }

        }
        else if (choice==4){
            System.out.println("Enter Key");
            char key=sc.next().charAt(0);
            System.out.println("Enter File Path To read");
            String folderRead=sc.next();
            System.out.println("Enter File Path To write");
            String folderWrite=sc.next();


            File sample=new File(folderRead);
            File sample2=new File(folderWrite);
            if (sample.exists()&&sample2.exists()){
                RailDecrypt decrept = new RailDecrypt(folderRead,folderWrite,key);
            decrept.railDecryptMain();}else {
                System.out.println("File Doesn't Exists");
            }
        }
    }
}
