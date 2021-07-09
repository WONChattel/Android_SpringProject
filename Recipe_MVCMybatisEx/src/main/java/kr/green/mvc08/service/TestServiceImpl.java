package kr.green.mvc08.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.green.mvc08.dao.TestDao;

@Service("testService")
@Transactional
public class TestServiceImpl implements TestService {

	@Autowired
	TestDao testDao;

	@Override
	public String selectToday() {
		return testDao.selectToday();
	}

	@Override
	public int selectSum(int n1, int n2) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("num1", n1);
		map.put("num2", n2);
		return testDao.selectSum(map);
	}

	@Override
	public int selectMul(int n1, int n2, int n3) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("num1",n1);
		map.put("num2",n2);
		map.put("num3",n3);
		return testDao.selectMul(map);
	}

}
