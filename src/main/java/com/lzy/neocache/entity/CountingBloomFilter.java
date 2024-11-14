package com.lzy.neocache.entity;

public interface CountingBloomFilter<T> {
    void addElement(T element);
    void removeElement(T element);
    boolean mightContain(T element);
}
