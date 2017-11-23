package task07.elements;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<Element> list = new ArrayList<Element>();
    
    public void append(Element elem) {
        list.add(elem);
    }

    @Override
    public String toString() {
        String s = "";
        for (Element element : list) {
            s += element.toString();
        }
        return s;
    }
    
}
