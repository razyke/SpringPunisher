package fromBoris.classes;

import fromBoris.interfaces.ProfillingControllerMBean;

public class ProfillingController implements ProfillingControllerMBean {

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  private boolean enabled;

}
