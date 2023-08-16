package persistProperties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.setProperty("host", "localhost:8080");
        prop.setProperty("user", "root");
        prop.setProperty("password", "root");
        prop.setProperty("database", "unifacisa");

        try {
            FileOutputStream reader = new FileOutputStream("archive.properties");
            prop.store(reader, "Configs Database");

            reader.close();
            System.out.println("data successfully persisted");

        } catch (IOException e) {
            System.err.println("error: " + e.getMessage());
        }

    }
}
