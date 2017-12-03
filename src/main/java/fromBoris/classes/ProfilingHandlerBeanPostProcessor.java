package fromBoris.classes;

import fromBoris.annotations.Profiling;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class ProfilingHandlerBeanPostProcessor implements BeanPostProcessor{

  private Map<String, Class> map = new HashMap<String, Class>();
  private ProfillingController controller = new ProfillingController();

  public ProfilingHandlerBeanPostProcessor() throws Exception {
    MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
    //Not work =(
    //platformMBeanServer.registerMBean(controller, new ObjectName("profiling","name", "controller"));
  }

  public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
    Class<?> aClass = o.getClass();
    if (aClass.isAnnotationPresent(Profiling.class)) {
      map.put(s, aClass);
    }
    return o;
  }

  public Object postProcessAfterInitialization(final Object o, String s) throws BeansException {


    if (!map.isEmpty()) {
      Class beanClass = map.get(s);
      if (beanClass != null) {

        return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(),
            new InvocationHandler() {

              public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                if (controller.isEnabled()) {
                  System.out.println("Profiling...");
                  long before = System.nanoTime();
                  Object retVal = method.invoke(o, args);
                  long after = System.nanoTime();
                  System.out.println(after-before);
                  System.out.println("End");
                  return retVal;
                } else {
                  return method.invoke(o, args);
                }
              }
            });
      }
    }
    return o;
  }
}
