


class Solution:
    def commonPrefix(self, a: str, b: str) -> str:
        lengthA = len(a)
        lengthB = len(b)
        length = lengthA if lengthA >= lengthB else lengthB
        for i in range(length):
            if a[i] != b[i]:
                break
        return a[:i]

    def longestCommonPrefix(self, strs: List[str]) -> str:
        length = len(strs)
        if length == 0:
            return ""
        common = strs[0]
        for i in range(1, length):
            common = commonPrefix(strs[i], common)
            if common == "":
                return common
        return common
        
        