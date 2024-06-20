import business.UserController;
import core.Database;
import core.Helper;
import entity.User;
import view.DashboardUI;
import view.LoginUI;

import java.sql.Connection;


public class App {

    public static void main(String[] args) {
        Helper.setTheme();
        LoginUI loginUI = new LoginUI();
//        UserController userController = new UserController();
//        User user = userController.findByLogin("cht@gmail.com", "12345");
//        DashboardUI dashboardUI = new DashboardUI(user);


    }

}
