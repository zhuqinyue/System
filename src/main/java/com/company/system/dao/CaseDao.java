//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.system.entity.SysCase;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseDao extends BaseMapper<SysCase> {
    List<SysCase> findFiveCase(String var1);

    String findOneCaseBody(String var1);

    List findAllCases(String var1);

    int updatePVbyID(String var1, int var2);
}
