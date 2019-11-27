package ata.Util;

import ata.Object.*;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.Iterator;

 public class AlgorithmUtil {

    public static Phrase getMainPoint(ArrayList<Phrase> phrases){
        ArrayList<Phrase> sample = new ArrayList<Phrase>();
        if(judgeSize(phrases)) throw new IllegalArgumentException("List parameter has no elements");
        for(Phrase phrase:phrases){
            if(phrase.getType().equals("Main-point")){
                sample.add(phrase);
            }
        }
        if(judgeSize(sample)) return null;
        int index = getRandomID(sample)-1;
        return sample.get(index);
    }

     public static Phrase getPointView(ArrayList<Phrase> phrases, Phrase MainPoint){
        if(judgeSize(phrases)) throw new IllegalArgumentException("List parameter has no elements");
        if(MainPoint == null) throw new IllegalArgumentException("No MainPoint exists");
        ArrayList<Phrase> sample = new ArrayList<Phrase>();
        for(Phrase phrase:phrases){
            if(phrase.getType().equals("viewpoint") && phrase.getPointTo().equals(MainPoint.getPointTo())){

                //match keywords array,calculate probabilities then sort in increasing order
            }
        }
        return null;
    }

    private static <K,V> boolean judgeStrength(K k, V v){
        if(k instanceof Phrase && v instanceof Snippet){
            Phrase phrase = (Phrase) k;
            Snippet snippet = (Snippet) v;
            if(phrase.getStrength()*snippet.getStrength()>=0)
                return true;
        }
        else if(k instanceof Phrase && v instanceof Phrase){
            Phrase phrase = (Phrase) k;
            Phrase phrase1 = (Phrase) v;
            if(phrase.getStrength()*phrase1.getStrength()>=0)
                return true;
        }
        else if(k instanceof Phrase && v instanceof Picture){
            Phrase phrase = (Phrase) k;
            Picture picture = (Picture) v;
            if(phrase.getStrength()*picture.getStrength()>=0)
                return true;
        }
        else if(k instanceof Snippet && v instanceof Picture){
            Snippet snippet = (Snippet) k;
            Picture picture = (Picture) v;
            if(snippet.getStrength()*picture.getStrength()>=0)
                return true;
        }else
            throw new IllegalArgumentException();
        return false;
    }

    public static Picture getPicture(ArrayList<Picture> pictures, ArrayList<Object> sample){
        if (judgeSize(pictures) || judgeSize(sample)) throw new IllegalArgumentException("List parameter has no elements");
        String[] arr;
        String[] arr2;
        ArrayList<Picture> pictureList = new ArrayList<Picture>();
        Object PreObject = sample.get(sample.size()-1);
            if(PreObject instanceof Phrase) {
            Phrase pre = (Phrase) PreObject;
            for (Picture pic : pictures) {
                if (pic.getPointTo().equals(pre.getPointTo()) && judgeStrength(pre,pic)) {
                    arr = pic.getKeyWords();
                    arr2 = pre.getKeyWords();
                    for(String a:arr){
                        for(String b:arr2){
                            if(a.equals(b))
                                pictureList.add(pic);
                        }
                    }
                }
            }
        }else if(PreObject instanceof Snippet) {
            Snippet pre = (Snippet) PreObject;
            for (Picture pic : pictures) {
                if (pic.getPointTo().equals(pre.getPointTo()) && judgeStrength(pre,pic)) {
                    arr = pic.getKeyWords();
                    arr2 = pre.getKeyWords();
                    for(String a:arr){
                        for(String b:arr2){
                            if(a.equals(b))
                                pictureList.add(pic);
                        }
                    }
                }
            }
        }
        if (judgeSize(pictureList)) return null;
        int index = getRandomID(pictureList)-1;
        return pictureList.get(index);
    }

    private static boolean judgeSize(ArrayList sample) {
        if(sample.size()<=0)
            return true;
        return false;
    }

    public static Phrase getPositiveMainPoint(ArrayList<Phrase> phrases) {
        Phrase MainPoint;
        while(true){
            MainPoint = getMainPoint(phrases);
            if(MainPoint != null){
                if(MainPoint.getStrength()>=0)
                    break;
            }
        }
        return MainPoint;
    }

    public static Phrase getNegativeMainPoint(ArrayList<Phrase> phrases) {
        Phrase MainPoint;
        while(true){
            MainPoint = getMainPoint(phrases);
            if(MainPoint != null){
                if(MainPoint.getStrength()<0)
                    break;
            }
        }
        return MainPoint;
    }

    public static <T> int getRandomID(ArrayList<T> List){
         return (int)(Math.random()*List.size()+1);
    }

    public static Snippet getDefinition(ArrayList<Snippet> snippets){
        if(judgeSize(snippets))
            throw new IllegalArgumentException("List parameter has no elements");
        else{
        ArrayList<Snippet> sample = new ArrayList<Snippet>();
        for(Snippet snippet:snippets){
            if(snippet.getType().equals("definition")){
                sample.add(snippet);
            }
        }
        if(judgeSize(sample)){
            return null;
        }else{
            int index = getRandomID(sample)-1;
            return sample.get(index);}
        }
    }

    public static <T> ArrayList<T> remove(ArrayList<T> list, T object){
        if(judgeSize(list)||object==null){
            throw new IllegalArgumentException("illegal parameter");}
        else{
        Iterator<T> it = list.listIterator();
        while(it.hasNext()){
            T m = (T)it.next();
            if(m instanceof Phrase){
                Phrase p = (Phrase) m;
                Phrase obj = (Phrase) object;
                if(p.getPhraseID() == obj.getPhraseID())
                    it.remove();
            }
            if(m instanceof Snippet){
                Snippet p = (Snippet) m;
                Snippet obj = (Snippet) object;
                if(p.getSnippetID()==obj.getSnippetID())
                    it.remove();
            }
            if(m instanceof Picture){
                Picture p = (Picture) m;
                Picture obj = (Picture) object;
                if(p.getImageID()==obj.getImageID())
                    it.remove();
            }
        }
        return list;
        }
    }

    public  static <T> void addMaterial(ArrayList samples, T object) {
        if(object != null && samples !=null) samples.add(object);
    }

     @Nullable
     public static Objects selectObject(ArrayList<Objects> objectsList) {
         Objects target = null;
         int objectID = getRandomID(objectsList);
         for(Objects object: objectsList){
             if(object.getObjectID()==objectID) {
                 target = object;
             }
         }//can be optimised:  current time complexity O(n)
         return target;
     }
}
