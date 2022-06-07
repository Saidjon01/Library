package controllers;

import service.AdminService;

public class AdminController {
    static AdminService service = new AdminService();
    public  void main() {
        service.adminService();
    }
}
