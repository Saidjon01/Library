package controllers;

import database.DataBase;
import templates.User;

import static role.UserRole.ADMIN;
import static role.UserRole.USER;

public class MainController {
    static AdminController adminController = new AdminController();
    static UserController userController = new UserController();
    static DataBase db = DataBase.getDataBase();

    public static void mainController() {

        while (true) {
            System.out.println( db.RED + "0 - exit"+ db.RESET);
            System.out.println(db.CYAN + "1 - sign in");
            System.out.println("2 - sign up" + db.RESET);

            switch (db.intScanner.nextInt()) {
                case 0:
                    System.out.println(db.YELLOW + "good bye" + db.RESET);
                    return;
                case 1:
                    signIn();
                    break;
                case 2:
                    SignUp();
                    break;
            }
        }

    }

    private static void SignUp() {
        User user = new User();

        System.out.print("Enter name: ");
        String name = db.strScanner.nextLine();
        user.setName(name);

        System.out.print("Enter username: ");
        String username = db.strScanner.nextLine();


        System.out.print("Enter password: ");
        String password = db.strScanner.nextLine();
        if (db.isUniqueUser(username, password)) {
            user.setPassword(password);
            user.setUsername(username);
        } else {
            System.out.println(db.RED + "Password or username is not unique" + db.RESET);

            System.out.println("main menu = 1");
            System.out.println("try again = 2");
            switch (db.intScanner.nextInt()) {
                case 1:
                    MainController.mainController();
                    break;
                case 2:
                    MainController.SignUp();
                    break;
            }
        }

        System.out.print("Enter age: ");
        Integer age = db.intScanner.nextInt();
        user.setAge(age);

        user.setRole(USER);
        db.users.add(user);
    }

    private static void signIn() {
        System.out.print("Enter username: ");
        String username = db.strScanner.nextLine();
        System.out.print("Enter password: ");
        String password = db.strScanner.nextLine();

        for (User user : db.users) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                if (user.getRole().equals(ADMIN)) {
                    db.currentUser = user;
                    adminController.main();

                }
                if (user.getRole().equals(USER)) {
                    db.currentUser = user;
                    userController.main();

                } else {
                    System.out.println("role is not defined");
                }
            }
        }
    }
}
