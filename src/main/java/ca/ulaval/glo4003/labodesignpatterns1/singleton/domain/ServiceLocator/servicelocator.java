package ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.ServiceLocator;

import java.util.HashMap;
import java.util.Map;

public class servicelocator {
  public static final Map<Class<?>, Object> services = new HashMap<>();


  public servicelocator() {
  }

  public static <T> void registerSingleton(Class<T> contract, T service) {
    services.put(contract, service);
  }

  public static <T> T resolve(Class<? extends T> contract) {

    return (T) services.get(contract);
  }


  public static void reset() {
    services.clear();
  }

}
