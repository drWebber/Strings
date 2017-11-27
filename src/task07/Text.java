package task07;

import java.util.ArrayList;
import java.util.List;
import task07.elements.Paragraph;
import task07.elements.Element;
import task07.util.RegExp;

/**
 * The class Text represents input string of characters as
 * an objects hierarchy, that including paragraphs, sentences,
 * sentence elements and etc.
 * @see task07.elements.Paragraph
 * @see task07.elements.Sentence
 * @see task07.elements.Element
 */
public class Text {
    /** A collection of the Paragraph class objects.
     * @see task07.elements.Paragraph. */
    private List<Paragraph> paragraphs = new ArrayList<Paragraph>();

    /** Empty constructor just gives an instance of Text object. */
    public Text() { }

    /** Constructs a Text from an input string.
     * @param text The input text, that must be represented as
     * the Text class object.
     */
    public Text(String text) {
        Paragraph paragraph;
        RegExp rx = new RegExp(text, "(\t{1,}| {2,})");
        text = rx.replace(" ");

        rx = new RegExp(text, "(.+?)\r\n");
        List<String> lines = rx.getMatches();
        for (String line : lines) {
            paragraph = new Paragraph(line);
            paragraphs.add(paragraph);
        }
    }

    /** Returns the list of paragraphs objects.
     * @return The list of paragraphs.
     * @see task07.elements.Paragraph.
     */
    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    /** Set the list of paragraphs objects as the Text context.
     * @param paragraphs The list of Paragraphs objects.
     * @see task07.elements.Paragraph.
     */
    public void setParagraphs(final List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    /** Returns the list of sentence elements objects.
     * @return The list of Elements.
     * @see task07.elements.Elements.
     */
    public List<Element> getElements() {
        List<Element> elements = new ArrayList<Element>();
        for (Paragraph paragraph : paragraphs) {
            elements.addAll(paragraph.getElements());
        }
        return elements;
    }

    @Override
    public final String toString() {
        String s = "";
        for (Paragraph paragraph : paragraphs) {
            s += paragraph.toString() + "\n";
        }
        return s;
    }
}
