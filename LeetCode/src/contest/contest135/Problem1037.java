package contest.contest135;

public class Problem1037 {

    public boolean isBoomerang(int[][] points) {
        return (points[0][0] - points[1][0]) * (points[2][1] - points[1][1])
                != (points[0][1] - points[1][1]) * (points[2][0] - points[1][0]);
    }
    
    public static void main(String[] args) {

    }
    
}