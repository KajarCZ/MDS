package cz.vutbr.bmds.cv01;

import java.util.ArrayList;

public class MyClass implements ISum{
    private static int count = 0;

    private ArrayList<Integer> list = new ArrayList<Integer>();

    // KONSTRUKTORY

    public MyClass(){
        count++;
    }

    public MyClass(int...numbers) {
        this();

        for (int i: numbers) {
            addInteger(i);
        }
    }

    // STATICKE METODY

    public static int getCount() {
        return  count;
    }

    public static MyClass createUnited(MyClass prvni, MyClass druhy) {
        MyClass newObject = new MyClass();

        newObject.list.addAll(prvni.list);
        newObject.list.addAll(druhy.list);

        return newObject;
    }

    // TRIDNI METODY

    public void addInteger(int i) throws IllegalArgumentException {
        if (i > 0){
            list.add(i);
        } else {
            throw new IllegalArgumentException("Nelze vkladat zaporna cisla");
        }
    }

    public boolean integerExists(int i) {
        return list.contains(i);
    }

    @Override
    public String toString() {
        return "\nSeznam o velikosti " + list.size() + " se souctem " + sum();
    }

    @Override
    public int sum() {
        int sum = 0;

        for (int i: list) {
            sum += i;
        }

        return sum;
    }

    public void print() {
        System.out.print("Seznam (" + list.size() + "): ");

        for (int i: list) {
            System.out.print(i+ " ");
        }
    }
}
