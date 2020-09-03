//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.company.system.entity.SysNews;
import com.company.system.entity.indexcontent;
import com.company.system.service.NewsService;
import com.company.system.vo.SysResult;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping({"news"})
public class NewsConroller {
    @Autowired
    private NewsService newsService;

    public NewsConroller() {
    }

    @RequestMapping({"addnews"})
    public String addnews() {
        return "/view/addnews.html";
    }

    @RequestMapping({"updatenews"})
    public String updatenews() {
        return "/view/updatenews.html";
    }

    @RequestMapping({"subnews"})
    @ResponseBody
    public SysResult subnews(SysNews news) {
        return this.newsService.addonenews(news)?SysResult.build(Integer.valueOf(0), "添加成功！"):SysResult.build(Integer.valueOf(1), "添加失败,请联系管理员");
    }

    @RequestMapping({"getpage"})
    @ResponseBody
    public SysResult getPage(Integer currentpage, Integer pagesize, String newstitle, String startime, String endtiem, Integer classify) {
        if(currentpage != null && pagesize != null && currentpage.intValue() > 0 && pagesize.intValue() > 0) {
            IPage page = this.newsService.page(currentpage.intValue(), pagesize.intValue(), newstitle, startime, endtiem, classify);
            System.out.println("page===" + page.getRecords().size());
            return SysResult.oK(page);
        } else {
            return SysResult.build(Integer.valueOf(1), "查询失败,请联系管理员");
        }
    }

