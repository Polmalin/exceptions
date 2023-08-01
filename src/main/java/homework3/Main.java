package homework3;

import homework3.data.Person;
import homework3.exceptions.FileRepositoryException;
import homework3.exceptions.InvalidInputException;
import homework3.parser.Parser;
import homework3.parser.PersonParser;
import homework3.services.FilePersonRepository;
import homework3.services.Repository;

import java.io.File;
import java.util.Scanner;

public class Main {
    private static final String EXIT = "exit";

    public static void main(String[] args) {
        final Repository<Person> repository = new FilePersonRepository(new File(""));
        final Parser<Person> parser = new PersonParser();
        final Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("input data: ");
            final String input = scanner.nextLine();
            if (EXIT.equals(input)) {
                return;
            }
            try {
                repository.save(parser.parse(input));
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (FileRepositoryException e) {
                e.printStackTrace();
            }
        }
    }
}
