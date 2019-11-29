package ata.Object;

public class Phrase {
    private int PhraseID;
    private int Strength;
    private String Content;
    private String Type;
    private String PointTo;
    private String[] KeyWords;
    public Phrase(int PhraseID,int Strength, String Content, String Type, String PointTo, String[] KeyWords){
        super();
        this.PhraseID = PhraseID;
        this.Strength = Strength;
        this.Content = Content;
        this.Type = Type;
        this.PointTo = PointTo;
        this.KeyWords = KeyWords;
    }

    public int getPhraseID() {
        return PhraseID;
    }

    public int getStrength() {
        return Strength;
    }

    public String getContent() {
        return Content;
    }

    public String getType() {
        return Type;
    }

    public String getPointTo() {
        return PointTo;
    }

    public String[] getKeyWords() {
        return KeyWords;
    }

    public void setContent(String content) {
        Content = content;
    }

    public void setKeyWords(String[] keyWords) {
        KeyWords = keyWords;
    }

    public void setPhraseID(int phraseID) {
        PhraseID = phraseID;
    }

    public void setPointTo(String pointTo) {
        PointTo = pointTo;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }

    public void setType(String type) {
        Type = type;
    }

    @Override
    public String toString() {
        return PhraseID+" "+Content;
    }
}
