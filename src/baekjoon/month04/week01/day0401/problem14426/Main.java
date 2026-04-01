package baekjoon.month04.week01.day0401.problem14426;

import java.io.*;
import java.util.*;
class Node{
	char ch;
	List<Node> child;
	public Node(char ch) {
		this.ch = ch;
		this.child = new ArrayList<>();
	}
	public Node find(char ch) {
		for(Node node : child) {
			if(node.ch==ch) return node;
		}
		return null;
	}
	public void addNode(Node node) {
		child.add(node);
	}
}
class Tree{
	Node root;
	public Tree() {
		this.root = new Node('#');
	}
	public void construct(Node node,String str, int index) {
		if(index==str.length())
			return;
		Node childNode = node.find(str.charAt(index));
		if(childNode!=null) {
			construct(childNode,str,index+1);//재귀호출
		}
		else {
			Node newNode = new Node(str.charAt(index));
			node.addNode(newNode);//추가
			construct(newNode,str,index+1);//추가 후 재귀
		}
	}
	
	public boolean isPrefix(Node node,String str, int index) {
		if(index==str.length()) {
			return true;
		}
		Node childNode = node.find(str.charAt(index));
		if(childNode!=null) {
			isPrefix(childNode,str,index+1);
		}
		return false;
		
	}
}
public class Main {
	static int cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N= Integer.parseInt(st.nextToken());
		int M= Integer.parseInt(st.nextToken());
		
		Tree tree = new Tree();
		for(int i=0;i<N;i++) {
			String word = br.readLine();
			tree.construct(tree.root, word, 0);
		}
		int cnt=0;
		for(int i=0;i<M;i++) {
			String word = br.readLine();
			if(tree.isPrefix(tree.root, word, 0)) cnt+=1; 
		}
		System.out.println(cnt);
	}
}
