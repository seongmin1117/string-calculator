package calcualtor;

import com.example.calculator.StringCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
  private StringCalculator stringCalculator;

  @BeforeEach
  void setUp() {
    stringCalculator = new StringCalculator();
  }
  @DisplayName("빈 문자열을 입력할 경우 0을 반환해야 한다.")
  @Test
  void isEmpty() {
    // given
    String text = "";
    // when
    int result = stringCalculator.add(text);
    // then
    Assertions.assertEquals(0, result);
  }

  @DisplayName("null을 입력할 경우 0을 반환해야 한다.")
  @Test
  void isNull() {
    // given
    String text = null;
    // when
    int result = stringCalculator.add(text);
    // then
    Assertions.assertEquals(0, result);
  }

  @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
  @Test
  void one() {
    // given
    String text = "1";
    // when
    int result = stringCalculator.add(text);
    // then
    Assertions.assertEquals(1, result);
  }

  @DisplayName("문자를 요구사항의 구분자로 분리한 후 각 숫자의 합을 구할 수 있다.")
  @Test
  void add() {
    // given
    String text = "1,2:6";
    // when
    int result = stringCalculator.add(text);
    // then
    Assertions.assertEquals(9, result);
  }

  @DisplayName("문자를 커스텀 구분자로 분리한 후 각 숫자의 합을 구할 수 있다.")
  @Test
  void custom() {
    // given
    String text = "//^\n6^5^1";
    // when
    int result = stringCalculator.add(text);
    // then
    Assertions.assertEquals(12, result);
  }

  @DisplayName("문자열 계산기에 음수를 전달하는 경우 RuntimeException 이 발생한다.")
  @Test
  void negative() throws RuntimeException {
    // given
    String input = "-1,-3,2";
    // when & then
    Assertions.assertThrows(RuntimeException.class, () -> stringCalculator.add(input));
  }
}
