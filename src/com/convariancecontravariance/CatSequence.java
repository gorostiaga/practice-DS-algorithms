package com.convariancecontravariance;

import java.util.ArrayList;
import java.util.List;

public class CatSequence implements AnimalSequence{

    @Override
    public Animal next() {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Cat cat4 = new Cat();
        Cat cat5 = new Cat();
        Cat cat6 = new Cat();
        Cat cat7 = new Cat();
        return cat1;
    }

    @Override
    public List<Animal> getAnimals() {
        List<Animal> result;
        List<Cat> list = new ArrayList<>();
        result = list;
        return result;
    }

    @Override
    public List<Animal> getCats() {

        return null;
    }
}
