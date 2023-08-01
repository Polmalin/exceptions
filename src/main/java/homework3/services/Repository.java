package homework3.services;

public interface Repository<T> {
    void save(T entity);
}
