package task07.elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ElementSequence {
    private List<Element> elements = new ArrayList<Element>();

    public ElementSequence(String sequence) {
        Element e = new Element(sequence);
        
        try {
            if (e.last().isCarriageReturn()) {
                e.pop(); /* pop carriage return symbol */
            }
            if (e.last().isSpace()) {
                Element spaceElem = new Element(e.pop());
                elements.add(spaceElem.setState(new Space()));
            }
            while (e.last().isPunctuationMark()) {
                Element pElem = new Element(e.pop());
                elements.add(pElem.setState(new PunktuationMark()));            
            }            
        } catch (IndexOutOfBoundsException ex) {
            System.err.println("WordSequence elements index out of bounds: " 
                    + ex.getMessage());
        }
        
        if (e.isPhoneNumber()) {
            e.setState(new PhoneNumber());
        } else if (e.isEmail()) {
            e.setState(new Email());
        } else {
            e.setState(new Word());
        }
        elements.add(e);
        Collections.reverse(elements);        
    }
    
    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }
}
