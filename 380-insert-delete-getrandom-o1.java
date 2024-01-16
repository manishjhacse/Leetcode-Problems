class RandomizedSet {
    private List<Integer> list;
    private Map<Integer, Integer> map;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);
        list.set(index, lastElement);
        map.put(lastElement, index);
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        int randomIdx = (int) (Math.random() * list.size());
        return list.get(randomIdx);
    }
}
