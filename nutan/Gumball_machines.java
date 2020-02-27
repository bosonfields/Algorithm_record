    public static void main(String[] args) {
        String[] arr = {"red", "green", "blue", "red", "white"};
        List<String> deliver = Arrays.asList(arr);
        int n = 5;
        System.out.println(gumCost(n, deliver));
    }
    public static double gumCost(int n, List<String> deliver){
        HashMap<String, Double> machine = new HashMap<>();
        String mayRefill = "";
        double res = 0;

        for(String color : deliver){
            if(!mayRefill.equals("") && machine.containsKey(color)){
                res += machine.remove(mayRefill) / 100;
            }
            machine.put(color, 1000.0);
            mayRefill = sellGum(machine);
        }
        return res;
    }
    public static String sellGum(HashMap<String, Double> machine){
        Double min = null;
        String res = "";
        for(Map.Entry entry : machine.entrySet()){
            entry.setValue((Double)entry.getValue() - 10);
            if(min == null || (double)entry.getValue() < min){
                res = (String)entry.getKey();
                min = (Double)entry.getValue();
            }
        }
        return res;
    }