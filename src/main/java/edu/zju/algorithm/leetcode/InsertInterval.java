package edu.zju.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> newList = new ArrayList<>();
        if (intervals.size() == 0) {
            newList.add(newInterval);
            return newList;
        }
        int start = newInterval.start;
        int end  = newInterval.end;
        boolean handled = false;
        Interval temp = newInterval;
        if (end < intervals.get(0).start) {
            newList.add(temp);
            handled = true;
        }
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (handled) {
                newList.add(interval);
                continue;
            }
            if (interval.end < temp.start) {
                newList.add(interval);
                continue;
            }
            if (temp.end < interval.start) {
                newList.add(temp);
                newList.add(interval);
                handled = true;
                continue;
            }
            temp.start = interval.start < temp.start ? interval.start : temp.start;
            temp.end = interval.end > temp.end ? interval.end : temp.end;
        }
        if (!handled)
            newList.add(temp);
        return newList;
    }

    private static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}

