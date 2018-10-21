import java.util.List;

/// <summary>
/// INSTRUCTIONS:
/// Write the logic within the Anagram Service class to determine how many anagrams exist in a given list of words.
/// The definition of an anagram can be found here: https://www.google.co.za/?#q=definition+of+anagram
///
/// The output should list how many anagrams exist for a given character count.
/// E.g. Words with the character length of 4 had 5000 anagrams
///
/// Feel free to change the structure of the solution if you feel it helps optimise execution speed, memory usage etc.
/// Feel free to ask other colleagues and / or use google when crafting your solution.
/// Document assumptions (if any) as comments in code.
///
/// Your code should:
///     a) make use of the included file Dictionary.txt,
///     b) write your results to the console in the form "Words with the character length of x had y anagrams"
///     c) include the total time in milliseconds somewhere in your console output
///     d) not write to the console on processing each word
///
/// </summary>
public class Main {

    public static void main(String[] args) {
        try {
            String dictionaryLocation = "./resources/Dictionary.txt";

            long startTime = System.currentTimeMillis();
            List<AnagramCounter> anagramResults = new AnagramService().compute(dictionaryLocation);
            long endTime = System.currentTimeMillis();

            System.out.println();
            System.out.println("Anagram Results (completed in " + (endTime - startTime) + " ms):");
            System.out.println();

            for (AnagramCounter anagramCounter : anagramResults) {
                System.out.println("Words with the character length of " +  anagramCounter.getWordLength() +
                        " had " + anagramCounter.getCount() + " anagrams");
            }
        } catch (Exception e) {
            System.out.println("The following exception occurred:");
            System.out.println(e.getMessage());
        }
    }
}
