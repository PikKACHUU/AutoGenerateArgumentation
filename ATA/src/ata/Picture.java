package ata;

public class Picture {
    private int ImageID;
    private int Strength;
    private String PointTo;
    private String URL;

    public Picture(int ImageID, int Strength, String PointTo, String URL){
        super();
        this.ImageID = ImageID;
        this.Strength = Strength;
        this.PointTo = PointTo;
        this.URL = URL;
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
}
