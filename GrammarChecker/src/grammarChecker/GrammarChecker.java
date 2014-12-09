package grammarChecker;
//Google Spell checker API

//Stanford POS Tagger API
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class GrammarChecker {

	static Rules rules;
	
	public static void main(String[] args) {
		// Initialize the tagger
        MaxentTagger tagger = new MaxentTagger(
                "taggers/english-left3words-distsim.tagger");
 
        // The sample string
        String sample = " Does She have money ";
        rules = new Rules();
        
        // The tagged string
        String tagged = tagger.tagString(sample);
        System.out.println(tagged);
       
        //Fix personal pronoun tag
        tagged = " " + fixPRPtag (tagged) + " ";
        System.out.println(tagged);
        
        //get sentence in form of tags
        tagged = POSTSentence (tagged);
        
        //Apply rules to sentence
        //tagged = matchRules(tagged);
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
		
		for(int i = 1; i < words.length; i++){
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
		
		
		
		String matchedSentence = new String();
		matchedSentence = applySubs (postSentence);
		
		while(matchedSentence.equals(postSentence) == false){
			postSentence = matchedSentence;
			matchedSentence = applySubs (postSentence);
		}
	
		System.out.println("mathcRules: " + matchedSentence);
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
			for(Rule rule : rules.getRules()){
				//Match and replace each rule against the sentence
				matchedSentence = matchedSentence.replaceAll(rule.getValue(), rule.getKey());
				System.out.println("applySubs: " + matchedSentence);
			}
		return matchedSentence;
	}
	/***
	 * since stanford tagger doesnt tag 3rd person personal pronouns
	 * this function adds a z to the personal pronoun tags that are 3rd person
	 * @param postSentence
	 * @return
	 */
	private static String fixPRPtag(String postSentence){
		String newPostSentence = new String();
		newPostSentence = postSentence;
		
		if (newPostSentence.contains("She_PRP "))
			newPostSentence = newPostSentence.replaceAll("She_PRP ", "She_PRPZ " );
		else if (newPostSentence.contains("He_PRP  "))
			newPostSentence = newPostSentence.replaceAll("He_PRP ", "He_PRPZ " );
		else if(newPostSentence.contains("It_PRP "))
			newPostSentence = newPostSentence.replaceAll("It_PRP ", "It_PRPZ " );
			
		return newPostSentence;
	}

}
