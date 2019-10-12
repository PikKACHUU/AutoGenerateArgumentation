package ata;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;


public class getJSON {

    public static String readJson(String fileName) {
        String JsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int Ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((Ch = reader.read()) != -1) {
                sb.append((char) Ch);
            }
            fileReader.close();
            reader.close();
             JsonStr = sb.toString();
            return JsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
