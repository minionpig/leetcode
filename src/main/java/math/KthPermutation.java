package math;

import java.util.ArrayList;
import java.util.List;

public class KthPermutation {

    public static void main(String[] args) {
        List<Character> v = new ArrayList<>(List.of('1', '2', '3', '4'));
        StringBuilder sb = new StringBuilder();
        Kth_permutation Kth = new Kth_permutation();
        Kth.find_kth_permutation(v, 8, sb);

        for(char s : sb.toString().toCharArray()) {
            System.out.println(s);
        }
    }
}

class Kth_permutation {
    public void find_kth_permutation(List<Character> v, int k, StringBuilder result) {

        if(v.size() == 0) return;

        int size = v.size();
        int blocksize = factorial(size - 1);

        int curindex = (k%blocksize!=0) ? k/blocksize + 1 : k/blocksize;

        result.append(v.get(curindex-1));

        v.remove(curindex -1);

        k = k - (curindex-1) * blocksize;
        find_kth_permutation(v, k, result);
    }

    private int factorial(int n) {
        int fac = 1;
        while(n>0){
            fac *= n;
            n--;
        }
        return fac;
    }
}
