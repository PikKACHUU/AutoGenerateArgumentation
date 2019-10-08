package ata;

public class Snippet {
    private int SnippetID;
    private int Strength;
    private String Content;
    private String Type;
    private String PointTo;

    public Snippet(int SnippetID, int Strength, String Content, String Type, String PointTo){
        super();
        this.SnippetID = SnippetID;
        this.Content = Content;
        this.Strength = Strength;
        this.Type = Type;
        this.PointTo = PointTo;
    }

    public int getSnippetID() {
        return SnippetID;
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
