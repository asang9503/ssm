package com.qfedu.stroy.service.impl;
//                       .::::.

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qfedu.mapper.StoryUserMapper;
import com.qfedu.pojo.ResponseVo;
import com.qfedu.pojo.StoryUser;
import com.qfedu.stroy.service.StoryUserService;

@Service
@Transactional
public class StoryUserServiceImpl implements StoryUserService {

	// 前后端联调
	// 需要确定前后的责任，即使前端缺少参数的传递也不能出现空指针的问题，所以要求对参数要进行校验

	// crm 客户关系管理 oa 自动化办公(请假，审批，日报) cms 内容管理系统(对网站的内容进行管理)

	@Autowired
	private StoryUserMapper mapper;

	public ResponseVo<StoryUser> updateUser(StoryUser suser) {
		int i = mapper.updateByPrimaryKeySelective(suser);

		return i == 0 ? ResponseVo.ERROR() : ResponseVo.OK();
	}

}
