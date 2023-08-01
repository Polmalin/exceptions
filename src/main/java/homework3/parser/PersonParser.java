package homework3.parser;

import homework3.data.Person;
import homework3.exceptions.InvalidInputException;

import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.regex.Pattern;

public class PersonParser implements Parser<Person> {
    private static final int PARTS_SIZE = 6;
    private static final String DATE_PATTERN = "dd.MM.yyyy";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
    private static final Pattern pattern = Pattern.compile("\\d+");
    private static final Set<String> genderSet = Set.of("f", "m");

    static {
        dateFormat.setLenient(false);
    }

    @Override
    public Person parse(String input) throws InvalidInputException {
        final String[] parts = input.split("\\s");
        if (PARTS_SIZE != parts.length) {
            throw new InvalidInputException("input must contain " + PARTS_SIZE + " parts");
        }
        checkDate(parts[3]);
        checkDigits(parts[4]);
        checkGender(parts[5]);
        int index = 0;
        return new Person(parts[index++], parts[index++], parts[index++], parts[index++], parts[index++], parts[index]);
    }

    private void checkDate(String date) throws InvalidInputException {
        try {
            dateFormat.parse(date);
        } catch (Exception e) {
            throw new InvalidInputException("date must follow " + DATE_PATTERN + " format");
        }
    }

    private void checkDigits(String phone) throws InvalidInputException {
        if (!pattern.matcher(phone).matches()) {
            throw new InvalidInputException("phone must contain only digits");
        }
    }

    private void checkGender(String gender) throws InvalidInputException {
        if (!genderSet.contains(gender)) {
            throw new InvalidInputException("gender must be only 'm' or 'f'");
        }
    }
}
