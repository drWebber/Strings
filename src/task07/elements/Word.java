package task07.elements;

public class Word implements State {
    @Override
    public final int getVowelCount(final Element element) {
        int vowels = 0;
        for (Symbol s : element.getSymbols()) {
            if (s.isVowel()) {
                ++vowels;
            }
        }
        return vowels;
    }
}
