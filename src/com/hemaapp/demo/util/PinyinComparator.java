package com.hemaapp.demo.util;

import java.util.Comparator;

import com.hemaapp.demo.model.DistrictInfor;


/**
 * Æ´Òô±È½ÏÆ÷
 */
public class PinyinComparator implements Comparator<DistrictInfor> {

	public int compare(DistrictInfor o1, DistrictInfor o2) {
		if (o1.getCharindex().equals("@")
				|| o2.getCharindex().equals("#")) {
			return -1;
		} else if (o1.getCharindex().equals("#")
				|| o2.getCharindex().equals("@")) {
			return 1;
		} else {
			return o1.getCharindex().compareTo(o2.getCharindex());
		}
	}

}
