package com.example.iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Bag<E> implements Container<E> {
    private ArrayList<E> contents;

    public Bag() {
      this.contents = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
      return this.contents.isEmpty();
    }

    @Override
    public int size() {
        return this.contents.size();
    }

    // create an override method for the add method in the Container interface
    @Override
    public void add(E item) {
      this.contents.add(item);
    }

    @Override
    public Iterator<E> iterator() {
      return this.contents.iterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
      this.contents.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
      return this.contents.spliterator();
    }

 }
