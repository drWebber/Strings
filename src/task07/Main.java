package task07;

import task07.readers.Reader;
import task07.readers.PlantTextReader;
import task07.comparators.VowelPartComparator;

/**
 * The main class that automatically executes an application.
 */
public class Main {
    /** 
     * The main method of an application.
     * @param args Command line arguments.
     */
    public static void main(final String[] args) {
        Text text = null;
        try {
            Reader r = new PlantTextReader("new.txt");
            String source = r.read();
            text = new Text(source);
            System.out.println("Source text:");
            System.out.println(source);

            System.out.println("Processed text:");
            System.out.println(text.toString());

            TextReviewer tr = new TextReviewer(text.getElements());
            tr.sort(new VowelPartComparator());
            System.out.println("Text elements, rearranged by vowels count:");
            System.out.println(tr);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
