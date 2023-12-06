package com.trie;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for(String i : strs){
            if(i.equals("")) {

                return ""; }
            trie.insert(i);
        }
        return trie.check2(strs.length);
        //return "espera";

    }


}

class Node {

    Node[] children;
    boolean isEnd;
    int repetition;
    public Node() {
        children = new Node[26];
        isEnd = false;
        repetition= 0;
    }
    public Node getChild (char c) {return children[c - 'a']; }

    public void setChild(char c, Node node){
        children[c - 'a'] = node;
    }

    public void setEnd(boolean bool){
        isEnd = bool;
    }
    public boolean getEnd() {return isEnd; }

}

class Trie {
    final Node root;
    public Trie(){
        root = new Node();
    }

    public void insert (String st){
        Node current = root;
        for(char c : st.toCharArray()) {
            if(current.getChild(c) == null){
                current.setChild(c, new Node());
            }

            current = current.getChild(c);
            current.repetition++;
            // System.out.println(c + " = " + current.repetition);
        }
        current.setEnd(true);
    }

    public String check2(String s, int n){
        Node current = root;
        for (int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if(current.getChild(c) != null && current.getChild(c).repetition == n){
                current = current.getChild(c);
            }
            else return s.substring(0,i);
        }
        return s;

    }

    public String check2(int n){
        Node current = root;
        StringBuilder sb = new StringBuilder();
        char ch = 'a';
        while(ch <= 'z'){
            if(current.getChild(ch) != null && current.getChild(ch).repetition == n){

                current = current.getChild(ch);
                sb.append(ch);
                ch = 'a';
            }else ch++;
            //if(i == 'w') System.out.println(current.getChild('e').repetition);

        }
        return sb.toString();
    }

    public String check(){
        List<Character> chList = new ArrayList<>();
        traverse2(root, chList);
        if(chList.size() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for(char c: chList){
            sb.append(c);
        }
        return sb.toString();


    }

    private void traverse2(Node node, List<Character> list){
        int repeated = 0;
        char chCurrent = ' ';
        Node current = node;
        for(char i = 'a'; i<= 'z'; i++){
            if(node.getChild(i) != null && !node.getChild(i).getEnd()){
                repeated++;
                current = node.getChild(i);
                chCurrent = i;
            }

        }
        if(repeated == 1){
            list.add(chCurrent);
            traverse2(current, list);

        }
        return;

    }

    public void printTrie() {
        printTrie(root, "");
    }

    private void printTrie(Node currentNode, String prefix) {
        if (currentNode.getEnd()) {
            System.out.println(prefix);
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            Node child = currentNode.getChild(ch);
            if (child != null) {
                printTrie(child, prefix + ch);
            }
        }
    }



    public void printTrie1(){
        //List<Character> list = new ArrayList<>();

        traverse(root);
        //for(char i: list) System.out.println(i);
        //System.out.println(list.toString());
    }

    private void traverse(Node node){
        for(char i = 'a'; i<= 'z'; i++){
            if(node.getChild(i) != null){
                System.out.println(i);
                traverse(node.getChild(i));
            }

        }
    }
}