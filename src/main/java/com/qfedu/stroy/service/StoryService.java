package com.qfedu.stroy.service;
//                       .::::.

import java.io.IOException;

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

import org.springframework.web.multipart.MultipartFile;

import com.qfedu.pojo.ResponseVo;
import com.qfedu.pojo.Story;

public interface StoryService {

	public boolean newStroy(String content, MultipartFile[] multipartFiles, String userid) throws IllegalStateException, IOException;

	public ResponseVo<Story> findStorys(Integer pageNum,Integer pageSize);
	public boolean newStroy(String content, String[] srcs, String userid) throws IllegalStateException, IOException;

}
