func findCenter(edges [][]int) int {
    set := make(map[int] struct{})
    for i :=0;i<len(edges);i++{
        for j :=0 ;j <len(edges[i]); j++{
            if _ , exists := set[edges[i][j]];exists{
                return edges[i][j]
            }else{
                set[edges[i][j]] = struct{}{}
            }
        }
    }
    return -1
}

