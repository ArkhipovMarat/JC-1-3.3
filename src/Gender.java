import java.util.List;
import java.util.Random;

public enum Gender {
    MALE,
    FEMALE;
    private static final List<Gender> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Gender randomGender()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
