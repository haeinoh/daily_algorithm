import java.util.Arrays;
import java.util.Comparator;

public class Solution42577 {
    static class TrieNode {
        TrieNode[] next;
        boolean isLast;

        TrieNode() {
            next = new TrieNode[10];
            this.isLast = false;
        }
    }

    static class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            TrieNode node = root;

            for(int i = 0; i < word.length(); i++) {
                int w = Character.getNumericValue(word.charAt(i));
                if(node.next[w] == null) node.next[w] = new TrieNode();
                node = node.next[w];
            }
            node.isLast = true;
        }

        boolean contains(String word) {
            TrieNode node = root;

            for(int i = 0; i < word.length(); i++) {
                int w = Character.getNumericValue(word.charAt(i));

                if(node.next[w] == null) return false;
                node = node.next[w];
                if(node.isLast) return true;
            }
            if(node.isLast) return true;
            return false;
        }
    }
    static boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        Trie t = new Trie();
        for(int i = 0; i < phone_book.length; i++) {
            if(!t.contains(phone_book[i])) t.insert(phone_book[i]);
            else {
                answer = false;
                break;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        String[] p = {"119", "97674223", "1195524421"};
        System.out.println(solution(p));
    }
}
