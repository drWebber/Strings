package task07.elements;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<Element> list = new ArrayList<Element>();
    
    public void setList(List<Element> list) {
        this.list = list;
    }

    public List<Element> getList() {
        return list;
    }

    public void append(Element elem) {
        list.add(elem);
    }
    
    public boolean isLastSpace() {
        int size = list.size();
        if (size <= 0) {
            return false;
        }
        Element e = list.get(size - 1);
        return e.last().isSpace();
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
