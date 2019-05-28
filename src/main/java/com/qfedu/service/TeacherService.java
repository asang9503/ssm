package com.qfedu.service;
//                       .::::.

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.qfedu.pojo.Classes;

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

import com.qfedu.pojo.User;

public interface TeacherService {

	// 教师的登录
	// 返回类型是用户的完整信息，参数是一个只有用户名密码有值的对象
	User login(User user);
	//查询所有的课程并且是分页查询，所以需要传入页码和每个页数
	 PageInfo<Classes> getAllClasses(String pageNum, String pageSize);

}
