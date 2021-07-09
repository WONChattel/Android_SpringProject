package kr.green.mvc08.dao;

import java.util.HashMap;

public interface TestDao {
	String selectToday();
	int selectSum(HashMap<String , Integer> map);
	int selectMul(HashMap<String , Integer> map);
}
