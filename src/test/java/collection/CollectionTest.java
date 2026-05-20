package collection;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectionTest {

    @Test
    void myStack() {
        MyStack.push(1);
        MyStack.push(2);
        MyStack.push(3);
        assertEquals(3, MyStack.top());
        assertEquals(3, MyStack.pop());
        assertEquals(2, MyStack.top());
        assertFalse(MyStack.empty());
        MyStack.pop();
        MyStack.pop();
        assertTrue(MyStack.empty());
    }

    @Test
    void myQueue() {
        MyQueue.push(1);
        MyQueue.push(2);
        assertEquals(1, MyQueue.peek());
        assertEquals(1, MyQueue.pop());
        assertFalse(MyQueue.empty());
        MyQueue.pop();
        assertTrue(MyQueue.empty());
    }

    @Test
    void kthLargest() {
        KthLargest obj = new KthLargest(3, new int[]{4, 5, 8, 2});
        assertEquals(4, obj.add(3));
        assertEquals(5, obj.add(5));
        assertEquals(5, obj.add(10));
        assertEquals(8, obj.add(9));
    }

    @Test
    void myTrie() {
        MyTrie trie = new MyTrie();
        trie.insert("apple");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
        assertTrue(trie.startsWith("app"));
    }

    @Test
    void myLRUCache() {
        MyLRUCache cache = new MyLRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));
        cache.put(3, 3);
        assertEquals(-1, cache.get(2));
        cache.put(4, 4);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }

    @Test
    void myTimeMap() {
        MyTimeMap timeMap = new MyTimeMap();
        timeMap.set("foo", "bar", 1);
        assertEquals("bar", timeMap.get("foo", 1));
        assertEquals("bar", timeMap.get("foo", 3));
        timeMap.set("foo", "bar2", 4);
        assertEquals("bar2", timeMap.get("foo", 4));
        assertEquals("bar2", timeMap.get("foo", 5));
    }

    @Test
    void wordDictionary() {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        assertFalse(wd.search("pad"));
        assertTrue(wd.search("bad"));
        assertTrue(wd.search(".ad"));
    }

    @Test
    void detectSquares() {
        DetectSquares ds = new DetectSquares();
        ds.add(new int[]{3, 10});
        ds.add(new int[]{11, 2});
        ds.add(new int[]{3, 2});
        assertEquals(1, ds.count(new int[]{11, 10}));
        assertEquals(0, ds.count(new int[]{14, 8}));
        ds.add(new int[]{11, 2});
        assertEquals(2, ds.count(new int[]{11, 10}));
    }

    @Test
    void myArray() {
        MyArray<Integer> arr = new MyArray<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        assertEquals(4, arr.size());
        assertEquals(2, arr.get(1));
        arr.remove(2);
        assertEquals(3, arr.size());
        assertEquals(3, arr.get(1));
        arr.removeAt(0);
        assertEquals(2, arr.size());
    }

    @Test
    void myHashSet() {
        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(2);
        assertTrue(set.contains(1));
        assertFalse(set.contains(3));
        set.add(2);
        assertTrue(set.contains(2));
        set.remove(2);
        assertFalse(set.contains(2));
    }

    @Test
    void myHashMap() {
        MyHashMap map = new MyHashMap();
        map.put(1, 1);
        map.put(2, 2);
        assertEquals(1, map.get(1));
        assertEquals(-1, map.get(3));
        map.put(2, 1);
        assertEquals(1, map.get(2));
        map.remove(2);
        assertEquals(-1, map.get(2));
    }

    @Test
    void mySinglyLinkedList() {
        MySinglyLinkedList.Node<Integer> head = new MySinglyLinkedList.Node<>(1);
        MySinglyLinkedList<Integer> list = new MySinglyLinkedList<>(head, 1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(4, list.size());
        assertEquals(1, list.removeFirst());
        assertEquals(3, list.size());
        assertEquals(4, list.remove());
        assertEquals(2, list.size());
    }

    @Test
    void myDoublyLinkedListLeetcode() {
        MyDoublyLinkedListLeetcode dll = new MyDoublyLinkedListLeetcode();
        dll.addAtHead(1);
        dll.addAtTail(3);
        dll.addAtIndex(1, 2);
        assertEquals(2, dll.get(1));
        dll.deleteAtIndex(1);
        assertEquals(3, dll.get(1));
    }

    @Test
    void customRandomizedCollection() {
        CustomRandomizedCollection col = new CustomRandomizedCollection();
        assertTrue(col.insert(1));
        assertFalse(col.insert(1));
        assertTrue(col.insert(2));
        assertTrue(col.remove(1));
        assertNotNull(col.getRandom());
    }

    @Test
    void customRandomSet() {
        CustomRandomSet set = new CustomRandomSet();
        set.insert(1);
        set.insert(2);
        set.insert(3);
        set.remove(2);
        int random = set.getRandom();
        assertTrue(random == 1 || random == 3);
    }

    @Test
    void myTwitter() {
        MyTwitter twitter = new MyTwitter();
        twitter.postTweet(1, 5);
        List<Integer> feed = twitter.getNewsFeed(1);
        assertEquals(List.of(5), feed);
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        feed = twitter.getNewsFeed(1);
        assertEquals(6, feed.get(0));
        twitter.unfollow(1, 2);
        feed = twitter.getNewsFeed(1);
        assertEquals(List.of(5), feed);
    }

    @Test
    void myAVLTree() {
        MyAVLTree tree = new MyAVLTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        assertNotNull(tree.root);
        assertEquals(2, tree.root.value);
    }

    @Test
    void myRedBlackTree() {
        MyRedBlackTree tree = new MyRedBlackTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        assertNotNull(tree.root);
    }
}
