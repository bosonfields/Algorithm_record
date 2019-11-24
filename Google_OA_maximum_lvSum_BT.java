    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> frontier = new LinkedList<>();
        int level = 0;
        
        frontier.add(root);
        int max = Integer.MIN_VALUE;
        int res = 0;
        
        while(!frontier.isEmpty()){
            int lvSize = frontier.size();
            level += 1;
            int lvSum = 0;
            for(int i = 0; i < lvSize; i++){
                TreeNode curr = frontier.poll();
                lvSum += curr.val;
                if(curr.left != null) frontier.add(curr.left);
                if(curr.right != null) frontier.add(curr.right);
                
            }
            if(lvSum > max){
                max = lvSum;
                res = level;
            }
        }
        
        return res;
    }