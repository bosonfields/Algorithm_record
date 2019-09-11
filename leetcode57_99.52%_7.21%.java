package leet_test;

        import org.omg.PortableInterceptor.INACTIVE;

        import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{8,10},{12,16}};
        int[] newInterval = {0,0};

        int[][] ans = insert(intervals, newInterval);

        for(int[] a: ans){
            System.out.println(Arrays.toString(a));
        }

    }

    public static int[][] insert(int[][] intervals, int[] newInterval){

        if(intervals.length==0){
            int[][] res = new int[1][];
            res[0] = newInterval;
            return res;
        }

        List<int[]> tmp = new ArrayList<>();

        int i=0;

        while(i<intervals.length && intervals[i][1]<newInterval[0]){
            tmp.add(intervals[i]);
            i++;
        }

        if(i == intervals.length) tmp.add(newInterval);
        else{
            int ml = Math.min(intervals[i][0], newInterval[0]);

            while(i<intervals.length && intervals[i][0]<=newInterval[1]){
                i++;
            }

            if(i==0) tmp.add(newInterval);
            else{

                int mr = Math.max(intervals[i-1][1], newInterval[1]);

                tmp.add(new int[]{ml, mr});
            }

            while(i<intervals.length){
                tmp.add(intervals[i]);
                i++;
            }
        }

        int[][] ans = new int[tmp.size()][];

        for(int k = 0; k<tmp.size(); k++){
            ans[k] = tmp.get(k);
        }

        return ans;
    }

}