class Node {
    Node arr[];

    Node() {
        arr = new Node[10];
    }
}

class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    public void addPrefix(String number) {
        Node temp = root;
        for (char ch : number.toCharArray()) {
            int digit = ch - '0';
            if (temp.arr[digit] == null) {
                temp.arr[digit] = new Node();
            }
            temp = temp.arr[digit];
        }
    }

    public int lengthOfPrefix(String number) {
        Node temp = root;
        int len = 0;
        for (char ch : number.toCharArray()) {
            int digit = ch - '0';
            if (temp.arr[digit] == null) {
                break;
            }
            temp = temp.arr[digit];
            len++;
        }
        return len;
    }
}

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < arr1.length; i++) {
            trie.addPrefix(Integer.toString(arr1[i]));
        }
        for (int i = 0; i < arr2.length; i++) {
            int len = trie.lengthOfPrefix(Integer.toString(arr2[i]));
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}