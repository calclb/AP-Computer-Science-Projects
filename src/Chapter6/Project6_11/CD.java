package Chapter6.Project6_11;

import java.text.NumberFormat;
public class CD
{
    private String title, artist;
    private double cost;
    private int tracks;
    //-----------------------------------------------------------------
// Creates a new CD with the specified information.
//-----------------------------------------------------------------
    public CD (String name, String singer, double price, int numTracks)
    {
        title = name;
        artist = singer;
        cost = price;
        tracks = numTracks;
    }
    //-----------------------------------------------------------------
// Returns a description of this CD.
//-----------------------------------------------------------------
    public String toString()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        String description;
        description = fmt.format(cost) + "\t" + tracks + "\t";
        description += title + "\t" + artist;
        return description;
    }

    // Added for title comparison
    public String getTitle() { return title; }
}