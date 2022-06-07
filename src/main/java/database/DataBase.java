package database;

import templates.Book;
import templates.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataBase {
   public Scanner strScanner = new Scanner(System.in);
   public Scanner intScanner = new Scanner(System.in);

    public  final String RESET = "\u001B[0m";
    public  final String BLACK = "\u001B[30m";
    public  final String RED = "\u001B[31m";
    public  final String GREEN = "\u001B[32m";
    public  final String YELLOW = "\u001B[33m";
    public  final String BLUE = "\u001B[34m";
    public  final String PURPLE = "\u001B[35m";
    public  final String CYAN = "\u001B[36m";
    public  final String WHITE = "\u001B[37m";

   public List<User> users = new ArrayList<>();

   public List<Book> books = new ArrayList<>();

   public boolean isUniqueUser(String username, String password){
       boolean check = false;
      for (User user : users){
          if (!(user.getPassword().equals(password) && user.getUsername().equals(username))){
              check =true;
          }
      }
      return check;
   }
   public User currentUser ;

    static   DataBase dataBase = new DataBase();
    public static DataBase getDataBase(){
        return dataBase;
    }

}
