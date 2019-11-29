package ata.Util;
import ata.Object.*;
import java.util.ArrayList;
import static ata.Util.AlgorithmUtil.*;

public class Generator{
   public ArrayList<Object> GeneratorOne(Objects object){
        ArrayList samples = new ArrayList();
        ArrayList<Snippet> snippets = object.getSnippets();
        ArrayList<Picture> pictures = object.getPictures();
        ArrayList<Phrase> phrases = object.getPhrases();

        Snippet intro = get(snippets,"definition");
        addMaterial(samples, intro);
        Picture img = get(pictures,intro);
        addMaterial(samples, img);

        Phrase MainPoint = get(phrases, "Main-point","positive");
        addMaterial(samples,MainPoint);
        remove(phrases, MainPoint);
        Picture img2 = get(pictures,MainPoint);
        addMaterial(samples, img2);

        Phrase cloneObj = new Phrase(MainPoint.getPhraseID(),MainPoint.getStrength(),MainPoint.getContent(),MainPoint.getType(),MainPoint.getPointTo(),MainPoint.getKeyWords());
        while(cloneObj.getKeyWords().length>0){
             for(String a:cloneObj.getKeyWords())
             System.out.println(a);
             Phrase PointView = get(phrases,cloneObj,"viewpoint");
             Snippet explanation = get(snippets,PointView,"explanation");
             if(addMaterial(samples,PointView) && addMaterial(samples,explanation)){
             remove(phrases,PointView);
             remove(snippets, explanation);
             cloneObj.setKeyWords(removeMatchedKeyWords(cloneObj.getKeyWords(),PointView));
             }
        }

        Phrase MainPointTwo = get(phrases, "Main-point","negative");
        addMaterial(samples,MainPointTwo);
        remove(phrases, MainPointTwo);
        Picture img3 = get(pictures,MainPointTwo);
        addMaterial(samples, img3);
         Phrase cloneObjTwo = new Phrase(MainPointTwo.getPhraseID(),MainPointTwo.getStrength(),MainPointTwo.getContent(),MainPointTwo.getType(),MainPointTwo.getPointTo(),MainPointTwo.getKeyWords());
        while(cloneObjTwo.getKeyWords().length>0){
             Phrase PointView = get(phrases,cloneObjTwo,"viewpoint");
             Snippet explanation = get(snippets,PointView,"explanation");
             if(addMaterial(samples,PointView) && addMaterial(samples,explanation)){
             remove(phrases,PointView);
             remove(snippets, explanation);
             cloneObjTwo.setKeyWords(removeMatchedKeyWords(cloneObjTwo.getKeyWords(),PointView));
             }
        }
        System.out.println(samples.toString());
        return samples;
    }


    private ArrayList<Object> GeneratorTwo(ArrayList<Objects> Objects){return null;}
    private ArrayList<Object> GeneratorThree(ArrayList<Objects> Objects){return null;}

}
