    public static void main(String[] args) {
        String s = "CABa";
        System.out.println(primeStr(s));
    }
    public static String primeStr(String s){
        int[] replaceBoard = new int[256];
        boolean[] primes = new boolean[52];
        for(int i = 0; i < 52; i++){
            primes[i] = isPrime(getASC(i));
        }
        for(int i = 0; i < 52; i++){
            int asc2 = getASC(i);
            if(primes[i]){
                replaceBoard[asc2] = asc2;
                continue;
            }
            int left = -1;
            int right = -1;
            for(int j = 0; i - j >= 0; j++){
                if(primes[i - j]){
                    left = getASC(i - j);
                    break;
                }
            }
            for(int j = 0; i + j < 52; j++){
                if(primes[i + j]){
                    right = getASC(i + j);
                    break;
                }
            }
            if(left == -1) replaceBoard[asc2] = right;
            else if(right == -1) replaceBoard[asc2] = left;
            else{
                replaceBoard[asc2] = asc2 - left <= right - asc2 ? left : right;
            }
        }
        
        char[] sArr = s.toCharArray();
        for(int i = 0; i < sArr.length; i++){
            sArr[i] = (char)replaceBoard[sArr[i]];
        }
        return new String(sArr);

    }
    private static boolean isPrime(int a){
        int limit = (int)Math.sqrt((double)a) + 1;
        for(int i = 2; i < limit; i++){
            if(a % i == 0) return false;
        }
        return true;
    }
    private static int getASC(int idx){
        return idx < 26 ? 'A' + idx : 'a' + idx - 26;
    }