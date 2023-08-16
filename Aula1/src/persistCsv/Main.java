package persistCsv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String[]> lines = new ArrayList<>();
        lines.add(new String[]{"cheatDescrption", "cheatCode"});
        lines.add(new String[]{"Vida++", "HESOYAM"});
        lines.add(new String[]{"Vida Infinita", "BAGUVIX"});
        lines.add(new String[]{"Modo Adrenalina", "MUNASEF"});
        lines.add(new String[]{"Oxigenio infinito", "CVWKXAM"});
        lines.add(new String[]{"Respeito máximo", "OGXSDAG"});
        lines.add(new String[]{"CJ magro", "KVGYZQK"});
        lines.add(new String[]{"Cj musculoso", "JYSDSOD"});
        lines.add(new String[]{"Hydra", "JUMPJET"});
        lines.add(new String[]{"JetPack", "YECGAA"});

        try {
            FileWriter writer = new FileWriter("data.csv");

            for (String[] line : lines) {
                writer.write(String.join(",", line));
                writer.write(System.lineSeparator());
            }

            writer.close();
            System.out.println("data persisted");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
