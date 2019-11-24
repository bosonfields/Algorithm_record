    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        
        for(String email : emails){
            String curr = helper(email);
            if(!set.contains(curr)){
                set.add(curr);
            }
        }
        
        return set.size();
    }
    public String helper(String email){
        
        char[] email_c = email.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        
        while(idx < email_c.length && email_c[idx] != '+' && email_c[idx] != '@'){
            if(email_c[idx] != '.') sb.append(email_c[idx]);
            idx++;
           }
            
        while(idx < email_c.length && email_c[idx] != '@'){
            idx++;
        }
        
        while(idx < email_c.length){
            sb.append(email_c[idx]);
            idx++;
        }
        
        return sb.toString();
    }