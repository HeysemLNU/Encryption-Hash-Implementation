import java.io.*;
import java.util.ArrayList;

public class RailEncrypt {
    public int theKeyInt;
    public File toRead;
    public File toWrite;
    public RailEncrypt(String pathRead, String pathWrite, char key){
        toRead=new File(pathRead);
        toWrite=new File(pathWrite);
        theKeyInt=key%96;
    }
    public void railMain () throws IOException {
        FileReader readFile=new FileReader(toRead);
        FileWriter writeFile=new FileWriter(toWrite);
        String readFromFile=new String();
        int charRead;
        while ((charRead=readFile.read())!=-1){
            readFromFile+=(char) charRead;
        }
       writeFile.write(railEncryptor(readFromFile));
        writeFile.close();
    }
    public String railEncryptor(String toEncr){
        ArrayList<String> continer = new ArrayList<>();
        for (int i = 0; i<theKeyInt; i++){
            String instance = "";
            continer.add(instance);
        }
        int addTo = 0;
        for (int i =0;i<toEncr.length();i++) {
            if (addTo ==theKeyInt-1){addTo = 0;}
            String addArr = continer.get(addTo) + toEncr.charAt(i);
            continer.remove(addTo);
            continer.add(addTo,addArr);
            addTo++;
        }
        String encryptedString = "";

        for (int i = 0; i<theKeyInt; i++){
            encryptedString +=continer.get(i);
        }
        return encryptedString;
    }

}
