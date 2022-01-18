package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Denis", "Tsybanov", "denis@.com");
      User user2 = new User("Karina", "Stepanova", "karina@.com");
      User user3 = new User("Sasha", "Ivanov", "sasha@.com");
      User user4 = new User("Roma", "Kalinin", "roma@.com");

      Car car1 = new Car("Lada", 2112);
      Car car2 = new Car("BMW", 5);
      Car car3 = new Car("Mersedes", 240);
      Car car4 = new Car("Nissan", 03);

      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));
      System.out.println(userService.userCar("Lada", 2112));

      context.close();
   }
}
