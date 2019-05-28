package com.qfedu.test;
//                       .::::.

import javax.mail.MessagingException;

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

import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailTest extends BaseJunitTest {

	@Autowired
	// 自动注入spring提供实现类，已经在spring_mail中进行了配置
	private JavaMailSender sender;

	@Test
	public void testsend() throws MessagingException {
		int i = 0;
		while(i <10) {
			
			MimeMessage msg = sender.createMimeMessage();
			// 第一个参数就是需要进行扩展的MimeMessage对象
			// 第二个参数是是否开启附件
			// 第三个是编码
			MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");
			
			helper.setTo("707358433@qq.com");
			helper.setFrom("805720458@qq.com");
			helper.setSubject("发送了一封邮件");
			helper.setText("狗儿子");
			
			sender.send(msg);
			++i;
		}
		
		

	}

}
