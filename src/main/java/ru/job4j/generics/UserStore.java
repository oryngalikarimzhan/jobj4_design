package ru.job4j.generics;

public class UserStore implements Store<User> {

    private final Store<User> store = new MemStore<>();

    @Override
    public void add(User model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        store.replace(id, model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        store.delete(id);
        return true;
    }

    @Override
    public User findById(String id) {
        return store.findById(id);
    }
}
