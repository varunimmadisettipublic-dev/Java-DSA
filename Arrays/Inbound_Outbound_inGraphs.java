/*

Getting started with graphs after long time i am going to learn a very new concept that is graphs.

problem statement: we will be given an 2d array. we need to find is there any one in that 2d array such that 
every one believes him but he does not belive anyone.

using the concept of inbound and outbound we can solve it right.


*/


class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n+1];
        int[] outDegree= new int[n+1];

        for(int[] i : trust){
            outDegree[i[0]]++;
            inDegree[i[1]]++;
        }

        for(int i=1;i<=n;i++){
            if(outDegree[i]==0 && inDegree[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}
