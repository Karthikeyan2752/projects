package com.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class ViewUserAction extends ActionSupport {
    private List<User> users; 

    public List<User> getUsers() {
        return users;
    }

    @Override
    public String execute() throws Exception {
        users = new ArrayList<>();

        String jdbcUrl = "jdbc:mysql://localhost:3306/user_registration";
        String dbUser = "root";
        String dbPassword = "karthikn2752";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
            String selectQuery = "SELECT id,username, email FROM users";  
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                users.add(user);
            }

            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return ERROR;
        } 

        return SUCCESS;
    }
}
