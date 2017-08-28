package soundsystem;

import java.util.List;

public class BankActualPalyer implements CompactDisc
{
    private String title;
    private String artist;
    private List<CompactDisc> compactDiscList;

    public BankActualPalyer(String title, String artist, List<CompactDisc> listCompanics)
    {
        this.artist = artist;
        this.title = title;
        this.compactDiscList = listCompanics;
    }

    public void play()
    {
        for (CompactDisc compactDisc : compactDiscList)
        {
            compactDisc.play();
        }
    }
}
