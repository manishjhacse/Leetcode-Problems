import java.util.ArrayList;
import java.util.TreeMap;

class MyCalendarTwo {
    List<int[]> bookings;
    TreeMap<Integer, Integer> overLappedMap;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overLappedMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prevStart = overLappedMap.lowerKey(end);
        if (prevStart != null && start <= overLappedMap.get(prevStart)-1) {
            return false;
        }
        for (int booking[] : bookings) {
            int commonStart = Math.max(booking[0], start);
            int commonEnd = Math.min(booking[1], end);
            if (commonStart < commonEnd) {
                overLappedMap.put(commonStart, commonEnd);
            }
        }
        bookings.add(new int[] { start, end });
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */