package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Separator {
    private BufferedReader reader;
    private BufferedWriter writer;
    private int fileIndex, characters;
    private String line;

    public Separator() throws Exception {
        reader = new BufferedReader(
                new FileReader("C:\\Java\\JavaProjects\\minecraft-function-divider\\src\\assets\\2085logo.mcfunction"));
        fileIndex = 1;
        writer = new BufferedWriter(new FileWriter(
                "C:\\Java\\JavaProjects\\minecraft-function-divider\\output\\2085logo" + fileIndex + ".txt"));

        characters = 0;
        line = reader.readLine();
    }


    public void separate() throws Exception {
        while (line != null) {
            characters += line.length();
            if (characters < 32500) {
                writer.write(line);
                writer.newLine();
            } else {
                System.out.println(characters - line.length());
                fileIndex++;
                writer = new BufferedWriter(new FileWriter(
                        "C:\\Java\\JavaProjects\\minecraft-function-divider\\output\\2085logo" + fileIndex + ".txt"));
                characters = line.length();
                writer.write(line);
                writer.newLine();
            }
            line = reader.readLine();
        }
        Verifier verifier = new Verifier(fileIndex);
        verifier.verify();
    }
}