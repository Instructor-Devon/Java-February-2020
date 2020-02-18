public class TrieNode {
	public char letter;
	public TrieNode[] children;
	public boolean isWord;
	public static int charToIndex(char letter) {
		int offset = 10;
		return Character.getNumericValue(letter) - offset;
	}
	public TrieNode(char letter) {
		this.letter = letter;
		isWord = false;
		children = new TrieNode[26];
	}
}