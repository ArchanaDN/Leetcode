import java.util.*;

class Node {
    Map<Character, Node> children = new HashMap<>();
    boolean endOfWord;
}

class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
    }


    public void insert(String word) {
        Node currNode = root;
        for (int i = 0; i < word.length(); i++) {
            if (!currNode.children.containsKey(word.charAt(i))) {
                currNode.children.put(word.charAt(i), new Node());
            }
            currNode = currNode.children.get(word.charAt(i));
        }
        currNode.endOfWord = true;
    }

    public boolean search(String word) {
        Node currNode = root;
        for (int i = 0; i < word.length(); i++) {
            if (!currNode.children.containsKey(word.charAt(i))) {
                return false;
            }
            currNode = currNode.children.get(word.charAt(i));
        }
        return currNode.endOfWord;
    }

    public boolean startsWith(String prefix) {
        Node currNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!currNode.children.containsKey(prefix.charAt(i))) {
                return false;
            }
            currNode = currNode.children.get(prefix.charAt(i));
        }
        return true;
    }
}
