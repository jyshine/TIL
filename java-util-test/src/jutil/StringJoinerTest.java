package jutil;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class StringJoinerTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("A", "B", "C", "D");

        // StirngJoiner 생성
        StringJoiner joiner = new StringJoiner(",");

        // StringJoiner Add
        strings.forEach(s -> {
            joiner.add(s);
            System.out.println(joiner.length());
        });

        // StringJoiner merge
        StringJoiner joiner2 = new StringJoiner(",");
        joiner2.add("E");
        joiner2.add("F");
        joiner2.add("G");
        System.out.println(joiner.merge(joiner2));

        // String prefix, suffix생성
        StringJoiner joiner3 = new StringJoiner(",","[","]");
        strings.forEach(joiner3::add);
        System.out.println(joiner3);
        StringJoiner joiner4 = new StringJoiner(",");
        joiner4.add("E");
        joiner4.add("F");
        joiner4.add("G");
        System.out.println(joiner3.merge(joiner4));
        System.out.println(joiner4.merge(joiner3));

        // length
        System.out.println(joiner);
        System.out.println(joiner.length());

        // setEmpty list
        StringJoiner joiner5 = new StringJoiner(",");
        joiner5.setEmptyValue("Empty value");
        System.out.println(joiner5);


        // StringJoinerCustom 테스트
        System.out.println("************joinerCustom start***********");
        StringJoinerCustom joinerCustom = new StringJoinerCustom(",");
        List<String> strings2 = Arrays.asList("A", "B", "C", "D");
        strings2.forEach(s -> {
            joinerCustom.add(s);
            System.out.println(joinerCustom.length());
        });

        Arrays.stream(joinerCustom.getElts()).forEach(
                s -> System.out.println(s)
        );
    }
}

class StringJoinerCustom {
    final String prefix;
    final String delimiter;
    final String suffix;

    String emptyValue;
    String[] elts;
    /** The number of string components added so far. */
    private int size;
    /** Total length in chars so far, excluding prefix and suffix. */
    private int len;

    public StringJoinerCustom(String delimiter) {
        this(delimiter, "", "");
    }

    public StringJoinerCustom(CharSequence prefix, CharSequence delimiter, CharSequence suffix) {

        this.prefix = prefix.toString();
        this.delimiter = delimiter.toString();
        this.suffix = suffix.toString();
    }

    public StringJoinerCustom add(CharSequence newEliement) {
        final String elt = String.valueOf(newEliement);
        if (elts == null) {
            elts = new String[8];
        } else {
            if (size == elts.length)
                elts = Arrays.copyOf(elts, 2 * size);
            len += delimiter.length();
        }
        len += elt.length();
        elts[size++] = elt;
        return this;
    }

    public String[] getElts() {
        return elts;
    }

    public int length() {
//        System.out.println(len + " / "+ prefix.length() +" / "+ suffix.length());
        return (size == 0 && emptyValue != null) ? emptyValue.length() :
                len + prefix.length() + suffix.length();
    }
}