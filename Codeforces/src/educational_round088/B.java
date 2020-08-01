package educational_round088;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int m = in.nextInt();
                long x = in.nextLong(); // 1 * 1
                long y = in.nextLong(); // 1 * 2

                char[][] grid = new char[n][m];
                for (int i = 0; i < n; i++) {
                    grid[i] = in.next().toCharArray();
                }

                long twoCost;
                if (x * 2 <= y) {
                    twoCost = x * 2;
                } else {
                    twoCost = y;
                }

                long ans = 0;
                for (int i = 0; i < n; i++) {
                    boolean isDone = false;
                    for (int j = 0; j < m - 1; j++) {
                        if (grid[i][j] == '*') {
                            continue;
                        }

                        if (grid[i][j+1] == '.') {
                            if (j == m - 2) {
                                isDone = true;
                            }
                            ans += twoCost;
                            j++;
                        } else {
                            ans += x;
                        }
                    }

                    if (!isDone && grid[i][m - 1] == '.') {
                        ans += x;
                    }
                }

                out.println(ans);
            }
        }
    }

    private static void sort(double[] arr) {
        Double[] objArr = Arrays.stream(arr).boxed().toArray(Double[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sort(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sort(long[] arr) {
        Long[] objArr = Arrays.stream(arr).boxed().toArray(Long[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void solve() {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(1, in, out);
        out.close();
    }

    public static void main(String[] args) {
        new Thread(null, () -> solve(), "1", 1 << 26).start();
    }

    static class InputReader {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }

}
