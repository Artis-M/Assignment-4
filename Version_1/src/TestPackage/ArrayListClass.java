package TestPackage;

import utility.collection.ListADT;

import java.util.ArrayList;

public class ArrayListClass<T> implements ListADT<T>
{
  private ArrayList<T> arrayList;

  public ArrayListClass()
  {
    this.arrayList = new ArrayList<>(16);
  }

  @Override public void add(int index, T element)
  {
    arrayList.add(index, element);
  }

  @Override public void add(T element)
  {
    arrayList.add(element);
  }

  @Override public void set(int index, T element)
  {
    arrayList.set(index, element);
  }

  @Override public T get(int index)
  {
    return arrayList.get(index);
  }

  @Override public T remove(int index)
  {
    arrayList.remove(index);
    return arrayList.get(index);
  }

  @Override public T remove(T element)
  {
    arrayList.remove(element);
    return element;
  }

  @Override public int indexOf(T element)
  {
    return arrayList.indexOf(element);
  }

  @Override public boolean contains(T element)
  {
    return arrayList.contains(element);
  }

  @Override public boolean isEmpty()
  {
    return arrayList.isEmpty();
  }

  @Override public boolean isFull()
  {
    return arrayList.size() == 16;
  }

  @Override public int size()
  {
    return arrayList.size();
  }
}
