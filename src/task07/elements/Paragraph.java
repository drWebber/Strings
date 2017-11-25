package task07.elements;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    private List<Sentence> list = new ArrayList<Sentence>();

    public Paragraph() {};
    
    public List<Sentence> getList() {
        return list;
    }

    public void setList(List<Sentence> list) {
        this.list = list;
    }

    public void append(Sentence sentence) {
        list.add(sentence);
    }

    @Override
    public String toString() {
        String s = "\n";
        for (Sentence sentence : list) {
            s += sentence.toString();
        }
        return s;
    }
    
}
