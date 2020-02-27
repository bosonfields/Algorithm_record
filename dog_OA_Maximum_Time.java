    public static void main(String[] args) {
        String s = "1?:??";

        String res = maximumTime(s);

        System.out.println(res);

    }
    public static String maximumTime(String s){

        char[] time = s.toCharArray();

        if(time[0] == '?' && time[1] == '?'){
            time[0] = '2';
            time[1] = '3';
        }

        if(time[0] == '?'){
            time[0] = time[1] > '3' ? '1' : '2';
        }

        if(time[1] == '?'){
            time[1] = time[0] == '2' ? '3' : '9';
        }

        time[3] = time[3] == '?' ? '5' : time[3];
        time[4] = time[4] == '?' ? '9' : time[4];

        String res = new String(time);

        return res;
    }