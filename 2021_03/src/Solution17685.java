//https://programmers.co.kr/learn/courses/30/lessons/17685

public class Solution17685 {
    static class TrieNode {
        TrieNode[] next;
        int count = 0;

        TrieNode() {
            next = new TrieNode[26];
            this.count = 0;
        }
    }

    static class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String str) {
            TrieNode node = root;

            for(int i = 0; i < str.length(); i++) {
                int idx = str.charAt(i) - 'a';
                if(node.next[idx] == null) node.next[idx] = new TrieNode();
                node.next[idx].count++;
                node = node.next[idx];
            }
        }

        int count(String str) {
            TrieNode node = root;
            int cnt = 0;
            for(int i = 0; i < str.length(); i++) {
                int idx = str.charAt(i) - 'a';
                cnt++;
                if(node.next[idx].count == 1) return cnt;
                node = node.next[idx];
            }
            return cnt;
        }
    }

    public static int solution(String[] words) {
        int answer = 0;
        Trie t = new Trie();
        for (String word : words) {
            t.insert(word);
        }

        for(String word: words) {
            answer += t.count(word);
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] w = {"go", "gone", "guild"};
//        String[] w = {"abc","def","ghi","jklm"};
        System.out.println(solution(w));

    }
}
