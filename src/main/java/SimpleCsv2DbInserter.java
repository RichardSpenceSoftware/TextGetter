// copyright by https://www.codejava.net
import java.io.*;
import java.sql.*;

public class SimpleCsv2DbInserter {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/sys";
        String username = "root";
        String password = "Dobenfry123@";

        String csvFilePath = "test.csv";

        int batchSize = 20;

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);

            String sql = "INSERT INTO withage (Review, Star, Age) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = "hello";

            int count = 0;

            lineReader.readLine(); // skip header line

            while ((lineText = lineReader.readLine()) != null) {
            System.out.println(lineText);
            String[] data = lineText.split(",");
                String Review = data[0];
                String Star = data[1];
                String Age = data[2];
//                String rating = data[3];
//                String comment = data.length == 5 ? data[4] : "";

                statement.setString(1, Review);
                statement.setString(2, Star);

//                Timestamp sqlTimestamp = Timestamp.valueOf(Age);
                statement.setString(3, Age);

//                Float fRating = Float.parseFloat(rating);
//                statement.setFloat(4, fRating);
//
//                statement.setString(5, comment);

                statement.addBatch();

                if (count % batchSize == 0) {
                    statement.executeBatch();
                }
            }

            lineReader.close();

            // execute the remaining queries
            statement.executeBatch();

            connection.commit();
            connection.close();

        } catch (IOException ex) {
            System.err.println(ex);
        } catch (SQLException ex) {
            ex.printStackTrace();

            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}