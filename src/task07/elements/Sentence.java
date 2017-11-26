package task07.elements;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<Element> elements = new ArrayList<Element>();
    
    public Sentence() {}
    
    public Sentence(List<Element> elements) {
        this.elements = elements;
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
    
}
