//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.system.entity.SysNews;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsDao extends BaseMapper<SysNews> {
    SysNews findonetest(@Param("newsid") Integer var1);

    List<SysNews> findFiveNews();

    List<SysNews> findFivetuijian();

    List<SysNews> findAllNews(@Param("classify") String var1, @Param("nowtime") String var2);

    int updatePVbyID(@Param("i") String var1, @Param("id")int var2);

    List<SysNews> findFourNesw();

	int updateZhuangtaiByIds(List<String> ids);
}
