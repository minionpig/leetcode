package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triplets {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 8, 10, 9, 12, 15, 18, 19};
        List<int[]> list = pythagoreanTriplet.find_pythagorean_triplets(arr);
        System.out.println(list);
    }
}

class pythagoreanTriplet {
    static List<int[]> find_pythagorean_triplets(int[] arr) {
        List<int[]> triplets = new ArrayList<>();
        if (arr == null || arr.length < 3) return triplets;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) continue;
            int low = 0;
            int high = arr.length - 1;
            int cur = arr[i] * arr[i];

            while(low < high){
                if(low == i || arr[low] == 0) {
                    low++;
                    continue;
                }
                if(high == i || arr[high] == 0) {
                    high--;
                    continue;
                }
                if(cur == arr[low] * arr[low] + arr[high]* arr[high]) {

                    triplets.add(new int[]{arr[i], arr[low], arr[high]});
                    break;
                }
                else if(cur < arr[low]* arr[low] + arr[high]* arr[high] ) high --;
                else low ++;
            }
        }

        return triplets;
    }
}