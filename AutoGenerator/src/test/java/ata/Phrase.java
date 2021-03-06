package ata;

public class Phrase {
    private int PhraseID;
    private int Strength;
    private String Content;
    private String Type;
    private String PointTo;

    public Phrase(int PhraseID,int Strength, String Content, String Type, String PointTo){
        super();
        this.PhraseID = PhraseID;
        this.Strength = Strength;
        this.Content = Content;
        this.Type = Type;
        this.PointTo = PointTo;
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
}
