package org.basics;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddUser {
    public static void main (String[] args) {

        User user = new User(null, "test", "test", 27, "test@gmail.com");

        // create Statement
        // executeQuery(string sql) : object ResultSet  select
        // executeUpdate(string sql)  create insert drop  update delete
        //        String query = "INSERT INTO users values(null,?,?,?,?)";
        String query = "INSERT INTO users values(null,,?,?,?)";

        //        Valeur de retour
        //        true si l’instruction retourne un jeu de résultats. false si elle retourne un nombre de mises à jour ou aucun résultat.
        try {
            PreparedStatement preparedStatement = ConceptsClass.connection().prepareStatement(query);
            preparedStatement.setString(1, user.getFirst());
            preparedStatement.setString(2, user.getLast());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setString(4, user.getEmail());
            boolean rs = preparedStatement.execute();
            //            System.out.println(rs);
            //            if (!rs) {
            //                System.out.println("insert user " + user.getFirst() + " with success");
            //            } else {
            //                System.out.println("failed to insert user : " + user.getFirst());
            //            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // execute() resutls  x
        // executeBatch

    }
}
