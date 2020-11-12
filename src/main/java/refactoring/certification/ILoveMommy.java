package refactoring.certification;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个不定长的字符串，如果其元音(aeiou)的数量占比超过30%，那么将每个连续的元音集合替换成"mommy". 例如：
 * * hard → hard
 * * his → hmommys
 * * hear → hmommyr
 * <p>
 * 现在我们的任务有两个：
 * <p>
 * 1. 重构代码，确保可读性和可维护性达到要求(Cognitive Complexity <= 16, issues == 0)。
 * 2. 增加对大写元音（AEIOU）的支持(测试通过).
 */
public class ILoveMommy {

  private static final Set<Character> VOWEL_CHAR_SET = Set.of(
      'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'
  );

  public String transform(
      final String input
  ) {
    if (input == null || input.isEmpty()) {
      return input;
    }
    final char[] chars = input.toCharArray();
    final Set<Integer> vowelIndexSet = getVowelIndexSet(chars, VOWEL_CHAR_SET);
    if (notRequireTransform(chars, vowelIndexSet)) {
      return input;
    }

    return transform(chars, "mommy", vowelIndexSet);
  }

  private String transform(
      final char[] chars,
      final String newString,
      final Set<Integer> vowelIndexSet
  ) {
    final StringBuilder output = new StringBuilder(
        chars.length + newString.length() * vowelIndexSet.size()
    );

    for (int i = 0; i < chars.length; i++) {
      if (vowelIndexSet.contains(i)) {
        if (!vowelIndexSet.contains(i - 1)) {
          output.append(newString);
        }
        continue;
      }
      output.append(chars[i]);
    }
    return output.toString();
  }

  private boolean notRequireTransform(
      final char[] chars,
      final Set<Integer> vowelIndexSet
  ) {
    return !requireTransform(chars, vowelIndexSet);
  }

  private boolean requireTransform(
      final char[] chars,
      final Set<Integer> vowelIndexSet
  ) {
    return vowelIndexSet.size() >= chars.length * 0.3;
  }

  private Set<Integer> getVowelIndexSet(
      final char[] chars,
      final Set<Character> vowelChars
  ) {
    final Set<Integer> vowelIndexSet = new HashSet<>(chars.length);
    for (int i = 0; i < chars.length; i++) {
      if (vowelChars.contains(chars[i])) {
        vowelIndexSet.add(i);
      }
    }
    return vowelIndexSet;
  }

}
