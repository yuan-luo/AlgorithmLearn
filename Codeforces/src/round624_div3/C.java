package round624_div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static void solve() throws IOException {
        int t = nextInt();
        while ((t--) > 0) {
            int n = nextInt();
            int m = nextInt();
            String str = next();
            int[] p = new int[m];
            for (int i = 0; i < m; i++) {
                p[i] = nextInt();
            }

            char[] arr = str.toCharArray();

            int[][] preSumArr = new int[n][26];

            preSumArr[0] = new int[26];
            preSumArr[0][arr[0] - 'a']++;

            for (int i = 1; i < n; i++) {
                preSumArr[i] = Arrays.copyOf(preSumArr[i-1], 26);
                preSumArr[i][arr[i] - 'a']++;
            }

            int[] ansArr = new int[26];

            for (int i = 0; i < m; i++) {
                int index = p[i] - 1;

                for (int j = 0; j < 26; j++) {
                    ansArr[j] += preSumArr[index][j];
                }
            }

            for (int j = 0; j < 26; j++) {
                ansArr[j] += preSumArr[n - 1][j];
            }

            for (int i = 0; i < 26; i++) {
                System.out.print(ansArr[i] + " ");
            }
            System.out.println();
        }
    }




    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        solve();
    }

    public static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null)
                throw new IOException();
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

}
