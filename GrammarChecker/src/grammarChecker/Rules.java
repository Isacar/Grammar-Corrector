package grammarChecker;

import java.util.ArrayList;
import java.util.List;

public class Rules {
	
	List<Rule> rules;
	
	public List<Rule> getRules() {
		return rules;
	}

	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

	public Rules() {
	
        rules = new ArrayList<Rule>();
        Rule newRule = new Rule(" S ", " NP VP ");
        rules.add(newRule);
        newRule = new Rule(" NP ", " DT NN ");
        rules.add(newRule);
        newRule = new Rule(" NP ", " IN NN ");
        rules.add(newRule);
        newRule = new Rule(" VP ", " VBD NP ");
        rules.add(newRule);
        newRule = new Rule(" VP ", " VB NP ");
        rules.add(newRule);
        newRule = new Rule(" VP ", " VB NP PP ");
        rules.add(newRule);
        newRule = new Rule(" NN ", " JJ NN ");
        rules.add(newRule);
        newRule = new Rule(" VP ", " VB PP ");
        rules.add(newRule);
        newRule = new Rule(" VP ", " VBN NP ");
        rules.add(newRule);
        newRule = new Rule(" VP ", " VBN IN S ");
        rules.add(newRule);
        newRule = new Rule(" NP ", " NP CC NP ");
        rules.add(newRule);
        newRule = new Rule(" VP ", " VP CC VP ");
        rules.add(newRule);
        newRule = new Rule(" S ", " S CC S ");
        rules.add(newRule);
        newRule = new Rule(" S ", " S VB ");
        rules.add(newRule);
        
        
	}

	
}
