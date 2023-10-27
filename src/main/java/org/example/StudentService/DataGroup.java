package org.example.StudentService;

import org.example.Criterion.GroupCriterion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataGroup<T> {

    private final List<T> data;
    private final GroupCriterion<T> groupCriterion;

    public DataGroup(List<T> data, GroupCriterion<T> groupCriterion) {
        this.data = data;
        this.groupCriterion = groupCriterion;
    }

    public Map<String, List<T>> group() {
        Map<String, List<T>> groups = new HashMap<>();
        for (T item : data) {
            String group = groupCriterion.apply(item);
            groups.computeIfAbsent(group, k -> new ArrayList<>()).add(item);
        }
        return groups;
    }
}
