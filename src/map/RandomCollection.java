package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by jinglongyang on 3/11/15.
 */
public class RandomCollection<T> {
    private Map<T, Integer> valueMap;
    private Map<Integer, T> indexMap;
    private Random random;

    public RandomCollection() {
        valueMap = new HashMap<>();
        indexMap = new HashMap<>();
        random = new Random();
    }

    public static void main(String[] args) {
        RandomCollection<Integer> map = new RandomCollection<>();
        map.add(1);
        map.add(2);
        map.removeRandom();
        map.remove(2);
        System.out.println(map);
    }

    public void add(T t) {
        int size = indexMap.size();
        valueMap.put(t, size);
        indexMap.put(size, t);
    }

    public void remove(T t) {
        if (valueMap.isEmpty()) {
            return;
        }
        int size = valueMap.size();
        Integer index = valueMap.remove(t);
        if (index == null) {
            return;
        }
        remove(index, size);
    }

    public void removeRandom() {
        if (valueMap.isEmpty()) {
            return;
        }
        int size = valueMap.size();
        int index = random.nextInt(size);
        valueMap.remove(indexMap.get(index));
        remove(index, size);
    }

    private void remove(int index, int size) {
        T t2 = indexMap.remove(size - 1);
        if (size != index + 1) {
            indexMap.put(index, t2);
            valueMap.put(t2, index);
        }
    }

    @Override
    public String toString() {
        return valueMap.toString();
    }
}
