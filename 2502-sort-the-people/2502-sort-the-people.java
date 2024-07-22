class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
         int n = names.length;
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
    }
}