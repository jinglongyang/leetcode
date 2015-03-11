package tree;

import java.util.Stack;

/**
 * Created by jinglongyang on 3/3/15.
 */
public class Trie {
    private TrieNode root = new TrieNode(' ');

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("aaron");
        trie.insert("emy");
        trie.insert("abc");

        System.out.println(trie.find("ad"));
        System.out.println(trie.find("ab"));
        trie.insert("ab");
        System.out.println(trie.find("ab"));
        System.out.println(trie.find("aaron"));
        trie.delete("ab");
        System.out.println(trie.find("ab"));
        trie.delete("abc");
        System.out.println(trie.find("abc"));
    }

    public void insert(String word) {
        preCheck(word);
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode[] children = cur.children;
            char c = word.charAt(i);
            int idx = c - 'a';
            TrieNode node = children[idx];
            if (node == null) {
                node = new TrieNode(c);
                children[idx] = node;
            }
            cur = node;
        }
        cur.setWord(true);
    }

    public boolean delete(String word) {
        preCheck(word);
        Stack<TrieNode> stack = new Stack<>();
        stack.push(root);
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode[] children = cur.children;
            char c = word.charAt(i);
            int idx = c - 'a';
            TrieNode node = children[idx];
            if (node == null) {
                return false;
            }
            stack.push(node);
            cur = node;
        }
        if (!cur.isWord()) {
            return false;
        }
        if (!isEmpty(cur.children)) {
            cur.setWord(false);
        } else {
            TrieNode node = stack.pop();
            while (!stack.isEmpty()) {
                TrieNode parent = stack.peek();
                parent.children[node.value - 'a'] = null;
                if (parent.isWord() || !isEmpty(parent.children)) {
                    break;
                } else {
                    node = stack.pop();
                }
            }
        }
        return true;
    }

    private void preCheck(String word) {
        if (word == null || word.length() == 0) {
            throw new IllegalArgumentException("");
        }
    }

    private boolean isEmpty(TrieNode[] children) {
        for (TrieNode child : children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }

    public boolean find(String word) {
        preCheck(word);
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode[] children = cur.children;
            char c = word.charAt(i);
            int idx = c - 'a';
            TrieNode node = children[idx];
            if (node == null) {
                return false;
            }
            cur = node;
        }
        return cur.isWord();
    }

    private static class TrieNode {
        private char value;
        private TrieNode[] children = new TrieNode[26];
        private boolean word;

        public TrieNode(char value) {
            this.value = value;
        }

        public boolean isWord() {
            return word;
        }

        public void setWord(boolean word) {
            this.word = word;
        }

        public TrieNode[] getChildren() {
            return children;
        }
    }
}
