package DynamicDemo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.jupiter.api.Named.named;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.TestFactory;

import parameterized.calculator;

class DynamicTestDemo {
	public boolean isPalindrome(String s) {
		String s2="";
		for(int i=0;i<s.length();i++) {
			s2=s2+s.charAt(s.length()-1-i);
		}
		if(s.equals(s2)) {
			return true;
		}else return false;
	}

    private final calculator calculator = new calculator();

    // This will result in a JUnitException!
    @TestFactory
    List<String> dynamicTestsWithInvalidReturnType() {
        return Arrays.asList("Hello");
    }

    @TestFactory
    Collection<DynamicTest> dynamicTestsFromCollection() {
        return Arrays.asList(
            dynamicTest("1st dynamic test", () -> assertTrue(isPalindrome("madam"))),
            dynamicTest("2nd dynamic test", () -> assertEquals(4, calculator.multiply(2, 2)))
        );
    }

    @TestFactory
    Iterable<DynamicTest> dynamicTestsFromIterable() {
        return Arrays.asList(
            dynamicTest("3rd dynamic test", () -> assertTrue(isPalindrome("madam"))),
            dynamicTest("4th dynamic test", () -> assertEquals(4, calculator.multiply(2, 2)))
        );
    }

    @TestFactory
    Iterator<DynamicTest> dynamicTestsFromIterator() {
        return Arrays.asList(
            dynamicTest("5th dynamic test", () -> assertTrue(isPalindrome("madam"))),
            dynamicTest("6th dynamic test", () -> assertEquals(4, calculator.multiply(2, 2)))
        ).iterator();
    }

@TestFactory
Stream<DynamicTest> dynamicTestsFromStreamFactoryMethodWithNames() {
    // Stream of palindromes to check
    Stream<Named<String>> inputStream = Stream.of(
            named("racecar is a palindrome", "racecar"),
            named("radar is also a palindrome", "radar"),
            named("mom also seems to be a palindrome", "mom"),
            named("dad is yet another palindrome", "dad")
        );

    // Returns a stream of dynamic tests.
    return DynamicTest.stream(inputStream,
        text -> assertTrue(isPalindrome(text)));
}

@TestFactory
Stream<DynamicNode> dynamicTestsWithContainers() {
    return Stream.of("A", "B", "C")
        .map(input -> dynamicContainer("Container " + input, Stream.of(
            dynamicTest("not null", () -> assertNotNull(input)),
            dynamicContainer("properties", Stream.of(
                dynamicTest("length > 0", () -> assertTrue(input.length() > 0)),
                dynamicTest("not empty", () -> assertFalse(input.isEmpty()))
            ))
        )));
}

@TestFactory
DynamicNode dynamicNodeSingleTest() {
    return dynamicTest("'pop' is a palindrome", () -> assertTrue(isPalindrome("pop")));
}

@TestFactory
DynamicNode dynamicNodeSingleContainer() {
    return dynamicContainer("palindromes",Stream.of("racecar", "radar", "mom", "dad") .map(text -> dynamicTest(text, () -> assertTrue(isPalindrome(text)))
    ));
}

}