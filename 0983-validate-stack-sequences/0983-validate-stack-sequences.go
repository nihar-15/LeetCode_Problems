func validateStackSequences(pushed []int, popped []int) bool {
    i , j := 0 , 0
    stack := []int{}
    
    for i < len(pushed){
        stack = append(stack , pushed[i])
        i++
        for j < len(popped) && len(stack) > 0 && stack[len(stack) - 1] == popped[j]{
            stack = stack[:len(stack) -1]
            j++
        }
       
    }
      return len(stack) == 0
}


      