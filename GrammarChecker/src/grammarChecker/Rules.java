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
        
        newRule = new Rule(" S ", " PRP VBP JJ ");
        rules.add(newRule);
        
        newRule = new Rule(" NP ", " DT NN ");
        rules.add(newRule);
        
        newRule = new Rule(" VP ", " VB S ");
        rules.add(newRule);
        
        newRule = new Rule(" NP ", " PDT NP ");
        rules.add(newRule);
        
        newRule = new Rule(" NP ", " NNP NNP ");
        rules.add(newRule);
        
        newRule = new Rule(" NP ", " NN IN NP ");
        rules.add(newRule);
        
        newRule = new Rule(" NP ", " NP IN NP ");
        rules.add(newRule);
        
        newRule = new Rule(" NP ", " DT IN DT ");
        rules.add(newRule);
        
        
        newRule = new Rule(" NP ", "  NP VBG IN NNP ");
        rules.add(newRule);
       
        
        newRule = new Rule(" NP ", " NP VBG IN NP IN DT JJ ");
        rules.add(newRule);
         
        
        newRule = new Rule(" NP ", " DT NNS ");
        rules.add(newRule);
        
        newRule = new Rule(" NP ", " PDT DT NN ");
        rules.add(newRule);
        
        newRule = new Rule(" NP ", " PDT DT NNS ");
        rules.add(newRule);
        
        newRule = new Rule(" NP ", " PDT NN ");
        rules.add(newRule);
        
        newRule = new Rule(" NP ", " PDT NNS ");
        rules.add(newRule);
        
        
        newRule = new Rule(" NP ", " CD NNS ");
        rules.add(newRule);
        
        newRule = new Rule(" NP ", " CD NN ");
        rules.add(newRule);
        
        
        newRule = new Rule(" NP ", " DT JJS NN NN ");
        rules.add(newRule);
        
        newRule = new Rule(" NP ", " NP IN NNP ");
        rules.add(newRule);
        
        newRule = new Rule(" NP ", " DT NNS VBG IN NNS RB ");
        rules.add(newRule);
       
        newRule = new Rule(" NP ", " DT NN WDT VBZ NN ");
        rules.add(newRule);
        
        newRule = new Rule(" NP ", " NP WDT VBZ NN ");
        rules.add(newRule);
        
        newRule = new Rule(" NP ", " NP CD ");
        rules.add(newRule);
        
        newRule = new Rule(" NP ", " NP TO NNP ");
        rules.add(newRule);
        
        newRule = new Rule(" NP ", " NN IN NNP ");
        rules.add(newRule);
        
        newRule = new Rule(" NP ", " NP CC NP ");
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
