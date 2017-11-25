package task07;

import java.util.ArrayList;
import java.util.List;

import task07.elements.*;

public class Text {
    private List<Paragraph> list = new ArrayList<Paragraph>();
    private Paragraph paragraph = new Paragraph();
    private Sentence sentence = new Sentence();
    private Element element = new Element();
    
    public Text() {};
    
    public void append(Symbol s) {
        if (s.isSpace()) {
            if (!element.isNull()) {
                State state = computeState(element);
                sentence.append(element.setState(state));
                element = new Element();
            }
            element.append(s);
            if (!sentence.isLastSpace()) {
                sentence.append(element.setState(new Space()));
            }
            element = new Element();                
        } else if (s.isSentenceEnd()) {
            if (!element.hasAtMark()) {
                if (!element.isNull()) {
                    sentence.append(element.setState(new Word()));
                    element = new Element(); /* flush element */
                }
                element.append(s); /* append current punctuation mark */
                sentence.append(element.setState(new PunktuationMark()));
                paragraph.append(sentence);
                element = new Element();
                sentence = new Sentence(); /* flush sentence */
            }
        } else if (s.isPunctuationMark()) {
            element.append(s); /* append current punctuation mark */
            sentence.append(element.setState(new PunktuationMark()));
            element = new Element();     
        } else if (s.isNewLine()) {
            if (!element.isNull()) {
                sentence.append(element.setState(new Word()));
                paragraph.append(sentence);
                element = new Element();
                sentence = new Sentence();
            }
            addParagraph();
        } else {
            //append symbol to word
            element.append(s);
        }
    }
    
    private State computeState(Element element) {
        State state;
        if (element.isEmail()) {
            state = new Email();
        } else if (element.isPhoneNumber()) {
            state = new PhoneNumber();
        } else {
            state = new Word();
        }
        return state;
    }

    private void addParagraph() {
        list.add(paragraph);
        paragraph = new Paragraph();
    }
    
    public String getElementsType() {
        String s = "";
        for (Paragraph paragraph : list) {
            for (Sentence sentence : paragraph.getList()) {
                for (Element e : sentence.getList()) {
                    s += e.getState().getClass().getSimpleName() + " ";                    
                }
            }
        }
        return s;        
    }

    @Override
    public String toString() {
        String s = "";
        for (Paragraph paragraph : list) {
            s += paragraph.toString();
        }
        return s;
    };
    
    
}
