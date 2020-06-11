import java.util.HashMap;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String common = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (common == "") {
                return "";
            }
            int index = strs[i].indexOf(common);
            if (index != 0) {
                common = common.substring(0, common.length() - 1);
            } else {
                i++;
            }
        }
        return common;
    }

    public String longestCommonPrefixu(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String common = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(common) != 0) {
                common = common.substring(0, common.length() - 1);
            }
            if (common.isEmpty()) {
                return "";
            }
        }
        return common;
    }

}

class TrieNode {
    private HashMap<Character, TrieNode> childrenMap;
    private boolean isEnd;

    public TrieNode() {
        childrenMap = new HashMap<>();
    }

    public boolean isContain(char ch) {
        return childrenMap.get(ch) != null;
    }

    public void putChild(char ch, TrieNode child) {
        childrenMap.put(ch, child);
    }

    public TrieNode getChild(char ch) {
        return childrenMap.get(ch);
    }

    public void setEnd(boolean is) {
        isEnd = is;
    }

    public boolean isEnd() {
        return isEnd;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String str) {
        TrieNode curr = root;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if (!curr.isContain(ch)) {
                TrieNode child = new TrieNode();
                curr.putChild(ch, child);
            }
            curr = curr.getChild(ch);
        }
        curr.setEnd(true);
    }

    public TrieNode searchPrefix(String str) {
        TrieNode curr = root;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if (!curr.isContain(ch)) {
                return null;
            }
            curr = curr.getChild(ch);
        }
        return curr;
    }

    public boolean search(String str) {
        TrieNode curr = searchPrefix(str);
        return curr != null && curr.isEnd();
    }

    public boolean startsWith(String str) {
        TrieNode curr = searchPrefix(str);
        return curr != null;
    }

    public void delete(String str) {

    }

}

class Test {
    public static void main(String[] args) {

        // Your Trie object will be instantiated and called as such:
        Trie obj = new Trie();
        obj.insert("word");
        boolean param_2 = obj.search("word");
        boolean param_3 = obj.startsWith("prefix");

    }
}