package service;

import database.DataBase;
import role.BookRole;
import templates.Book;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    AdminService adminService = new AdminService();
    static DataBase db = DataBase.getDataBase();

    public void userService() {
        while (true) {
            System.out.println(db.RED + "0 - exit" + db.RESET);
            System.out.println(db.CYAN +"1 - get book");
            System.out.println("2 - show books");
            System.out.println("3 - add book");
            System.out.println("4 - show own books");
            System.out.println("5 - return book" + db.RESET);
            System.out.println("");
            switch (db.intScanner.nextInt()) {
                case 0:
                    return;
                case 1:
                    getBook();
                    break;
                case 2:
                    adminService.showBook();
                    break;
                case 3:
                    adminService.addBook();
                    break;
                case 4:
                    showOwnBooks();
                    break;
                case 5:
                    returnBook();
                    break;
            }
        }
    }

    private void returnBook() {
        for (Book book : db.books) {
            if (book.getRentedTo().equals(db.currentUser.getId())){
                System.out.println(book);
            }
        }
        System.out.println("Enter book id to return :");
        String id = db.strScanner.nextLine();
        for (Book book : db.books) {
            if (book.getId().equals(id));
            book.setRentedTo("");
            book.setRole(BookRole.RETURNED);
        }

    }


    private void showOwnBooks() {
        for (Book book : db.books) {
            if (book.getRentedTo().equals(db.currentUser.getId())){
                System.out.println(book);
            }
        }
    }

    private void getBook() {
        Book book = new Book();
        System.out.println("Enter book's name :");
        String name = db.strScanner.nextLine();

        for (int i = 0; i < db.books.size(); i++) {
            if (name.equals(db.books.get(i).getName())){
               book = db.books.get(i);
            }
        }
        if (book.getName()!=null){
            System.out.println(book);
            System.out.println("Is that you wanted to get ?");
            System.out.println();
            System.out.println(db.GREEN+ "1 - yes" +db.RESET);
            System.out.println(db.RED+   "0 - no" +db.RESET);
            switch (db.intScanner.nextInt()){
                case 0:
                    return;
                case 1:
                    book.setRentedTo(db.currentUser.getId());
                    book.setRole(BookRole.NOTRETURNED);
                    break;
            }
        }else {
            System.out.println(db.RED + "We don't have this kinda book !" + db.RESET);
        }
    }
//    }else {
//            System.out.println("you have already got 5 book");
//            return;
//        }

}
