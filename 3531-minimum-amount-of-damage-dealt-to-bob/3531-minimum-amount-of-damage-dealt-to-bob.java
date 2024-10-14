class Solution {
    public long minDamage(int power, int[] damage, int[] health) {
        List<Threat> threat = new ArrayList<>();
        long totalDamage = 0 ;
        long currentDamage = 0;
        for(int i = 0 ; i < damage.length ; i++){
            double timeToKill = Math.ceil((double) health[i] / power);
            threat.add(new Threat(timeToKill / damage[i], i));
            currentDamage += damage[i];
        }
        Collections.sort(threat);
        for(int i = 0  ; i  < damage.length ; i++){
         int idx = threat.get(i).idx;
         int time =  (int) Math.ceil((double) health[idx] / power);
         totalDamage +=(time * currentDamage);
         currentDamage -= damage[idx];
        }
        return totalDamage ;
    }
}
class Threat implements Comparable<Threat>{
    double threatLevel ;
    int idx ; 
    Threat(double threat , int idx){
        this.threatLevel = threat ;
        this.idx = idx ;
    }
    public int compareTo(Threat t ){
        return Double.compare(this.threatLevel , t.threatLevel);
    }
}