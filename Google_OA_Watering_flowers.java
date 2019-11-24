    public static void main(String[] args) {
        int[] plants = {6};
        int capacity_1 = 5, capacity_2 = 7;

        int res = refillTimes(plants, capacity_1, capacity_2);

        System.out.println(res);

    }
    public static int refillTimes(int[] plants, int capacity_1, int capacity_2){
        int left = 0, right = plants.length - 1;
        int left_can = 0, right_can  = 0;
        int res = 0;

        while(left < right){
            if(left_can < plants[left]){
                res++;
                left_can = capacity_1 - plants[left];
            }else{
                left_can -= plants[left];
            }

            if(right_can < plants[right]){
                res++;
                right_can = capacity_2 - plants[right];
            }
            else{
                right_can -= plants[right];
            }
            left++;
            right--;
        }

        if(left == right && right_can + left_can < plants[left]){
            res++;
        }

        return res;
    }