
var memo map[string]int

func maxLength(arr []string) int {
	memo = make(map[string]int)
	return fun(arr, 0, "")
}

func fun(arr []string, idx int, temp string) int {
	if idx >= len(arr) {
		return len(temp)
	}
	key := fmt.Sprintf("%d,%s", idx, temp)
	if val, found := memo[key]; found {
		return val
	}

	exclude := fun(arr, idx+1, temp)
	include := 0
	if !hasDuplicates(arr[idx], temp) {
		include = fun(arr, idx+1, temp+arr[idx])
	}
	result := max(exclude, include)
	memo[key] = result
	return result
}

func hasDuplicates(s1, s2 string) bool {
	v := make([]bool, 26)
	for _, char := range s1 {
		if v[char-'a'] {
			return true
		}
		v[char-'a'] = true
	}
	for _, char := range s2 {
		if v[char-'a'] {
			return true
		}
		v[char-'a'] = true
	}
	return false
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
