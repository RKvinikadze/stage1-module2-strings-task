package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        for (char ch: source.toCharArray()){
            if (delimiters.contains(String.valueOf(ch))){
                if (sb.length() != 0) res.add(sb.toString());
                sb = new StringBuilder();
            }else{
                sb.append(ch);
            }
        }

        if (sb.length() != 0) res.add(sb.toString());

        return res;
    }
}
