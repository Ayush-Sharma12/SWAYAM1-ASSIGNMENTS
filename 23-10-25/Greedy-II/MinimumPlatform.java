import java.util.*;

public class MinimumPlatform {
    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println("Minimum platforms needed = " + findPlatform(arr, dep));
    }

    static int findPlatform(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int n = arr.length;
        int i = 0, j = 0;
        int platforms = 0, maxPlatforms = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) { // Train arrives before previous departs
                platforms++;
                maxPlatforms = Math.max(maxPlatforms, platforms);
                i++;
            } else { // Train departs, free one platform
                platforms--;
                j++;
            }
        }

        return maxPlatforms;
    }
}
