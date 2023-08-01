package homework3.services;

import homework3.data.Person;
import homework3.exceptions.FileRepositoryException;

import java.io.*;
import java.util.StringJoiner;

public class FilePersonRepository implements Repository<Person> {
    private final File dir;

    public FilePersonRepository(File dir) {
        this.dir = dir;
    }

    @Override
    public void save(Person entity) {
        try (Writer writer = new BufferedWriter(new FileWriter(getFile(entity), true))) {
            writer.append(createLine(entity)).append("\n");
        } catch (IOException e) {
            throw new FileRepositoryException(e);
        }
    }

    private File getFile(Person entity) {
        if (!dir.exists()) {
            dir.mkdir();
        }
        return dir.toPath().resolve(entity.getLastName()).toFile();
    }

    private String createLine(Person entity) {
        final StringJoiner stringJoiner = new StringJoiner("><");
        stringJoiner.add(entity.getLastName());
        stringJoiner.add(entity.getFirstName());
        stringJoiner.add(entity.getSecondName());
        stringJoiner.add(entity.getBirthDate());
        stringJoiner.add(entity.getPhone());
        stringJoiner.add(entity.getGender());
        return "<" + stringJoiner + ">";
    }
}
