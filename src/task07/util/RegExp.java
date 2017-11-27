package task07.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class that performs match and replacement operations
 * on a string by interpreting a Pattern.
 */
public class RegExp {
    /** Compiled regular expression pattern. */
    private Pattern pattern;
    /** The string to be matched. */
    private String text;

    /**
     * Sole constructor.
     * @param text The string to be matched.
     * @param pattern The regular expression to be compiled.
     */
    public RegExp(final String text, final String pattern) {
        this.pattern = Pattern.compile(pattern);
        this.text = text;
    }

    /** Returns compiled regular expression.
     * @return Compiled pattern.
     */
    public Pattern getPattern() {
        return pattern;
    }

    /** Compiles the given regular expression into a pattern.
     * @param pattern The regular expression to be compiled.
     */
    public void setPattern(final String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    /** Returns the string to be matched.
     * @return The string to be matched.
     */
    public String getMatcher() {
        return text;
    }

    /** Set the string to be matched.
     * @param text The string to be matched.
     */
    public void setMatcher(final String text) {
        this.text = text;
    }

    /** Returns the string list of matches.
     * @return The string list of matches.
     */
    public List<String> getMatches() {
        List<String> list = new ArrayList<String>();
        Matcher m = pattern.matcher(text);
        while (m.find()) {
            list.add(m.group());
        }
        return list;
    }

    /**
     * Replaces every subsequence that matches the pattern.
     * @param replaceTo The replacement string.
     * @return The string constructed by replacing the matching.
     */
    public String replace(final String replaceTo) {
        Matcher m = pattern.matcher(text);
        return m.replaceAll(replaceTo);
    }
}
