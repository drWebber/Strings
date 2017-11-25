package task07;

import task07.elements.*;
import task07.readers.*;

public class Main {

    public static void main(String[] args) {
    
        Text text = new Text();
        try {
            Reader r = new PlantTextReader("new.txt");
            int c;
            while ((c = r.read()) != -1) {
                Symbol s = new Symbol(c);
                text.append(s);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println(text.toString());
        System.out.println(text.getElementsType());
    }

}
