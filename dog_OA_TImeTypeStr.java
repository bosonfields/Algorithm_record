    public static void main(String[] args) {
        String keyboard = "abcdefghijklmnopqrstuvwxyz";
        String test = "";

        int res = typeCost(keyboard, test);

        System.out.println(res);

    }
    public static int typeCost(String keyboard, String test){
        if(test == null || test.length() == 0) return 0;

        char[] kb_arr = keyboard.toCharArray();
        char[] test_arr = test.toCharArray();

        int[] letter_map = new int[26];

        for(int i = 0; i < 26; i++){
            char curr = kb_arr[i];
            int lex_idx = curr - 'a';
            letter_map[lex_idx] = i;
        }

        int res = letter_map[test_arr[0] - 'a'];

        for(int i = 1; i < test_arr.length; i++){
            res += Math.abs(letter_map[test_arr[i] - 'a'] - letter_map[test_arr[i - 1] - 'a']);
        }

        return res;
    }