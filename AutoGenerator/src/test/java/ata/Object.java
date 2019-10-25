package ata;

import java.util.ArrayList;

public class Object {
    private String ObjectName;
    private int ObjectID;
    private ArrayList<Picture> Pictures;
    private ArrayList<Phrase> Phrases;
    private ArrayList<Snippet> Snippets;

    public Object(String ObjectName, int ObjectID, ArrayList<Picture> Pictures, ArrayList<Phrase> Phrases, ArrayList<Snippet> Snippets){
        super();
        this.ObjectName = ObjectName;
        this.ObjectID = ObjectID;
        this.Pictures = Pictures;
        this.Phrases = Phrases;
        this.Snippets = Snippets;
    }

    public String getObjectName() {
        return ObjectName;
    }

    public int getObjectID() {
        return ObjectID;
    }

    public ArrayList<Phrase> getPhrases() {
        return Phrases;
    }

    public ArrayList<Picture> getPictures() {
        return Pictures;
    }

    public ArrayList<Snippet> getSnippets() {
        return Snippets;
    }
}
