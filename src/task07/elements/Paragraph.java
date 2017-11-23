package task07.elements;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    private List<Sentence> list = new ArrayList<Sentence>();
    
    public Paragraph() {};

    public void append(Sentence sentence) {
        list.add(sentence);
    }

    @Override
    public String toString() {
        String s = "";
        for (Sentence sentence : list) {
            s += sentence.toString();
        }
        return s;
    }
    
}
