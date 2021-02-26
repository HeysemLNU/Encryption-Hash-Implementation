import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RailDecrypt {
    public int theKeyInt;
    public File toRead;
    public File toWrite;
    public RailDecrypt(String pathRead, String pathWrite, char key){
        toRead=new File(pathRead);
        toWrite=new File(pathWrite);
        theKeyInt=key%96;
    }
    public void railDecryptMain () throws IOException {
        FileReader readFile=new FileReader(toRead);
        FileWriter writeFile=new FileWriter(toWrite);
        String readFromFile=new String();
        int charRead;
        while ((charRead=readFile.read())!=-1){
            readFromFile+=(char) charRead;
        }
        writeFile.write(railDecryptor(readFromFile));
        writeFile.close();
    }
    public String railDecryptor(String readFromFile){
        ArrayList<String> decrArr = new ArrayList<>();

        for (int i = 0; i<theKeyInt; i++){
            String instance = "";
            decrArr.add(instance);
        }
        int decrAdd = 0;

        for (int i =0;i<readFromFile.length();i++) {
            if (decrAdd ==theKeyInt-1){decrAdd = 0;}
            String addArr = decrArr.get(decrAdd) + readFromFile.charAt(i);
            decrArr.remove(decrAdd);
            decrArr.add(decrAdd,addArr);
            decrAdd++;
        }

        ArrayList <String>  order = new ArrayList<>();


        int beginSub=0;
        for (int i =0; i<theKeyInt;i++){
            String divide = readFromFile.substring(beginSub,beginSub+decrArr.get(i).length());
            beginSub = beginSub+decrArr.get(i).length();
            order.add(divide);
        }

        String theResult = "";
        boolean stopLoop = false;
        int pointer = 0;
        while (stopLoop == false){
            for (int i = 0; i<order.size()-1;i++){
                if (pointer==order.get(i).length()){
                    stopLoop = true;
                    break;}
                theResult += order.get(i).charAt(pointer);
            }pointer ++;
        }
        return theResult;
    }
}
