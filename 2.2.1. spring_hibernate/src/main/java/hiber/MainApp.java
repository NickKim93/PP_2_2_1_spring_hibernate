package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      Car car1 = new Car("Toyota", 2010);
      user1.setUserCar(car1);
      userService.add(user1);
      System.out.println(userService.getUserByCar(car1));
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      Car car2 = new Car("Nissan", 2015);
      user2.setUserCar(car2);
      userService.add(user2);
      System.out.println(userService.getUserByCar(car2));
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      Car car3 = new Car("Tesla", 2010);
      user3.setUserCar(car3);
      userService.add(user3);
      System.out.println(userService.getUserByCar(car3));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      context.close();
   }
}
