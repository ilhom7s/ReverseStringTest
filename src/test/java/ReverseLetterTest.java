import org.example.reverse.ReverseLetter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class ReverseLetterTest {
    private final ReverseLetter reverseLetter = new ReverseLetter();
@ParameterizedTest
@CsvSource({
        ",",
        "null,"
})
    public void returnsEmptyForEmptyInput(){
       var result =  reverseLetter.reverse(null);
     assertEquals("",result);
    }
    @Test
    public void onlyStringSizeLessThenOne(){
     var result = reverseLetter.reverse("a");
     assertEquals("a",result);
    }
    @Test
    public void stringWithOutLetter(){
    var result = reverseLetter.reverse("12345&$");
    assertEquals("12345&$",result);
    }
    @ParameterizedTest
   @CsvSource({
           "hello, olleh",
           "привет, тевирп",
   })
    public void stringOnlyWithLetters(String input,String expected){

    var result = reverseLetter.reverse(input);
    assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvSource({
            "'Hello',   'olleH'",
            "'aBcD',    'DcBa'",
            "'Ab-Cd',   'dC-bA'",
            "'ПрИвЕт',  'тЕвИрП'"
    })
    void lettersKeepTheirCaseWhenSwapped(String input, String expected) {
        assertEquals(expected, reverseLetter.reverse(input));
    }

    @ParameterizedTest
    @CsvSource({
            "'!abc!',          '!cba!'",
            "'--ab--cd--',     '--dc--ba--'",
            "'1a2b3',          '1b2a3'",
            "'#a-b#',          '#b-a#'",
            "'?hello world!',  '?dlrow olleh!'"
    })
    void nonLetterCharactersStayInPlace(String input, String expected) {
    var result = reverseLetter.reverse(input);
    assertEquals(expected,result);
    }
}
