package grammarChecker;
//Google Spell checker API
import java.util.HashMap;
import java.util.Map;




//Stanford POS Tagger API
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class GrammarChecker {

	static Map  <String, String> rules;
	
	public static void main(String[] args) {
		// Initialize the tagger
        MaxentTagger tagger = new MaxentTagger(
                "taggers/english-left3words-distsim.tagger");
 
        // The sample string
        String sample = "The dog saw a man";
        //List<String> rules = new ArrayList<String>();
        rules = new HashMap<String, String>();
        //List<rules> 
        rules.put("S", "NP VBP");
        rules.put("NP", "DT NN");
        rules.put("VBP", "VBD NP");
        
        
        // The tagged string
        String tagged = tagger.tagString(sample);
        
        //get sentence in form of tags
        tagged = POSTSentence (tagged);
      
        //Apply rules to sentence
        tagged = matchRules(tagged);
        // Output the result
        System.out.println(tagged);

	}
	
	
	/***
	 * Will return the sentence in form of pos tags
	 * @param sentence
	 * @return
	 */
	private static String POSTSentence (String sentence){
		String POSTs = "";
		String[] words = sentence.split(" ");
		String word = new String();
		
		for(int i = 0; i < words.length; i++){
			word = words[i];
			String[] wordParts = word.split("_");
			POSTs += wordParts[1] + " ";
		}
		
		return POSTs;
	}
	
	/*** 
	 * Returns a post sentence with rules applied to it
	 * @param postSentence
	 * @return matchedSentence
	 */
	private static String matchRules(String postSentence){
		
		System.out.println(postSentence);
		
		String matchedSentence = new String();
		matchedSentence = applySubs (postSentence);
		
		while(matchedSentence.equals(postSentence) == false){
			postSentence = matchedSentence;
			matchedSentence = applySubs (postSentence);
		}
	
		return matchedSentence;
		
	}
	
	/**
	 * Applies rules to post sentence
	 * Helper function to matchRules
	 * @param matchedSentence
	 * @return
	 */
	private static String applySubs(String matchedSentence){

			//Iterate through the rules
			for(String key : rules.keySet()){
				//Match and replace each rule against the sentence
				matchedSentence = matchedSentence.replaceAll(rules.get(key), key);
			}
		return matchedSentence;
	}

}
