package task07.elements;

import task07.elements.State;

public class Email implements State {
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
}
