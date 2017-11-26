package task07.elements;

public class Word implements State {
    @Override
    public int getVowelCount(Element element) {
        int vowels = 0;
        for (Symbol s : element.getSymbols()) {
            if (s.isVowel()) {
                ++vowels;
            }
        }
        return vowels;
    }

    @Override
    public String toString() {
        return "w";
    }
}
