package com.qfedu.test;
//                       .::::.

import static org.junit.Assert.assertEquals;

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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.qfedu.pojo.User;
import com.qfedu.service.TeacherService;
import com.qfedu.service.impl.TeacherServiceImpl;

//创建一个测试的基本类，在基本类中进行spring注解配置，其他的单元测试类只需要继承即可
public class TeacherServiceTest extends BaseJunitTest {

	// spring和juni整个之后最大功能就是能够接受自动注入
	@Autowired
	private TeacherService service;

	@Test
	@Transactional // 标明此方法需使用事务

	@Rollback(true) // 表示支持回滚，测试操作数据库之后会自动进行回滚
	public void testLogin() {

		/*
		 * ApplicationContext app = new
		 * ClassPathXmlApplicationContext("spring.xml");
		 * 
		 * TeacherService service = app.getBean(TeacherServiceImpl.class);
		 * 
		 * User user = new User(); user.setUsername("root");
		 * user.setPassword("123");
		 * 
		 * User userR = service.login(user);
		 * 
		 * assertEquals(1, userR.getIsteacher().intValue());
		 */

		User user = new User();
		user.setUsername("root");
		user.setPassword("123");

		User userR = service.login(user);
		assertEquals(1, userR.getIsteacher().intValue());
	}
}
