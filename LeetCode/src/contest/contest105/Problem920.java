package contest.contest105;

public class Problem920 {

    private static final int MOD = (int) (1e9 + 7);

    public int numMusicPlaylists(int n, int l, int k) {
        long[][] dp = new long[l+1][n+1];
        dp[0][0] = 1;
        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] += dp[i-1][j-1] * (n-j+1); // 播放新歌
                dp[i][j] += dp[i-1][j] * Math.max(j-k, 0); //播放旧歌
                dp[i][j] %= MOD;
            }
        }

        return (int) dp[l][n];
    }
    
    public static void main(String[] args) {
//        System.out.println(new Problem04().numMusicPlaylists(16, 16, 4));
        System.out.println(new Problem920().numMusicPlaylists(16, 17, 5));
    }

}

//    你的音乐播放器里有 N 首不同的歌，在旅途中，你的旅伴想要听 L 首歌（不一定不同，即，允许歌曲重复）。请你为她按如下规则创建一个播放列表：
//
//        每首歌至少播放一次。
//        一首歌只有在其他 K 首歌播放完之后才能再次播放。
//        返回可以满足要求的播放列表的数量。由于答案可能非常大，请返回它模 10^9 + 7 的结果。
//
//
//
//        示例 1：
//
//        输入：N = 3, L = 3, K = 1
//        输出：6
//        解释：有 6 种可能的播放列表。[1, 2, 3]，[1, 3, 2]，[2, 1, 3]，[2, 3, 1]，[3, 1, 2]，[3, 2, 1].
//        示例 2：
//
//        输入：N = 2, L = 3, K = 0
//        输出：6
//        解释：有 6 种可能的播放列表。[1, 1, 2]，[1, 2, 1]，[2, 1, 1]，[2, 2, 1]，[2, 1, 2]，[1, 2, 2]
//        示例 3：
//
//        输入：N = 2, L = 3, K = 1
//        输出：2
//        解释：有 2 种可能的播放列表。[1, 2, 1]，[2, 1, 2]
//
//
//        提示：
//
//        0 <= K < N <= L <= 100
