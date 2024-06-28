func maximumImportance(n int, roads [][]int) int64 {
   degree := make([]int, n)
   for i:=0 ;i<len(roads) ; i++{
     degree[ roads[i][0]]++
     degree[roads[i][1]]++
   }
   sort.Ints(degree)
   var val int64 =1
   var ans int64 = 0
   for i:=0;i<len(degree);i++{
     k := val  *  int64(degree[i])
     ans = ans+ k
     val= val+1
   }
    return ans
}