    public static void main(String[] args) {
        int n = 5201;
        List<Integer> res = deciBinaryNumber(n);
        System.out.println(res.toString());
    }
    public static List<Integer> deciBinaryNumber(int n){
        List<Integer> res = new LinkedList<>();

        while(n != 0){
            int digit = 1, check = n, curr = 0;
            while(check != 0){
                if(check % 10  > 0){
                    curr += digit;
                }
                check /= 10;
                digit *= 10;
            }
            n -= curr;
            res.add(0, curr);
        }
        return res;
    }