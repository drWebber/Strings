package task07.elements;

import java.util.ArrayList;
import java.util.List;

import task07.elements.Symbol;

public abstract class Element {
    private List<Symbol> list = new ArrayList<Symbol>();

    public Element() {};
    
    public List<Symbol> getList() {
        return list;
    }

    public void setList(List<Symbol> list) {
        this.list = list;
    }
    
    @Override
    public String toString() {
        String s = "";
        for (Symbol symbol : list) {
            s += symbol.toString();
        }
        return s;
    }

    public abstract int getVovelsProportion();
}
