package fromBoris.screenSaver;

import java.awt.Color;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class ColorFrame extends JFrame {

  @Autowired
  private Color color;

  public ColorFrame() {
    setSize(200, 200);
    setVisible(true);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }

  public void showOnRandomPase() {
    Random random = new Random();
    setLocation(random.nextInt(1200), random.nextInt(700));
    getContentPane().setBackground(color);
    repaint();
  }
}
