package task07.readers;

import java.io.IOException;

/**
 * Interface for reading character streams.
 * The only methods that must be implemented are read().
 */
public interface Reader {
    /** Attempts to read characters into the specified string buffer.
     * @return A String containing the contents of the line.
     * @throws IOException if an I/O error occurs.
     */
    String read() throws IOException;
}
