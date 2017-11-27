package task07;

import task07.elements.Element;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextReviewer {
    private List<Element> elements = new ArrayList<Element>();

    public TextReviewer() { }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public void sort (Comparator<Element> comparator) {
        elements.sort(comparator);
    }

    @Override
    public String toString() {
        String s = "";
        for (Element element : elements) {
            s += element.toString() + " ";
        }
        return s;
    }
}
