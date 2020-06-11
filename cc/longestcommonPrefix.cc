#include <string>
#include <vector>

class Solution {
 public:
  std::string commonPrefix(const std::string &a, const std::string &b) {
    int lengthA = a.size();
    int lengthB = b.size();
    int length = lengthA <= lengthB ? lengthA : lengthB;

    int i = 0;
    for (; i < length; i++) {
      if (a[i] != b[i]) {
        break;
      }
    }
    return a.substr(0, i);
  }

  std::string longestCommonPrefix(const std::vector<std::string> &strs) {
    int size = strs.size();
    if (size == 0) {
      return "";
    }
    std::string common = strs[0];
    for (int i = 1; i < size; i++) {
      common = commonPrefix(strs[i], common);
      if (common.empty()) {
        return "";
      }
    }
    return common;
  }
};
