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

  private static final Set<Character> VOWEL_SET = Set.of(
      'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'
  );

  public String transform(
      final String input
  ) {
    if (input == null || input.isEmpty()) {
      return input;
    }

    final Set<Integer> vowelIndexSet = getVowelIndexSet(input);

    if (requiredTransform(input, vowelIndexSet)) {
      return transform(input, "mommy");
    }

    return input;
  }

  private String transform(
      final String input,
      final String newString
  ) {
    StringBuffer inputAsBuffer = new StringBuffer(input);
    Boolean consecutive = false;
    for (int i = 0; i < inputAsBuffer.length(); i++) {
      char character = inputAsBuffer.charAt(i);
      boolean result = false;
      if (VOWEL_SET.contains(character)) {
        result = true;
      }
      if (result) {
        inputAsBuffer.deleteCharAt(i);
        if (!consecutive) {
          inputAsBuffer.insert(i, newString);
          i = i + newString.length() - 1;
          consecutive = true;
          continue;
        }
        consecutive = false;
      } else {
        consecutive = false;
      }
    }
    return inputAsBuffer.toString();
  }

  private boolean requiredTransform(
      final String input,
      final Set<Integer> vowelIndexSet
  ) {
    return vowelIndexSet.size() >= input.length() * 0.3;
  }

  private Set<Integer> getVowelIndexSet(
      final String input
  ) {
    final Set<Integer> vowelIndexSet = new HashSet<>(input.length());
    for (int i = 0; i < input.length(); i++) {
      if (VOWEL_SET.contains(input.charAt(i))) {
        vowelIndexSet.add(i);
      }
    }
    return vowelIndexSet;
  }

}
