package AB5;

import AB5.Interfaces.Dinosaur;

public class Application {
    public static void main(String[] args) {

        Dinosaur dino;

        // check dino DNA
        System.out.println(new DinosaurDNA(5));
        System.out.println();

        // add some dinosaurs to the hashmap
        System.out.println("Storing some dinosaurs in the hashmap...");
        DinosaurHashMap map = new DinosaurHashMap(4, 4);
        for (int i = 0; i < 10; i++) {
            dino = map.put(new TyrannosaurusRex(new DinosaurDNA(i), "TRex_" + i));
            System.out.println((dino != null) ? "Error: store should return null for new nodes" : "dino TRex_" + i + " was stored.");
            dino = map.put(new Edmontosaurus(new DinosaurDNA(i + 16), "Edmont_" + i));
            System.out.println((dino != null) ? "Error: store should return null for new nodes" : "dino Edmont_" + i + " was stored.");
        }
        System.out.println();

        // check the size of the hashmap
        System.out.println("Checking hashmap size...");
        System.out.println("Size: " + map.size());
        System.out.println();

        // find dinosaurs in the hashmap
        System.out.println("Finding some dinosaurs in the hashmap...");
        dino = map.get(new DinosaurDNA(1));
        System.out.println((dino != null) ? dino + " was found." : "Error: find returned null");
        dino = map.get(new DinosaurDNA(3));
        System.out.println((dino != null) ? dino + " was found." : "Error: find returned null");
        dino = map.get(new DinosaurDNA(33));
        System.out.println((dino != null) ? dino + "Error: an unknown dino was found." : "OK: find for unknown dino returned null");
        System.out.println();

        // now remove dinosaurs from the hashmap
        System.out.println("Removing some dinosaurs from the hashmap...");
        dino = map.remove(new DinosaurDNA(1));
        System.out.println((dino != null) ? "removed dino, length=" + map.size() : "Error: removed dino should not be null after removing a dinosaur.");
        dino = map.remove(new DinosaurDNA(3));
        System.out.println((dino != null) ? "removed dino, length=" + map.size() : "Error: removed dino should not be null after removing a dinosaur.");
        dino = map.remove(new DinosaurDNA(666));
        System.out.println((dino == null) ? "OK: unknown dino can not be removed, length=" + map.size() : "Error: dino should be unknown...");
        System.out.println();

        // test the hashmap iterator
        System.out.println("Test hashmap iterator...");
        System.out.println("Order of dinos may vary here, as this iterator's order is implementation specific.");
        DinosaurHashMapIterator mapIterator = map.iterator();
        while (mapIterator.hasNext()) {
            System.out.println(mapIterator.next());
        }
        System.out.println();

        // now clear the hashmap
        System.out.println("Clearing the hashmap...");
        map.clear();
        System.out.println("Size: " + map.size());
        System.out.println();

        // test find and remove on an empty map
        System.out.println("Test find and remove on empty map...");
        dino = map.get(new DinosaurDNA(33));
        System.out.println((dino != null) ? dino + "Error: a dino was found in an empty map!" : "OK: find in empty map returned null");
        dino = map.remove(new DinosaurDNA(1));
        System.out.println((dino == null) ? "OK: remove dino from empty map returned null, length=" + map.size() : "Error: remove from empty map returned a dino!");
        System.out.println();

        // test the hashmap iterator on an empty map
        System.out.println("Test hashmap iterator... (should not produce any output)");
        mapIterator = map.iterator();
        while (mapIterator.hasNext()) {
            System.out.println(mapIterator.next());
        }
        System.out.println();

        // TODO: implementation of any developer specific tests (optional)
        testIteratorOverflow();
    }

    public static void testIteratorOverflow() {
        System.out.println("* test iterator overflow");

        System.out.print("|- next on an empty list should return null ");
        DinosaurBucketList list = new DinosaurBucketList();
        DinosaurListIterator listIterator = list.iterator();
        if (listIterator.next() == null && listIterator.next() == null) {
            System.out.println("[PASS]");
        } else {
            System.out.println("[FAIL]");
            System.err.println("Got non null value after iterating over an empty list");
            return;
        }

        System.out.print("|- next on a list with 1 element should return null after one next call ");
        list.store(new Edmontosaurus(new DinosaurDNA(1), "Melsa"));
        listIterator = list.iterator();
        if (listIterator.next() != null && listIterator.next() == null && listIterator.next() == null) {
            System.out.println("[PASS]");
        } else {
            System.out.println("[FAIL]");
            System.err.println("Got non null value after iterating over an empty list");
            return;
        }

        System.out.print("|- next on an empty hashmap should return null ");
        DinosaurHashMap hashMap = new DinosaurHashMap();
        DinosaurHashMapIterator mapIterator = hashMap.iterator();
        if (mapIterator.next() == null && mapIterator.next() == null) {
            System.out.println("[PASS]");
        } else {
            System.out.println("[FAIL]");
            System.err.println("Got non null value after iterating over an empty list");
            return;
        }

        System.out.print("|- next on a hashmap with 1 element should return null after one next call ");
        hashMap.put(new Edmontosaurus(new DinosaurDNA(1), "Melsa"));
        mapIterator = hashMap.iterator();
        if (mapIterator.next() != null && mapIterator.next() == null && mapIterator.next() == null) {
            System.out.println("[PASS]");
        } else {
            System.out.println("[FAIL]");
            System.err.println("Got non null value after iterating over an empty list");
            return;
        }

        System.out.printf("\\%s%n", "-".repeat(10));
    }

}
