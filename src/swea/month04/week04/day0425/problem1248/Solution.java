    package swea.month04.week04.day0425.problem1248;

    import java.io.*;
    import java.util.*;

    class Node {
        int vid;
        Node left;
        Node right;
        Node parent;

        public Node(int vid) {
            this.vid = vid;
            this.left = this.right = this.parent = null;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public Node getParent() {
            return parent;
        }

        public void setLeft(Node node) {
            this.left = node;
        }

        public void setRight(Node node) {
            this.right = node;
        }

        public void setParent(Node node) {
            this.parent = node;
        }

    }

    class Tree {
        Node root;

        public Tree() {
            this.root = new Node(1);
        }

        public void insertNode(int parentVid, int childVid) {
            Node parentNode = searchNode(root, parentVid);
            if (parentNode == null) return;

            Node childNode = new Node(childVid);
            if (parentNode.getLeft() == null) parentNode.setLeft(childNode);
            else parentNode.setRight(childNode);

            childNode.setParent(parentNode);
        }

        public Node searchNode(Node node, int vid) {
            if (node == null) return null;
            if (node.vid == vid) return node;
            Node res = searchNode(node.getLeft(), vid);

            if (res != null) return res;

            return searchNode(node.getRight(), vid);

        }
        public int getSize(Node node) {
            if (node == null) return 0;
            return 1 + getSize(node.getLeft()) + getSize(node.getRight());
        }
    }

    public class Solution {
        static void traversal(Node node, List<Integer> list) {
            if (node==null)
                return;
            list.add(node.vid);
            traversal(node.getParent(), list);
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            for (int tc = 1; tc <= T; tc++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int V = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                Tree tree = new Tree();
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < E; i++) {
                    int parentVid = Integer.parseInt(st.nextToken());
                    int childVid = Integer.parseInt(st.nextToken());
                    tree.insertNode(parentVid, childVid);
                }
                List<Integer> ancestorV1 = new ArrayList<>();
                List<Integer> ancestorV2 = new ArrayList<>();

                Node node1 = tree.searchNode(tree.root, v1);
                Node node2 = tree.searchNode(tree.root, v2);

                traversal(node1, ancestorV1);
                traversal(node2, ancestorV2);

                int i = ancestorV1.size() - 1;
                int j = ancestorV2.size() - 1;
                int answer = -1;
                while (i >= 0 && j >= 0) {
                    if (!ancestorV1.get(i).equals(ancestorV2.get(j))) {
                        break;
                    }
                    answer = ancestorV1.get(i);
                    i--;
                    j--;
                }
                Node subroot = tree.searchNode(tree.root,answer);
                int size = tree.getSize(subroot);
                System.out.println("#"+tc+ " "+answer+ " "+size);
            }
        }
    }
