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
        Snippet intro = getDefinition(snippets);
        addMaterial(samples, intro);
        Picture img = getPicture(pictures,samples);
        addMaterial(samples, img);
        Phrase MainPoint = getPositiveMainPoint(phrases);
        addMaterial(samples,MainPoint);
        remove(phrases, MainPoint);
        Picture img2 = getPicture(pictures,samples);
        addMaterial(samples, img2);


        Phrase MainPointTwo = getNegativeMainPoint(phrases);
        addMaterial(samples,MainPointTwo);
        remove(phrases, MainPointTwo);
        Picture img3 = getPicture(pictures,samples);
        addMaterial(samples, img3);

        return samples;
    }


    private ArrayList<Object> GeneratorTwo(ArrayList<Objects> Objects){return null;}
    private ArrayList<Object> GeneratorThree(ArrayList<Objects> Objects){return null;}

}
