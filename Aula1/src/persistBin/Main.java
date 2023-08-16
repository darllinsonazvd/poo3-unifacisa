package persistBin;

import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Pessoa p = new Pessoa("Cleito", "Rasta");
        try {
            FileOutputStream data = new FileOutputStream("archive.bin");
            ObjectOutputStream writer = new ObjectOutputStream(data);

            writer.writeObject(p);
            writer.close();
            data.close();
            System.out.println("data saved");

        } catch (IOException e) {
            System.err.println("error: " + e.getMessage());
        }
    }
}

class Pessoa implements Serializable {
    String name;
    String occupation;

    public Pessoa(String name, String occupation) {
        this.name = name;
        this.occupation = occupation;
    }
}