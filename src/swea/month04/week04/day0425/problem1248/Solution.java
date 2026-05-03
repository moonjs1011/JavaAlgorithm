    package swea.month04.week04.day0425.problem1248;

    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;


    public class Solution {
        static Map<Integer,List<Integer>> tree;
        static int[] parent;
        static void traversal(List<Integer> ancestorList,int vid){
                if(vid==1) {
                    return;
                }
                ancestorList.add(parent[vid]);
                traversal(ancestorList,parent[vid]);
        }
        /*
         * 함수자체에 문제가 있었음. 모든 조상이 같으면 -1이 리턴됌
         */
        static int getCommonAncestor(List<Integer> ancestorV1, List<Integer> ancestorV2){
            int minSize = Math.min(ancestorV1.size(),ancestorV2.size());
            int common = 1;
            for(int i=0;i<minSize;i++){
                int ancestor1 = ancestorV1.get(i);
                int ancestor2 = ancestorV2.get(i);

                if(ancestor1!=ancestor2) break;
                common = ancestor1;
            }
            return common;
        }
        static int getSize(int vid) {
            int size = 1;
            for (int child : tree.get(vid)) {
                size += getSize(child);
            }
            return size;
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

                tree = new HashMap<>();
                parent= new int[V+1];
                for(int i=1;i<=V;i++) tree.put(i,new ArrayList<>());

                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < E; i++) {
                    int parentVid = Integer.parseInt(st.nextToken());
                    int childVid = Integer.parseInt(st.nextToken());
                    tree.get(parentVid).add(childVid);
                    parent[childVid] = parentVid;
                }

                List<Integer>ancestorV1 = new ArrayList<>();
                List<Integer>ancestorV2 = new ArrayList<>();

                traversal(ancestorV1,v1);
                traversal(ancestorV2,v2);

                Collections.reverse(ancestorV1);
                Collections.reverse(ancestorV2);

//                for(int v : ancestorV1) System.out.print(v+" ");
//                System.out.println();
//                for(int v : ancestorV2) System.out.print(v+" ");
//                System.out.println();

                int commonAncestorVid = getCommonAncestor(ancestorV1,ancestorV2);
                int size = getSize(commonAncestorVid);
                System.out.println("#"+tc+ " "+commonAncestorVid+ " "+size);
            }
        }
    }
