package Chapter4;

public class Die {

    private int face;
    private int faces;

    public Die()
    {
        faces = 6;
        roll();
    }

    public Die(int faces)
    {
        this.faces = faces;
        roll();
    }

    public void roll() {
        face = (int)(Math.random()*faces+1);
        //System.out.println("The die rolled a " + face + ".");
    }

    public void setFaces(int f) { faces = f; }

    public int getFace() { return face; }
    public int getTotalFaces() { return faces; }

    public String toString() { return String.valueOf(face); }
}
