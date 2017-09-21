package soundsystem;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CDPlayerXMLConfigTest
{
    @Test
    public void test()
    {
        ApplicationContext acx = new ClassPathXmlApplicationContext("beans.bean.xml");
        //  Assert.assertNotNull(acx.getBean("soundsystem.SgtPeppers#0"));
        // Assert.assertNotNull(acx.getBean("soundsystem.SgtPeppers#1"));
        ((CompactDisc) acx.getBean("companic")).play();
    }

    @Test
    public void testDI()
    {
        ApplicationContext acx = new ClassPathXmlApplicationContext("beans.bean.xml");
        Assert.assertNotNull(acx.getBean("cdPlayer"));
        // Assert.assertNotNull(acx.getBean("soundsystem.SgtPeppers#1"));
        ((MediaPalyer) acx.getBean("cdPlayer")).play();
    }

    @Test
    public void testDIValue()
    {
        ApplicationContext acx = new ClassPathXmlApplicationContext("beans.bean.xml");
        Assert.assertNotNull(acx.getBean("bankDisc"));
        // Assert.assertNotNull(acx.getBean("soundsystem.SgtPeppers#1"));
        ((MediaPalyer) acx.getBean("cdPlayer")).play();
    }

    @Test
    public void testSetValue()
    {
        ApplicationContext acx = new ClassPathXmlApplicationContext("beans.bean.xml");
        Object o = acx.getBean("cdPlayerSet");
        Object o1 = acx.getBean("cdPlayerSet");
        ((MediaPalyer) acx.getBean("cdPlayerSet")).play();
    }
}
