
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * 5
 * 1 2 1 0 0
 * 1 2 3 0 0
 */
public class Xor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        Long[] nums1 = null;
        Long[] nums2 = null;
        HashSet<Long> set1 = new HashSet<>();
        HashSet<Long> set2 = new HashSet<>();

        for (int i = 0; i < len; i++) {
            long cur = sc.nextLong();
            if (!set1.contains(cur)) {
                set1.add(cur);
            } else {
                set1.remove(cur);
            }
        }
        for (int i = 0; i < len; i++) {
            long cur = sc.nextLong();
            if (!set2.contains(cur)) {
                set2.add(cur);
            } else {
                set2.remove(cur);
            }
        }
        if (set1.isEmpty() || set2.isEmpty()) {
            System.out.println(0);
            return;
        }
        long result = 0;
        nums1 = set1.toArray(new Long[0]);
        nums2 = set2.toArray(new Long[0]);
        for (int i = 0; i <nums1.length; i++) {
            for (int j = 0; j <nums2.length ; j++) {
                result = result ^(nums1[i]+nums2[j]);
            }
        }
        System.out.println(result);
    }
}
