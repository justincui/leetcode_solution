package no864_Shortest_Path_to_Get_All_Keys;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
	class Record{
		Map<Character, Integer> keys=new HashMap<>(); //length from current grid to known keys
				
		//return if this was updated
		boolean merge(Record update) {
			HashSet<Character> result = new HashSet<Character>(this.keys);
			result.addAll(update.keys);
			//if this & update has same keys, update this to smaller step
			if(this.keys.size()==result.size() && update.keys.size()==result.size()) {
				if(this.steps<update.steps) {
					this.steps=update.steps;
					return true;
				}
				return false; 
			}
			else if(this.keys.size()<result.size()){
				
			}
			
		}
	}
	
	int 
    public int shortestPathAllKeys(String[] grid) {
        
    }
}