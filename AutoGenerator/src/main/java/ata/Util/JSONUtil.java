package ata.Util;

import ata.*;
import ata.Object.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class JSONUtil {
    public void getJSONData(Class runner, ArrayList<Objects> ObjectsList, String JSONPath) {
        String ObjectName;
        int ObjectID;
        ArrayList<Picture> Pictures;
        ArrayList<Phrase> Phrases ;
        ArrayList<Snippet> Snippets;
        String[] keywords;
        String path = runner.getClassLoader().getResource(JSONPath).getPath();
        String stream = this.readJSON(path);
        JSONObject Jobj = JSON.parseObject(stream);
        JSONArray JSONObjects = Jobj.getJSONArray("JSONObjects");
        for(int i=0;i<JSONObjects.size();i++){
            JSONObject object = (JSONObject) JSONObjects.get(i);
            ObjectName = (String) object.get("ObjectName");
            ObjectID = (int) object.get("ObjectID");
            //System.out.println("Object name " + ObjectName + " " + ObjectID);
            JSONArray phrases = (JSONArray) object.getJSONArray("Phrases");
            JSONArray pictures = (JSONArray) object.getJSONArray("Pictures");
            JSONArray snippets = (JSONArray) object.getJSONArray("Snippets");
            Phrases = new ArrayList<Phrase>();
            Pictures = new ArrayList<Picture>();
            Snippets = new ArrayList<Snippet>();
            for(Object o : phrases){
                JSONObject phrase =(JSONObject) o;
                keywords = this.getKeyWords(phrase);
                Phrases.add(new Phrase((int)phrase.get("PhraseID"),(int)phrase.get("Strength"),(String)phrase.get("Content"),(String)phrase.get("Type"),(String)phrase.get("PointTo"),keywords));
            }
            for (Object o : snippets) {
                JSONObject snippet = (JSONObject) o;
                keywords = this.getKeyWords(snippet);
                Snippets.add(new Snippet((int) snippet.get("SnippetID"), (int) snippet.get("Strength"), (String) snippet.get("Content"), (String) snippet.get("Type"), (String) snippet.get("PointTo"), keywords));
            }
            for(Object o : pictures){
                JSONObject picture =(JSONObject) o;
                keywords = this.getKeyWords(picture);
                Pictures.add(new Picture((int)picture.get("ImageID"),(int)picture.get("Strength"),(String)picture.get("PointTo"),(String)picture.get("URL"),keywords));
            }
            // System.out.println(Pictures.size()+" "+Phrases.size()+" "+Snippets.size());
            ObjectsList.add(new Objects(ObjectName,ObjectID,Pictures,Phrases,Snippets));
        }
    }



    @NotNull
    private String[] getKeyWords(JSONObject sample) {
        JSONArray KeyWords = sample.getJSONArray("Keywords");
        if(KeyWords.size()==0) throw new NullPointerException("Illegal JSON structure: has no KeyWords");
        String[] keywords = new String[KeyWords.size()];
        Arrays.setAll(keywords, KeyWords::getString);
        return keywords;
    }

    @Nullable
    private String readJSON(String fileName) {
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
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
