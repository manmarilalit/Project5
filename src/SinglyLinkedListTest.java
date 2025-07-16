package prj5;

import java.util.Arrays;

import student.TestCase;

/**
 * 
 * Tests the equals and toArray methods of a singly linked list.
 * 
 * @author Margaret Ellis (maellis1)
 * 
 * @author Jeff Robertson (thejar)
 * 
 * @author Kexin Zhang (phoebez)
 * 
 * @version 10/19/2024
 *
 */
public class SinglyLinkedListTest extends TestCase {

    private SinglyLinkedList<String> emptyListA;
    private SinglyLinkedList<String> emptyListB;
    private SinglyLinkedList<String> smallListA;
    private SinglyLinkedList<String> smallListB;
    private SinglyLinkedList<String> bigListA;
    private SinglyLinkedList<String> bigListB;
    
    private SinglyLinkedList<Influencer> l1;
    private SinglyLinkedList<Influencer> l2;

    private String nullObject;


    /**
     * Initializes 2 empty lists, 2 lists with a small number of items, and 2
     * lists with a large number of items
     */
    public void setUp() {
        emptyListA = new SinglyLinkedList<String>();
        emptyListB = new SinglyLinkedList<String>();

        smallListA = new SinglyLinkedList<String>();
        smallListB = new SinglyLinkedList<String>();

        smallListA.add("apple");
        smallListA.add("strawberry");
        smallListA.add("pear");

        smallListB.add("apple");
        smallListB.add("strawberry");
        smallListB.add("pear");

        bigListA = new SinglyLinkedList<String>();

        for (int i = 0; i < 100; i++) {
            bigListA.add("fruit" + i);
        }

        bigListB = new SinglyLinkedList<String>();
        for (int i = 0; i < 100; i++) {
            bigListB.add("fruit" + i);
        }
        
        // to be explicit
        nullObject = null;
        
        l1 = new SinglyLinkedList<Influencer>();
        l1.add(new Influencer("", "ArtAllDay", "", ""));
        l1.add(new Influencer("", "australian_wildlife", "", ""));
        l1.add(new Influencer("", "JustBeatz", "", ""));
        l1.add(new Influencer("", "wizardHighSchool", "", ""));
        
        l2 = new SinglyLinkedList<Influencer>();
        l2.add(new Influencer("", "australian_wildlife", "", ""));
        l2.add(new Influencer("", "ArtAllDay", "", ""));
        l2.add(new Influencer("", "JustBeatz", "", ""));
        l2.add(new Influencer("", "wizardHighSchool", "", ""));

    }


    /**
     * Tests the equals method on an empty list
     */
    public void testEqualsEmptyList() {
        assertEquals(emptyListA, emptyListA);
        assertEquals(emptyListA, emptyListB);
        assertFalse(emptyListA.equals(nullObject));
        assertFalse(emptyListA.equals("soccer"));
        assertFalse(emptyListA.equals(smallListA));
        assertFalse(smallListA.equals(emptyListA));
        emptyListB.add("jump roping");
        assertFalse(emptyListA.equals(emptyListB));
        smallListA.clear();
        assertEquals(emptyListA, smallListA);
    }


    /**
     * Tests the equals method on a list with a small number of items in it
     */
    public void testEqualsSmallList() {
        assertEquals(smallListA, smallListA);
        assertEquals(smallListA, smallListB);
        assertFalse(smallListA.equals(nullObject));
        assertFalse(smallListA.equals("soccer"));
        assertFalse(smallListA.equals(bigListA));
        assertFalse(smallListA.equals(emptyListA));
        smallListB.add("jump roping");
        assertFalse(smallListA.equals(smallListB));

        
        smallListA.add("rope jumping");
        assertFalse(smallListA.equals(smallListB));

        
        smallListA.remove("rope jumping");
        smallListA.add("jump roping");
        assertEquals(smallListA, smallListB);
    }


