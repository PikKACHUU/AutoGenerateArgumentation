package ata.Object;

public class Snippet {
    private int SnippetID;
    private int Strength;
    private String Content;
    private String Type;
    private String PointTo;
    private String[] KeyWords;

    public Snippet(int SnippetID, int Strength, String Content, String Type, String PointTo, String[] KeyWords) {
        super();
        this.SnippetID = SnippetID;
        this.Content = Content;
        this.Strength = Strength;
        this.Type = Type;
        this.PointTo = PointTo;
        this.KeyWords = KeyWords;
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

    public String[] getKeyWords() {
        return KeyWords;
    }

    public void setKeyWords(String[] keyWords) {
        KeyWords = keyWords;
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

    public void setContent(String content) {
        Content = content;
    }

    public void setSnippetID(int snippetID) {
        SnippetID = snippetID;
    }

    @Override
    public String toString() {
        return SnippetID+" "+Content;
    }
}
