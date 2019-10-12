package ata;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ATA  {

    public static void main(String[] args)  {
       System.out.println("Hello world!");
    }

    public static void getJSONData(){
        String path = ATA.class.getClassLoader().getResource("src/test/resources/JSONDATA.json").getPath();
        String stream = getJSON.readJson(path);
        JSONObject obj = JSON.parseObject(stream);
    }

}
