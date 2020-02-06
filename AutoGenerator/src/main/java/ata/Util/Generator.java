package ata.Util;
import ata.Object.*;
import java.util.ArrayList;
import static ata.Util.AlgorithmUtil.*;

public class Generator{

   public ArrayList<Object> GeneratorOne(Objects object){
        AlgorithmUtil util = new AlgorithmUtil();
        ArrayList samples = new ArrayList();
        ArrayList<Snippet> snippets = object.getSnippets();
        ArrayList<Picture> pictures = object.getPictures();
        ArrayList<Phrase> phrases = object.getPhrases();

        Snippet intro = util.get(snippets,"definition");
        util.addMaterial(samples, intro);
        Picture img = util.get(pictures,intro);
        util.addMaterial(samples, img);

        Phrase MainPoint = util.get(phrases, "Main-point","positive");
        util.addMaterial(samples,MainPoint);
        util.remove(phrases, MainPoint);
        Picture img2 = util.get(pictures,MainPoint);
        util.addMaterial(samples, img2);

        Phrase cloneObj = new Phrase(MainPoint.getPhraseID(),MainPoint.getStrength(),MainPoint.getContent(),MainPoint.getType(),MainPoint.getPointTo(),MainPoint.getKeyWords());
        while(cloneObj.getKeyWords().length>0){
             for(String a:cloneObj.getKeyWords())
             System.out.println(a);
             Phrase PointView = util.get(phrases,cloneObj,"viewpoint");
             if(PointView==null) break;
             Snippet explanation = util.get(snippets,PointView,"explanation");
             if(util.addMaterial(samples,PointView) && util.addMaterial(samples,explanation)){
                  util.remove(phrases,PointView);
                  util.remove(snippets, explanation);
             cloneObj.setKeyWords(util.removeMatchedKeyWords(cloneObj.getKeyWords(),PointView));
             }
        }

        Phrase MainPointTwo = util.get(phrases, "Main-point","negative");
        util.addMaterial(samples,MainPointTwo);
        util.remove(phrases, MainPointTwo);
        Picture img3 = util.get(pictures,MainPointTwo);
        util.addMaterial(samples, img3);
         Phrase cloneObjTwo = new Phrase(MainPointTwo.getPhraseID(),MainPointTwo.getStrength(),MainPointTwo.getContent(),MainPointTwo.getType(),MainPointTwo.getPointTo(),MainPointTwo.getKeyWords());
        while(cloneObjTwo.getKeyWords().length>0){
             Phrase PointView = util.get(phrases,cloneObjTwo,"viewpoint");
             if(PointView==null) break;
             Snippet explanation = util.get(snippets,PointView,"explanation");
             if(util.addMaterial(samples,PointView) && util.addMaterial(samples,explanation)){
                  util.remove(phrases,PointView);
                  util.remove(snippets, explanation);
             cloneObjTwo.setKeyWords(util.removeMatchedKeyWords(cloneObjTwo.getKeyWords(),PointView));
             }
        }
        System.out.println(samples.toString());
        return samples;
    }


    private ArrayList<Object> GeneratorTwo(ArrayList<Objects> Objects){return null;}
    private ArrayList<Object> GeneratorThree(ArrayList<Objects> Objects){return null;}

}
