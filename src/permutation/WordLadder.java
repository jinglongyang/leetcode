package permutation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://oj.leetcode.com/problems/word-ladder/
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * <p/>
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class WordLadder {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("a");
        dict.add("b");
        dict.add("c");
        System.out.println(new WordLadder().ladderLength("a", "c", dict));
        WordLadder wordLadder = new WordLadder();
        WordLadder.Wrapper wrapper = wordLadder.new Wrapper("", 1);
    }

    public int ladderLength(String start, String end, Set<String> dict) {
        if (start.equals(end)) return 0;
        Queue<Wrapper> queue = new LinkedList<>();
        queue.add(new Wrapper(start, 1));
        dict.remove(start);
        while (!queue.isEmpty()) {
            Wrapper wrapper = queue.poll();
            String word = wrapper.word;
            for (char c = 'a'; c < 'z'; c++) {
                for (int i = 0; i < word.length(); i++) {
                    if (c != word.charAt(i)) {
                        String newWord = getNewWord(word, i, c);
                        if (newWord.equals(end)) {
                            return wrapper.step + 1;
                        }
                        if (dict.contains(newWord)) {
                            queue.offer(new Wrapper(newWord, wrapper.step + 1));
                            dict.remove(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }

    private String getNewWord(String word, int index, char c) {
        StringBuilder sb = new StringBuilder(word);
        sb.setCharAt(index, c);
        return sb.toString();
    }

    private class Wrapper {
        private String word;
        private int step;

        Wrapper(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
}
