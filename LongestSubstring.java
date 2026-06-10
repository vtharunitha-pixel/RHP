class LongestSubstring {
    public int findLength(int[] nums1, int[] nums2) {
        
        if(nums1==null||nums2==null||nums1.length==0||nums2.length==0){
            return 0;
        }
        int m =nums1.length;
        int n= nums2.length;
        int max=0;
        int dp[][] = new int [m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(nums1[i-1]==nums2[j-1]){
                dp[i][j]=dp[i-1][j-1]+1;
                max=Math.max(max,dp[i][j]);
                 }
                 else{
                    dp[i][j]=0;
                 }
            }
        }
      return max;
    }
}