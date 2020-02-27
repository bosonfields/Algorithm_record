public class public static void main(String[] args) {
  
    public static void main(String[] args) {
        String A = "abcd,aabc,bd";
        String B = "aaa,aa";

        int[] res = compareString(A, B);

        System.out.println(Arrays.toString(res));
    }
    public static int[] compareString(String A, String B){
        String[] arr_A = A.split(",");
        String[] arr_B = B.split(",");
        int len_B = arr_B.length;
        int[] countInA = new int[11];
        int[] C = new int[len_B];
        for(String s : arr_A){
            int currF = smallestCount(s);
            countInA[currF] += 1;
        }
        for(int j = 1; j < countInA.length; j++){
            countInA[j] += countInA[j - 1];
        }
        for(int i = 0; i < len_B; i++){
            int currF = smallestCount(arr_B[i]);
            C[i] = countInA[currF - 1];
        }
        return C;
    }
    public static int smallestCount(String s){
        char[] sArr = s.toCharArray();
        char smallest = 'z';
        int mini = 0;

        for(char c : sArr){
            if(c > smallest){
                continue;
            }
            if(c < smallest){
                smallest = c;
                mini = 1;
            }else {
                mini += 1;
            }
        }
        return mini;
    }
}
