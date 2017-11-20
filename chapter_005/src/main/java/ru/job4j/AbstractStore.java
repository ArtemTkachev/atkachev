package ru.job4j;

public abstract class AbstractStore implements Store{
    private int size;
    private SimpleArray<Base> simpleArray;
    public AbstractStore(int size) {
        this.size = size;
        this.simpleArray = new SimpleArray<>(size);
    }


    @Override
    public Base add(Base model) {
        return simpleArray.add(model);
    }

    @Override
    public Base update(Base model) {
        return simpleArray.update(model);
    }

    @Override
    public boolean delete(String id) {
        for(int i = 0; i < size; i++) {
            Base model = simpleArray.get(i);
            if (model!=null && model.getId().equals(id)) {
                return simpleArray.delete(i);
            }
        }
        return false;
    }
}
