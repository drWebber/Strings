package task07.elements;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    private List<Sentence> sentences = new ArrayList<Sentence>();

    public Paragraph() {}

    public Paragraph(List<Sentence> sentences) {
        this.sentences = sentences;
    }
    
    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> list) {
        this.sentences = list;
    }

    @Override
    public String toString() {
        String s = "";
        for (Sentence sentence : sentences) {
            s += sentence.toString();
        }
        return s;
    }
    
}
