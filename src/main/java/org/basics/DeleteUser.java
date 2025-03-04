package org.basics;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteUser {

    public static void main (String[] args) {
        String selectQuery = "SELECT * from users where id = ?";
        int id = 3;

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
                    String deleteQuery = "DELETE FROM users where id = ?";
                    preparedStatement = ConceptsClass.connection().prepareStatement(deleteQuery);
                    preparedStatement.setInt(1, user.getId());
                    int res = preparedStatement.executeUpdate();
                    System.out.println(res);
                    if (res >= 1) {
                        System.out.println("user :" + user.getFirst() + " is deleted with success");
                    } else {
                        System.out.println("user don't remove .");
                    }
                }
            }
            ConceptsClass.connection().close();
            //            User user = new User(null, "test", "test", 27, "test@gmail.com");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
