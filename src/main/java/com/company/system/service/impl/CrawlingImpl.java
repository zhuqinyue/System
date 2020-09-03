//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.service.impl;

import com.company.system.entity.Data;
import com.company.system.entity.JsonRootBean;
import com.company.system.entity.SysNews;
import com.company.system.exception.ServiceExcetion;
import com.company.system.service.CrawLing;
import com.company.system.service.NewsService;
import com.company.system.utlis.HttpClientHelper;
import com.company.system.utlis.JsoupParserUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrawlingImpl implements CrawLing {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    NewsService newsService;
    @Autowired
    HttpClientHelper httpClientHelper;

    public CrawlingImpl() {
    }

    public void qingGua() {
        try {
            new HashMap();
            String CountPage = this.httpClientHelper.get("https://www.cnwebe.com/sem", (HashMap)null, (HashMap)null);
            Document doc = Jsoup.parse(CountPage);
            Elements ul = JsoupParserUtil.getElementsByClassName(doc, "ajaxposts");
            Element el = (Element)ul.get(0);
            Elements post_main = JsoupParserUtil.getElementsByClassName(el, "post_main");
            System.out.println(post_main.size());
            Iterator var7 = post_main.iterator();

            while(var7.hasNext()) {
                Element li = (Element)var7.next();
                Elements imgeffect = JsoupParserUtil.getElementsByClassName(li, "imgeffect");
                String url = imgeffect.attr("href");
                System.out.println("rul==" + url);
                SysNews sysNews = null;
                sysNews = this.getBody(url);
                sysNews.setImgsrc(((Element)li.getElementsByClass("thumb").get(0)).attr("data-original"));
                this.newsService.addonenews(sysNews);
            }
        } catch (Exception var13) {
            var13.printStackTrace();
        }

    }

    private SysNews getBody(String url) throws Exception {
        SysNews sysNews = new SysNews();
        if(url != null && !url.equals("")) {
            String page = this.httpClientHelper.get(url, (HashMap)null, (HashMap)null);
            Thread.sleep(500L);
            Document parse = Jsoup.parse(page);
            Element style = parse.getElementById("main-inline-css");
            Elements post_header = parse.getElementsByClass("post_header");
            Iterator content_post = post_header.iterator();

            while(content_post.hasNext()) {
                Element el = (Element)content_post.next();
                Elements el1 = el.getElementsByTag("h1");
                sysNews.setNewstitle(el1.toString().replace("<h1>", "").replace("</h1>", ""));
            }

            Elements content_post1 = parse.getElementsByClass("content_post");
            Iterator el2 = content_post1.iterator();

            while(el2.hasNext()) {
                Element el3 = (Element)el2.next();
                Elements elementsByTag = el3.getElementsByTag("blockquote");
                Element element = (Element)elementsByTag.get(0);
                String html = element.html();
                sysNews.setSynopsis(html.replace("<p>", "").replace("</p>", ""));
                String style1 = style.toString().replace("<style id=\"main-inline-css\" type=\"text/css\">", "").replace("</style>", "");
                sysNews.setStyle(style1);
                sysNews.setNewstype("tw");
                sysNews.setTuijian("false");
                sysNews.setZhuangtai("未发布");
                sysNews.setClassify("01");
                sysNews.setStarttime(this.sdf.format(new Date()));
                sysNews.setEndtime("2030-01-01");
                Elements img = el3.getElementsByTag("img");
                Iterator var15 = img.iterator();

                while(var15.hasNext()) {
                    Element i = (Element)var15.next();
                    i.attr("src", i.attr("data-original"));
                }

                sysNews.setNewsbody(el3.html());
            }

            return sysNews;
        } else {
            throw new ServiceExcetion("请检查爬取地址是否正确");
        }
    }

    public void zhihu() {
        HashMap map = new HashMap();
        map.put("include", "data%5B%3F%28target.type%3Dtopic_sticky_module%29%5D.target.data%5B%3F%28target.type%3Danswer%29%5D.target.content%2Crelationship.is_authorized%2Cis_author%2Cvoting%2Cis_thanked%2Cis_nothelp%3Bdata%5B%3F%28target.type%3Dtopic_sticky_module%29%5D.target.data%5B%3F%28target.type%3Danswer%29%5D.target.is_normal%2Ccomment_count%2Cvoteup_count%2Ccontent%2Crelevant_info%2Cexcerpt.author.badge%5B%3F%28type%3Dbest_answerer%29%5D.topics%3Bdata%5B%3F%28target.type%3Dtopic_sticky_module%29%5D.target.data%5B%3F%28target.type%3Darticle%29%5D.target.content%2Cvoteup_count%2Ccomment_count%2Cvoting%2Cauthor.badge%5B%3F%28type%3Dbest_answerer%29%5D.topics%3Bdata%5B%3F%28target.type%3Dtopic_sticky_module%29%5D.target.data%5B%3F%28target.type%3Dpeople%29%5D.target.answer_count%2Carticles_count%2Cgender%2Cfollower_count%2Cis_followed%2Cis_following%2Cbadge%5B%3F%28type%3Dbest_answerer%29%5D.topics%3Bdata%5B%3F%28target.type%3Danswer%29%5D.target.annotation_detail%2Ccontent%2Chermes_label%2Cis_labeled%2Crelationship.is_authorized%2Cis_author%2Cvoting%2Cis_thanked%2Cis_nothelp%3Bdata%5B%3F%28target.type%3Danswer%29%5D.target.author.badge%5B%3F%28type%3Dbest_answerer%29%5D.topics%3Bdata%5B%3F%28target.type%3Darticle%29%5D.target.annotation_detail%2Ccontent%2Chermes_label%2Cis_labeled%2Cauthor.badge%5B%3F%28type%3Dbest_answerer%29%5D.topics%3Bdata%5B%3F%28target.type%3Dquestion%29%5D.target.annotation_detail%2Ccomment_count%3B");
        map.put("limit", "5");
        map.put("after_id", "5.00000");

        try {
            ArrayList e = new ArrayList();
            String s = this.forisend("https://www.zhihu.com/api/v4/topics/19564940/feeds/top_activity?include=data%5B%3F%28target.type%3Dtopic_sticky_module%29%5D.target.data%5B%3F%28target.type%3Danswer%29%5D.target.content%2Crelationship.is_authorized%2Cis_author%2Cvoting%2Cis_thanked%2Cis_nothelp%3Bdata%5B%3F%28target.type%3Dtopic_sticky_module%29%5D.target.data%5B%3F%28target.type%3Danswer%29%5D.target.is_normal%2Ccomment_count%2Cvoteup_count%2Ccontent%2Crelevant_info%2Cexcerpt.author.badge%5B%3F%28type%3Dbest_answerer%29%5D.topics%3Bdata%5B%3F%28target.type%3Dtopic_sticky_module%29%5D.target.data%5B%3F%28target.type%3Darticle%29%5D.target.content%2Cvoteup_count%2Ccomment_count%2Cvoting%2Cauthor.badge%5B%3F%28type%3Dbest_answerer%29%5D.topics%3Bdata%5B%3F%28target.type%3Dtopic_sticky_module%29%5D.target.data%5B%3F%28target.type%3Dpeople%29%5D.target.answer_count%2Carticles_count%2Cgender%2Cfollower_count%2Cis_followed%2Cis_following%2Cbadge%5B%3F%28type%3Dbest_answerer%29%5D.topics%3Bdata%5B%3F%28target.type%3Danswer%29%5D.target.annotation_detail%2Ccontent%2Chermes_label%2Cis_labeled%2Crelationship.is_authorized%2Cis_author%2Cvoting%2Cis_thanked%2Cis_nothelp%3Bdata%5B%3F%28target.type%3Danswer%29%5D.target.author.badge%5B%3F%28type%3Dbest_answerer%29%5D.topics%3Bdata%5B%3F%28target.type%3Darticle%29%5D.target.annotation_detail%2Ccontent%2Chermes_label%2Cis_labeled%2Cauthor.badge%5B%3F%28type%3Dbest_answerer%29%5D.topics%3Bdata%5B%3F%28target.type%3Dquestion%29%5D.target.annotation_detail%2Ccomment_count%3B&limit=5&after_id=5.00000", e);
            int i = 1;

            while(true) {
                s = this.forisend(s, e);
                if(i > 100) {
                    break;
                }

                ++i;
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    private String forisend(String s, List list) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String ss = this.httpClientHelper.get(s, (HashMap)null, (HashMap)null);
        JsonRootBean j = (JsonRootBean)objectMapper.readValue(ss, JsonRootBean.class);
        List data = j.getData();
        Iterator var7 = data.iterator();

        while(var7.hasNext()) {
            Data d = (Data)var7.next();
            String type = d.getTarget().getUrl();
            System.out.println(d.getTarget().getType());
            if("article".equals(d.getTarget().getType())) {
                this.zhuhuAdd(type);
            }
        }

        if(j.getPaging().getIs_end()) {
            return "";
        } else {
            return j.getPaging().getNext();
        }
    }

    public void zhuhuAdd(String url) {
        String s = this.httpClientHelper.get(url, (HashMap)null, (HashMap)null);

        try {
            Thread.sleep(500L);
        } catch (InterruptedException var9) {
            var9.printStackTrace();
        }

        Document parse = Jsoup.parse(s);
        Elements elementsByAttribute = parse.getElementsByAttribute("data-actualsrc");
        Iterator elementsByClassName = elementsByAttribute.iterator();

        Element element;
        while(elementsByClassName.hasNext()) {
            element = (Element)elementsByClassName.next();
            element.attr("src", element.attr("data-actualsrc"));
        }

        Elements elementsByClassName1 = JsoupParserUtil.getElementsByClassName(parse, "Post-RichText");
        element = (Element)elementsByClassName1.get(0);
        SysNews sysNews = new SysNews();
        sysNews.setNewsbody(element.html());
        sysNews.setNewstype("tw");
        sysNews.setTuijian("false");
        sysNews.setZhuangtai("未发布");
        sysNews.setClassify("01");
        sysNews.setStarttime(this.sdf.format(new Date()));
        sysNews.setEndtime("2030-01-01");
        sysNews.setImgsrc(parse.getElementsByClass("TitleImage").attr("src"));
        sysNews.setNewstitle(parse.getElementsByClass("Post-Title").html());
        sysNews.setSynopsis(parse.getElementsByClass("Post-Title").html());
        boolean addonenews = this.newsService.addonenews(sysNews);
        System.out.println(addonenews);
    }
}
