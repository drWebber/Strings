package task07.elements;

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
    
//    public boolean isPunctuationMark() {
//        //. ; , : - ? ! ... ( ) " "
//        return ((ch == ''));
//    }
    
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
