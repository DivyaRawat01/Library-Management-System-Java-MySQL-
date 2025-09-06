package project_ad_java;
import java.sql.*;
import java.util.Scanner;

public class LibrarySystem {
    private static final String URL = "jdbc:mysql://localhost:3306/database_name";
    private static final String USER = "root";
    private static final String PASSWORD = "add your password";

    private static Connection conn;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database!");
            int choice;
            do {
                System.out.println("\nLibrary Menu:");
                System.out.println("1. Add Book");
                System.out.println("2. View Books");
                System.out.println("3. Update Book");
                System.out.println("4. Delete Book");
                System.out.println("5. Exit");
                System.out.print("Enter your choice:(1-5) ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> addBook();
                    case 2 -> viewBooks();
                    case 3 -> updateBook();
                    case 4 -> deleteBook();
                    case 5 -> System.out.println("Exiting from the program...");
                    default -> System.out.println("Invalid choice!\n choose again...");
                }
            } while (choice != 5);
            conn.close();
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input format.");
        }
    }
    private static void addBook() throws SQLException {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author's name: ");
        String author = scanner.nextLine();
        System.out.print("Enter publication year: ");
        int year = Integer.parseInt(scanner.nextLine());

        String sql = "INSERT INTO table_name (title, author, year) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, title);
        pstmt.setString(2, author);
        pstmt.setInt(3, year);
        int rows = pstmt.executeUpdate();
        System.out.println(rows + " book added in database.");
    }

    private static void viewBooks() throws SQLException {
        String sql = "SELECT * FROM books";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("\nBooks List:");
        System.out.println("ID \t Title \t\t\t\t Author \t\t   Year");
        while (rs.next()) {
            System.out.println(rs.getInt("id")+"    "+rs.getString("title")+"       "+rs.getString("author")+"   \t  "+ rs.getInt("year"));
        }
    }

    private static void updateBook() throws SQLException {
        System.out.print("Enter book ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter new title: ");
        String title = scanner.nextLine();
        System.out.print("Enter new author: ");
        String author = scanner.nextLine();
        System.out.print("Enter new year: ");
        int year = Integer.parseInt(scanner.nextLine());

        String sql = "UPDATE books SET title = ?, author = ?, year = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, title);
        pstmt.setString(2, author);
        pstmt.setInt(3, year);
        pstmt.setInt(4, id);
        int rows = pstmt.executeUpdate();
        System.out.println(rows + " book(s) updated.");
    }

    private static void deleteBook() throws SQLException {
        System.out.print("Enter book ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        String sql = "DELETE FROM books WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        int rows = pstmt.executeUpdate();
        System.out.println(rows + " book(s) deleted.");
    }
}


