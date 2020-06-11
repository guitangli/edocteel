import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

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
    public HashMap<Character, TrieNode> childrenMap;
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
        TrieNode node = searchPrefix(str);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String str) {
        TrieNode node = searchPrefix(str);
        return node != null;
    }

    public List<String> getAllWithPrefix(String str) {
        TrieNode node = searchPrefix(str);
        if (node == null) {
            return null;
        }
        return getAllByNode(node, str);
    }

    public List<String> getAllByNode(TrieNode node, String prefix) {
        List<String> list = new ArrayList<String>();
        StringBuffer str = new StringBuffer(prefix);
        recursiveTraverse(node, str, list);
        return list;
    }

    private void recursiveTraverse(TrieNode node, StringBuffer str, List<String> list) {
        if (node.isEnd()) {
            list.add(str.toString());
            return;
        }
        for (Map.Entry pair : node.childrenMap.entrySet()) {
            Character key = (Character) pair.getKey();
            TrieNode child = (TrieNode) pair.getValue();
            if (child != null) {
                str.append(key);
                recursiveTraverse(child, str, list);
                str = str.deleteCharAt(str.length() - 1);
            }
        }
    }

    public void delete(String str) {

    }

}

class Test {
    public static void main(String[] args) {

        // Your Trie object will be instantiated and called as such:
        Trie obj = new Trie();
        obj.insert("lword");
        obj.insert("ltiantiankuaile");
        obj.insert("lwoaini");
        obj.insert("lwomenlove");
        boolean param_2 = obj.search("lword");
        boolean param_3 = obj.startsWith("lprefix");
        List<String> out = obj.getAllWithPrefix("");
        System.out.print(out);

    }
}