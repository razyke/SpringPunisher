package fromBoris.screenSaver;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class PeriodicalScopeConfigurer implements Scope {
  Map<String, Pair<LocalTime, Object>> map =  new HashMap<>();


  public Object get(String s, ObjectFactory<?> objectFactory) {
    if (map.containsKey(s)) {
      Pair<LocalTime, Object> pair = map.get(s);
      int secondsSinceLast = LocalTime.now().getSecond() - pair.getKey().getSecond();
      if (secondsSinceLast > 3) {
        map.put(s, new Pair<>(LocalTime.now(), objectFactory.getObject()));
      }
    }else {
        map.put(s, new Pair<>(LocalTime.now(), objectFactory.getObject()));
      }

    return map.get(s).getValue();
  }

  public Object remove(String s) {
    return null;
  }

  public void registerDestructionCallback(String s, Runnable runnable) {

  }

  public Object resolveContextualObject(String s) {
    return null;
  }

  public String getConversationId() {
    return null;
  }
}
