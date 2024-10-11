class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
         int n = times.length;
        int[] endTimes = new int[n]; 
        Arrays.fill(endTimes, -1);  

        int targetArrivalTime = times[targetFriend][0];

        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));

        for (int[] time : times) {
            int arrival = time[0];
            int depart = time[1];

            for (int i = 0; i < n; i++) {
                if (endTimes[i] <= arrival) {
                    endTimes[i] = depart;

                    if (arrival == targetArrivalTime) {
                        return i;
                    }
                    break;
                }
            }
        }

        return -1; 

        /*List<Friend> list = new ArrayList<Friend>();
        int i = 0;
        int n = times.length;
        for (int time[] : times) {
            list.add(new Friend(i, time[0], time[1]));
            i++;
        }
        Collections.sort(list);
        int chairNumber = 0;

        i = 1;
        int j = 0;
        while (i < n && j < n && list.get(i).pos != targetFriend) {
            if (list.get(i).startTime <= list.get(j).endTime) {
                chairNumber++;
                i++;
            } else if (list.get(i).startTime > list.get(j).endTime) {
                chairNumber--;
                j++;
            }

        }
        if(i == targetFriend){
            if (list.get(i).startTime <= list.get(j).endTime) {
                chairNumber++;
                i++;
            } else if (list.get(i).startTime > list.get(j).endTime) {
                chairNumber--;
                j++;
            } 
        }
        return chairNumber;
    }
    */
    
}
}
class Friend implements Comparable<Friend> {
    int pos, startTime, endTime;

    Friend(int p, int s, int e) {
        pos = p;
        startTime = s;
        endTime = e;
    }

    public int compareTo(Friend f) {
        return Integer.compare(this.startTime, f.startTime);
    }
}