import database.DataBase;
import role.BookRole;
import role.UserRole;
import templates.Book;
import templates.User;

import static role.UserRole.ADMIN;

public class Main {
    static User user = new User();

    static DataBase db = DataBase.getDataBase();
    public static void main(String[] args) {
        user.setName("John");
        user.setRole(ADMIN);
        user.setAge(20);




        user.setPassword("123");
        user.setUsername("ali");
        db.users.add(user);

        controllers.MainController.mainController();
    }
    static User user1 = new User("ali","aa","1234", UserRole.USER);
}
