package ata;


import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.ArrayList;

public class AutoGenerator  {
private ArrayList<JSONObject> JSONObjects;
    public static void main(String[] args)  {
       JSONObject a = new JSONObject(null);
        System.out.println("Hello world!");
    }

    public static void getJSONData(){
        String path = AutoGenerator.class.getClassLoader().getResource("src/main/java/resources/JSONDATA.json").getPath();
        String stream = readJSON(path);
        com.alibaba.fastjson.JSONObject obj = JSON.parseObject(stream);
    }

    public static String readJSON(String fileName) {
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

public ArrayList<Object> GeneratorOne(ArrayList<JSONObject> Objects){return null;}
public ArrayList<Object> GeneratorTwo(ArrayList<JSONObject> Objects){return null;}
public ArrayList<Object> GeneratorThree(ArrayList<JSONObject> Objects){return null;}
public void CreateSlidesByTemplate(ArrayList<Object> Material){}
}
