package com.zhboy.myapplication;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author: zhou_hao
 * @date: 2021/2/24
 * @description:
 **/
public class PaChong {

    public static void testStory1() {
        //爬取目标也链接
        String url = "http://www.17989.com/duanzi/1.htm";
        Set<String> storySet = new HashSet<>(10000);
        while (StringUtils.isNotBlank(url)) {
            Document document = null;
            try {
                //请求目标页
                document = Jsoup.connect(url)
                        .userAgent("for huan huan")
                        .timeout(30000)
                        .get();
            } catch (Exception e) {
                System.out.println("println111111111"+e.getMessage());
            }
            if (Objects.nonNull(document)) {
                //获取数据div节点
                Elements storyElements = document.select("div.module");
                for (Element element : storyElements) {
                    String className = element.className();
                    if ("module articlelist".equals(className)) {
                        //具体的数据内容列表
                        Elements liElements = element.select("li");
                        for (Element storyEle : liElements) {
                            //具体一条数据
                            String text = storyEle.text();
                            System.out.println("println222222: "+text);
                            if (StringUtils.isNotBlank(text)) {
                                storySet.add(text);
                            }
                        }

                    }
                }
            }

//            //下一页 递归层数太深 引发栈溢出 改为循环
//            Elements nextPageElements = document.select("div.page a");
//
//            Elements nextPageEle = nextPageElements.select("a.next");
//            //下一页的请求链接
//            url = CollectionUtils.isEmpty(nextPageEle) ? "" : nextPageEle.first().attr("abs:href");
//
//            LOGGER.info("info3 nexPageUrl:{}", url);
        }

        System.out.println("println444444: "+storySet.size());

        //包装数据并将处理完的数据保存到库里
//        List<GifAndStoryTask> gifAndStoryTaskList = new ArrayList<>(storySet.size());
//        for (String story : storySet) {
//            GifAndStoryTask gifAndStoryTask = new GifAndStoryTask();
//            gifAndStoryTask.setContentDesc(story);
//            gifAndStoryTask.setTitle("");
//            Date now = new Date();
//            gifAndStoryTask.setCreateTime(now);
//            gifAndStoryTask.setUpdateTime(now);
//            gifAndStoryTask.setContentType(GifAndStoryContentTypeEnum.FUNNY_STORY.getContentType());
//
//            gifAndStoryTaskList.add(gifAndStoryTask);
//
//        }
//        System.out.println("println444444: "+storySet.size());
//        LOGGER.info("getStory1 size::{}", storySet.size());
//        gifAndStoryTaskService.saveBatch(gifAndStoryTaskList);
    }
}
