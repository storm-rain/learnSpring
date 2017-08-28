package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerConfig
{
    @Bean(name = "cdPlayer_Z")
    public MediaPalyer cdPlayer(CompactDisc zhoujl)
    {
        return new CDPlayer(zhoujl);
    }

    @Bean
    public MediaPalyer otherCdPlayer(CompactDisc segt)
    {
        return new CDPlayer(segt);
    }

    @Bean
    public CompactDisc segt()
    {
        return new SgtPeppers();
    }

    @Bean
    CompactDisc zhoujl()
    {
        return new Zhoujl();
        }
        }
