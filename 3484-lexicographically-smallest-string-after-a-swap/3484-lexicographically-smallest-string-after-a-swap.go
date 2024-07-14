func getSmallestString(sq string) string {
    s := []rune(sq)
	for i := 0; i < len(s)-1; i++ {
		if int(s[i])%2 == 0 && int(s[i+1])%2 == 0 && int(s[i]) > int(s[i+1]) {
			s = swap(i, i+1, s)
			break
		}
		if int(s[i])%2 == 1 && int(s[i+1])%2 == 1 && int(s[i]) > int(s[i+1]) {
			s = swap(i, i+1, s)
			break
		}
	}
	return string(s)
}

func swap(se, e int, s []rune) []rune {
	t := s[se]
	s[se] = s[e]
	s[e] = t
	return s
}