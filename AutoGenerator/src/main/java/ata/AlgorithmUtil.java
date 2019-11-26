package ata;

import java.util.ArrayList;
import java.util.Iterator;

public class AlgorithmUtil {

    public static <T> ArrayList addObj(ArrayList sample, T object ){
        if(object != null){
            sample.add(object);
        }
        return sample;
    }

    public static <T> Picture getPicture(ArrayList<Picture> sample, T PreObject){
        String[] arr;
        String[] arr2;
        if(PreObject instanceof Phrase) {
            Phrase pre = (Phrase) PreObject;
            for (Picture pic : sample) {
                if (pic.getPointTo() == pre.getPointTo()) {
                    arr = pic.getKeyWords();
                    arr2 = pre.getKeyWords();
                    for(String a:arr){
                        for(String b:arr2){
                            if(a.equals(b))
                                return pic;
                        }
                    }
                }
            }
        }else if(PreObject instanceof Snippet) {
            Snippet pre = (Snippet) PreObject;
            for (Picture pic : sample) {
                if (pic.getPointTo() == pre.getPointTo()) {
                    arr = pic.getKeyWords();
                    arr2 = pre.getKeyWords();
                    for(String a:arr){
                        for(String b:arr2){
                            if(a.equals(b))
                                return pic;
                        }
                    }
                }
            }
        }else if(PreObject instanceof Picture) {
            Picture pre = (Picture) PreObject;
            for (Picture pic : sample) {
                if (pic.getPointTo() == pre.getPointTo()) {
                    arr = pic.getKeyWords();
                    arr2 = pre.getKeyWords();
                    for(String a:arr){
                        for(String b:arr2){
                            if(a.equals(b))
                                return pic;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static <T> int getRandomID(ArrayList<T> List ){
         return (int)(Math.random()*List.size()+1);
    }

    public static Snippet getDefinition(ArrayList<Snippet> snippets){
        if(snippets.size()<=0)
            return null;
        else{
        ArrayList<Snippet> sample = new ArrayList<Snippet>();
        for(Snippet snippet:snippets){
            if(snippet.getType().equals("definition")){
                sample.add(snippet);
            }
        }
        if(sample.size()>0){
        int index = getRandomID(sample)-1;
        return sample.get(index);
        }else
            return null;
        }
    }

    public static <T> ArrayList<T> remove(ArrayList<T> list, T object){
        if(list.size()<=0){
            System.out.println("Input ArrayList parameter of method remove() do not contain elements.");
            return list;}
        else{
        Iterator<T> it = list.listIterator();
        while(it.hasNext()){
            if((T)it.next() instanceof Phrase){
                Phrase p = (Phrase) it;
                Phrase obj = (Phrase) object;
                if(p.getPhraseID()==obj.getPhraseID())
                    it.remove();
            }
            if((T)it.next() instanceof Snippet){
                Snippet p = (Snippet) it;
                Snippet obj = (Snippet) object;
                if(p.getSnippetID()==obj.getSnippetID())
                    it.remove();
            }
            if((T)it.next() instanceof Picture){
                Picture p = (Picture) it;
                Picture obj = (Picture) object;
                if(p.getImageID()==obj.getImageID())
                    it.remove();
            }
        }
        return list;
        }
    }
}
