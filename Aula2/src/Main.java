import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://github.com/darllinsonazvd").get();
            Elements result = doc.getElementsByTag("h1");

            FileWriter reader = new FileWriter("index.html");
            reader.write(String.valueOf(result));
            reader.close();

            System.out.println("Títulos da página coletados com sucesso e salvos no arquivo index.html");
        } catch (IOException err) {
            System.out.println("Deu pau!");
        }
    }
}