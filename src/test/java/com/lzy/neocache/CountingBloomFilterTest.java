package com.lzy.neocache;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import com.lzy.neocache.entity.CountingBloomFilterImpl;

public class CountingBloomFilterTest {
  public static void main(String[] args) {
        for (Method method : TestClass.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                try {
                    method.invoke(new TestClass());
                    System.out.println(method.getName() + " executed successfully.");
                } catch (Exception e) {
                    System.out.println(method.getName() + " failed: " + e.getMessage());
                }
            }
        }
    }
}

class TestClass {
  CountingBloomFilterImpl<String> myBloomFilter = new CountingBloomFilterImpl<>(500,0.01);
  public void init() {
      for(int i = 1; i <= 500; i++) {
          myBloomFilter.addElement(String.valueOf(i));
      }
  }
  public void delete() {
      for(int i = 200; i <= 300; i++) {
          myBloomFilter.removeElement(String.valueOf(i));
      }
  }
  @Test
  public void testContain() {
    init();
    for (int i = 1; i <= 500; i++) {
      boolean result = myBloomFilter.mightContain(String.valueOf(i));
      if (result) {
          System.out.println("Right: " + i + " exists");
      } else {
          System.out.println("Wrong: " + i + " exist");
      }
    }
  }
  @Test
  public void testNotContain() {
    init();
    for (int i = 501; i <= 600; i++) {
      boolean result = myBloomFilter.mightContain(String.valueOf(i));
      if (result) {
          System.out.println("Wrong: " + i + " not exists");
      } else {
          System.out.println("Right: " + i + " not exists");
      }
    }
  }
  @Test
  public void testDeleteContain() {
    init();
    delete();
    for (int i = 100; i < 200; i++) {
      boolean result = myBloomFilter.mightContain(String.valueOf(i));
      if (result) {
          System.out.println("Right: " + i + " exists");
      } else {
          System.out.println("Wrong: " + i + " exist");
      }
    }
    for (int i = 200; i <= 300; i++) {
      boolean result = myBloomFilter.mightContain(String.valueOf(i));
      if (result) {
          System.out.println("Wrong: " + i + " not exists");
      } else {
          System.out.println("Right: " + i + " not exists");
      }
    }
  }
}
