package edu.princeton.cs.LeetCode.MST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//连接所有点的最小费用
public class zjt_1584 {
    public static void main(String[] args) {

    }

    //连通图
    private class UF{
        private int[] parent;
        private int[] size;
        //连通分量的个数
        private int count;

        public UF(int n) {
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        // 将节点 p 和节点 q 连通
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;

            // 小树接到大树下面，较平衡
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            // 两个连通分量合并成一个连通分量
            count--;
        }

        // 判断节点 p 和节点 q 是否连通
        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        // 返回节点 x 的连通分量根节点
        private int find(int x) {
            while (parent[x] != x) {
                // 进行路径压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        // 返回图中的连通分量个数
        public int count() {
            return count;
        }
    }


    public int minCostConnectPoints(int[][] points) {
        int lenght = points.length;

        //用于保存每个边 以及对应的权值  int[0]:from   int[1]:to   int[2]:weight
        List<int[]> edge = new ArrayList<>();
        for(int i=0;i<lenght;i++){
            for(int j=i+1;j<lenght;j++){
                int xi = points[i][0],yi = points[i][1];
                int xj = points[j][0],yj = points[j][1];

                edge.add(new int[]{i,j,Math.abs(xi-xj)+Math.abs(yi-yj)});
            }
        }

        //将边按照权重的大小按从小到大进行排序
        Collections.sort(edge,(a,b) -> {return a[2]-b[2];});
        int mst = 0;
        UF uf = new UF(lenght);
        for(int[] weigth:edge){
            int u = weigth[0];
            int v = weigth[1];
            int val = weigth[2];
            if(uf.connected(u,v)){
                continue;
            }
            mst += val;
            uf.union(u,v);
        }
        return mst;
    }
}
