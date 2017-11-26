package task07.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    private String pattern;
    private String text;
    
    public RegExp(String text, String pattern) {
        this.pattern = pattern;
        this.text = text;
    }
    
    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getMatcher() {
        return text;
    }

    public void setMatcher(String text) {
        this.text = text;
    }

    public List<String> getMatches() {
        List<String> list = new ArrayList<String>();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        while (m.find()) {
            list.add(m.group());
        }
        return list;
    }
    
    public String replace(String replaceTo) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        return m.replaceAll(replaceTo);
    }
}
