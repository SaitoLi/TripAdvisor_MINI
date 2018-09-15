package lzz.com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lzz.com.dao.PagesDao;
import lzz.com.vo.Pages;
import lzz.com.vo.Person;

public class PagesService {
	
	private PagesDao pDao = new PagesDao();
	public Map<String, Object> pageQuery(int start){
		Map<String,Object> map = new HashMap<String,Object>();
		//��ѯ��ǰҳ�ļ�¼
		List<Pages> list = pDao.queryAllPages(start);
		//��ѯ�ܼ�¼
		int recordCount = pDao.getCount();
		
		map.put("list", list);
		map.put("count", recordCount);
		
		return map;
	}
	
}
