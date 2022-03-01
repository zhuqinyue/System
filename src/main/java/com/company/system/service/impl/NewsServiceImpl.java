//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.system.dao.IndexDao;
import com.company.system.dao.NewsDao;
import com.company.system.entity.SysNews;
import com.company.system.entity.indexcontent;
import com.company.system.exception.ServiceExcetion;
import com.company.system.service.NewsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private IndexDao indexDao;

    public NewsServiceImpl() {
    }
    @Override
    public String inputFile(MultipartFile file) {
        ArrayList imageType = new ArrayList();
        imageType.add("jpg");
        imageType.add("png");
        imageType.add("bmp");
        imageType.add("gif");
        String originalFilename = file.getOriginalFilename();
        String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();
        if(imageType.contains(fileSuffix)) {
            String newFileName = UUID.randomUUID().toString() + originalFilename;
            String dirPath = System.getProperty("user.dir");
            System.out.println(dirPath);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            String path = File.separator + "uploadImg" + File.separator + sdf.format(date) + "/" + newFileName;
            File destFile = new File(dirPath + path);
            if(!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }

            try {
                file.transferTo(destFile);
                return path;
            } catch (IOException var12) {
                var12.printStackTrace();
                return null;
            }
        } else {
            throw new ServiceExcetion("非法文件");
        }
    }
    @Override
    @Transactional
    public boolean addonenews(SysNews news) {
        if(news.getStarttime() != null && !news.getStarttime().isEmpty() && news.getEndtime() != null && !news.getEndtime().isEmpty()) {
            String transactionStatus1 = news.getStarttime().replace("-", "");
            String Endtime = news.getEndtime().replace("-", "");
            int in;
            if(!transactionStatus1.isEmpty() && !Endtime.isEmpty()) {
                int b = Integer.parseInt(transactionStatus1);
                in = Integer.parseInt(Endtime);
                if(b > in) {
                    throw new ServiceExcetion("开始时间不能大于结束时间");
                }
            }

            System.out.println(news.getNewsbody());
            if(news.getNewsbody().isEmpty()) {
                throw new ServiceExcetion("新闻主体内容不能为空");
            } else {
                System.out.println(news.getNewstitle());
                if(news.getNewstitle().isEmpty()) {
                    throw new ServiceExcetion("请填写标题");
                } else {
                    System.out.println(news.getSynopsis());
                    if(news.getSynopsis().isEmpty()) {
                        throw new ServiceExcetion("请填写简介");
                    } else {
                        if(news.getNewstype().equals("tw")) {
                            news.setNewstype("1");
                        } else {
                            news.setNewstype("2");
                        }

                        if(news.getClassify() != null && !news.getClassify().isEmpty()) {
                            news.setCreatedtime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()).toString());
                            news.setUpdatetime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()).toString());
                            if(news.getZhuangtai() == null) {
                                news.setZhuangtai("已发布");
                            }

                            news.setIszancun("0");
                            boolean b1 = this.newsDao.insert(news) > 0;
                            in = news.getNewsid().intValue();
                            if(b1) {
                                this.redisTemplate.opsForValue().set("news" + in, news.getNewsbody());
                            }

                            return b1;
                        } else {
                            throw new ServiceExcetion("请选择新闻类型");
                        }
                    }
                }
            }
        } else {

            throw new ServiceExcetion("请填写开始时间或者结束时间");
        }
    }
    @Override
    public SysNews findOneNewsById(int newsid) {
        if(newsid == 0) {
            throw new ServiceExcetion("新闻ID不能为空或者0");
        } else {
            String s = (String)this.redisTemplate.opsForValue().get("news" + newsid);
            SysNews news;
            if(s != null && !s.isEmpty()) {
                try {
                    news = (SysNews)(new ObjectMapper()).readValue(s, SysNews.class);
                    System.out.println("===========走缓存=============");
                    return news;
                } catch (JsonProcessingException var4) {
                    System.out.println("=======json转化失败===========");
                    var4.printStackTrace();
                }
            }

            news = (SysNews)this.newsDao.selectOne((Wrapper)(new QueryWrapper()).eq("newsid", Integer.valueOf(newsid)));
            return news != null && !news.equals("")?news:null;
        }
    }
    @Override
    public IPage<SysNews> page(int currentpage, int pagesize, String newstitle, String starttime, String endtime, Integer classfly) {
        if(starttime != null && !StringUtils.isEmpty(starttime) && endtime != null && !StringUtils.isEmpty(endtime) && Integer.parseInt(starttime.replace("-", "")) > Integer.parseInt(endtime.replace("-", ""))) {
            throw new ServiceExcetion("开始时间不能大于结束时间");
        } else {
            QueryWrapper sysNewsQueryWrapper = new QueryWrapper();
            if(newstitle != null && !StringUtils.isEmpty(newstitle)) {
                sysNewsQueryWrapper.like("newstitle", newstitle);
            }

            if(starttime != null && !StringUtils.isEmpty(starttime)) {
                sysNewsQueryWrapper.ge("createdtime", starttime);
            }

            if(endtime != null && !StringUtils.isEmpty(endtime)) {
                endtime = endtime + " 23:59:59";
                sysNewsQueryWrapper.le("createdtime", endtime);
            }

            if(classfly != null && classfly.intValue() != 0) {
                sysNewsQueryWrapper.eq("classify", classfly);
            }
            sysNewsQueryWrapper.in("zhuangtai",new String[] {"已发布","未发布"});


//            sysNewsQueryWrapper.select(SysNews.class, (info) -> {
//                return !info.getColumn().equals("newsbody") && !info.getColumn().equals("style");
//            });
            sysNewsQueryWrapper.orderByDesc(new String[]{"updatetime"});
            Page page = new Page((long)currentpage, (long)pagesize);
            long l1 = System.currentTimeMillis();
            IPage page1 = this.newsDao.selectPage(page, sysNewsQueryWrapper);
            long l2 = System.currentTimeMillis();
            System.out.println("毫秒" + (l2 - l1));
            return page1;
        }
    }
    @Override
    @Transactional
    public boolean deletenewsbyid(String newsid) {
        if(newsid != null && !newsid.isEmpty()) {
            SysNews sysNews = new SysNews();
            sysNews.setZhuangtai("删除");
            sysNews.setNewsid(Integer.valueOf(newsid));
            int i = newsDao.updateById(sysNews);
            if(i == 1) {
                return true;
            } else {
                throw new ServiceExcetion("删除失败,记录可能不存在");
            }
        } else {
            return false;
        }
    }
    @Override
    public SysNews findNewsByNewsID(String newsid) {
        if(newsid != null && !newsid.isEmpty()) {
            long l1 = System.currentTimeMillis();
            SysNews sysNews = (SysNews)this.newsDao.selectById(newsid);
            long l2 = System.currentTimeMillis();
            System.out.println("执行时间" + (l2 - l1));
            if(sysNews != null) {
                return sysNews;
            } else {
                throw new ServiceExcetion("记录可能不存在");
            }
        } else {
            return null;
        }
    }
    @Override
    @Transactional
    public boolean deleteList(List<String> datalist) {
        if(datalist != null && datalist.size() > 0) {


            return this.newsDao.updateZhuangtaiByIds(datalist) == datalist.size();
        } else {
            throw new ServiceExcetion("请选择要删除的记录");
        }
    }
    @Override
    @Transactional
    public boolean updateNews(SysNews news) {
        if(this.deletenewsbyid(news.getNewsid().toString())) {
            news.setNewsid((Integer)null);
            return this.addonenews(news);
        } else {
            return false;
        }
    }
    @Override
    public boolean updatezhuangtai(int newsid, String zhuangtai) {
        if(newsid == 0) {
            throw new ServiceExcetion("新闻ID为空");
        } else if(StringUtils.isEmpty(zhuangtai)) {
            throw new ServiceExcetion("新闻状态为空");
        } else {
            SysNews sysNews = new SysNews();
            sysNews.setNewsid(Integer.valueOf(newsid));
            sysNews.setZhuangtai(zhuangtai);
            return this.newsDao.updateById(sysNews) > 0;
        }
    }
    @Override
    @Transactional
    public boolean zancun(SysNews news, String type) {
        if(news.getNewstitle() != null && !news.getNewstitle().equals("")) {
            if(news.getNewstype() != null && !news.getNewstype().isEmpty()) {
                if(news.getNewstype().equals("tw")) {
                    news.setNewstype("1");
                } else {
                    news.setNewstype("2");
                }
            }

            news.setIszancun("1");
            news.setZhuangtai("未发布");
            news.setUpdatetime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()).toString());
            return type != null && type.equals("add")?this.newsDao.insert(news) > 0:(type != null && type.equals("update")?this.newsDao.updateById(news) > 0:false);
        } else {
            throw new ServiceExcetion("必须填写标题");
        }
    }

    @Override
    public List<SysNews> findFiveNews() {
        List list = this.newsDao.findFiveNews();
        return list.size() > 0?list:null;
    }

    @Override
    public List<SysNews> findFourNews() {
        List list = this.newsDao.findFourNesw();
        return list.size() > 0?list:null;
    }

    @Override
    public List<SysNews> findtuijians() {
        List list = this.newsDao.findFivetuijian();
        return list.size() > 0?list:null;
    }
    @Override
    public List<SysNews> findAllNews(String type) {
        List list = this.newsDao.findAllNews(type, (new SimpleDateFormat("yyyy-MM-dd")).format(new Date()).toString());
        if(list != null && list.size() > 0) {
            return list;
        } else {
            throw new ServiceExcetion("记录可能不存在");
        }
    }
    @Override
    public Boolean addPV(String id) {
        SysNews sysNews = (SysNews)this.newsDao.selectOne((Wrapper)(new QueryWrapper()).eq("newsid", id));
        Integer liulanliang = sysNews.getLiulanliang();
        if(liulanliang == null) {
            liulanliang = Integer.valueOf(1);
        }
        sysNews.setLiulanliang(liulanliang+1);
        int i = newsDao.updateById(sysNews);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public indexcontent findimgs() {
        return (indexcontent)this.indexDao.selectOne((Wrapper)null);
    }
    @Override
    public boolean updateimg(String img1, String img2, String img3) {
        if(!StringUtils.isEmpty(img1) && !StringUtils.isEmpty(img2) && !StringUtils.isEmpty(img3)) {
            indexcontent index = new indexcontent();
            index.setImg1(img1);
            index.setImg2(img2);
            index.setImg3(img3);
            int update = this.indexDao.update(index, (Wrapper)null);
            if(update == 1) {
                return true;
            }
        }

        return false;
    }
    @Override
    public List<SysNews> findNewsByIDs(List exportlist) {
        List sysNews = null;
        if(exportlist != null && exportlist.size() > 0) {
            QueryWrapper Wrapper = new QueryWrapper();
            Wrapper.in("newsid", exportlist);
            sysNews = this.newsDao.selectList(Wrapper);
        } else {
            sysNews = this.newsDao.selectList((Wrapper)null);
        }

        return sysNews;
    }
}
