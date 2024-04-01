func lengthOfLastWord(s string) int {
 words := strings.Fields(s)

   // If there are no words, return 0
   if len(words) == 0 {
      return 0
   }

   // Return the length of the last word
   return len(words[len(words)-1])
   
}