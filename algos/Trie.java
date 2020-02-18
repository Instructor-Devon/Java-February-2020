import java.util.ArrayList;
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
	public boolean validPrefix(String word) { // word: "ca"
		// start at root
		TrieNode runner = this.root;
		// iterate letters in "word"
		
		
		for(char c:word.toCharArray()) {
			int i = TrieNode.charToIndex(c);
			// check if each letter is a valid child
			if(runner.children[i] == null) {
				// if not... return false
				return false;
			}
			// if so, move into that child location
			runner = runner.children[i];
		}
		
		// when we are done iterating...
		return true;
	}
	public boolean hasWord(String word) { // word: "ca"
		// start at root
		TrieNode runner = this.root;
		// iterate letters in "word"
		
		
		for(char c:word.toCharArray()) {
			int i = TrieNode.charToIndex(c);
			// check if each letter is a valid child
			if(runner.children[i] == null) {
				// if not... return false
				return false;
			}
			// if so, move into that child location
			runner = runner.children[i];
		}
		
		// when we are done iterating...
		// check runner for .isWord
		return runner.isWord;
	}
	public List<String> autocomplete(String prefix) {
		// prefix: ca
		// => ["cat", "car"]
		ArrayList<String> words = new ArrayList<String>();
		// travel through prefix until node at end (p node)
		// start at root
		
		TrieNode runner = this.root;
		// build up substring
		String substring = "";
		
		for(char c:prefix.toCharArray()) {
			int i = TrieNode.charToIndex(c);
			// check if each letter is a valid child
			if(runner.children[i] == null) {
				// if not... return false
				return words;
			}
			substring += runner.children[i].letter;
			// if so, move into that child location
			runner = runner.children[i];
		}
		//             { a }  []      "ca"
		this.rAddWords(runner, words, substring);
		// maybe build substrings as we...
		// maybe recursion?
		
		return words;
	}
	public void rAddWords(TrieNode node, List<String> words, String substring) {
		// base case!
		if(node == null) {
			return;
		}
		// check node for .isWord
		if(node.isWord) {
			words.add(substring);
		}
		
		for(TrieNode child : node.children) {
			// descend into node's children
			// build up substring???
			if(child != null) {
				this.rAddWords(child, words, substring+child.letter);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
