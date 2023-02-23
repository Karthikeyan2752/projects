package com.leetcodes2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {

	public static int leastBricks(List<List<Integer>> wall) {
		Map<Integer, Integer> map = new HashMap<>();
		for (List<Integer> list : wall) {
			int total = 0;
			for (int i : list) {
				total += i;
				if (map.containsKey(total)) {
					map.put(total, map.get(total) + 1);
				} else {
					map.put(total, 1);
				}
			}
		}
		int max = 0;
		for (int v : map.values()) {
			max = Math.max(v, max);
		}
		return wall.size() - max;
	}
	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<>();
		list.add(List.of(1, 2, 2, 1));
		list.add(List.of(3, 1, 2));
		list.add(List.of(1, 3, 2));
		list.add(List.of(2, 4));
		list.add(List.of(3, 1, 2));
		list.add(List.of(1, 3, 1, 1));
		System.out.println(leastBricks(list));
	}

}
