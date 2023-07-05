package com.SegoviaEli.Creational.Builder;

public class Demo {
    public static void main(String[] args) {

        /**
         * Below we will build an html-style unordered list
         * We will do so using a built-in Builder to demo how a Builder
         * makes your life a lot easier
         *
         *
         * So as we can see builders are pretty cool!!!
         */

        // The words we want to list in an unordered list
        String [] words = {"Hello", "World"};

        StringBuilder sb = new StringBuilder();
        sb.append("<ul>\n");
        for (String word : words) {
            sb.append(String.format(" <li>%s</li>\n", word));
        }

        sb.append("<ul>");
        System.out.println(sb);
        /**
         * output:
         * <ul>
         *     <li>Hello</li>
         *     <li>World</li>
         * </ul>
         */

        /**
         * So... this illustrates that builders are great at incrementally building an object
         * If you don't need everything all at once, but rather want to construct thigns
         * in a piece-wise manner, then Builder DP is great
         */

    }
}
