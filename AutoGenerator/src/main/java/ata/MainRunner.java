package ata;

import ata.Object.Objects;
import java.util.ArrayList;
import static ata.Util.AlgorithmUtil.RandomSelectObject;
import ata.Util.Generator;
import ata.Util.JSONUtil;

public class MainRunner  {

public static void main(String[] args)  {
        ArrayList<Objects> ObjectsList = new ArrayList<Objects>();
        Generator generator = new Generator();
        JSONUtil reader = new JSONUtil();
        reader.getJSONData(MainRunner.class,ObjectsList,"JSONDATA.json");
        Objects target = RandomSelectObject(ObjectsList);

    //System.out.println(objectID);
        generator.GeneratorOne(target);

    }


private void CreateSlidesByTemplate(ArrayList<Object> Material){}
}
