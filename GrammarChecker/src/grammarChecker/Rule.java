package grammarChecker;

public class Rule {
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private String key;
	private String value;
	
	public Rule(String key1, String value1) {
		
		setKey(key1);
		setValue(value1);
	}

}
