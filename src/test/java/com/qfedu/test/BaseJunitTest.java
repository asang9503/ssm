package com.qfedu.test;
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

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//单元测试的优点1在不重启服务器的前提下测试代码2批量测试3生成报告4查看每个方法的运行时间
//单元测试与spring进行整合,整合的目的，目前我们在普通的单元测试中需要手动的初始化ico容器，在从容器中获取bean
//整合之后，我们可以直接将bean对象自动装配到test类中

//表示以junit4环境进行运行
@RunWith(SpringJUnit4ClassRunner.class)
//指定spring的xml文件，在一单元测试进行运行的时候会自动根据指定的配置文件初始化ico容器
@ContextConfiguration({ "/spring_*.xml" })
public class BaseJunitTest {

}
