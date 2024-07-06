func passThePillow(n int, time int) int {
    pos , dir := 0 , 1
    for i:= 0 ; i<time ;i++{
        if dir == 1 {
            if pos == n-1 {
                dir =-1 
            }
            pos += dir
        }else{
            if pos == 0 {
                dir = 1
            }
            pos += dir
        }
    }
    return pos +1
}