    @RequestMapping(
            value = {"inputimg"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public SysResult uoloadFile(MultipartFile file) {
        String path = this.newsService.inputFile(file);
        if(path != null && !path.equals("")) {
            SysResult sysResult = new SysResult();
            sysResult.setMsg("上传成功");
            sysResult.setStatus(Integer.valueOf(0));
            sysResult.setData(path);
            sysResult.setLocation(path);
            return sysResult;
        } else {
            return SysResult.build(Integer.valueOf(0), "上传文件失败了,请联系管理员");
        }
    }

    @RequestMapping({"deletenewsbyid"})
    @ResponseBody
    public SysResult deletenewsbyid(String newsid) {
        return this.newsService.deletenewsbyid(newsid)?SysResult.oK():SysResult.build(Integer.valueOf(1), "删除失败,数据已经回滚,请联系管理员");
    }

    @RequestMapping({"findNewsByNewsID"})
    @ResponseBody
    public SysResult findNewsByNewsID(String newsid) {
        SysNews sysNews = this.newsService.findNewsByNewsID(newsid);
        return sysNews != null?SysResult.oK(sysNews):SysResult.build(Integer.valueOf(1), "查询失败了,请联系管理员");
    }

    @RequestMapping({"/deleteList"})
    @ResponseBody
    public SysResult deleteList(@RequestParam(value = "datalist[]",required = false) List<String> datalist) {
        return this.newsService.deleteList(datalist)?SysResult.oK():SysResult.build(Integer.valueOf(1), "删除失败了,请联系管理员");
    }

    @RequestMapping({"upnews"})
    @ResponseBody
    public SysResult Updatenews(SysNews news) {
        return news != null && this.newsService.updateNews(news)?SysResult.oK("更新成功"):SysResult.build(Integer.valueOf(1), "更新失败");
    }

    @RequestMapping({"updatezhuangtai"})
    @ResponseBody
    public SysResult updatezhuangtai(int newsid, String zhuangtai) {
        return this.newsService.updatezhuangtai(newsid, zhuangtai)?SysResult.oK():SysResult.build(Integer.valueOf(1), "修改失败了");
    }

    @RequestMapping({"zancun"})
    @ResponseBody
    public SysResult zancun(SysNews news, String type) {
        System.out.println(news);
        System.out.println(type);
        return this.newsService.zancun(news, type)?SysResult.build(Integer.valueOf(0), "暂存成功！"):SysResult.build(Integer.valueOf(1), "保存失败,请联系管理员");
    }

    @RequestMapping({"updateimg"})
    @ResponseBody
    public SysResult updateimg(String img1, String img2, String img3) {
        if(this.newsService.updateimg(img1, img2, img3)) {
            indexcontent findimgs = this.newsService.findimgs();
            return SysResult.oK(findimgs);
        } else {
            return SysResult.build(Integer.valueOf(1), "上传文件失败了，请联系运维人员查看原因");
        }
    }

    @RequestMapping({"/ExcelDownload"})
    public void excelDownload(HttpServletResponse response, @RequestParam(value = "ids[]",required = false) List<String> ids, String ids1) throws IOException {
        String[] header = new String[]{"标题", "简介", "上架开始时间", "上架结束时间", "展示类型", "浏览量", "展示图", "创建时间", "状态", "新闻类型", "更新时间", "主体内容"};
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("新闻类型");
        sheet.setDefaultColumnWidth(10);
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFRow headrow = sheet.createRow(0);

        for(int emps = 0; emps < header.length; ++emps) {
            HSSFCell i = headrow.createCell(emps);
            HSSFRichTextString row1 = new HSSFRichTextString(header[emps]);
            i.setCellValue(row1);
            i.setCellStyle(headerStyle);
        }

        List var12 = null;
        if(ids != null && ids.size() != 0) {
            var12 = this.newsService.findNewsByIDs(ids);
        } else {
            String[] var13 = ids1.split(",");
            List var15 = Arrays.asList(var13);
            var12 = this.newsService.findNewsByIDs(var15);
        }

        for(int var14 = 0; var14 < var12.size(); ++var14) {
            HSSFRow var16 = sheet.createRow(var14 + 1);
            var16.createCell(1).setCellValue(new HSSFRichTextString(((SysNews)var12.get(var14)).getNewstitle()));
            var16.createCell(0).setCellValue(new HSSFRichTextString(((SysNews)var12.get(var14)).getSynopsis()));
            var16.createCell(2).setCellValue(new HSSFRichTextString(((SysNews)var12.get(var14)).getStarttime()));
            var16.createCell(3).setCellValue(new HSSFRichTextString(((SysNews)var12.get(var14)).getEndtime()));
            if(((SysNews)var12.get(var14)).getNewstype().toString().equals("1")) {
                var16.createCell(4).setCellValue(new HSSFRichTextString(""));
            } else {
                var16.createCell(4).setCellValue(new HSSFRichTextString(""));
            }

            if(null != ((SysNews)var12.get(var14)).getLiulanliang()) {
                var16.createCell(5).setCellValue(new HSSFRichTextString(((SysNews)var12.get(var14)).getLiulanliang().toString()));
            } else {
                var16.createCell(5).setCellValue(new HSSFRichTextString(""));
            }

            var16.createCell(6).setCellValue(new HSSFRichTextString(""));
            var16.createCell(7).setCellValue(new HSSFRichTextString(((SysNews)var12.get(var14)).getCreatedtime()));
            var16.createCell(8).setCellValue(new HSSFRichTextString(((SysNews)var12.get(var14)).getZhuangtai()));
            if("01".equals(((SysNews)var12.get(var14)).getClassify())) {
                var16.createCell(9).setCellValue(new HSSFRichTextString("产品运营"));
            } else if("02".equals(((SysNews)var12.get(var14)).getClassify())) {
                var16.createCell(9).setCellValue(new HSSFRichTextString("品牌营销"));
            } else {
                var16.createCell(9).setCellValue(new HSSFRichTextString("产品推广"));
            }

            var16.createCell(10).setCellValue(new HSSFRichTextString(((SysNews)var12.get(var14)).getUpdatetime()));
            var16.createCell(11).setCellValue(new HSSFRichTextString(((SysNews)var12.get(var14)).getNewsbody()));
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=newsdata.xls");
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }
}
