package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
    public static Connection connectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/Zarzadzanie_flota_pojazdow", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
