import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListClassTest
{
  private ArrayList<String> arrayList;

  @org.junit.jupiter.api.BeforeEach void setUp()
  {
    this.arrayList = new ArrayList<>(16);
    arrayList.add("One");
    arrayList.add("Two");
    arrayList.add("Three");
    arrayList.add("Four");
  }

  @Test void ArrayListClass()
  {
    this.arrayList = new ArrayList<>();
  }

  @org.junit.jupiter.api.Test void addNull()
  {
    arrayList.add(4, null);
    assertNull(arrayList.get(4));
    assertEquals(5, arrayList.size());
  }

  @org.junit.jupiter.api.Test void addOne()
  {
    arrayList.add(4, "Dummy");
    assertEquals("Dummy", arrayList.get(4));
    assertEquals(5, arrayList.size());
  }

  @org.junit.jupiter.api.Test void addTwice()
  {
    arrayList.add(4, "Dummy");
    arrayList.add(5, "Dummy");
    assertEquals("Dummy", arrayList.get(4));
    assertEquals("Dummy", arrayList.get(5));
    assertEquals(6, arrayList.size());
  }

  @org.junit.jupiter.api.Test void addMultiple()
  {
    arrayList.add(2, "Dummy");
    arrayList.add(3, "Dummy2");
    arrayList.add(4, "Dummy3");
    assertEquals("Dummy", arrayList.get(2));
    assertEquals("Dummy2", arrayList.get(3));
    assertEquals("Dummy3", arrayList.get(4));
    assertEquals(7, arrayList.size());
  }

  @org.junit.jupiter.api.Test void testAddNull()
  {
    arrayList.add(null);
    assertNull(arrayList.get(4));
    assertEquals(5, arrayList.size());
  }

  @org.junit.jupiter.api.Test void testAddOne()
  {
    arrayList.add("Dummy");
    assertEquals("Dummy", arrayList.get(4));
    assertEquals(5, arrayList.size());
  }

  @org.junit.jupiter.api.Test void testAddTwice()
  {
    arrayList.add("Dummy");
    arrayList.add("Dummy");
    assertEquals("Dummy", arrayList.get(4));
    assertEquals("Dummy", arrayList.get(5));
    assertEquals(6, arrayList.size());
  }

  @org.junit.jupiter.api.Test void testAddMultiple()
  {
    arrayList.add("Dummy");
    arrayList.add("Dummy2");
    arrayList.add("Dummy3");
    assertEquals("Dummy", arrayList.get(4));
    assertEquals("Dummy2", arrayList.get(5));
    assertEquals("Dummy3", arrayList.get(6));
    assertEquals(7, arrayList.size());
  }

  @org.junit.jupiter.api.Test void setNull()
  {
    arrayList.set(1, null);
    assertNull(arrayList.get(1));
  }

  @org.junit.jupiter.api.Test void setNew()
  {
    arrayList.set(1, "Hello");
    assertEquals("Hello", arrayList.get(1));
  }

  @org.junit.jupiter.api.Test void setMultiple()
  {
    arrayList.set(1, "Hello");
    arrayList.set(2, "World");
    assertEquals("Hello", arrayList.get(1));
    assertNotEquals("Hello", arrayList.get(2));
    assertEquals("World", arrayList.get(2));
  }

  @org.junit.jupiter.api.Test void setNewTwice()
  {
    arrayList.set(1, "Dummy");
    assertEquals("Dummy", arrayList.get(1));
    arrayList.set(1, "Dummy2");
    assertEquals("Dummy2", arrayList.get(1));
  }

  @org.junit.jupiter.api.Test void get()
  {
    assertEquals("Two", arrayList.get(1));
    assertEquals("Three", arrayList.get(2));
    assertNotNull(arrayList.get(3));
  }

  @org.junit.jupiter.api.Test void removeNull()
  {
    arrayList.add(null);
    arrayList.remove(4);
    assertEquals(4, arrayList.size());
  }

  @org.junit.jupiter.api.Test void removeOne()
  {
    arrayList.remove(3);
    assertEquals(3, arrayList.size());
  }

  @org.junit.jupiter.api.Test void removeMultiple()
  {
    arrayList.remove(3);
    arrayList.remove(2);
    assertEquals(2, arrayList.size());
  }

  @org.junit.jupiter.api.Test void testRemoveNull()
  {
    arrayList.remove(null);
    assertEquals(4, arrayList.size());
  }

  @org.junit.jupiter.api.Test void testRemoveOne()
  {
    arrayList.remove("One");
    assertEquals(3, arrayList.size());
    assertNotEquals("One", arrayList.get(0));
  }

  @org.junit.jupiter.api.Test void testRemoveMultiple()
  {
    arrayList.remove("One");
    arrayList.remove("Two");
    assertEquals(2, arrayList.size());
  }

  @org.junit.jupiter.api.Test void indexOfNull()
  {
    assertNotEquals(0, arrayList.indexOf(null));
  }

  @org.junit.jupiter.api.Test void indexOfOne()
  {
    assertEquals(0, arrayList.indexOf("One"));
  }

  @org.junit.jupiter.api.Test void containsNull()
  {
    assertFalse(arrayList.contains(null));
  }

  @org.junit.jupiter.api.Test void containsOne()
  {
    assertTrue(arrayList.contains("Two"));
  }

  @org.junit.jupiter.api.Test void isEmpty()
  {
    assertFalse(arrayList.isEmpty());
  }

  @org.junit.jupiter.api.Test void isFull()
  {
    assertNotEquals(16, arrayList.size());
  }

  @org.junit.jupiter.api.Test void size()
  {
    assertEquals(4, arrayList.size());
  }
}