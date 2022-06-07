package controllers;

import service.UserService;

public class UserController {
    static UserService service = new UserService();

    public static void main() {
        service.userService();
    }
}
