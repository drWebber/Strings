package task07.readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * PlantTextReader is a text file(.txt) reader.
 */
public class PlantTextReader implements Reader {
    /** Text file path. */
    private String filePath;

    /**
     * Sole constructor.
     * @param filePath to .txt file
     */
    public PlantTextReader(final String filePath) throws IOException {
        this.filePath = filePath;
    }

    @Override
    public final String read() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        br.close();
        return sb.toString();
    }
}
