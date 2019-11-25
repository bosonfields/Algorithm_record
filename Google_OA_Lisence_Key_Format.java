    public String licenseKeyFormatting(String S, int K) {
        char[] sArr = S.toCharArray();
        
        int cap = 0;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = sArr.length - 1; i >= 0; i--){
            if(sArr[i] == '-') continue;
            
            if(cap == K){
                sb.append('-');
                cap = 0;
            }
            
            cap += 1;             
            if(Character.isLetter(sArr[i])) sb.append(Character.toUpperCase(sArr[i]));
            else sb.append(sArr[i]);
        }
        
        while(sb.length() > 0 && sb.charAt(sb.length() - 1) == '-'){
            sb.deleteCharAt(sb.length() - 1);
        }
        
        String res = sb.reverse().toString();
        return res;
    }