package com.mdolat.gameoflife.board;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ErrorMessageTest {

  @Test
  public void testEqualsSameObject() {
    ErrorMessage errorMessage = ErrorMessage.of("first message");

    assertTrue(errorMessage.equals(errorMessage));
  }

  @Test
  public void testEqualsSameMessage() {
    ErrorMessage errorMessage = ErrorMessage.of("first message");
    ErrorMessage errorMessage2 = ErrorMessage.of("first message");

    assertTrue(errorMessage.equals(errorMessage2));
  }

  @Test
  public void testNotEqualsNull() {
    ErrorMessage errorMessage = ErrorMessage.of(null);
    ErrorMessage errorMessage2 = ErrorMessage.of("first message");

    assertFalse(errorMessage.equals(errorMessage2));
  }

  @Test
  public void testNotEqualsOtherType() {
    ErrorMessage errorMessage = ErrorMessage.of("first message");

    assertFalse(errorMessage.equals(new Object()));
  }
}
