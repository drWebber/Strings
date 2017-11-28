package task07;

import task07.elements.Element;
import task07.elements.Word;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WordsReviewer {
    private List<Element> words = new ArrayList<Element>();

    public WordsReviewer() { }

    public WordsReviewer(List<Element> words) {
        setWords(words);
    }

    public List<Element> getWords() {
        return words;
    }

    public void setWords(List<Element> words) {
        for (Element element : words) {
            if (element.getState() instanceof Word) {
                this.words.add(element);                
            }
        }
    }

    public void sort (Comparator<Element> comparator) {
        words.sort(comparator);
    }

    @Override
    public String toString() {
        String s = "";
        for (Element element : words) {
            s += element.toString() + " ";
        }
        return s;
    }
}
