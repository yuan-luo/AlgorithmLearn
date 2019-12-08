package contest.contest166;

public class Problem01 {

    public int subtractProductAndSum(int n) {
        int sum1 = 1;
        int sum2 = 0;

        while (n > 0) {
            sum1 *= (n % 10);
            sum2 += (n % 10);
            n /= 10;
        }

        return sum1 - sum2;
    }
    
    public static void main(String[] args) {

    }
    
}
