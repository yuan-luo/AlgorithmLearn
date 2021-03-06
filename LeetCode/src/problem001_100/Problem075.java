package problem001_100;

public class Problem075 {

    public void sortColorsCountSort(int[] nums) {
        int[] countArr = new int[3];
        int size = nums.length;

        for (int i = 0; i < size; i++) {
            countArr[nums[i]]++;
        }

        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < countArr[i]; j++) {
                nums[count++] = i;
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * 空间复杂度为O(1), 时间复杂度为O(n)
     */
    public void sortColors(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                swap(nums, 0, 1);
            }

            return;
        }

        int left = 0;
        int right = nums.length - 1;

        for (int i = 1; i <= right; ) {
            if (nums[left] > nums[right]) {
                swap(nums, left, right);
            }

            if (nums[i] < nums[left]) {
                swap(nums, i, left);
            }

            if (nums[i] > nums[right]) {
                swap(nums, i, right);
            }

            boolean isLeftRightMove = false;
            if (nums[left] == 0) {
                left++;
                if (i < left) {
                    i++;
                }
                isLeftRightMove = true;
            }

            if (nums[right] == 2) {
                right--;
                isLeftRightMove = true;
            }

            if (!isLeftRightMove) {
                i++;
            }
        }

    }


    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        new Problem075().sortColors(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
