package swea.month05.week01.day0505.problem1231;

import java.io.*;
import java.util.*;
class Node{
    char ch;
    List<Integer> child;
    //Have no child
    Node(char ch){
        this.ch = ch;
        child = new ArrayList<>();
    }
    //Only have left child
    Node(char ch,int leftVid){
        this.ch = ch;
        child = new ArrayList<>();
        child.add(leftVid);
    }
    //Have left and right child
    Node(char ch,int leftVid,int rightVid){
        this.ch = ch;
        child = new ArrayList<>();
        child.add(leftVid);
        child.add(rightVid);
    }
}
public class Solution {
    static Node[] tree;
    static StringBuilder sb;

    static void inorder(int vid) {
        if(vid==-1) return;

        Node node = tree[vid];
        int leftVid = -1;
        int rightVid = -1;
        if(node.child.size()==2){
            leftVid = node.child.get(0);
            rightVid = node.child.get(1);
        }

        else if(node.child.size()==1){
            leftVid=  node.child.get(0);
        }

        inorder(leftVid);
        sb.append(node.ch);
        inorder(rightVid);

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int T = 10;
        for(int tc=1;tc<=T;tc++){
            int N = Integer.parseInt(br.readLine());
            tree = new Node[N+1];
            for(int i=1;i<=N;i++) {
                String[] tokens = br.readLine().split(" ");
                int vid = Integer.parseInt(tokens[0]);
                char ch = tokens[1].charAt(0);

                //Have no child
                if (tokens.length == 2) {
                    Node node = new Node(ch);
                    tree[vid] = node;
                }
                //Only have left child
                else if (tokens.length == 3) {
                    int leftVid = Integer.parseInt(tokens[2]);
                    Node node = new Node(ch, leftVid);
                    tree[vid] = node;
                }
                //Have left and right child
                else if (tokens.length == 4) {
                    int leftVid = Integer.parseInt(tokens[2]);
                    int rightVid = Integer.parseInt(tokens[3]);
                    Node node = new Node(ch, leftVid, rightVid);
                    tree[vid] = node;
                }
            }
            sb.append("#").append(tc).append(" ");
            inorder(1);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
