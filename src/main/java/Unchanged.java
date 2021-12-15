
import java.io.*;
import java.sql.*;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

public class Unchanged {

        public static void main(String[] args) {
String jdbcURL = "jdbc:mysql://localhost:3306/sys";
String username = "root";
String password = "Dobenfry123@";

String csvFilePath = "test3.csv";

int batchSize = 20;

Connection connection = null;

ICsvBeanReader beanReader = null;
CellProcessor[] processors = new CellProcessor[] {
new NotNull(), // course name
new NotNull(), // student name
new NotNull(), // rating
};

try {
long start = System.currentTimeMillis();

connection = DriverManager.getConnection(jdbcURL, username, password);
connection.setAutoCommit(false);

String sql = "INSERT INTO withage (Review, Star, Age) VALUES (?, ?, ?)";
PreparedStatement statement = connection.prepareStatement(sql);

beanReader = new CsvBeanReader(new FileReader(csvFilePath),
                    CsvPreference.STANDARD_PREFERENCE);

beanReader.getHeader(true); // skip header line

String[] header = {"Review", "Star", "Date"};
Review bean = null;

int count = 0;

while ((bean = beanReader.read(Review.class, header, processors)) != null) {
String Review = bean.getReview();
String Star = bean.getStar();
String Date = bean.getDate();

statement.setString(1, Review);
statement.setString(2, Star);
statement.setString(3, Date);

statement.addBatch();

if (count % batchSize == 0) {
statement.executeBatch();
}
}

beanReader.close();

// execute the remaining queries
statement.executeBatch();

connection.commit();
connection.close();

long end = System.currentTimeMillis();
System.out.println("Execution Time: " + (end - start));
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