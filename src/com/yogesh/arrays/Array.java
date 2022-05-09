package com.yogesh.arrays;

public class DynamicArray {
    private int[] items;
    private int count;

    public DynamicArray(int length){
        items = new int[length];
    }

    public void insert(int item){
        //if the array is full, resize it
        if(items.length == count) {
            //create a new array(twice the size of old array)
            int[] newItems = new int[count * 2];

            //copy all existing items from old to new array
            for(int i = 0; i < count; i++)
                newItems[i] = items[i];

            //set items to this new array
            items = newItems;
          
        }
        //Add new item at the end
        items[count++] = item;
    }

    public int indexOf(int item){
        //if we find item, return index
        //otherwise, return -1
        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;
        return -1;
    }

    public void removeAt(int index){
        //validate index
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        //shift items to left and fill the hole(removed items)
        for (int i = index; i < count; i++)
            // set items of i to right side i
            items[i] = items[i + 1];

        count--;
    }
    
    public void insertAt(int item, int index) {
    if (index < 0 || index > count)
      throw new IllegalArgumentException();

    // Note that I've extracted the logic for
    // resizing the array into this private
    // method so we can reuse in insert() and
    // insertAt() methods.
    //
    // This also made our code cleaner and
    // more readable.
    resizeIfRequired();

    for (int i = count - 1; i >= index; i--)
      items[i + 1] = items[i];

    items[index] = item;
    count++;
  }

  private void resizeIfRequired() {
    if (items.length == count) {
      int[] newItems = new int[count * 2];

      for (int i = 0; i < count; i++)
        newItems[i] = items[i];

      items = newItems;
    }
  }

  public void reverse() {
    int[] newItems = new int[count];

    for (int i = 0; i < count; i++)
      newItems[i] = items[count - i - 1];

    items = newItems;
  }

  public int max() {
    // O(n): Because we have to iterate over
    // the entire array to find the largest
    // number. This number may be at the end
    // of the array (worst case scenario).
    int max = 0;
    for (int item : items)
      if (item > max)
        max = item;

    return max;
  }

  public Array intersect(Array other) {
    var intersection = new Array(count);

    for (int item : items)
      if (other.indexOf(item) >= 0)
        intersection.insert(item);

    return intersection;
  }


    public void print(){
        for(int i = 0; i < count; i++)
            System.out.print(items[i]+" ");
        System.out.println();
    }
}
