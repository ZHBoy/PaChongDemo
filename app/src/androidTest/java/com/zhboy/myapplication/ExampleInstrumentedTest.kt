package com.zhboy.myapplication

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.apache.commons.lang3.StringUtils
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.zhboy.myapplications", appContext.packageName)
    }

    //
    private var urlFilterBeans = arrayOf(
        //上海
        UrlFilterBean("http://shanghai.chinatax.gov.cn/zcfw/", "div.content", "content")
        //内蒙古
        , UrlFilterBean(
            "http://neimenggu.chinatax.gov.cn/zcwj/",
            "ul.content-slide",
            "content-slide"
        )
        //山西
        , UrlFilterBean(
            "http://shanxi.chinatax.gov.cn/zcwj",
            "div.swiper-slide",
            "swiper-slide"
        )
        //辽宁
        , UrlFilterBean(
            "http://liaoning.chinatax.gov.cn/col/col2000/index.html",
            "div.common-list-items",
            "common-list-items"
        )
        //吉林
        , UrlFilterBean(
            "http://jilin.chinatax.gov.cn/col/col6311/index.html",
            "div.common-list-items",
            "common-list-items"
        )
        //黑龙江
        , UrlFilterBean(
            "http://heilongjiang.chinatax.gov.cn/col/col7573/index.html",
            "div.list42",
            "list42"
        )

        //江苏
        , UrlFilterBean(
            "https://jiangsu.chinatax.gov.cn/col/col8198/index.html",
            "div.zxfb-text",
            "zxfb-text"
        )

        //浙江
        , UrlFilterBean(
            "http://zhejiang.chinatax.gov.cn/col/col13296/index.html",
            "div.common-list-items",
            "common-list-items"
        )

        //安徽
        , UrlFilterBean(
            "http://anhui.chinatax.gov.cn/col/col9415/index.html",
            "div.common-list-items",
            "common-list-items"
        )
        //江西
        , UrlFilterBean(
            "http://jiangxi.chinatax.gov.cn/col/col31014/index.html",
            "div.common-list-items",
            "common-list-items"
        )
        //山东
        , UrlFilterBean(
            "http://shandong.chinatax.gov.cn/col/col4/index.html",
            "div.thr2.col-sx-6",
            "thr2 col-sx-6"
        )
        //河南
        , UrlFilterBean(
            "https://henan.chinatax.gov.cn/henanchinatax/index/index.html",
            "ul.msgList.homeTopCon",
            "msgList homeTopCon"
        )

        //湖北
        , UrlFilterBean(
            "http://hubei.chinatax.gov.cn/hbsw/xwdt/index.html",
            "div.tab-box__list.news-box__list",
            "tab-box__list news-box__list"
        )

        //湖南
        , UrlFilterBean(
            "http://hunan.chinatax.gov.cn/",
            "div.news-box__list.index-nav-one__content.changeTextType",
            "news-box__list index-nav-one__content changeTextType"
        )
        //广东
        , UrlFilterBean(
            "http://guangdong.chinatax.gov.cn/gdsw/index.shtml",
            "ul.infoList.clearfix",
            "infoList clearfix"
        )

        //广西
        , UrlFilterBean(
            "http://guangxi.chinatax.gov.cn/",
            "ul.list01",
            "list01"
        )

        //海南
        , UrlFilterBean(
            "http://hainan.chinatax.gov.cn/",
            "div.lm3-r-x",
            "lm3-r-x"
        )

        //四川
        , UrlFilterBean(
            "https://sichuan.chinatax.gov.cn/index.html",
            "div.common-list-items",
            "common-list-items"
        )

        //云南
        , UrlFilterBean(
            "https://yunnan.chinatax.gov.cn/",
            "div.thr2-list",
            "thr2-list"
        )
        //西藏
        , UrlFilterBean(
            "https://xizang.chinatax.gov.cn/",
            "div.common-list-items",
            "common-list-items"
        )
        //陕西
        , UrlFilterBean(
            "http://shaanxi.chinatax.gov.cn/index.html",
            "div.zxfb-text",
            "zxfb-text"
        )
        //甘肃
        , UrlFilterBean(
            "http://gansu.chinatax.gov.cn/",
            "div.common-list-items",
            "common-list-items"
        )
        //青海
        , UrlFilterBean(
            "http://qinghai.chinatax.gov.cn/web/index.shtml",
            "ul.tab-pane active",
            "tab-pane active"
        )
        //宁夏
        , UrlFilterBean(
            "http://ningxia.chinatax.gov.cn/index.html",
            "div.common-list-items",
            "common-list-items"
        )
        //新疆
        , UrlFilterBean(
            "http://xinjiang.chinatax.gov.cn/sszc/",
            "div.bd1",
            "bd1"
        )
        //河北
        , UrlFilterBean(
            "http://hebei.chinatax.gov.cn/hbsw/",
            "div.list_lubo",
            "list_lubo"
        )
        //大连
        , UrlFilterBean(
            "http://dalian.chinatax.gov.cn/",
            "div.notice-list",
            "notice-list"
        )
        //宁波
        , UrlFilterBean(
            "http://ningbo.chinatax.gov.cn/",
            "div.list",
            "list"
        )
        //厦门
        , UrlFilterBean(
            "http://xiamen.chinatax.gov.cn/xmswcms/index.html",
            "ul.tab_list.clearfix",
            "tab_list clearfix"
        )
        //青岛
        , UrlFilterBean(
            "http://qingdao.chinatax.gov.cn/",
            "ul.pc_big_ul",
            "pc_big_ul"
        )
        //深圳
        , UrlFilterBean(
            "http://cshenzhen.chinatax.gov.cn/sztax/index.shtml",
            "ul.infoList.clearfix",
            "infoList clearfix"
        )


        //贵州 空指针
//        ,UrlFilterBean(
//            "http://guizhou.chinatax.gov.cn/",
//            "div.Work_dynamics",
//            "Work_dynamics"
//        )

        //重庆 使用的id
//        ,UrlFilterBean(
//            "http://chongqing.chinatax.gov.cn/cqtax/index.html",
//            "ul.zxfb",
//            "zxfb"
//        )

        //福建 i
//        , UrlFilterBean(
//            "http://fujian.chinatax.gov.cn/",
//            "div.arts_gg_title1",
//            "arts_gg_title1"
//        )

//        // 天津 td
//        ,UrlFilterBean("http://tianjin.chinatax.gov.cn/sjsy_zcwj.jsp", "div.zfcg0101", "zfcg0101")

        //北京 HTTP error fetching URL 412
//        ,UrlFilterBean(
//            "http://beijing.chinatax.gov.cn/bjswj/c104343/sszc.shtml",
//            "div.bsfw_left_content.column_list.column_list1",
//            "bsfw_left_content.column_list.column_list1"
//        )

    )


    @Test
    fun testStory1() {
        //爬取目标也链接
        var ruleString = ""

        urlFilterBeans.map {
            var document: Document? = null
            try {
                //请求目标页
                document = Jsoup.connect(it.url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31")
                    .timeout(30000)
                    .get()
                if (Objects.nonNull(document)) {
                    //获取数据div节点
                    val storyElements = document!!.select(it.divOut)

                    for (element in storyElements) {
                        val className = element.className()
                        if (it.divInt == className) {
                            //具体的数据内容列表
                            val liElements = element.select("li")

                            //添加5条
                            for (i in 0..5) {
                                //具体一条数据
                                val purl = liElements[i].select("a").first().attr("abs:href")
                                val text = liElements[i].text()
                                if (StringUtils.isNotBlank(text)) {
                                    ruleString += "<a href='$purl'>$text</a><p></p>"
                                }
                            }
                            break
                        }
                    }
                }
            } catch (e: Exception) {
            }

        }

        println(ruleString)

    }
}