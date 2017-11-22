package ru.job4j;

public abstract class AbstractStore<T extends Base> implements Store<T>{
    private int size;
    private SimpleArray<T> simpleArray;
    public AbstractStore(int size) {
        this.size = size;
        this.simpleArray = new SimpleArray<>(size);
    }


    @Override
    public T add(T model) {
        return simpleArray.add(model);
    }

    @Override
    public T update(T model) {
        return simpleArray.update(model);
    }

    @Override
    public boolean delete(String id) {
        for(int i = 0; i < size; i++) {
            T model = simpleArray.get(i);
            if (model!=null && model.getId().equals(id)) {
                return simpleArray.delete(i);
            }
        }
        return false;
    }
}
