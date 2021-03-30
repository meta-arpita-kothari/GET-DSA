package dictionary;

/**
 * class containing key-value pair information
 * 
 */
public class Pair {
	private String key;
	private String value;
	
	public Pair (String key,String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * @return key value of Pair
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @return value from Pair
	 */
	public String getValue() {
		return value;
	}

	public void setKey(String key) {
		this.key = key;
	}

	
	
}