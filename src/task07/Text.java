package task07;

import java.util.ArrayList;
import java.util.List;
import task07.elements.*;
import task07.util.RegExp;

public class Text {
    private List<Paragraph> paragraphs = new ArrayList<Paragraph>();

    public Text() {};
    
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
    
    @Override
    public String toString() {
        String s = "";
        for (Paragraph paragraph : paragraphs) {
            s += paragraph.toString() + "\n";
        }
        return s;
    }
}