    /**
     * Tests the equals method on a list with a large number of items in it
     */
    public void testEqualsBigList() {
        assertEquals(bigListA, bigListA);
        assertEquals(bigListA, bigListB);
        assertFalse(bigListA.equals(nullObject));
        assertFalse(bigListA.equals("soccer"));
        assertFalse(bigListA.equals(smallListA));
        assertFalse(bigListA.equals(emptyListA));
        bigListB.add("jump roping");
        assertFalse(bigListA.equals(bigListB));

        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 100; i > 0; i--) {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 50; i++) {
            bigListB.add("fruit" + i);
        }
        for (int i = 0; i < 50; i++) {
            bigListB.add("fruit" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 100; i++) {
            bigListB.add("fruit" + i);
        }
        assertEquals(bigListA, bigListB);

    }


    /**
     * Tests the toArray method on an empty list
     */
    public void testToArrayEmpty() {

        Object[] emptyArray = {};
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(emptyListA.toArray(), smallListB.toArray()));
        Object[] oneItemArray = { "one thing" };
        emptyListA.add("one thing");
        assertTrue(Arrays.equals(emptyListA.toArray(), oneItemArray));

    }


    /**
     * Tests the toArray method on a list with items in it
     */
    public void testToArrayContents() {

        Object[] origArray = { "apple", "strawberry", "pear" };
        assertTrue(Arrays.equals(smallListA.toArray(), origArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(smallListA.toArray(), bigListB.toArray()));

    }
    
    /**
     * tests add method with index
     */
    public void testAddWithIndex() {
        Exception exception = null;
        try {
            this.emptyListA.add(0, nullObject);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);
        
        exception = null;
        Exception exception2 = null;
        try {
            this.emptyListA.add(-1, "inappropriate index");
        }
        catch (Exception e) {
            exception = e;
        }
        try {
            this.emptyListA.add(1000, "inappropriate index2");
        }
        catch (Exception e) {
            exception2 = e;
        }
        assertNotNull(exception);
        assertNotNull(exception2);
        assertTrue(exception instanceof IndexOutOfBoundsException);
        assertTrue(exception instanceof IndexOutOfBoundsException);
        
        assertEquals(this.emptyListA.size(), 0, 0.01);
        assertEquals(this.emptyListA.toString(), "{}");
        this.emptyListA.add(0, "string");
        assertEquals(this.emptyListA.toString(), "{string}");
        assertEquals(this.emptyListA.size(), 1, 0.01);
        
        
        assertEquals(this.smallListA.size(), 3, 0.01);
        assertEquals(this.smallListA.toString(),
            "{apple, strawberry, pear}");
        this.smallListA.add(0, "string");
        assertEquals(this.smallListA.size(), 4, 0.01);
        assertEquals(this.smallListA.toString(),
            "{string, apple, strawberry, pear}");

        this.smallListA.remove("string");
        assertEquals(this.smallListA.size(), 3, 0.01);
        assertEquals(this.smallListA.toString(),
            "{apple, strawberry, pear}");
        this.smallListA.add(1, "string");
        assertEquals(this.smallListA.size(), 4, 0.01);
        assertEquals(this.smallListA.toString(),
            "{apple, string, strawberry, pear}");
    }
    
    /**
     * tests add method with no index
     */
    public void testAddWithNoIndex() {
        Exception exception = null;
        try {
            this.emptyListA.add(nullObject);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);
        
        assertEquals(this.emptyListA.size(), 0, 0.01);
        assertEquals(this.emptyListA.toString(), "{}");
        this.emptyListA.add("string");
        assertEquals(this.emptyListA.toString(), "{string}");
        assertEquals(this.emptyListA.size(), 1, 0.01);
        
        assertEquals(this.smallListA.size(), 3, 0.01);
        assertEquals(this.smallListA.toString(),
            "{apple, strawberry, pear}");
        this.smallListA.add("string");
        assertEquals(this.smallListA.size(), 4, 0.01);
        assertEquals(this.smallListA.toString(),
            "{apple, strawberry, pear, string}");
        
    }
    
    /**
     * tests remove method with object
     */
    public void testRemoveWObject() {
        assertFalse(this.emptyListA.remove("pseudoString"));
        
        assertEquals(this.emptyListA.size(), 0, 0.01);
        this.emptyListA.add("string");
        assertEquals(this.emptyListA.size(), 1, 0.01);
        assertTrue(this.emptyListA.remove("string"));
        assertEquals(this.emptyListA.size(), 0, 0.01);
        
        this.emptyListB.add("string");
        assertEquals(this.emptyListB.size(), 1, 0.01);
        assertFalse(emptyListB.remove("bannana"));
        assertTrue(emptyListB.remove("string"));
        assertEquals(this.emptyListB.size(), 0, 0.01);
        
        this.emptyListB.add("string1");
        this.emptyListB.add("string2");
        assertEquals(this.emptyListB.size(), 2, 0.01);
        assertTrue(emptyListB.remove("string1"));
        assertEquals(this.emptyListB.size(), 1, 0.01);
        
        
        //size>3
        this.emptyListA.add("string1");
        this.emptyListA.add("string2");
        this.emptyListA.add("string3");
        assertEquals(this.emptyListA.size(), 3, 0.01);
        assertTrue(emptyListA.remove("string2"));
        assertTrue(this.emptyListA.get(1).equals("string3"));
        
        assertEquals(this.smallListA.size(), 3, 0.01);
        assertTrue(this.smallListA.remove("pear"));
        assertEquals(this.smallListA.size(), 2, 0.01);
        
        assertFalse(smallListA.remove("dancing"));
        
    }
    
    /**
     * tests remove method with index
     */
    public void testRemoveWIndex() {
        Exception exception = null;
        try {
            this.smallListA.remove(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);
        
        exception = null;
        try {
            this.smallListA.remove(0);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNull(exception);
        assertFalse(exception instanceof IndexOutOfBoundsException);
        
        
        exception = null;
        try {
            this.emptyListA.remove(1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);
        
        exception = null;
        try {
            this.smallListA.remove(100);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);
        
        assertTrue(this.smallListA.remove(1));
    }
    
    /**
     * tests get method
     */
    public void testGet() {
        Exception exception = null;
        try {
            this.smallListA.get(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);
        
        assertEquals(this.smallListA.get(0), "apple");
        assertEquals(this.smallListA.get(1), "strawberry");
        assertEquals(this.smallListA.get(2), "pear");
    }
    
    /**
     * tests contains method
     */
    public void testContains()
    {
        assertTrue(this.smallListA.contains("apple"));
        assertFalse(this.smallListA.contains("test"));
    }
    
    // ----------------------------------------------------------
    /**
     * tests clear method
     */
    public void testClear() {
        assertEquals(this.emptyListA.size(), 0, 0.01);
        this.emptyListA.clear();
        assertEquals(this.emptyListA.size(), 0, 0.01);
        
        assertEquals(this.smallListA.size(), 3, 0.01);
        this.smallListA.clear();
        assertEquals(this.smallListA.size(), 0, 0.01);
    }
    
    /**
     * tests lastIndexOf method
     */
    public void testLastIndexOf() {
        this.emptyListA.add("string1");
        this.emptyListA.add("string1");
        this.emptyListA.add("string2");
        
        assertEquals(this.emptyListA.lastIndexOf("string2"), 2, 0.01);
        
        assertEquals(this.emptyListA.lastIndexOf("string1"), 1, 0.01);
        
        assertEquals(this.emptyListA.lastIndexOf("test"), -1, 0.01);
    }


    /**
     * test the toString method
     */
    public void testToString() {
        assertEquals(this.emptyListA.toString(), "{}");
        
        this.emptyListA.add("string");
        
        assertEquals(this.smallListA.toString(),
            "{apple, strawberry, pear}");
    }
    
    
    // ----------------------------------------------------------
    /**
     * test the sort method
     */
    public void testSort() {
        CompareByChannelName c = new CompareByChannelName();
        l1.sort(c);
        Object[] arr = l1.toArray();
        assertEquals("ArtAllDay", ((Influencer) arr[0]).getChannelName());
        assertEquals("australian_wildlife", 
            ((Influencer) arr[1]).getChannelName());
        assertEquals("JustBeatz", ((Influencer) arr[2]).getChannelName());
        assertEquals("wizardHighSchool", 
            ((Influencer) arr[3]).getChannelName());
        
        l2.sort(c);
        arr = l2.toArray();
        assertEquals("ArtAllDay", ((Influencer) arr[0]).getChannelName());
        assertEquals("australian_wildlife", 
            ((Influencer) arr[1]).getChannelName());
        assertEquals("JustBeatz", ((Influencer) arr[2]).getChannelName());
        assertEquals("wizardHighSchool", 
            ((Influencer) arr[3]).getChannelName());

    }

}
