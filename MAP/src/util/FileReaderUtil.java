package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class FileReaderUtil {
    public static void cargarInventario(String path, Map<String, String> map) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                map.put(parts[1].trim(), parts[0].trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}