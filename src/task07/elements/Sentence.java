package task07.elements;

import java.util.ArrayList;
import java.util.List;

import task07.util.RegExp;

public class Sentence {
    private List<Element> elements = new ArrayList<Element>();
    
    public Sentence() {}
    
    public Sentence(String sentence) {
        RegExp rx = new RegExp(sentence, ".+?(\\s|$)");
        List<String> lines = rx.getMatches();
        for (String line : lines) {
            ElementSequence ws = new ElementSequence(line);
            elements.addAll(ws.getElements());
        }        
    }
    
    public void setElements(List<Element> list) {
        this.elements = list;
    }

    public List<Element> getElements() {
        return elements;
    }
    
    @Override
    public String toString() {
        String s = "";
        for (Element element : elements) {
            s += element.toString();
        }
        return s;
    }

    public String toMaskedString() {
        String s = "";
        for (Element element : elements) {
            s += element.toMaskedString();
        }
        return s;
    }
}
