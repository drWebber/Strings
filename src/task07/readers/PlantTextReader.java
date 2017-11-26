package task07.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PlantTextReader implements Reader {
    private BufferedReader br;
    
    public PlantTextReader(String filePath) throws IOException {
        br = new BufferedReader(new FileReader(filePath));
    }

    @Override
    public String read() throws IOException {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        return sb.toString();
    }

}
