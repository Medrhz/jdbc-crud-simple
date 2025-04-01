
# JDBC CRUD Simple Application

This project demonstrates basic CRUD (Create, Read, Update, Delete) operations using JDBC in a simple Java application.

## Features

- **Create**: Add new records to the database.
- **Read**: Retrieve and display existing records.
- **Update**: Modify existing records.
- **Delete**: Remove records from the database.

## Technologies Used

- **Java**: Programming language for the application.
- **JDBC**: Java Database Connectivity for interacting with the database.
- **MySQL**: Relational database management system used for storing data.
- **Maven**: Build tool for managing dependencies and building the project.

## Dependencies

Below are the key dependencies used in this project:

```xml
<dependencies>
    <!-- MySQL JDBC Driver -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.26</version>
    </dependency>
    
    <!-- SLF4J API for logging -->
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>1.7.32</version>
    </dependency>
    
    <!-- SLF4J Simple Logger -->
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-simple</artifactId>
        <version>1.7.32</version>
    </dependency>
</dependencies>
```

## Getting Started

To run this project locally:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Medrhz/jdbc-crud-simple.git
   ```

2. **Navigate to the Project Directory**:
   ```bash
   cd jdbc-crud-simple
   ```

3. **Setup Database**:
   - Create a MySQL database named `jdbc_crud` or modify the connection string to point to your existing database.
   - Add necessary tables to the database by running the provided SQL script or creating your own.

4. **Build the Project**: Use Maven to build the project.
   ```bash
   mvn clean install
   ```

5. **Run the Application**: Run the application from your IDE or command line.

   ```bash
   mvn exec:java
   ```

## Project Structure

- **src/main/java**: Contains the main Java source files.
- **src/main/resources**: Contains configuration files (such as database connection details).
- **pom.xml**: Project Object Model file for Maven dependencies.

## Example Usage

Below is an example of how to use the CRUD operations:

### Create:

```java
Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (name, email) VALUES (?, ?)");
stmt.setString(1, "John Doe");
stmt.setString(2, "johndoe@example.com");
stmt.executeUpdate();
```

### Read:

```java
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM users");
while (rs.next()) {
    System.out.println("ID: " + rs.getInt("id"));
    System.out.println("Name: " + rs.getString("name"));
    System.out.println("Email: " + rs.getString("email"));
}
```

### Update:

```java
PreparedStatement stmt = conn.prepareStatement("UPDATE users SET name = ? WHERE id = ?");
stmt.setString(1, "Jane Doe");
stmt.setInt(2, 1);
stmt.executeUpdate();
```

### Delete:

```java
PreparedStatement stmt = conn.prepareStatement("DELETE FROM users WHERE id = ?");
stmt.setInt(1, 1);
stmt.executeUpdate();
```

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your changes.

