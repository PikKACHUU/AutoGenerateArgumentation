package ata;

import ata.Object.Objects;

import java.io.IOException;
import java.util.ArrayList;
import static ata.Util.AlgorithmUtil.RandomSelectObject;
import ata.Util.Generator;
import ata.Util.JSONUtil;
import ata.Util.PowerPointUtil;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.xslf.usermodel.XMLSlideShow;

public class MainRunner  {

public static void main(String[] args) throws IOException {
        ArrayList<Objects> ObjectsList = new ArrayList<Objects>();
        Generator generator = new Generator();
        JSONUtil reader = new JSONUtil();
        PowerPointUtil PPTUtil = new PowerPointUtil();
        reader.getJSONData(MainRunner.class,ObjectsList,"JSONDATA.json");
        Objects target = RandomSelectObject(ObjectsList);
    //System.out.println(objectID);
        ArrayList sample =  generator.GeneratorOne(target);
        XMLSlideShow ppt = new XMLSlideShow();
        PPTUtil.setTitle(ppt,target.getObjectName());
        PPTUtil.CreateSlides(sample,ppt);
//        PPTUtil.setHeaderFooter("Created by Junye Mao",ppt);
        PPTUtil.OutputSlideShow("slideshow.pptx",ppt);
}


private void CreateSlidesByTemplate(ArrayList<Object> Material){}
}
