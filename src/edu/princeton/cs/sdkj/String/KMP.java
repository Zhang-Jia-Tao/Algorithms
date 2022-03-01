package edu.princeton.cs.sdkj.String;

//KMP
public class KMP {
    private int[][] dp;
    private String pat; //模式串

    public KMP(String pat){
        this.pat = pat;
        int M = pat.length();

        //dp[状态][字符] = 下一个状态
        dp = new int[M][256];

        //base case
        //只有遇到pat[0]这个字符才能使状态从0转移到1,遇到其他字符的话还是停留在状态0
        dp[0][pat.charAt(0)] = 1;

        //影子状态X初始化为0
        int X = 0;

        //当前状态 j 从 1 开始
        //构建状态转移图
        for(int j=1;j<M;j++){
            for(int c=0;c<256;c++){
                dp[j][c] = dp[X][c];
            }
            dp[j][pat.charAt(j)] = j + 1;

            //更新影子状态
            X = dp[X][pat.charAt(j)];
        }
    }

    public int search(String txt){
        int M = pat.length();
        int N = txt.length();

        //pat的初始状态为0
        int j=0;
        for(int i=0;i<N;i++){
            //计算 pat 的下一个状态
            j = dp[j][txt.charAt(i)];
            //到达终止状态，返回结果
            if(j == M){
                return i - M + 1;
            }
        }
        //没有到达终止态，匹配失败
        return -1;
    }


    public static void main(String[] args) {
        KMP kmp = new KMP("aba");
        int index = kmp.search("abbabcaba");
        System.out.println(index);

    }
}
