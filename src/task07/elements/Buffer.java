package task07.elements;

import java.util.ArrayList;
import java.util.List;

public class Buffer {
    private List<Symbol> list = new ArrayList<Symbol>();
    
    public Buffer() {};
    
    public void append(Symbol s) {
        list.add(s);
    }
    
    public List<Symbol> getList() {
        return list;
    }
}
