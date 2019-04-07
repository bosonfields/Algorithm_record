//leetcode 630 61.68% 78.18%

class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1]-b[1]);
        PriorityQueue<Integer> selected = new PriorityQueue<>((a,b)->(b-a));

        int time = 0;

        for(int[] c : courses){
            time+=c[0];
            selected.offer(c[0]);
            if(c[1]<time) time -=selected.poll();
        }
        return selected.size();
    }
}