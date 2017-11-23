package task07;

import java.util.ArrayList;
import java.util.List;

import task07.elements.*;

public class Text {
    private List<Paragraph> list = new ArrayList<Paragraph>();
    private Paragraph paragraph = new Paragraph();
    private Sentence sentence = new Sentence();
    private Word word = new Word();
    private Buffer buf = new Buffer();
    
    public Text() {};
    
    public void append(Symbol s) {
        if (s.isSpace()) {
            word.setList(buf.getList());
            sentence.append(word);
            sentence.append(new Space());
            word = new Word();
            buf = new Buffer();
        } else {
            buf.append(s);
        }
        if (s.isSentenceEnd()) {
            word.setList(buf.getList());
            sentence.append(word);
            paragraph.append(sentence);
            sentence = new Sentence();            
        }
        if (s.isNewLine()) {
            paragraph.append(sentence);
            sentence = new Sentence();
            list.add(paragraph);
            paragraph = new Paragraph();
        }        
    }

    @Override
    public String toString() {
        return list.toString();
    };
    
    
}
