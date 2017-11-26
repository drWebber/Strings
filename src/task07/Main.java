package task07;

import task07.readers.*;
import task07.comparators.VowelPartComparator;

public class Main {

    public static void main(String[] args) {
        
        Text text = null;
        try {
            Reader r = new PlantTextReader("new.txt");
            String source = r.read();
            text = new Text(source);
            System.out.println("Source text:");
            System.out.println(source);
            
            System.out.println("Processed text:");
            System.out.println(text.toString());
            
            TextReviewer tr = new TextReviewer();
            tr.setElements(text.getElements());
            tr.sort(new VowelPartComparator());
            System.out.println("Text elements, rearranged by vowels count"
                    + " (by descending):");
            System.out.println(tr);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
