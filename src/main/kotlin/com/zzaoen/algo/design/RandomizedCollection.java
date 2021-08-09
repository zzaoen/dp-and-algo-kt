package com.zzaoen.algo.design;

import java.util.*;

/**
 * @author: Bruce Zhao
 * @date: 2020/10/31 10:08
 * @desc:
 */
public class RandomizedCollection {
  List<Integer> array = null;
  Map<Integer, Set<Integer>> map = null;

  /*public static void main(String[] args) {
    RandomizedCollection main = new RandomizedCollection();
    main.insert(1);
    main.insert(1);
    main.insert(2);
    System.out.println(main.getRandom());
    main.remove(1);
    main.remove(1);
    main.remove(1);
    main.remove(2);
    main.remove(3);
    
  }*/
  /** Initialize your data structure here. */
  public RandomizedCollection() {
    array = new ArrayList<>();
    map = new HashMap<>();
  }

  /**
   * Inserts a value to the collection. Returns true if the collection did not already contain the
   * specified element.
   */
  public boolean insert(int val) {
    array.add(val);
    Set<Integer> set = map.getOrDefault(val, new HashSet<Integer>());
    set.add(array.size() - 1);
    map.put(val, set);
    return set.size() == 1;
  }

  /**
   * Removes a value from the collection. Returns true if the collection contained the specified
   * element.
   */
  public boolean remove(int val) {
    if (!map.containsKey(val)) return false;
  
    Iterator<Integer> it = map.get(val).iterator();
    int firstIndex = it.next();
    int lastNum = array.get(array.size() - 1);
  
    // 1,1,2 remove(1) 2,1,2
    array.set(firstIndex, lastNum);
    
    // remove val's index
    map.get(val).remove(firstIndex);
    // remove lastNum's index
    map.get(lastNum).remove(array.size() - 1);
    
    // 1,1,2 remove(2)
    if (firstIndex < array.size() - 1) {
      map.get(lastNum).add(firstIndex);
    }
    
    // If no more num, remove index
    if (map.get(val).size() == 0) {
      map.remove(val);
    }
    
    // remove the last one(val)
    array.remove(array.size() - 1);
    return true;
  }

  /** Get a random element from the collection. */
  public int getRandom() {
    return array.get((int) (Math.random() * array.size()));
  }
}
