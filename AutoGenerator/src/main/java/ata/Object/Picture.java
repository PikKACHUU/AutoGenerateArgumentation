package ata.Object;

public class Picture {
    private int ImageID;
    private int Strength;
    private String PointTo;
    private String URL;
    private String[] KeyWords;

    public Picture(int ImageID, int Strength, String PointTo, String URL,  String[] KeyWords){
        super();
        this.ImageID = ImageID;
        this.Strength = Strength;
        this.PointTo = PointTo;
        this.URL = URL;
        this.KeyWords = KeyWords;
    }

    public int getImageID() {
        return ImageID;
    }

    public int getStrength() {
        return Strength;
    }

    public String getPointTo() {
        return PointTo;
    }

    public String getURL() {
        return URL;
    }

    public String[] getKeyWords() {
        return KeyWords;
    }
}
