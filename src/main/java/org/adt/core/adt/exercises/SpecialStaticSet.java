package org.adt.core.adt.exercises;

import org.adt.core.adt.definition.ISet;

import java.util.Random;

public class SpecialStaticSet implements ISet {

    private final int[] array;
    private int count;

    public SpecialStaticSet() {
        this.array = new int[10000];
        this.count = 0;
    }

    @Override
    public void add(int a) {
        if(a % 2 == 1) {
            for(int i = 0; i < this.count; i++) {
                if(this.array[i] == a) {
                    return;
                }
            }

            this.array[this.count] = a;
            this.count++;
            return;
        }
        
        int total = 0;
        for(int i = 0; i < this.count; i++) {
            if(this.array[i] == a) {
                total++;
            }
            if(total == 3) {
                return;
            }
        }

        this.array[this.count] = a;
        this.count++;
    }

    @Override
    public void remove(int a) {
        for(int i = 0; i < this.count; i++) {
            if(this.array[i] == a) {
                if(i == this.count - 1) {
                    this.count--;
                    return;
                }
                this.array[i] = this.array[this.count - 1];
                this.count--;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int choose() {
        if(this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return -1;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        return this.array[randomIndex];
    }
}
