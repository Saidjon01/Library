package service;

import controllers.MainController;
import database.DataBase;
import role.BookRole;
import templates.Book;
import templates.User;

import static role.UserRole.ADMIN;
import static role.UserRole.USER;

public class AdminService {
    static DataBase db = DataBase.getDataBase();

    public void adminService() {
        while (true) {
            System.out.println(db.RED+"0 - exit"+ db.RESET);
            System.out.println(db.CYAN + "1 - add book");
            System.out.println("2 - remove book");
            System.out.println("3 - show book");
            System.out.println("4 - create user");
            System.out.println("5 - show user");
            System.out.println("6 - edit user");
            System.out.println("7 - delete user" + db.RESET);
            System.out.print("=> ");
            switch (db.intScanner.nextInt()) {
                case 0:
                    MainController.mainController();
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    showBook();
                    break;
                case 4:
                    createUser();
                    break;
                case 5:
                    showUser();
                    break;
                case 6:
                    editUser();
                    break;
                case 7:
                    deleteUser();
                    break;
            }
        }
    }

    private void deleteUser() {
        System.out.println("Enter user id to delete");
        String id = db.strScanner.nextLine();
        for (int i = 0; i < db.users.size(); i++) {
            if (db.users.get(i).getId().equals(id)){
                db.users.remove(db.users.get(i));
            }
        }
    }

    private void editUser() {
        deleteUser();
        createUser();
    }

    private void showUser() {
        for (int i = 0; i < db.users.size(); i++) {
            System.out.println(db.users.get(i));
            System.out.println();
        }
    }

    private static void createUser() {
        User user = new User();

        System.out.println("Enter name : ");
        String name = db.strScanner.nextLine();
        user.setName(name);

        System.out.print("Enter username: ");
        String username = db.strScanner.nextLine();


        System.out.print("Enter password ; ");
        String password =db.strScanner.nextLine();
        if (db.isUniqueUser(username , password)){
            user.setPassword(password);
            user.setUsername(username);
        }else {
            System.out.println(db.RED + "this password or username is not unique" + db.RESET);

            System.out.println("main menu = 1");
            System.out.println("try again = 2");
            switch (db.intScanner.nextInt()){
                case 1:
                    MainController.mainController();
                    break;
                case 2:
                    AdminService.createUser();
                    break;
            }
        }

        System.out.print("Enter  age : ");
        Integer age = db.intScanner.nextInt();
        user.setAge(age);
        System.out.println("if user is Admin press 1");
        System.out.println("if user is not Admin press 2");
        int choice = db.intScanner.nextInt();
        if (choice==1){
            user.setRole(ADMIN);
        }if (choice==2){
            user.setRole(USER);
        }

        db.users.add(user);
        System.out.println(db.GREEN + "successfully created" + db.RESET);
    }

    protected void showBook() {
        for (Book book : db.books) {
            System.out.println(book);
        }
    }

    private void removeBook() {
        System.out.println("Enter book's id");
        String id = db.strScanner.nextLine();
        for (int i = 0; i < db.books.size(); i++) {
            if (db.books.get(i).getId().equals(id)){
                db.books.remove(db.books.get(i));
                System.out.println(db.GREEN + "successfully removed" + db.RESET);
            }
        }
    }

    protected void addBook() {
        Book book = new Book();
        System.out.println("Enter book name :");
        String name = db.strScanner.nextLine();
        book.setName(name);
        System.out.println("Enter book's author: ");
        String author = db.strScanner.nextLine();
        book.setAuthor(author);
        book.setRole(BookRole.NEW);
        db.books.add(book);
        System.out.println(db.GREEN + "successfully added" + db.RESET);
    }
}
