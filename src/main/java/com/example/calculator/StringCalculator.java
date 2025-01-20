package com.example.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

  public int add(String text) {

    if (isEmptyOrNull(text)) {
      return 0;
    }
    String[] words = split(text);
    int[] numbers = toIntArray(words);

    return sum(numbers);
  }
  private int sum(int[] numbers) {
    int sum = 0;
    for (int number : numbers) {
      sum += number;
    }

    return sum;
  }

  private boolean isEmptyOrNull(String text) {
    return text == null || text.isEmpty();
  }

  private int[] toIntArray(String[] words) {
    int[] numbers = new int[words.length];
    for (int i = 0; i < words.length; i++) {
      numbers[i] = toInt(words[i]);
    }
    return numbers;
  }
  private int toInt(String text) {
    int number = Integer.parseInt(text);
    if (number<0){
      throw new RuntimeException("음수는 입력할 수 없습니다.");
    }
    return number;
  }

  private String[] split(String text) {

    String regex = "//(.)\n(.*)";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(text);

    if (m.find()) {
      String custom = m.group(1);
      return m.group(2).split(Pattern.quote(custom));
    }

    return text.split("[,|:]");
  }
}
