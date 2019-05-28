package com.qfedu.service.impl;
//                       .::::.

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//                     .::::::::.
//                    :::::::::::
//                 ..:::::::::::'
//              '::::::::::::'
//                .::::::::::
//           '::::::::::::::..
//                ..::::::::::::.
//              ``::::::::::::::::
//               ::::``:::::::::'        .:::.
//              ::::'   ':::::'       .::::::::.
//            .::::'      ::::     .:::::::'::::.
//           .:::'       :::::  .:::::::::' ':::::.
//          .::'        :::::.:::::::::'      ':::::.
//         .::'         ::::::::::::::'         ``::::.
//     ...:::           ::::::::::::'              ``::.
//    ```` ':.          ':::::::::'                  ::::..
//                       '.:::::'                    ':'````..
//
//

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qfedu.mapper.ClassesMapper;
import com.qfedu.mapper.UserMapper;
import com.qfedu.pojo.Classes;
import com.qfedu.pojo.User;
import com.qfedu.service.TeacherService;

@Service
@Transactional // 表示当前类中的所有方法在执行中都会进行事务的开始和提交。
//也可以单独出现在方法之上
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private UserMapper mapper;

	@Autowired
	private ClassesMapper cMapper;

	
	/**
	 * 
	 */
	public User login(User user) {
		// 调用dao代码，dao的功能都在mapper中，所以我们需要接受容器的注入

		return mapper.selectByNameAndPass(user);
	}

	public PageInfo<Classes> getAllClasses(String pageNum, String pageSize) {

		int pageNumInt = 1;
		int pageSizeInt = 5;
		if (pageNum != null && pageNum.length() > 0) {
			pageNumInt = Integer.valueOf(pageNum);
		}
		if (pageSize != null && pageSize.length() > 0) {
			pageSizeInt = Integer.valueOf(pageSize);
		}

		// 在service层开始分页查询
		PageHelper.startPage(pageNumInt, pageSizeInt);
		List<Classes> datas = cMapper.select();

		PageInfo<Classes> pageInfo = new PageInfo<Classes>(datas);

		return pageInfo;
	}

}
