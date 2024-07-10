func minOperations(logs []string) int {
    var stack[] string
    for _ , log :=  range logs{
        if log == "./"{
            continue 
        }else if len(stack) > 0 && log =="../"{
            stack = stack[:len(stack)-1]
        }else if log != "../"{
            stack = append(stack , log)
        }
    }
    return len(stack)
}