package task07.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import task07.elements.Symbol;

public class Element {
    private State state;
    private List<Symbol> list = new ArrayList<Symbol>();

    public Element() {};
    
    public Element(State state) {
        this.state = state;
    }
    
    public void append(Symbol s) {
        list.add(s);
    }

    public State getState() {
        return state;
    }

    public Element setState(State state) {
        this.state = state;
        return this;
    }
    
    public List<Symbol> getList() {
        return list;
    }

    public void setList(List<Symbol> list) {
        this.list = list;
    }
    
    public boolean isNull() {
        return list.size() == 0;
    }
    
    public Symbol last() {
        int size = list.size();
        if (size <= 0) {
            return new Symbol(0);
        }
        return list.get(size - 1);
    }
    
    public int getVovelsCount() {
        return state.getVovelsCount();
    }

    public boolean isEmail() {
        Pattern p = Pattern.compile("^.+?@.+?\\..{2,}$");
        Matcher m = p.matcher(this.toString());
        return m.matches();
    }

    public boolean isPhoneNumber() {
        Pattern p = Pattern.compile("8\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}");
        Matcher m = p.matcher(this.toString());
        return m.matches();
    }
    
    public boolean hasAtMark() {
        return this.toString().contains("@");
    }
    
    @Override
    public String toString() {
        String s = "";
        for (Symbol symbol : list) {
            s += symbol.toString();
        }
        return s;
    }
}
