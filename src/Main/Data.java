package Main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Data {
    private PrintWriter sortie;
    private int users = 0;

    public Data() {
        try {
            sortie = new PrintWriter(new BufferedWriter(new FileWriter("users.csv")));
        }
        catch (IOException e) { }
    }

    public void writeData(String texte) {
        users++;
        sortie.println(texte);
    }

    public void saveData() {
        sortie.flush();
    }

    public void readData() {

    }
}
