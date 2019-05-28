package com.qfedu.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.qfedu.pojo.Classes;
import com.qfedu.pojo.User;
import com.qfedu.service.TeacherService;

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
@Controller
public class UserController {

	@Autowired
	private TeacherService tService;

	@RequestMapping("/login")
	public String login(User user, HttpSession session) {
		// 获取前端数据

		// 执行登录逻辑
		User userR = tService.login(user);

		// 获取业务返回数据，进行响应

		if (userR == null) {
			// 登录失败

			return "redirect:logins.html";
		} else {

			// 登录成功

			session.setAttribute("user", userR);
			if (userR.getIsteacher() == 1) {
				// 老师
				return "redirect:tindex";
			} else {
				// 学生
				return "redirect:sindex.html";
			}

		}

	}

	@RequestMapping("/teacherIndex")
	public String tIndex(Map<String, Object> map, @RequestParam(name = "pageNum", required = false) String pageNum,
			@RequestParam(name = "pageSize", required = false) String pageSize) {

		PageInfo<Classes> data = tService.getAllClasses(pageNum, pageSize);

		System.out.println(data);
		map.put("datas", data);
		return "tIndex";
	}

	// 如果想要使用pojo的方式进行表单的后台校验，必须是pojo的方式
	// 如果想要对pojo中的数据进行校验，直接使用@Valid修饰即可
	// 校验结果通过入参处最后一个参数，类型是BindingResult获取
	@RequestMapping("/addClasses")
	public void addClasses(HttpServletResponse resp, @Valid Classes cls, BindingResult result) throws IOException {

		Map<String, Object> map = new HashMap<>();
		// 校验失败
		if (result.hasErrors()) {

			resp.getWriter().print("error");
		} else {
			// 校验成功
			resp.getWriter().print("success");
		}

	}

}
