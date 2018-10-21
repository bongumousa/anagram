import java.util.Comparator;

public class StringComparator implements Comparator<String> {

    public int compare(String firstString, String secondString) {

        if (firstString == null) {
            return -1;
        }

        if (secondString == null) {
            return -1;
        }


        // TODO - sort characters

        if (firstString.equals(secondString)) {
            return 0;
        }

//        @Override
//        public int compare(String o1, String o2) {
//            return 0;
//        }
        // future proof is case is changed on the file
        return firstString.compareToIgnoreCase(secondString);
    }
}
