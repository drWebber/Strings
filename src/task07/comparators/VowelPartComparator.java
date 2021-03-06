package task07.comparators;

import java.util.Comparator;
import task07.elements.Element;

public class VowelPartComparator implements Comparator<Element> {
    @Override
    public int compare(final Element e1, final Element e2) {
        return e1.getVowelCount() - e2.getVowelCount();
    }
}
