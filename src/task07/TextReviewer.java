package task07;

import task07.elements.Element;
import task07.elements.Word;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextReviewer {
    private List<Element> elements = new ArrayList<Element>();

    public TextReviewer() { }

    public TextReviewer(List<Element> elements) {
        for (Element element : elements) {
            if (element.getState() instanceof Word) {
                this.elements.add(element);                
            }
        }
    }

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
