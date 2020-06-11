package leetcode

func longestCommonPrefix(strs []string) string {
	length := len(strs)
	if length == 0 {
		return ""
	}
	common := strs[0]
	for i := 1; i < length; i++ {
		common = commonPrefix(strs[i], common)
		if common == "" {
			return ""
		}
	}
	return common
}

func commonPrefix(a, b string) string {
	lengthA := len(a)
	lengthB := len(b)
	if lengthA == 0 || lengthB == 0 {
		return ""
	}
	length := 0
	if lengthA <= lengthB {
		length = lengthA
	} else {
		length = lengthB
	}
	i := 0
	for ; i < length; i++ {
		if a[i] != b[i] {
			break
		}
	}
	return a[0:i]
}
