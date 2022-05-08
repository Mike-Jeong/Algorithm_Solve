
import java.util.*;

//09052022
//Trie 연습

public class Practice_0905 {
    public static void main(String[] args) {
        Trie t = new Trie();

        t.addString("apple");
        t.addString("april");
        t.addString("app");
        t.addString("ice");
        t.addString("ace");
        t.addString("bear");
        t.addString("best");
        t.addString("postorder");

        t.seetrie(t.roots, 0);

        System.out.println(t.contains("app"));
        System.out.println(t.contains("be"));
        System.out.println(t.contains("pre"));
        System.out.println(t.contains("ab"));

    }
}

class Node {

    private char data;
    private boolean isLast = false;
    Map<Character, Node> childrCharacters;

    public Node(char data) {
        this.data = data;
        childrCharacters = new HashMap<>();
    }

    public void addChild(char data) {

        if (!childrCharacters.containsKey(data)) {
            childrCharacters.put(data, new Node(data));
        }
    }

    public char getData() {
        return data;
    }

    public boolean getLast() {
        return isLast;
    }

    public void setLast(boolean isLast) {
        this.isLast = isLast;
    }

}

class Trie {

    Map<Character, Node> roots = new HashMap<>();

    public void addString(String word) {

        char[] alphas = word.toCharArray();

        if (!roots.containsKey(alphas[0])) {
            roots.put(alphas[0], new Node(alphas[0]));
        }

        Node curNode = roots.get(alphas[0]);

        for (int i = 1; i < word.length(); i++) {

            curNode.addChild(alphas[i]);
            curNode = curNode.childrCharacters.get(alphas[i]);

        }

        curNode.setLast(true);
    }

    public boolean contains(String word) {

        char[] alphas = word.toCharArray();
        Node curNode;

        if (!roots.containsKey(alphas[0])) {
            return false;
        } else {

            curNode = roots.get(alphas[0]);

            for (int i = 1; i < alphas.length; i++) {
                if (!curNode.childrCharacters.containsKey(alphas[i])) {
                    return false;
                } else {
                    curNode = curNode.childrCharacters.get(alphas[i]);
                }
            }

            return true;

        }
    }

    public void seetrie(Map<Character, Node> rounds, int level) {
        for (char node : rounds.keySet()) {
            System.out.println(node + ", " + level);
            seetrie(rounds.get(node).childrCharacters, level + 1);

        }
    }

}