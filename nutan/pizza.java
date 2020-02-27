    public static void main(String[] args) {
        int[] arr = {1,0,1};
        System.out.println(preparePizza(arr));
    }
    public static boolean preparePizza(int[] guests){

        for(int i = 0; i < guests.length; i++){
            if(guests[i] % 2 == 1) guests[i] = 1;
            if(guests[i] == 0) continue;
            if(guests[i] % 2 == 0) guests[i] = 2;
        }

        for(int i = 0; i < guests.length; i++){
            if(guests[i] < 0 ) return false;
            if(i == guests.length - 1 && guests[i] == 1) return false;

            if(guests[i] == 0 || guests[i] == 2) continue;

            if(guests[i] == 1) guests[i + 1] -= 1;
        }

        return true;
    }