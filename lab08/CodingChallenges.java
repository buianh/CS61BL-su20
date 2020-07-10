import java.util.*;
import java.util.stream.Collectors;

public class CodingChallenges {

    /**
     * Return the missing number from an array of length N containing all the
     * values from 0 to N except for one missing number.
     */
    public static int missingNumber(int[] values) {
        // TODO
        Set<Integer> targetSet = new HashSet<>();
                //Arrays.stream(values).boxed().collect(Collectors.toSet());
        for (int i = 0; i< values.length; i++) {
            targetSet.add(values[i]);
        }
        int i = 0;
        while (i <= targetSet.size()) {
            if (!targetSet.contains(i)){
                return i;
            }
            i += 1;
        }
        return -1;
    }

    /**
     * Returns true if and only if two integers in the array sum up to n.
     * Assume all values in the array are unique.
     */
    public static boolean sumTo(int[] values, int n) {
        // TODO
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i< values.length; i++) {
            list.add(values[i]);
        }
        while (list.size()>0){
            int current_int = list.get(0);
            int left_over = n - current_int;
            list.remove(0);
            if (list.contains(left_over)){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if and only if s1 is a permutation of s2. s1 is a
     * permutation of s2 if it has the same number of each character as s2.
     */
    public static boolean isPermutation(String s1, String s2) {
        // TODO
        Map<String, Integer> map = new HashMap<>();
        String[] alphabets = s1.split("");
        String[] beta = s2.split("");
        for (int i = 0; i<alphabets.length; i++) {
            Integer count = map.get(alphabets[i]);
            if (count == null) {
                map.put(alphabets[i],1);
            } else {
                map.put(alphabets[i],count+1);
            }
        }
        for (int i = 0; i<beta.length; i++) {
            Integer count = map.get(beta[i]);
            if (count == null || count < 1) {
                return false;
            } else {
                map.put(beta[i],count-1);
            }
        }
        for (String key : map.keySet()) {
           if (map.get(key) != 0) {
               return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        System.out.println(missingNumber(new int[] {0,1,5,2,4,6}));
        System.out.println(sumTo(new int[] {0,1,5,3,4},9));
        System.out.println(isPermutation("but", "btu"));
    }
}