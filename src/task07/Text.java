package task07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import task07.elements.*;
import task07.util.RegExp;

public class Text {
    private List<Paragraph> paragraphs = new ArrayList<Paragraph>();

    public Text() {};
    
    public Text(String text) {
        Paragraph paragraph;
        RegExp rx = new RegExp(text, "(\t{1,}| {2,})");
        text = rx.replace(" ");

        rx = new RegExp(text, "(.+?)\r\n");
        List<String> lines = rx.getMatches();
        for (String line : lines) {
            paragraph = new Paragraph(getSentences(line));
            paragraphs.add(paragraph);
        }
    }
    
    public String getElementsType() {
        String s = "";
        for (Paragraph paragraph : paragraphs) {
            for (Sentence sentence : paragraph.getSentences()) {
                for (Element e : sentence.getElements()) {
                    s += e.getState().getClass().getSimpleName() + " ";                    
                }
            }
        }
        return s;        
    }

    @Override
    public String toString() {
        String s = "";
        for (Paragraph paragraph : paragraphs) {
            s += paragraph.toString() + "\n";
        }
        return s;
    }
    
    /* splitting by sentences */
    private List<Sentence> getSentences(String source) {
        Sentence sentence;
        List<Sentence> sentences = new ArrayList<Sentence>();
        RegExp rx = new RegExp(source, 
                ".+?(\\.(\\s|$)|\\?(\\s|$)|\\!(\\s|$)|$)");
        List<String> lines = rx.getMatches();
        for (String line : lines) {
            sentence = new Sentence(getElements(line));
            sentences.add(sentence);
        }
        return sentences;
    }
    
    /* Elements including states */
    private List<Element> getElements(String source) {
        List<Element> elements = new ArrayList<Element>();
        RegExp rx = new RegExp(source, ".+?(\\s|$)");
        List<String> lines = rx.getMatches();
        for (String line : lines) {
            elements.addAll(getItems(line));
        }        
        return elements;
    }
    
    /* Splitting elements by states */
    private List<Element> getItems(String source) {
        List<Element> elements = new ArrayList<Element>();
        Element e = new Element(source);
        if (e.last().isCarriageReturn()) {
            e.pop(); /* pop carriage return symbol */
        }
        if (e.last().isSpace()) {
            Element spaceElem = new Element(e.pop());
            elements.add(spaceElem.setState(new Space()));
        }
        while (e.last().isPunctuationMark()) {
            Element pElem = new Element(e.pop());
            elements.add(pElem.setState(new PunktuationMark()));            
        }
        if (e.isPhoneNumber()) {
            e.setState(new PhoneNumber());
        } else if (e.isEmail()) {
            e.setState(new Email());
        } else {
            e.setState(new Word());
        }
        elements.add(e);
        Collections.reverse(elements);
        return elements;        
    }
}
