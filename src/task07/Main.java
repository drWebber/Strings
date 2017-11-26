package task07;

import task07.readers.*;

public class Main {

    public static void main(String[] args) {
        
        Text text = null;
        try {
            Reader r = new PlantTextReader("new.txt");
            String source = r.read();
            text = new Text(source);
            System.out.println("A source text:");
            System.out.println(source);
            
            System.out.println("A processed text:");
            System.out.println(text.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
