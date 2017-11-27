package task07.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import task07.elements.Symbol;

public class Element {
    private State state;
    private List<Symbol> symbols = new ArrayList<Symbol>();

    public Element() {};
    
    public Element(final Symbol s) {
        symbols.add(s);
    };

    public Element(final String str) {
        Symbol s;
        for (int i = 0; i < str.length(); i++) {
            s = new Symbol(str.charAt(i));
            symbols.add(s);
        }
    }

    public Symbol last() throws IndexOutOfBoundsException {
        return symbols.get(symbols.size() - 1);
    }

    public Symbol pop() throws IndexOutOfBoundsException {
        return symbols.remove(symbols.size() - 1);
    }

    public State getState() {
        return state;
    }

    public Element setState(State state) {
        this.state = state;
        return this;
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Symbol> list) {
        this.symbols = list;
    }

    public int getVowelCount() {
        return state.getVowelCount(this);
    }

    public boolean isEmail() {
        Pattern p = Pattern.compile(".+?@.+?\\..{2,}");
        Matcher m = p.matcher(this.toString());
        return m.matches();
    }

    public boolean isPhoneNumber() {
        Pattern p = Pattern.compile("8\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}");
        Matcher m = p.matcher(this.toString());
        return m.matches();
    }

    @Override
    public String toString() {
        String s = "";
        for (Symbol symbol : symbols) {
            s += symbol.toString();
        }
        return s;
    }
}
