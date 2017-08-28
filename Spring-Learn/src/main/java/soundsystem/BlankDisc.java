package soundsystem;

public class BlankDisc implements CompactDisc
{
    private String title;
    private String artist;

    public BlankDisc(String title, String artist)
    {
        this.artist = artist;
        this.title = title;
    }

    public void play()
    {
        System.out.println("playing " + title + " by " + artist);
    }
}
