package task07.elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Symbol {
    private char ch;

    public Symbol(char ch) {
        this.ch = ch;
    }
    
    public boolean isPunctuationMark() {
        Pattern p = Pattern.compile("[.\\,\\;\\:\\(\\)\\?\\-\\_]");
        Matcher m = p.matcher(String.valueOf(ch));
        return m.matches();
    }
    
    @Override
    public String toString() {
        return String.valueOf(ch);
    }

    public boolean isSpace() {
        return ch == ' ';
    }

    public boolean isCarriageReturn() {
        return ch == '\r';
    }
}
