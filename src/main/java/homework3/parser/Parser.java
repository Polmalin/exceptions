package homework3.parser;

import homework3.exceptions.InvalidInputException;

public interface Parser<T> {
    T parse(String input) throws InvalidInputException;
}
