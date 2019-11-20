package ata;


import com.alibaba.fastjson.*;
import org.jetbrains.annotations.NotNull;


import java.io.*;
import java.util.ArrayList;

public class AutoGenerator  {
private static ArrayList<Objects> Objects;
public static void main(String[] args)  {
    String stream = readJSON("/Users/junye.mao/IdeaProjects/AutoGenerateArgumentation/AutoGenerator/src/main/resources/JSONDATA.json");
        System.out.println(stream);
    }

    private AutoGenerator(){}
// getJSONData() is method to transfer json string to Objects
    private static void getJSONData() {
        String ObjectName;
        int ObjectID;
        ArrayList<Picture> Pictures;
        ArrayList<Phrase> Phrases ;
        ArrayList<Snippet> Snippets;
        String[] keywords;
        String path = AutoGenerator.class.getClassLoader().getResource("JSONDATA.json").getPath();
        String stream = readJSON(path);
        JSONObject Jobj = JSON.parseObject(stream);
        JSONArray JSONObjects = Jobj.getJSONArray("JSONObjects");
        for(int i=0;i<JSONObjects.size();i++){
            JSONObject object = (JSONObject) JSONObjects.get(0);
            ObjectName = (String) object.get("ObjectName");
            ObjectID = (int) object.get("ObjectID");
            System.out.println("Object name " + ObjectName + " " + ObjectID);
            JSONArray phrases = (JSONArray) object.getJSONArray("Phrases");
            JSONArray pictures = (JSONArray) object.getJSONArray("Pictures");
            JSONArray snippets = (JSONArray) object.getJSONArray("Snippets");
            Phrases = new ArrayList<Phrase>();
            Pictures = new ArrayList<Picture>();
            Snippets = new ArrayList<Snippet>();
            for(Object o : phrases){
                JSONObject phrase =(JSONObject) o;
                keywords = getKeyWords(phrase);
                Phrases.add(new Phrase((int)phrase.get("PhraseID"),(int)phrase.get("Strength"),(String)phrase.get("Content"),(String)phrase.get("Type"),(String)phrase.get("PointTo"),keywords));
            }
            for (Object o : snippets) {
                JSONObject snippet = (JSONObject) o;
                keywords = getKeyWords(snippet);
                Snippets.add(new Snippet((int) snippet.get("PhraseID"), (int) snippet.get("Strength"), (String) snippet.get("Content"), (String) snippet.get("Type"), (String) snippet.get("PointTo"), keywords));
            }
            for(Object o : pictures){
                JSONObject picture =(JSONObject) o;
                keywords = getKeyWords(picture);
                Snippets.add(new Snippet((int)picture.get("PhraseID"),(int)picture.get("Strength"),(String)picture.get("Content"),(String)picture.get("Type"),(String)picture.get("PointTo"),keywords));
            }
            Objects.add(new Objects(ObjectName,ObjectID,Pictures,Phrases,Snippets));
        }

    }

    @NotNull
    private static String[] getKeyWords(JSONObject sample){
        JSONArray KeyWords = sample.getJSONArray("KeyWords");
        String[] keywords = new String[KeyWords.size()];
        for(int k=0;k<keywords.length;k++){
            keywords[k] = KeyWords.getString(k);
        }
        return keywords;
    }

    private static String readJSON(String fileName) {
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

public ArrayList<Object> GeneratorOne(ArrayList<Objects> Objects){return null;}
public ArrayList<Object> GeneratorTwo(ArrayList<Objects> Objects){return null;}
public ArrayList<Object> GeneratorThree(ArrayList<Objects> Objects){return null;}
public void CreateSlidesByTemplate(ArrayList<Object> Material){}
}
