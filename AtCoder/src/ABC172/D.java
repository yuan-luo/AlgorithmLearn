package ABC172;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class D {

    static class Task {

        private List<Integer> getAllPrimes(int n) {
            boolean[] isNotPrime = new boolean[n + 1];
            for (int i = 2; i * i <= n; i++) {
                if (isNotPrime[i]) {
                    continue;
                }

                for (int j = i * i; j <= n; j += i) {
                    isNotPrime[j] = true;
                }
            }

            List<Integer> primeList = new ArrayList<>();
            for (int i = 2; i <= n; i++) {
                if (!isNotPrime[i]) {
                    primeList.add(i);
                }
            }
            return primeList;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            List<Integer> primeList = getAllPrimes(n);
            long ans = 0;
            for (int i = 1; i <= n; i++) {
                long count = 0;
                for (long prime : primeList) {
                    if (prime * prime > i) {
                        break;
                    }

                    long cur = prime;
                    while (cur * cur <= i) {
                        if (i % cur == 0) {
                            if (cur * cur == i) {
                                count++;
                            } else {
                                count += 2;
                            }
                        }

                        cur *= prime;
                    }
                }

                ans += (count + 2) * i;
            }

            out.println(ans - 1);
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
