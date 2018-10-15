package Main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Data {
    private PrintWriter sortie;
    private BufferedReader entree;

    private ArrayList<String> liste;

    public Data() {
        liste = new ArrayList<>();

        try {
            entree = new BufferedReader(new FileReader("users.csv"));
        }
        catch (FileNotFoundException e) { }

        try {
            String value = entree.readLine();
            while (value != null) {
                liste.add(value);
                value = entree.readLine();
            }
        }
        catch (IOException e) {}

        try {
            sortie = new PrintWriter(new BufferedWriter(new FileWriter("users.csv")));
        }
        catch (IOException e) { }

    }

    public void writeData(String texte) {
        liste.add(texte);
    }

    public void saveData() {
        for (String value : liste) {
            sortie.println(value);
        }

        sortie.flush();
    }

    public ArrayList<String> readValues(boolean usernames) {
        ArrayList<String> values = new ArrayList<>();

        for (String user : liste) {
            char[] temp = user.toCharArray();
            int virgIndex = 0;
            int start = 0;

            int position;

            if (usernames) position = 1;
            else position = 2;

            for (int i = 0; i < temp.length; i++) {
                if (temp[i] == ',' && virgIndex == position) {
                    start = i + 1;
                    virgIndex++;
                } else if (temp[i] == ',' && virgIndex < position) {
                    virgIndex++;
                } else if (temp[i] == ',' && virgIndex == position + 1) {
                    user = user.substring(start, i);
                    virgIndex++;
                }
            }
            values.add(user);
        }
        return values;
    }
}
