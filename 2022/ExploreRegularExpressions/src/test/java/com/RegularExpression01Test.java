package com.codeexcursion;
import org.junit.Assert;
import org.junit.Test;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegularExpression01Test {


    /*
       All tests should be run against multiline files.
       Each test exploration should test for single and multiple results.
       Should test matching across seperate lines.
    */
    
     private String testString =
     "The quick brown fox jumped over the lazy dog.\n" +
     "The quick brown fox jumped over the lazy dog.\n" +
     "The quick brown fox jumped over the lazy dog.\n" +
     "The quick brown fox jumped over the lazy dog.\r\n" +
     "The quick brown fox jumped over the lazy dog.\r\n" +
     "The quick brown fox jumped over the lazy dog.\r\n" +
     "The quick brown fox jumped over the lazy dog.\n\r" +
     "The quick brown fox jumped over the lazy dog.\n\r" +
     "The quick brown fox jumped over the lazy dog.\n\r" +
     "The quick brown fox jumped over the lazy @#$%^&*! dog.\n" +
     "The quick brown fox jumped over the lazy @#$%^&*! dog.\n" +
     "The quick brown fox jumped over the lazy @#$%^&*! dog.\n"
     ;

     private String testString2 =
     "The quick brown fox jumped over the lazy dog.\n" +
     "The quick brown fox jumped over the lazy dog.\n" +
     "The quick brown fox jumped over the lazy dog.\n" +
     "The quick brown fox jumped over the lazy @#$%^&*! dog.\n" +
     "The quick brown fox jumped over the lazy @#$%^&*! dog.\n" +
     "The quick brown fox jumped over the lazy @#$%^&*! dog.\n"
     ;


    @Test
    public void findPlainTextTest() {
      Pattern pattern = Pattern.compile("fox");
      Matcher matcher = pattern.matcher(testString);
      int matchCount = 0;

      while(matcher.find()) {
        matchCount++;
      }

      Assert.assertEquals("Should have had 12 matches", 12, matchCount);
    }

    @Test
    public void findSpecialCharactersTest() {
      Pattern pattern = Pattern.compile("@#\\$%\\^&\\*!");
      Matcher matcher = pattern.matcher(testString);
      int matchCount = 0;

      while(matcher.find()) {
        matchCount++;
      }

      Assert.assertEquals("Should have had 3 matches", 3, matchCount);
    }


    @Test
    public void findPlainTextAcrossMultipleLines5Test() {
      Pattern pattern = Pattern.compile("dog\\.\nThe");
      Matcher matcher = pattern.matcher(testString);
      int matchCount = 0;

      while(matcher.find()) {
        matchCount++;
      }

      Assert.assertEquals("Should have had 5 matches", 5, matchCount);
    }

    @Test
    public void findPlainTextAcrossMultipleLines11Test() {
      Pattern pattern = Pattern.compile("dog\\.\r?\n?\r?The");
      Matcher matcher = pattern.matcher(testString);
      int matchCount = 0;

      while(matcher.find()) {
        matchCount++;
      }

      Assert.assertEquals("Should have had 11 matches", 11, matchCount);
    }

    @Test
    public void multilineDefaultTest() {
      Pattern pattern = Pattern.compile("(?ms)^.*$");
      Matcher matcher = pattern.matcher(testString2);
      int matchCount = 0;

      while(matcher.find()) {
        matchCount++;
      }

      Assert.assertEquals("Should have had 11 matches", 11, matchCount);
    }    


}



