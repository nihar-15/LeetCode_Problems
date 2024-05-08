class Solution {
	public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
		int passanger = 0, curCap=0, bus=0;

		Arrays.sort(buses);
		Arrays.sort(passengers);

		while(bus < buses.length){
			curCap=0;
			while(passanger < passengers.length && curCap < capacity && passengers[passanger] <= buses[bus]){
				passanger++;
				curCap++;
			}
			bus++;
		}

		int result = curCap==capacity? passengers[passanger-1]: buses[buses.length-1];
		Set<Integer> set = new HashSet();
		for(int i: passengers){
			set.add(i);
		}

		while(set.contains(result)){
			result--;
		}
		return result;
	}
}