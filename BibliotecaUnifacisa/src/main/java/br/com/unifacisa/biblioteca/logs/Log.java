package br.com.unifacisa.biblioteca.logs;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
    public Logger logger;
    FileHandler fh;

    public Log(String fileName) throws IOException {
        File f = new File(fileName);

        if (!f.exists()) {
            f.createNewFile();
        }

        fh = new FileHandler(fileName, true);
        logger = Logger.getLogger("Log test");
        logger.addHandler(fh);

        SimpleFormatter formatter = new SimpleFormatter();
    }
}
