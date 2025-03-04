package org.basics;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditUser {
    public static void main (String[] args) {
        String selectQuery = "SELECT * from users where id = ?";
        int id = 6;

        try {
            PreparedStatement preparedStatement = ConceptsClass.connection().prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);
            boolean isFind = preparedStatement.execute();

            if (isFind) {
                // set data
                ResultSet resultSet = preparedStatement.executeQuery();
                // get data
                if (resultSet.next()) {
                    int idUser = resultSet.getInt("id");
                    String first = resultSet.getString("first");
                    String last = resultSet.getString("last");
                    String email = resultSet.getString("email");
                    int age = resultSet.getInt("age");
                    User user = new User(idUser, first, last, age, email);
                    System.out.println(user);
                    user.setFirst("salma");
                    user.setLast("toufiki");
                    user.setEmail("salma@gmail.com");
                    String updateQuery = "update users set first = ? , last = ?, email = ? where  id = ?";
                    preparedStatement = ConceptsClass.connection().prepareStatement(updateQuery);
                    preparedStatement.setString(1, user.getFirst());
                    preparedStatement.setString(2, user.getLast());
                    preparedStatement.setString(3, user.getEmail());
                    preparedStatement.setInt(4, user.getId());
                    int res = preparedStatement.executeUpdate();
                    System.out.println(res);
                    if (res >= 1) {
                        System.out.println("user :" + user.getFirst() + " is updated with success");
                    } else {
                        System.out.println("user don't update .");
                    }
                }
            }
            ConceptsClass.connection().close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
