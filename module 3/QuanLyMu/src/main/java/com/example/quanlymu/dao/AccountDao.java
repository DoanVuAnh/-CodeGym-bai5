package com.example.quanlymu.dao;

import com.example.quanlymu.models.Account;

import java.sql.*;

public class AccountDao {

    public Account checkLogin(String username, String password) {

        String sql = " select * from account where username = ? and password = ?";
        try( Connection connection = ConnectionMySql.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String role = resultSet.getString("role");
                String fullName = resultSet.getString("fullname");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                Integer age = resultSet.getInt("age");
                return new Account(id,username, password, role, fullName,age, phone,email);
            }

            return null;
        } catch (SQLDataException e){
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
