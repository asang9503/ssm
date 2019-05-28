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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qfedu.mapper.StoryImgMapper;
import com.qfedu.mapper.StoryMapper;
import com.qfedu.pojo.ResponseVo;
import com.qfedu.pojo.Story;
import com.qfedu.pojo.StoryImg;
import com.qfedu.stroy.service.StoryService;

@Service
@Transactional
public class StoryServiceImpl implements StoryService {

	@Autowired
	private StoryMapper storyMapper;
	@Autowired
	private StoryImgMapper storyImgMapper;

	public boolean newStroy(String content, MultipartFile[] multipartFiles, String userid)
			throws IllegalStateException, IOException {

		// 保存content到story表

		Story story = new Story();
		story.setUserid(Integer.parseInt(userid));
		story.setContent(content);
		storyMapper.insert(story);

		// 图片保存,并且获取每张图片的名字
		List<StoryImg> storyImgs = new ArrayList<StoryImg>();

		for (int i = 0; i < multipartFiles.length; i++) {

			String imgName = System.currentTimeMillis() + Math.random() * 100 + multipartFiles[i].getOriginalFilename();
			File file = new File("Z:\\windos\\xiaomi\\" + imgName);

			multipartFiles[i].transferTo(file);
			StoryImg si = new StoryImg();
			si.setImgurl(imgName);
			si.setStoryid(story.getId());
			storyImgs.add(si);
		}

		// int i =1/0;
		// 插入配图表

		storyImgMapper.inserts(storyImgs);

		return true;
	}

	public ResponseVo<Story> findStorys(Integer pageNum,Integer pageSize) {

		
		PageHelper.startPage(pageNum, pageSize);
		
	List<Story> list=	storyMapper.selectStoryOrder();
		
	PageInfo<Story> page =	new PageInfo<Story>(list);
	ResponseVo<Story> vo = ResponseVo.OK();
		vo.setData(page.getList());
		//如果有配置一对多，会将数据封装到对象的list属性中，使最终返回的数据的条目数减少，造成分页的结果中的总数与前端显示的条目数不匹配
		vo.setCount(page.getList().size());

		return vo;
	}

	public boolean newStroy(String content, String[] srcs, String userid) throws IllegalStateException, IOException {
		Story story = new Story();
		story.setUserid(Integer.parseInt(userid));
		story.setContent(content);
		storyMapper.insert(story);
		
		List<StoryImg> storyImgs = new ArrayList<StoryImg>();
		
		
		for(String src:srcs){
			StoryImg si=	new StoryImg();
			si.setImgurl(src);
			si.setStoryid(story.getId());
			storyImgs.add(si);
		}
		storyImgMapper.inserts(storyImgs);
		return false;
	}

}
