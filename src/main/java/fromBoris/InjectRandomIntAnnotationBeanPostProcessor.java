package fromBoris;

import java.lang.reflect.Field;
import java.util.Random;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

  public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
    Field[] fields = o.getClass().getDeclaredFields();
    for (Field f :
        fields) {
      InjectRandomInt annotation = f.getAnnotation(InjectRandomInt.class);
      if (annotation != null) {
        int min = annotation.min();
        int max = annotation.max();
        Random random = new Random();
        int i = min + random.nextInt(max - min);
        f.setAccessible(true);
        ReflectionUtils.setField(f, o, i);
      }
    }
    return o;
  }

  public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
    return o;
  }
}
