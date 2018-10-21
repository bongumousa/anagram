import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class AnagramService {

    public List<AnagramCounter> compute(String dictionaryLocation) throws IOException {
        List<String> unsortedWords = FileUtils.readLines(new File(dictionaryLocation));
        List<String> words = new ArrayList<>();

        ArrayList<AnagramCounter> anagramCounters = new ArrayList<>();
        Comparator<String> comparator = new StringComparator();

        Comparator<String> lengthComparator = new LengthComparator();

        boolean isNextLevel = false;

        // sort characters alphabetically
        for (String w : unsortedWords) {
            words.add(sortString(w));
        }
        Collections.sort(words, lengthComparator);

        AnagramCounter anagramCounter = new AnagramCounter(0, 0);

        for (int i = 0; i < words.size(); i++) {

            String word = words.get(i);

            if (i == 0 || isNextLevel) {
                anagramCounter = new AnagramCounter(word.length(), 0);
                isNextLevel = false;
            }

            for (int j = i + 1; j < words.size(); j++) {

                if (words.get(j).length() > words.get(i).length()) {
                    // next level
                    if (anagramCounter.getCount() > 0) {
                        anagramCounter.incrementCount();
                    }
                    anagramCounters.add(anagramCounter);
                    i = j - 1;
                    isNextLevel = true;
                    break;
                } else {

                    if (comparator.compare(words.get(i), words.get(j)) == 0) {
                        anagramCounter.incrementCount();
                    } else {
                        // next set
                        anagramCounter.incrementCount();
                        i = j - 1;
                        break;
                    }
                }
            }
        }

        // add the last item's count
        if (anagramCounter.getCount() > 0) {
            anagramCounter.incrementCount();
        }
        anagramCounters.add(anagramCounter);
        return anagramCounters;
    }

    /**
     * sorts characters of a string in an alphabetically
     * @param str - unsorted string
     * @return sorted string
     * */
    private String sortString(String str) {

        Character tempArray[] = new Character[str.length()];
        for (int i = 0; i < str.length(); i++) {
            tempArray[i] = str.charAt(i);
        }

        Comparator<Character> charactorComparatorComparator = new CharactorComparator();

        Arrays.sort(tempArray, charactorComparatorComparator);

        StringBuilder sb = new StringBuilder(tempArray.length);
        for (Character c : tempArray)
            sb.append(c.charValue());

        return sb.toString();
    }


}

