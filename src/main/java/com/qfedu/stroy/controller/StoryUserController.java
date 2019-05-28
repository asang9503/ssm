package com.qfedu.stroy.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qfedu.pojo.ResponseVo;
import com.qfedu.pojo.Story;
import com.qfedu.pojo.StoryUser;

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
@RequestMapping("/api/v1")
public class StoryUserController {

	@RequestMapping(path = "/findStorys", method = RequestMethod.PATCH)
	public @ResponseBody ResponseVo<Story> updateStory(StoryUser suser) throws IllegalStateException, IOException {

		
		
		
		
		return null;

	}

}
