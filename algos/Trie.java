import java.util.List;

public class Trie {
	TrieNode root;
	public Trie() {
		root = new TrieNode(' ');
	}
	public void addWord(String word) {
		// loop through word
		TrieNode runner = this.root;
		for(char c: word.toCharArray()) {
			int letterIdx = TrieNode.charToIndex(c);
			// check if char in word has child node
			if(runner.children[letterIdx] == null) {
				// if not there, add new node
				runner.children[letterIdx] = new TrieNode(c);
			}
			// travel into node at char/index
			runner = runner.children[letterIdx];
		}
		runner.isWord = true;
		// when end is reached, set currentNode isWord
	}
	public boolean hasWord(String word) {
		return false;
	}
	public List<String> autocomplete(String prefix) {
		// prefix: ap
		// travel through prefix until node at end (p node)
		// maybe recursion?
		
		return null;
	}
}
