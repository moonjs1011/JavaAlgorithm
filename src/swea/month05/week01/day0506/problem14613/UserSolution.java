package swea.month05.week01.day0506.problem14613;

import java.util.HashMap;
class UserSolution {

    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }

        Node(Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }

    static class MyList {
        Node root;
        int length;

        MyList(Node root, int length) {
            this.root = root;
            this.length = length;
        }
    }

    private HashMap<String, MyList> map;

    public void init() {
        map = new HashMap<>();
    }

    public String arrToString(char mName[]) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < mName.length; i++) {
            if (mName[i] == '\0') break;
            sb.append(mName[i]);
        }

        return sb.toString();
    }

    private Node build(int[] arr, int start, int end) {
        if (start == end) {
            return new Node(arr[start]);
        }

        int mid = (start + end) / 2;
        Node left = build(arr, start, mid);
        Node right = build(arr, mid + 1, end);

        return new Node(left, right);
    }

    private Node update(Node node, int start, int end, int index, int value) {
        if (start == end) {
            return new Node(value);
        }

        int mid = (start + end) / 2;

        if (index <= mid) {
            Node newLeft = update(node.left, start, mid, index, value);
            return new Node(newLeft, node.right);
        } else {
            Node newRight = update(node.right, mid + 1, end, index, value);
            return new Node(node.left, newRight);
        }
    }

    private int query(Node node, int start, int end, int index) {
        if (start == end) {
            return node.value;
        }

        int mid = (start + end) / 2;

        if (index <= mid) {
            return query(node.left, start, mid, index);
        } else {
            return query(node.right, mid + 1, end, index);
        }
    }

    public void makeList(char mName[], int mLength, int mListValue[]) {
        String name = arrToString(mName);

        Node root = build(mListValue, 0, mLength - 1);
        MyList list = new MyList(root, mLength);

        map.put(name, list);
    }

    public void copyList(char mDest[], char mSrc[], boolean mCopy) {
        String dstName = arrToString(mDest);
        String srcName = arrToString(mSrc);

        MyList srcList = map.get(srcName);

        if (mCopy) {
     
            MyList copiedList = new MyList(srcList.root, srcList.length);
            map.put(dstName, copiedList);
        } else {
            map.put(dstName, srcList);
        }
    }

    public void updateElement(char mName[], int mIndex, int mValue) {
        String name = arrToString(mName);

        MyList list = map.get(name);
        list.root = update(list.root, 0, list.length - 1, mIndex, mValue);
    }

    public int element(char mName[], int mIndex) {
        String name = arrToString(mName);

        MyList list = map.get(name);
        return query(list.root, 0, list.length - 1, mIndex);
    }
}