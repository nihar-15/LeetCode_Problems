func findContentChildren(g []int, s []int) int {
    sort.Ints(g)
    sort.Ints(s)
    satisfied := 0
    cookie := 0
    for (satisfied < len(g) && cookie < len(s)){
        if(g[satisfied] <= s[cookie]){
            satisfied ++
        }
        cookie++
    }
    return satisfied
}

    