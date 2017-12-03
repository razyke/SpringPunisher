package fromBoris.classes;

import fromBoris.annotations.PostProxyListener;
import java.lang.reflect.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class PostProxyInvocation implements ApplicationListener<ContextRefreshedEvent> {

  @Autowired
  private ConfigurableListableBeanFactory factory;

  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

    ApplicationContext context = contextRefreshedEvent.getApplicationContext();

    String[] names = context.getBeanDefinitionNames();

    for (String name : names) {

      BeanDefinition beanDefinition = factory.getBeanDefinition(name);

      String beanClassName = beanDefinition.getBeanClassName();

      try {
        Class<?> originalClass = Class.forName(beanClassName);
        Method[] declaredMethods = originalClass.getMethods();

        for (Method method : declaredMethods) {

          if (method.isAnnotationPresent(PostProxyListener.class)) {
            Object bean = context.getBean(name);
            Method currenMethod = bean.getClass()
                .getMethod(method.getName(), method.getParameterTypes());

            currenMethod.invoke(bean);
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }


    }
  }
}
