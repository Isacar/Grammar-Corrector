package grammarChecker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SpellChecker extends GrammarChecker {
// By David Harkness
	private Dictionary dict;
    final static String filePath = "dictionary/dictionary.txt";
    final static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    SpellChecker() {
        dict = new Dictionary();
        dict.build(filePath);

    }

    boolean run (String input) {
        //String result = "";
    	boolean correct = true;
    	String[] words = input.split(" ");
		String word = new String();
		
		
		for(int i = 1; i < words.length; i++){
			word = words[i];
			String tag = tagger.tagString(word);
			tag = POSTWord(tag).trim();
			if(!tag.contentEquals("NNS") && !tag.contentEquals("NNPS") && !tag.contentEquals("NNP")) {
				if (!dict.contains(word)) {
	                System.out.print(word + " is not spelled correctly. ");
	                System.out.println(printSuggestions(word));
	                correct = false;
	            }
			}
		}
           
        return correct; 
    }

    String printSuggestions(String input) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> suggs = makeSuggestions(input);
        Set<String> suggestions = new HashSet<String>();

        for(String word : suggs) {
            suggestions.add(word);
        }
        if (suggestions.size() == 0) {
            return "and there are no suggestions.\n";
        }
        sb.append("Suggestions:\n");
        for (String s : suggestions) {
            sb.append("\n  -" + s);
        }
        return sb.toString();
    }

    private ArrayList<String> makeSuggestions(String input) {
        ArrayList<String> toReturn = new ArrayList<>();
        toReturn.addAll(charAppended(input));
        toReturn.addAll(charMissing(input));
        toReturn.addAll(charsSwapped(input));
        return toReturn;
    }

    private ArrayList<String> charAppended(String input) { 
        ArrayList<String> toReturn = new ArrayList<>();
        for (char c : alphabet) {
            String atFront = c + input;
            String atBack = input + c;
            if (dict.contains(atFront)) {
                toReturn.add(atFront);
            }
            if (dict.contains(atBack)) {
                toReturn.add(atBack);
            }
        }
        return toReturn;
    }

    private ArrayList<String> charMissing(String input) {   
        ArrayList<String> toReturn = new ArrayList<>();

        int len = input.length() - 1;
        //try removing char from the front
        if (dict.contains(input.substring(1))) {
            toReturn.add(input.substring(1));
        }
        for (int i = 1; i < len; i++) {
            //try removing each char between (not including) the first and last
            String working = input.substring(0, i);
            working = working.concat(input.substring((i + 1), input.length()));
            if (dict.contains(working)) {
                toReturn.add(working);
            }
        }
        if (dict.contains(input.substring(0, len))) {
            toReturn.add(input.substring(0, len));
        }
        return toReturn;
    }

    private ArrayList<String> charsSwapped(String input) {   
        ArrayList<String> toReturn = new ArrayList<>();

        for (int i = 0; i < input.length() - 1; i++) {
            String working = input.substring(0, i);// System.out.println("    0:" + working);
            working = working + input.charAt(i + 1);  //System.out.println("    1:" + working);
            working = working + input.charAt(i); //System.out.println("    2:" + working);
            working = working.concat(input.substring((i + 2)));//System.out.println("    FIN:" + working); 
            if (dict.contains(working)) {
                toReturn.add(working);
            }
        }
        return toReturn;
    }

    public static void main(String[] args) {
        //SpellChecker sc = new SpellChecker();
        //sc.run();
    }
}
