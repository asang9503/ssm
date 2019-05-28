package com.qfedu.stroy.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qfedu.pojo.ResponseVo;
import com.qfedu.pojo.Story;
import com.qfedu.stroy.service.StoryService;

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
@RequestMapping("/api/v1/")
public class StoryContoller {

	@Autowired
	private StoryService service;

	@RequestMapping(path = "/stroy", method = RequestMethod.POST)

	public @ResponseBody ResponseVo<Story> uploadStory(String content,
			@RequestParam("imgs") MultipartFile[] multipartFile, String userid)
					throws IllegalStateException, IOException {

		service.newStroy(content, multipartFile, "1");

		ResponseVo<Story> vo = new ResponseVo<Story>();
		return vo;

	}

	@RequestMapping(path = "/story", method = RequestMethod.GET)
	public @ResponseBody ResponseVo<Story> selectStorys(Integer pageNum, Integer pageSize, HttpServletResponse resp)
			throws IllegalStateException, IOException {

		// 所有其他站点都可以通过ajax跨域访问
		resp.addHeader("Access-Control-Allow-Origin", "*");
		return service.findStorys(pageNum, pageSize);

	}

	@RequestMapping(path = "/uploadfile", method = RequestMethod.POST)

	public @ResponseBody ResponseVo uploadFile(HttpServletResponse resp,
			@RequestParam("file") MultipartFile multipartFile) throws IllegalStateException, IOException {

		// response对头部的设置有两个方法，一个add还有一个set

		resp.addHeader("Access-Control-Allow-Origin", "*");
		// 解决ie浏览器下的Bug
		resp.setContentType("text/html");
		String fileName = UUID.randomUUID().toString() + multipartFile.getOriginalFilename();
		File file = new File("Z:\\windos\\xiaomi\\" + fileName);

		multipartFile.transferTo(file);
		ResponseVo vo = ResponseVo.OK();
		vo.setSrc(fileName);
		// 将文件的名字或者文件的路径在返回给前端，前端获取到之后保存到隐藏表单域中，和其他的文本第二次提交的时候一起保存到数据库
		return vo;

	}

	@RequestMapping(path = "/stroylayui", method = RequestMethod.POST)

	public @ResponseBody ResponseVo<Story> uploadStory(HttpServletResponse resp,String content, String[] filename)
			throws IllegalStateException, IOException {
		resp.addHeader("Access-Control-Allow-Origin", "*");

		service.newStroy(content, filename, "1");

		ResponseVo<Story> vo = new ResponseVo<Story>();
		return vo;

	}

}
