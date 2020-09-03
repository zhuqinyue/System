//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.company.system.entity.SysCase;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CaseService {
    boolean addOneCase(SysCase var1);

    IPage<SysCase> page(Integer var1, Integer var2, String var3, String var4, String var5, String var6);

    boolean deletecasebyid(String var1);

    boolean deleteList(List<String> var1);

    boolean updatezhuangtai(int var1, String var2);

    boolean zancun(SysCase var1, String var2);

    SysCase findCaseBycaseID(String var1);

    boolean updateCase(SysCase var1);

    List<SysCase> findFiveCase();

    List<SysCase> findAllCase();

    void addPV(String var1);
}
