package fromBoris.screenSaver;

import java.awt.Color;
import java.util.Random;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "fromBoris.screenSaver")
public class Config {

  @Bean
  @Scope("prototype")
  public Color color() {
    Random random = new Random();
    return new Color(random.nextInt(255),random.nextInt(255), random.nextInt(255));
  }

  @Bean
  public AbstractColorFrame frame(){
    return new AbstractColorFrame() {
      @Override
      protected Color getColor() {
        return color();
      }
    };
  }

}
