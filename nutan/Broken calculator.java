class Solution {
    public int brokenCalc(int X, int Y) {
        int res = 0;
        
        while(X < Y){
            Y = Y % 2 == 0 ? Y / 2 : Y + 1;
            res++;
        }
        
        return res + X - Y;
    }
}