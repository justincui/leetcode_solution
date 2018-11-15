package no739_DailyTemperatures;

public class Solution {
	public int[] dailyTemperatures(int[] T) {
        int[] result=new int[T.length](); //initialized to 0
        
        TreeSet<Integer> pendingDays=new TreeSet<>(); //days waiting for higher temperature
        int prevTemp=T[0]; //current lowest
        for(int i=1;i<T)
    }
}
