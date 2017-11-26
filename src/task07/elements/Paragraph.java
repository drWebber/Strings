package task07.elements;

import java.util.ArrayList;
import java.util.List;

import task07.util.RegExp;

public class Paragraph {
    private List<Sentence> sentences = new ArrayList<Sentence>();

    public Paragraph() {}

    public Paragraph(String paragraph) {
        Sentence sentence;
        RegExp rx = new RegExp(paragraph, 
                ".+?(\\.(\\s|$)|\\?(\\s|$)|\\!(\\s|$)|$)");
        List<String> lines = rx.getMatches();
        for (String line : lines) {
            sentence = new Sentence(line);
            sentences.add(sentence);
        }
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
