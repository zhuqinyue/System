//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.company.system.entity.SysNews;
import com.company.system.entity.indexcontent;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface NewsService {
    String inputFile(MultipartFile var1);

    boolean addonenews(SysNews var1);

    SysNews findOneNewsById(int var1);

    IPage<SysNews> page(int var1, int var2, String var3, String var4, String var5, Integer var6);

    boolean deletenewsbyid(String var1);

    SysNews findNewsByNewsID(String var1);

    boolean deleteList(List<String> var1);

    boolean updateNews(SysNews var1);

    boolean updatezhuangtai(int var1, String var2);

    boolean zancun(SysNews var1, String var2);

    List<SysNews> findFiveNews();

    List<SysNews> findFourNews();

    List<SysNews> findtuijians();

    List<SysNews> findAllNews(String var1);

    void addPV(String var1);

    indexcontent findimgs();

    boolean updateimg(String var1, String var2, String var3);

    List<SysNews> findNewsByIDs(List var1);
}
