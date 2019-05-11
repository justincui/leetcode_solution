package no739_DailyTemperatures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Solution {
	public int[] dailyTemperatures(int[] T) {
        int[] result=new int[T.length]; //initialized to 0
        if(T.length==0) {
        	return result;
        }
        
        //days waiting for higher temperature
        //use int[] to handle duplicated temperatures
        TreeMap<Integer, List<Integer>> pendingDays =   
        		new TreeMap<>((Integer x, Integer y)->(x-y));
        ArrayList<Integer> value = new ArrayList<Integer>();
        value.add(0);
        pendingDays.put(T[0], value);
        
        for(int i=1;i<T.length;i++) {
        	int currTemp=T[i];
        	Iterator<Entry<Integer, List<Integer>>> iter = pendingDays.entrySet().iterator();

        	while(iter.hasNext()) {
        		Entry<Integer, List<Integer>> entry = iter.next();
        		
        		int prevTemp = entry.getKey();
        		if(prevTemp < currTemp) {
        			List<Integer> dayIndexes = entry.getValue();
        			for(int dayIndex: dayIndexes) {
        				result[dayIndex] = i-dayIndex;
        			}
        			iter.remove();
        			continue;
        		}
        		break;
        	}
        	List<Integer> days= pendingDays.get(currTemp);
        	if(days==null) {
        		days=new ArrayList<Integer>();
        		days.add(i);
        		pendingDays.put(currTemp, days);
        	}
        	else {
        		days.add(i);
        	}
        }
        return result;
    }
}
