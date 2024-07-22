class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
         Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }        
        Arrays.sort(heights);
        String[] result = new String[heights.length];
        int index = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            result[index] = map.get(heights[i]);
            index++;
        }
        return result;
        
        /* int n = names.length;
        List<Person> people = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            people.add(new Person(names[i], heights[i]));
        }
        
        Collections.sort(people);
        
        String ans[] = new String[n];
        int i =0 ;
        for (Person person : people) {
            ans[i++] = person.name;
        }
        
        return ans;
      
    }

    static class Person implements Comparable<Person> {
        String name;
        int height;
        
        Person(String name, int height) {
            this.name = name;
            this.height = height;
        }
        
        @Override
        public int compareTo(Person other) {
            // Sort by height in descending order
            return Integer.compare(other.height, this.height);
        }
        */
    }
}