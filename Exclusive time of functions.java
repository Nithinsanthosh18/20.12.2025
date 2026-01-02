class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;

        for (String log : logs) {
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int time = Integer.parseInt(parts[2]);

            if (type.equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += time - prevTime;
                }
                stack.push(id);
                prevTime = time;
            } else { // "end"
                res[stack.pop()] += time - prevTime + 1;
                prevTime = time + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> logs1 = Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6");
        System.out.println(Arrays.toString(sol.exclusiveTime(2, logs1))); // [3,4]

        List<String> logs2 = Arrays.asList("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7");
        System.out.println(Arrays.toString(sol.exclusiveTime(1, logs2))); // [8]

        List<String> logs3 = Arrays.asList("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7");
        System.out.println(Arrays.toString(sol.exclusiveTime(2, logs3))); // [7,1]
    }
}
 
    
