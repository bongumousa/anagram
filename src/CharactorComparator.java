import java.util.Comparator;

public class CharactorComparator implements Comparator<Character> {
    @Override
    public int compare(Character o1, Character o2) {
        return Character.compare(o1, o2);
    }
}
