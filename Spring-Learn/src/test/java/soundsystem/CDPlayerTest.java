package soundsystem;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CDPlayerTest
{
    @Test
    public void cdShouldNotBeNull()
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
      //  ((CompactDisc)ctx.getBean("hahaha")).play();
       ((MediaPalyer)ctx.getBean("CDPlayer")).play();

    }
}
