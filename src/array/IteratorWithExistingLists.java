package array;

import java.util.*;

/**
 * Given n sorted lists, implement a new iterator
 */
public class IteratorWithExistingLists {
    private static class MyIterator<E extends Comparable<E>> implements Iterator<E> {
        private List<List<E>> lists;
        private E next;
        private Map<Integer, Integer> locations;

        public MyIterator(List<List<E>> lists) {
            this.lists = lists;
            this.locations = new HashMap<>();
            if (lists != null && !lists.isEmpty()) {
                for (int i = 0; i < lists.size(); i++) {
                    locations.put(i, 0);
                }
                next = getMin();
            }
        }


        public E next() {
            if (next == null) {
                return null;
            } else {
                E current = next;
                next = getMin();
                return current;
            }
        }

        private E getMin() {
            E min = null;
            int minIndex = 0, minStart = 0;
            for (int i = 0; i < lists.size(); i++) {
                List<E> list = lists.get(i);
                int start = locations.get(i);
                if (list.size() > start && (min == null || min.compareTo(list.get(start)) > 0)) {
                    min = list.get(start);
                    minIndex = i;
                    minStart = start + 1;
                }
            }
            if (min != null)
                locations.put(minIndex, minStart);
            return min;
        }

        public boolean hasNext() {
            return next != null;
        }

        public void remove() {
            throw new RuntimeException("Not implemented");
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(0, 2, 5, 9, 15),
                Arrays.asList(-1, 3, 5, 7),
                Arrays.asList(-2, 0, 8, 20));

        MyIterator<Integer> it = new MyIterator<>(list);

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
