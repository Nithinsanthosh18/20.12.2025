class Solution {
    public int scheduleCourse(int[][] courses) {
        // Sort courses by their lastDay
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int totalTime = 0;
        
        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];
            
            if (totalTime + duration <= lastDay) {
                // Take this course
                maxHeap.offer(duration);
                totalTime += duration;
            } else if (!maxHeap.isEmpty() && maxHeap.peek() > duration) {
                // Replace the longest course with this shorter one
                totalTime += duration - maxHeap.poll();
                maxHeap.offer(duration);
            }
        }
        
        return maxHeap.size();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.scheduleCourse(new int[][]{
            {100,200},{200,1300},{1000,1250},{2000,3200}
        })); // 3
        
        System.out.println(sol.scheduleCourse(new int[][]{
            {1,2}
        })); // 1
        
        System.out.println(sol.scheduleCourse(new int[][]{
            {3,2},{4,3}
        })); // 0
    }
}
   
    
