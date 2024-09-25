class Node {
    Node arr[];
    int count;

    Node() {
        arr = new Node[26];
        count = 0;
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void addWordToPrefix(String word) {
        Node temp = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (temp.arr[index] == null) {
                temp.arr[index] = new Node();
            }
            temp.arr[index].count++;
            temp = temp.arr[index];
        }
    }

    public int prefixCount(String word) {
        Node temp = root;
        int prefixCount = 0;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (temp.arr[index] == null) {
                break;
            }
            temp = temp.arr[index];
            prefixCount += temp.count;

        }
        return prefixCount;
    }
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        int ans[] = new int[words.length];
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWordToPrefix(word);
        }
        int index = 0;
        for (String word : words) {
            ans[index++] = trie.prefixCount(word);
        }
        return ans;
    }
}