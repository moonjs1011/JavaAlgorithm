package swea.month05.week01.day0506.problem14613;

import java.util.*;
public class TestMain {
    public static void main(String[] args) {
        HashMap<Character,int[]> map=new HashMap<>();

        int[] a = {1,2,3,4,5};
        int[] b ={11,12,13,14,15};
        map.put('a',a);
        map.put('b',b);
        map.put('c',map.get('a'));
        int[] src = map.get('a');
        int[] dst = Arrays.copyOf(src,src.length);
        map.put('d',dst);
        System.out.println(Arrays.toString(map.get('a')));
        System.out.println(Arrays.toString(map.get('c')));
        System.out.println(Arrays.toString(map.get('d')));
        map.get('a')[0] = 10;
        System.out.println(Arrays.toString(map.get('a')));
        System.out.println(Arrays.toString(map.get('c')));
        System.out.println(Arrays.toString(map.get('d')));

        char[] str = {'a','b','c'};
        System.out.println(Arrays.toString(str).toString());
    }
}
