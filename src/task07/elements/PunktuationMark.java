package task07.elements;

public class PunktuationMark implements State {
    @Override
    public int getVowelCount(Element element) {
        return 0;
    }

    @Override
    public String toString() {
        return "p";
    }
}
