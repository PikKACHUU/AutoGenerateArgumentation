package ata.Object;

import java.util.ArrayList;

public class Objects {
    private String ObjectName;
    private int ObjectID;
    private ArrayList<Picture> Pictures;
    private ArrayList<Phrase> Phrases;
    private ArrayList<Snippet> Snippets;

    public Objects(String ObjectName, int ObjectID, ArrayList<Picture> Pictures, ArrayList<Phrase> Phrases, ArrayList<Snippet> Snippets){
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

    public void setObjectID(int objectID) {
        ObjectID = objectID;
    }

    public void setObjectName(String objectName) {
        ObjectName = objectName;
    }

    public void setPhrases(ArrayList<Phrase> phrases) {
        Phrases = phrases;
    }

    public void setPictures(ArrayList<Picture> pictures) {
        Pictures = pictures;
    }

    public void setSnippets(ArrayList<Snippet> snippets) {
        Snippets = snippets;
    }

    @Override
    public String toString() {
        return ObjectName+" "+ObjectID;
    }
}
