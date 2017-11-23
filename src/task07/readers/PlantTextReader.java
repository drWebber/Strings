package task07.readers;

import java.io.FileReader;
import java.io.IOException;

public class PlantTextReader implements Reader {
    private FileReader reader;
    
    public PlantTextReader(String filePath) throws IOException {
            reader = new FileReader(filePath);
    }

    @Override
    public int read() throws IOException {
        return reader.read();
    }

}
