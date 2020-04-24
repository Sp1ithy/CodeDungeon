package com.company.items;

import com.company.Exceptions.LessThanZeroException;

//класс родитель для всех предметов в игре
public abstract class Item {
    private int weight;
    private double price;

    protected Item() {
        weight = 0;
        price = 0;
    }

    protected Item(int weight, double price) throws LessThanZeroException {
        setWeight(weight);
        setPrice(price);
    }

    protected int getWeight() {
        return weight;
    }

    protected void setWeight(int weight) throws LessThanZeroException {
        if (weight < 0) {
            throw new LessThanZeroException(weight);
        }
        this.weight = weight;
    }

    protected void setPrice(double price) throws LessThanZeroException {
        if (price < 0) {
            throw new LessThanZeroException(price);
        }
        this.price = price;
    }

    protected double getPrice() {
        return price;
    }
}
