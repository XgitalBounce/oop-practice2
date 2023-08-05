package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;


/**
 * 1) 비밀번호는 최소 8자 이상 12자 이하여야 한다.
 * 2) 비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생시킨다.
 * 3) 경계조건에 대해 테스트 코드를 작성해야 한다
 */

public class PasswordValidatorTest {

    @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다.")  // 테스트 코드에 대한 역할을 명시한다.
    @Test
    void validatePasswordTest()
    {
       assertThatCode(()->PasswordValidator.validate("serverwizard"))
                .doesNotThrowAnyException();
    }

    @DisplayName("비밀번호가 8자 미만 혹은 12자 이상 초과하는 경우 IllegalArgumentException 예외가 발생한다.")
    @ParameterizedTest //  ValueSource를 사용할 수 있음 + csv 등등
    @ValueSource(strings={"aabbcce", "aabbccddeeffg"})
    void validatePasswordTest2(String password)
    {
        assertThatCode(()->PasswordValidator.validate(password))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }


}
