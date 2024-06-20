package dao;

import core.Database;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {

    private Connection connection;

    public UserDao() {
        this.connection = Database.getInstance();
    }


    public User findByLogin(String mail, String password){

        User user = null;

        String query = "select * from [user] where mail = ? and password = ?";
        try {
            PreparedStatement pr  =this.connection.prepareStatement(query);
            pr.setString(1, mail);
            pr.setString(2, password);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                user = this.match(rs);
            }
            return user;
        } catch (SQLException exception){
            exception.printStackTrace();
        }
        return user;


    }


    public ArrayList<User> findAll() {
        ArrayList<User> users = new ArrayList<>();
        try {
            ResultSet rs = this.connection.createStatement().executeQuery("select * from [user]");
            while (rs.next()){
                users.add(this.match(rs));
            }
        } catch (SQLException exception){
            exception.printStackTrace();
        }

        return users;
    }

    public User match(ResultSet rs) throws SQLException{
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("mail"));
        user.setMail(rs.getString("password"));
        return user;
    }


}
