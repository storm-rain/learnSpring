package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class CDPlayer implements MediaPalyer
{
    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd)
    {
        this.cd = cd;
    }

    public CDPlayer()
    {
    }

    public void setCd(CompactDisc cd)
    {
        this.cd = cd;
    }

    public void play()
    {
        cd.play();
    }
}
