package ata.Util;

import ata.Object.*;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class AlgorithmUtil {

     public static <T> T get(ArrayList<T> objects, String key, String Strength){
         ArrayList<T> sample = new ArrayList<T>();
         if(judgeSize(objects)) throw new IllegalArgumentException("List parameter has no elements");
         if(key==null) throw new IllegalArgumentException();
         switch(Strength){
             case "positive":
                 for(T object:objects){
                     if(object instanceof Phrase){
                         Phrase target = (Phrase) object;
                         if((target.getType().equals(key) ||target.getPointTo().equals(key)) && target.getStrength()>=0){
                             sample.add(object);
                         }
                     }
                     if(object instanceof Snippet){
                         Snippet target = (Snippet) object;
                         if((target.getType().equals(key) ||target.getPointTo().equals(key)) && target.getStrength()>=0){
                             sample.add(object);
                         }
                     }
                     if(object instanceof Picture){
                         Picture target = (Picture) object;
                         if(target.getPointTo().equals(key) && target.getStrength()>=0){
                             sample.add(object);
                         }
                     }
                 }
                 break;
             case "negative":
                 for(T object:objects){
                     if(object instanceof Phrase){
                         Phrase target = (Phrase) object;
                         if((target.getType().equals(key) ||target.getPointTo().equals(key)) && target.getStrength()<0){
                             sample.add(object);
                         }
                     }
                     if(object instanceof Snippet){
                         Snippet target = (Snippet) object;
                         if((target.getType().equals(key) ||target.getPointTo().equals(key)) && target.getStrength()<0){
                             sample.add(object);
                         }
                     }
                     if(object instanceof Picture){
                         Picture target = (Picture) object;
                         if(target.getPointTo().equals(key) && target.getStrength()<0){
                             sample.add(object);
                         }
                     }
                 }
                 break;
             default:
                 System.out.println("Illegal parameter String Strength");
                 throw new IllegalArgumentException();
         }
         if(judgeSize(sample)) {
             System.out.println("No material is find with Key "+key+" in method get(ArrayList<T> objects, String key, String strength)");
             return null;}
         int index = getRandomID(sample)-1;
         return sample.get(index);

     }
     //get a material from ArrayList according to two features

     public static <T> T get(ArrayList<T> objects,  String key){
         ArrayList<T> sample = new ArrayList<T>();
         if(judgeSize(objects)) throw new IllegalArgumentException("List parameter has no elements");
         switch(key){
             case "positive":
                 for(T object:objects){
                     if(object instanceof Phrase){
                         Phrase target = (Phrase) object;
                         if(target.getStrength()>=0){
                             sample.add(object);
                         }
                     }
                     if(object instanceof Snippet){
                         Snippet target = (Snippet) object;
                         if( target.getStrength()>=0){
                             sample.add(object);
                         }
                     }
                     if(object instanceof Picture){
                         Picture target = (Picture) object;
                         if( target.getStrength()>=0){
                             sample.add(object);
                         }
                     }
                 }
                 break;
             case "negative":
                 for(T object:objects){
                     if(object instanceof Phrase){
                         Phrase target = (Phrase) object;
                         if(target.getStrength()<0){
                             sample.add(object);
                         }
                     }
                     if(object instanceof Snippet){
                         Snippet target = (Snippet) object;
                         if(target.getStrength()<0){
                             sample.add(object);
                         }
                     }
                     if(object instanceof Picture){
                         Picture target = (Picture) object;
                         if(target.getStrength()<0){
                             sample.add(object);
                         }
                     }
                 }
                 break;
             default:
                 for(T object:objects){
                     if(object instanceof Phrase){
                         Phrase target = (Phrase) object;
                         if(target.getType().equals(key) || target.getPointTo().equals(key)){
                             sample.add(object);
                         }
                     }
                     if(object instanceof Snippet){
                         Snippet target = (Snippet) object;
                         if(target.getType().equals(key) || target.getPointTo().equals(key)){
                             sample.add(object);
                         }
                     }
                     if(object instanceof Picture){
                         Picture target = (Picture) object;
                         if(target.getPointTo().equals(key) || target.getPointTo().equals(key)){
                             sample.add(object);
                         }
                     }
                 }
         }
         if(judgeSize(sample)) {
             System.out.println("No material is find with Key "+key+" in method get(ArrayList<T> objects, String key)");
             return null;}
         int index = getRandomID(sample)-1;
         return sample.get(index);

     }
     //get amaterial from ArrayList according to one  feature

     public static <T> T get(ArrayList<T> objects, String type,String PointTo, String Strength){
         ArrayList<T> sample = new ArrayList<T>();
         if(judgeSize(objects)) throw new IllegalArgumentException("List parameter has no elements");
         if(type==null || PointTo ==null) throw new IllegalArgumentException();
         switch(Strength){
             case "positive":
                 for(T object:objects){
                     if(object instanceof Phrase){
                         Phrase target = (Phrase) object;
                         if(target.getType().equals(type) && target.getPointTo().equals(PointTo) && target.getStrength()>=0){
                             sample.add(object);
                         }
                     }
                     if(object instanceof Snippet){
                         Snippet target = (Snippet) object;
                         if(target.getType().equals(type) && target.getPointTo().equals(PointTo) && target.getStrength()>=0){
                             sample.add(object);
                         }
                     }
                     if(object instanceof Picture){
                         throw new IllegalArgumentException("Picture is illegal in get(ArrayList<T> objects, String type,String PointTo, String Strength)");
                         }
                     }
                 break;
             case "negative":
                 for(T object:objects){
                     if(object instanceof Phrase){
                         Phrase target = (Phrase) object;
                         if(target.getType().equals(type) && target.getPointTo().equals(PointTo) && target.getStrength()<0){
                             sample.add(object);
                         }
                     }
                     if(object instanceof Snippet){
                         Snippet target = (Snippet) object;
                         if(target.getType().equals(type) && target.getPointTo().equals(PointTo) && target.getStrength()<0){
                             sample.add(object);
                         }
                     }
                     if(object instanceof Picture){
                         throw new IllegalArgumentException("Picture is illegal in get(ArrayList<T> objects, String type,String PointTo, String Strength)");
                     }
                     }
                 break;
             default:
                 System.out.println("Illegal parameter String Strength");
                 throw new IllegalArgumentException();
         }
         if(judgeSize(sample)) {
             System.out.println("No material is find with Key "+type+" in method get(ArrayList<T> objects, String key, String strength)");
             return null;}
         int index = getRandomID(sample)-1;
         return sample.get(index);

     }
     //get a material from ArrayList according to three features

     public static <T> T get(ArrayList<T> objects,  int ObjectID){
         if(judgeSize(objects)) throw new IllegalArgumentException("List parameter has no elements");
                 for(T object:objects){
                     if(object instanceof Phrase){
                         Phrase target = (Phrase) object;
                         if(target.getPhraseID() == ObjectID){
                            return object;
                         }
                     }
                     if(object instanceof Snippet){
                         Snippet target = (Snippet) object;
                         if(target.getSnippetID() == ObjectID){
                             return object;
                         }
                     }
                     if(object instanceof Picture){
                         Picture target = (Picture) object;
                         if(target.getImageID() == ObjectID){
                             return object;
                         }
                     }
                 }
                 System.out.println("Can not find object with ID " + ObjectID+" in ArrayList with method get(ArrayList<T> objects,  int ObjectID)");
                 return null;
     }
     //get a material from ArrayList according to ObjectID

     public static <T> T get(ArrayList<T> objects, Object PreObject) {
        if (judgeSize(objects) || PreObject == null)
            throw new IllegalArgumentException("List parameter has no elements");
         ArrayList<Double> MatchRateArray = new ArrayList<Double>();
         for(int i =0;i<objects.size();i++){
             MatchRateArray.add(0.0);
         }
         ArrayList<T> List = new ArrayList<T>();
         double maxRate = 0;
         double rate;
         int index = 0;
        if (PreObject instanceof Phrase) {
            Phrase pre = (Phrase) PreObject;
            for (T object : objects) {
                if (object instanceof Picture) {
                    Picture target = (Picture) object;
                    if (target.getPointTo().equals(pre.getPointTo()) && judgeStrength(pre, target)) {
                        rate = CalMatchRate(pre, target);
                        maxRate=getMaxRate(maxRate, rate);
                         MatchRateArray.set(index,rate);
                    }
                }
                if (object instanceof Phrase) {
                    Phrase target = (Phrase) object;
                    if (target.getPointTo().equals(pre.getPointTo()) && judgeStrength(pre, target)) {
                        rate = CalMatchRate(pre, target);
                        maxRate=getMaxRate(maxRate, rate);
                        MatchRateArray.set(index,rate);
                    }
                }
                if (object instanceof Snippet) {
                    Snippet target = (Snippet) object;
                    if (target.getPointTo().equals(pre.getPointTo()) && judgeStrength(pre, target)) {
                        rate = CalMatchRate(pre, target);
                        maxRate=getMaxRate(maxRate, rate);
                        MatchRateArray.set(index,rate);
                    }
                }
                 index++;
            }
        } else if (PreObject instanceof Snippet) {
            Snippet pre = (Snippet) PreObject;
            for (T object : objects) {
                if (object instanceof Picture) {
                    Picture target = (Picture) object;
                    if (target.getPointTo().equals(pre.getPointTo()) && judgeStrength(pre, target)) {
                        rate = CalMatchRate(pre, target);
                        maxRate=getMaxRate(maxRate, rate);
                        MatchRateArray.set(index,rate);
                    }
                }
                if (object instanceof Phrase) {
                    Phrase target = (Phrase) object;
                    if (target.getPointTo().equals(pre.getPointTo()) && judgeStrength(pre, target)) {
                        rate = CalMatchRate(pre, target);
                        maxRate=getMaxRate(maxRate, rate);
                        MatchRateArray.set(index,rate);
                    }
                }
                if (object instanceof Snippet) {
                    Snippet target = (Snippet) object;
                    if (target.getPointTo().equals(pre.getPointTo()) && judgeStrength(pre, target)) {
                        rate = CalMatchRate(pre, target);
                        maxRate=getMaxRate(maxRate, rate);
                        MatchRateArray.set(index,rate);
                    }
                }
                index++;
            }
        } else if (PreObject instanceof Picture) {
            Picture pre = (Picture) PreObject;
            for (T object : objects) {
                if (object instanceof Picture) {
                    Picture target = (Picture) object;
                    if (target.getPointTo().equals(pre.getPointTo()) && judgeStrength(pre, target)) {
                        rate = CalMatchRate(pre, target);
                        maxRate=getMaxRate(maxRate, rate);
                        MatchRateArray.set(index,rate);
                    }
                }
                if (object instanceof Phrase) {
                    Phrase target = (Phrase) object;
                    if (target.getPointTo().equals(pre.getPointTo()) && judgeStrength(pre, target)) {
                        rate = CalMatchRate(pre, target);
                        maxRate=getMaxRate(maxRate, rate);
                        MatchRateArray.set(index,rate);
                    }
                }
                if (object instanceof Snippet) {
                    Snippet target = (Snippet) object;
                    if (target.getPointTo().equals(pre.getPointTo()) && judgeStrength(pre, target)) {
                        rate = CalMatchRate(pre, target);
                        maxRate=getMaxRate(maxRate, rate);
                        MatchRateArray.set(index,rate);
                    }
                }
                index++;
            }
        }
         if(maxRate!=0){
         for(int i=0;i<MatchRateArray.size();i++){
             if(MatchRateArray.get(i)==maxRate)
                 List.add(objects.get(i));
         }
         }
         if (judgeSize(List)) {
             System.out.println("No matched object is found");
             return null;
         }
         int Index = getRandomID(List) - 1;
         return List.get(Index);
     }

     public static <T> T get(ArrayList<T> objects, Object PreObject, String type) {
         if (judgeSize(objects) || PreObject == null)
             throw new IllegalArgumentException("List parameter has no elements");
         ArrayList<Double> MatchRateArray = new ArrayList<Double>();
         for(int i =0;i<objects.size();i++){
             MatchRateArray.add(0.0);
         }
         ArrayList<T> List = new ArrayList<T>();
         double maxRate = 0;
         double rate;
         int index=0;
         if (PreObject instanceof Phrase) {
             Phrase pre = (Phrase) PreObject;
             for (T object : objects) {
                 if (object instanceof Picture) {
                     Picture target = (Picture) object;
                     if (target.getPointTo().equals(pre.getPointTo()) && judgeStrength(pre, target)) {
                         rate = CalMatchRate(pre, target);
                         maxRate=getMaxRate(maxRate, rate);
                         MatchRateArray.set(index,rate);
                     }
                 }
                 if (object instanceof Phrase) {
                     Phrase target = (Phrase) object;
                     if (target.getType().equals(type) && target.getPointTo().equals(pre.getPointTo()) && judgeStrength(pre, target)) {
                         rate = CalMatchRate(pre, target);
                         maxRate=getMaxRate(maxRate, rate);
                         MatchRateArray.set(index,rate);
                     }
                 }
                 if (object instanceof Snippet) {
                     Snippet target = (Snippet) object;
                     if (target.getType().equals(type) && target.getPointTo().equals(pre.getPointTo()) && judgeStrength(pre, target)) {
                         rate = CalMatchRate(pre, target);
                         maxRate=getMaxRate(maxRate, rate);
                         MatchRateArray.set(index,rate);
                     }
                 }
                 index++;
             }
         } else if (PreObject instanceof Snippet) {
             Snippet pre = (Snippet) PreObject;
             for (T object : objects) {
                 if (object instanceof Picture) {
                     Picture target = (Picture) object;
                     if (target.getPointTo().equals(pre.getPointTo()) && judgeStrength(pre, target)) {
                         rate = CalMatchRate(pre, target);
                         maxRate=getMaxRate(maxRate, rate);
                         MatchRateArray.set(index,rate);
                     }
                 }
                 if (object instanceof Phrase) {
                     Phrase target = (Phrase) object;
                     if (target.getType().equals(type) && target.getPointTo().equals(pre.getPointTo()) && judgeStrength(pre, target)) {
                         rate = CalMatchRate(pre, target);
                         maxRate=getMaxRate(maxRate, rate);
                         MatchRateArray.set(index,rate);
                     }
                 }
                 if (object instanceof Snippet) {
                     Snippet target = (Snippet) object;
                     if (target.getType().equals(type) && target.getPointTo().equals(pre.getPointTo()) && judgeStrength(pre, target)) {
                         rate = CalMatchRate(pre, target);
                         maxRate=getMaxRate(maxRate, rate);
                         MatchRateArray.set(index,rate);
                     }
                 }
                 index++;
             }
         } else if (PreObject instanceof Picture) {
             Picture pre = (Picture) PreObject;
             for (T object : objects) {
                 if (object instanceof Picture) {
                     Picture target = (Picture) object;
                     if (target.getPointTo().equals(pre.getPointTo()) && judgeStrength(pre, target)) {
                         rate = CalMatchRate(pre, target);
                         maxRate=getMaxRate(maxRate, rate);
                         MatchRateArray.set(index,rate);
                     }
                 }
                 if (object instanceof Phrase) {
                     Phrase target = (Phrase) object;
                     if (target.getType().equals(type) && target.getPointTo().equals(pre.getPointTo()) && judgeStrength(pre, target)) {
                         rate = CalMatchRate(pre, target);
                         maxRate=getMaxRate(maxRate, rate);
                         MatchRateArray.set(index,rate);
                     }
                 }
                 if (object instanceof Snippet) {
                     Snippet target = (Snippet) object;
                     if (target.getType().equals(type) && target.getPointTo().equals(pre.getPointTo()) && judgeStrength(pre, target)) {
                         rate = CalMatchRate(pre, target);
                         maxRate=getMaxRate(maxRate, rate);
                         MatchRateArray.set(index,rate);
                     }
                 }
                 index++;
             }
         }
         if(maxRate!=0){
             for(int i=0;i<MatchRateArray.size();i++){
                 if(MatchRateArray.get(i)==maxRate)
                     List.add(objects.get(i));
             }
         }
         if (judgeSize(List)) {
             System.out.println("No matched object is found");
             return null;
         }
         int Index = getRandomID(List) - 1;
         return List.get(Index);
     }

     private static double getMaxRate(double maxRate, double rate) {
         if(rate>maxRate) maxRate =rate;
         return (double)maxRate;
     }

     private static <K,V> double CalMatchRate(K k, V v) {
         String[] arr;
         String[] arr2;
         int counter=0;
         if(k instanceof Phrase && v instanceof Snippet){
             Phrase phrase = (Phrase) k;
             Snippet snippet = (Snippet) v;
             arr = phrase.getKeyWords();
             arr2 = snippet.getKeyWords();
             for(String a:arr){
                 for(String b:arr2){
                     if(a.equals(b))
                         counter++;
                 }
             }
             return (double)counter/arr.length;
         }
         else if(k instanceof Phrase && v instanceof Phrase){
             Phrase phrase = (Phrase) k;
             Phrase phrase1 = (Phrase) v;
             arr = phrase.getKeyWords();
             arr2 = phrase1.getKeyWords();
             for(String a:arr){
                 for(String b:arr2){
                     if(a.equals(b))
                         counter++;
                 }
             }
             return (double)counter/arr.length;
         }
         else if(k instanceof Phrase && v instanceof Picture){
             Phrase phrase = (Phrase) k;
             Picture picture = (Picture) v;
             arr = phrase.getKeyWords();
             arr2 = picture.getKeyWords();
             for(String a:arr){
                 for(String b:arr2){
                     if(a.equals(b))
                         counter++;
                 }
             }
             return (double)counter/arr.length;
         }
         else if(k instanceof Snippet && v instanceof Picture){
             Snippet snippet = (Snippet) k;
             Picture picture = (Picture) v;
             arr = snippet.getKeyWords();
             arr2 = picture.getKeyWords();
             for(String a:arr){
                 for(String b:arr2){
                     if(a.equals(b))
                         counter++;
                 }
             }
             return (double)counter/arr.length;
         }
         else if(k instanceof Snippet && v instanceof Phrase){
             Snippet snippet = (Snippet) k;
             Phrase phrase = (Phrase) v;
             arr = snippet.getKeyWords();
             arr2 = phrase.getKeyWords();
             for(String a:arr){
                 for(String b:arr2){
                     if(a.equals(b))
                         counter++;
                 }
             }
             return (double)counter/arr.length;
         }
         else if(k instanceof Snippet && v instanceof Snippet) {
             Snippet snippet = (Snippet) k;
             Snippet snippet2 = (Snippet) v;
             arr = snippet.getKeyWords();
             arr2 = snippet2.getKeyWords();
             for(String a:arr){
                 for(String b:arr2){
                     if(a.equals(b))
                         counter++;
                 }
             }
             return (double)counter/arr.length;
         }
         else if(k instanceof Picture && v instanceof Snippet) {
             Picture pic = (Picture) k;
             Snippet snippet = (Snippet) v;
             arr = pic.getKeyWords();
             arr2 = snippet.getKeyWords();
             for(String a:arr){
                 for(String b:arr2){
                     if(a.equals(b))
                         counter++;
                 }
             }
             return (double)counter/arr.length;
         }
         else if(k instanceof Picture && v instanceof Phrase) {
             Picture pic = (Picture) k;
             Phrase phrase = (Phrase) v;
             arr = pic.getKeyWords();
             arr2 = phrase.getKeyWords();
             for(String a:arr){
                 for(String b:arr2){
                     if(a.equals(b))
                         counter++;
                 }
             }
             return (double)counter/arr.length;
         }
         else if(k instanceof Picture && v instanceof Picture) {
             Picture pic = (Picture) k;
             Picture pic2 = (Picture) v;
             arr = pic.getKeyWords();
             arr2 = pic2.getKeyWords();
             for(String a:arr){
                 for(String b:arr2){
                     if(a.equals(b))
                         counter++;
                 }
             }
             return (double)counter/arr.length;
         }
         else
             throw new IllegalArgumentException();
     }

     private static boolean judgeSize(ArrayList sample) {
        if(sample.size()<=0)
            return true;
        return false;
    }

     public static <T> int getRandomID(ArrayList<T> List){
         return (int)(Math.random()*List.size()+1);
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

     public static <T> String[] removeMatchedKeyWords(String[] arr, T object){
         ArrayList<String> list = new ArrayList<String>();
         String[] result;
         String[] sample = null;
         if(object instanceof Phrase) {
             Phrase target = (Phrase) object;
             sample = target.getKeyWords();
         }
         if(object instanceof Snippet) {
             Snippet target = (Snippet) object;
             sample = target.getKeyWords();
         }
         if(object instanceof Picture) {
             Picture target = (Picture) object;
             sample = target.getKeyWords();
         }
         for(String a:arr){
             list.add(a);
         }
         for(String a:sample){
             if(list.contains(a))
                 list.remove(a);
         }
         result = new String[list.size()];
         Arrays.setAll(result,list::get);
         return result;
     }

     public  static <T> boolean addMaterial(ArrayList samples, T object) {
        if(object != null && samples !=null){
            samples.add(object);
            return true;
        }
        else
            return false;
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
         }
         else if(k instanceof Snippet && v instanceof Phrase){
             Snippet snippet = (Snippet) k;
             Phrase phrase = (Phrase) v;
             if(snippet.getStrength()*phrase.getStrength()>=0)
                 return true;
         }
         else if(k instanceof Snippet && v instanceof Snippet) {
             Snippet snippet = (Snippet) k;
             Snippet snippet2 = (Snippet) v;
             if (snippet.getStrength() * snippet2.getStrength() >= 0)
                 return true;
         }
         else if(k instanceof Picture && v instanceof Snippet) {
             Picture pic = (Picture) k;
             Snippet snippet = (Snippet) v;
             if (pic.getStrength() * snippet.getStrength() >= 0)
                 return true;
         }
         else if(k instanceof Picture && v instanceof Phrase) {
             Picture pic = (Picture) k;
             Phrase phrase = (Phrase) v;
             if (pic.getStrength() * phrase.getStrength() >= 0)
                 return true;
         }
         else if(k instanceof Picture && v instanceof Picture) {
             Picture pic = (Picture) k;
             Picture pic2 = (Picture) v;
             if (pic.getStrength() * pic2.getStrength() >= 0)
                 return true;
         }
         else
             throw new IllegalArgumentException();
         return false;
     }

     @Nullable
     public static Objects RandomSelectObject(ArrayList<Objects> objectsList) {
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
