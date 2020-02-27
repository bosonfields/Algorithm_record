    public static void main(String[] args) {
        int cargoNums = 5;
        int portNums = 3;
        int cargoLimit = 5;
        int weightLimit = 180;
        int[] weights = {30, 30, 100, 90, 50};
        int[] ports = {3, 3, 1, 1, 3};


        System.out.println(cargo(cargoNums, portNums, cargoLimit, weightLimit, weights, ports));
    }
    public static int cargo(int cargoNums, int portNums, int cargoLimit, int weightLimit, int[] weights, int[] ports){
        int idx = 0;
        int res = 0;
        int currCargoNums = 0;
        int currWeight = 0;

        while(idx < ports.length){
            res += 1;
            int currStops = 0;
            int prePort = -1;
            while(idx < ports.length && currCargoNums + 1 <= cargoLimit && currWeight + weights[idx] <= weightLimit){
                if(ports[idx] != prePort){
                    prePort = ports[idx];
                    currStops += 1;
                }
                currCargoNums += 1;
                currWeight += weights[idx];
                idx++;
            }
            res += currStops;
            currCargoNums = 0;
            currWeight = 0;
        }
        return res;
    }