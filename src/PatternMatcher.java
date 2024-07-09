import java.util.regex.*;

public class PatternMatcher {

    public static void main(String args[]){

        // Simple example
        String input = "Hi Learners";
        Pattern pattern = Pattern.compile("Learn", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()){
            System.out.println("Simple example - Match found");
        }
        else {
            System.out.println("Simple example - Match not found");
        }

        // use of | - finds the exact string among the options
        Pattern pattern1 = Pattern.compile("apple|banana|cherry");
        Matcher matcher1 = pattern1.matcher("cherry is red.");
        if(matcher1.find()){
            System.out.println("Example of | - Match found");
        }
        else {
            System.out.println("Example of | - Match not found");
        }
        // use of . - acts as a wild card for one character

        Pattern pattern2 = Pattern.compile(".amp");
        Matcher matcher2 = pattern2.matcher("samples");
        if(matcher2.find()){
            System.out.println("Example of . - Match found");
        }
        else {
            System.out.println("Example of . - Match not found");
        }

        // use of ^ - finds pattern at the start of data string

        Pattern pattern3 = Pattern.compile("^samp");
        Matcher matcher3 = pattern3.matcher("samples");
        if(matcher3.find()){
            System.out.println("Example of ^ - Match found");
        }
        else {
            System.out.println("Example of ^ - Match not found");
        }

        // use of $ - finds pattern at the end of data string
        boolean isMatched = Pattern.matches(".*al$","animal");
        System.out.println("Example of $ - Match found " + isMatched);


        // use of range - finds range in data string
        boolean isRangeMatched = Pattern.matches("[a-z]{3,7}","apple");
        System.out.println("Example of range - Match found " + isRangeMatched);


        /*Create a regular expression that accepts 10 digit numeric characters
         starting with 7, 8 or 9 only.*/
        boolean Q1A1 = Pattern.matches("[7-9][0-9]{9}","8382938373");
        boolean Q1A2 = Pattern.matches("[789]\\d{9}","8382938373");
        System.out.println("Example of Q1A1 - Match found " + Q1A1);
        System.out.println("Example of Q1A2 - Match found " + Q1A2);

        // Find HTML tags

        //Pattern pattern4 = Pattern.compile("<[a-zA-Z0-9]+>(.*?)</[a-zA-Z0-9]+>");
        Pattern pattern4 = Pattern.compile("<\\w+>(.*?)</\\w+>", Pattern.DOTALL);
        Matcher matcher4 = pattern4.matcher("<h1>Nayeem loves counseling</h1>\n" +
                "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>\n" +
                "<Amee>safat codes like a ninja</amee>\n" +
                "<SA premium>Imtiaz has a secret crush</SA premium>");

        while(matcher4.find()){
            System.out.println(matcher4.group(1));
        }


    }
}
