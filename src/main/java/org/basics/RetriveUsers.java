package org.basics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RetriveUsers {
    public static void main (String[] args) {

        String query = "select * from users";
        List<User> users = new ArrayList<>();
        try {
            Statement statement = ConceptsClass.connection().createStatement();
            boolean result = statement.execute(query);

            if (result) {
                ResultSet resultSet = statement.executeQuery(query);
                System.out.println("========== list of user =========== ");
                while (resultSet.next()) {

                    int id = resultSet.getInt("id");
                    String first = resultSet.getString("first");
                    String last = resultSet.getString("last");
                    String email = resultSet.getString("email");
                    int age = resultSet.getInt("age");
                    User user = new User(id, first, last, age, email);
                    users.add(user);
                    System.out.println("id :  " + user.getId());
                    System.out.println("first:  " + user.getFirst());
                    System.out.println("last :  " + user.getLast());
                    System.out.println("age :  " + user.getAge());
                    System.out.println("email :  " + user.getEmail());
                    System.out.println("----------------------------");
                }
            } else {
                System.out.println("just is updating in data");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
