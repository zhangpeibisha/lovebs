package org.nix.zpbs.trie;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTreeTest {

    TrieTree tree;
    String[] strs;
    @Before
    public void insert() {
        tree = new TrieTree();
        strs = new String[]{ "banana", "band", "bee", "absolute", "ac", "acm" ,"ac","a","a"};
        for (String str : strs) {
            tree.insert(str);
        }
    }

    @Test
    public void haveCount(){
        int i = 0;
        int[] ex = {1,1,1,1,2,1,2,2,2};
        for (String str : strs) {
            System.out.println(str+ " have " + tree.hasStrCount(str));
            assertEquals(ex[i],tree.hasStrCount(str));
            i++;
        }
    }

    @Test
    public void hasStr() {
        boolean banana = tree.hasStr("banana");
        assertTrue(banana);
        boolean banan = tree.hasStr("banan");
        assertFalse(banan);
    }

    @Test
    public void hasStrCount() {
        long banana = tree.hasStrCount("banana");
        assertEquals(1,banana);
        long banan = tree.hasStrCount("banan");
        assertEquals(0,banan);
        long a = tree.hasStrCount("a");
        assertEquals(2,a);
    }

    @Test
    public void countPrefix() {
        int a = tree.countPrefix("a");
        assertEquals(6,a);
    }

    @Test
    public void preWalk() {
        tree.preWalk(tree.getRoot());
    }

    @Test
    public void getRoot() {
    }
}