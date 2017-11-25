package task07.elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Symbol {
    private char ch;

    public Symbol(int unicodeSymbol) {
        char c = (char) unicodeSymbol;
        if (isTab(c)) {
            c = ' ';
        }
        this.ch = c;
    }
    
    public boolean isSentenceEnd() {
        return ((ch == '.') || (ch == '!') || (ch == '?'));
    }
    
    public boolean isPunctuationMark() {
        Pattern p = Pattern.compile("[\\.\\,\\(\\)\\:\\;\\!\\'\\-\\_\\?\"]+");
        Matcher m = p.matcher(String.valueOf(ch));
        return m.matches();
    }
    
    public boolean isSpace() {
        return ch == ' ';        
    }
    
    public boolean isNewLine() {
        return ch == '\n';
    }

    private boolean isTab(char c) {
        return c == '\t';
    }
    
    @Override
    public String toString() {
        return String.valueOf(ch);
    }
}
