//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("sys_news")
public class SysNews {
    @TableId(
            type = IdType.AUTO
    )
    private Integer newsid;
    private String newstitle;
    private String synopsis;
    private String starttime;
    private String endtime;
    private String newsbody;
    private String newstype;
    private String tuijian;
    private Integer liulanliang;
    private String imgsrc;
    private String dianjiliang;
    private String createdtime;
    private String zhuangtai;
    private String classify;
    private String iszancun;
    private String updatetime;
    private String style;

    public SysNews() {
    }

    public Integer getNewsid() {
        return this.newsid;
    }

    public String getNewstitle() {
        return this.newstitle;
    }

    public String getSynopsis() {
        return this.synopsis;
    }

    public String getStarttime() {
        return this.starttime;
    }

    public String getEndtime() {
        return this.endtime;
    }

    public String getNewsbody() {
        return this.newsbody;
    }

    public String getNewstype() {
        return this.newstype;
    }

    public String getTuijian() {
        return this.tuijian;
    }

    public Integer getLiulanliang() {
        return this.liulanliang;
    }

    public String getImgsrc() {
        return this.imgsrc;
    }

    public String getDianjiliang() {
        return this.dianjiliang;
    }

    public String getCreatedtime() {
        return this.createdtime;
    }

    public String getZhuangtai() {
        return this.zhuangtai;
    }

    public String getClassify() {
        return this.classify;
    }

    public String getIszancun() {
        return this.iszancun;
    }

    public String getUpdatetime() {
        return this.updatetime;
    }

    public String getStyle() {
        return this.style;
    }

    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public void setNewsbody(String newsbody) {
        this.newsbody = newsbody;
    }

    public void setNewstype(String newstype) {
        this.newstype = newstype;
    }

    public void setTuijian(String tuijian) {
        this.tuijian = tuijian;
    }

    public void setLiulanliang(Integer liulanliang) {
        this.liulanliang = liulanliang;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public void setDianjiliang(String dianjiliang) {
        this.dianjiliang = dianjiliang;
    }

    public void setCreatedtime(String createdtime) {
        this.createdtime = createdtime;
    }

    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public void setIszancun(String iszancun) {
        this.iszancun = iszancun;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public boolean equals(Object o) {
        if(o == this) {
            return true;
        } else if(!(o instanceof SysNews)) {
            return false;
        } else {
            SysNews other = (SysNews)o;
            if(!other.canEqual(this)) {
                return false;
            } else {
                label215: {
                    Integer this$newsid = this.getNewsid();
                    Integer other$newsid = other.getNewsid();
                    if(this$newsid == null) {
                        if(other$newsid == null) {
                            break label215;
                        }
                    } else if(this$newsid.equals(other$newsid)) {
                        break label215;
                    }

                    return false;
                }

                String this$newstitle = this.getNewstitle();
                String other$newstitle = other.getNewstitle();
                if(this$newstitle == null) {
                    if(other$newstitle != null) {
                        return false;
                    }
                } else if(!this$newstitle.equals(other$newstitle)) {
                    return false;
                }

                label201: {
                    String this$synopsis = this.getSynopsis();
                    String other$synopsis = other.getSynopsis();
                    if(this$synopsis == null) {
                        if(other$synopsis == null) {
                            break label201;
                        }
                    } else if(this$synopsis.equals(other$synopsis)) {
                        break label201;
                    }

                    return false;
                }

                String this$starttime = this.getStarttime();
                String other$starttime = other.getStarttime();
                if(this$starttime == null) {
                    if(other$starttime != null) {
                        return false;
                    }
                } else if(!this$starttime.equals(other$starttime)) {
                    return false;
                }

                label187: {
                    String this$endtime = this.getEndtime();
                    String other$endtime = other.getEndtime();
                    if(this$endtime == null) {
                        if(other$endtime == null) {
                            break label187;
                        }
                    } else if(this$endtime.equals(other$endtime)) {
                        break label187;
                    }

                    return false;
                }

                String this$newsbody = this.getNewsbody();
                String other$newsbody = other.getNewsbody();
                if(this$newsbody == null) {
                    if(other$newsbody != null) {
                        return false;
                    }
                } else if(!this$newsbody.equals(other$newsbody)) {
                    return false;
                }

                label173: {
                    String this$newstype = this.getNewstype();
                    String other$newstype = other.getNewstype();
                    if(this$newstype == null) {
                        if(other$newstype == null) {
                            break label173;
                        }
                    } else if(this$newstype.equals(other$newstype)) {
                        break label173;
                    }

                    return false;
                }

                label166: {
                    String this$tuijian = this.getTuijian();
                    String other$tuijian = other.getTuijian();
                    if(this$tuijian == null) {
                        if(other$tuijian == null) {
                            break label166;
                        }
                    } else if(this$tuijian.equals(other$tuijian)) {
                        break label166;
                    }

                    return false;
                }

                Integer this$liulanliang = this.getLiulanliang();
                Integer other$liulanliang = other.getLiulanliang();
                if(this$liulanliang == null) {
                    if(other$liulanliang != null) {
                        return false;
                    }
                } else if(!this$liulanliang.equals(other$liulanliang)) {
                    return false;
                }

                label152: {
                    String this$imgsrc = this.getImgsrc();
                    String other$imgsrc = other.getImgsrc();
                    if(this$imgsrc == null) {
                        if(other$imgsrc == null) {
                            break label152;
                        }
                    } else if(this$imgsrc.equals(other$imgsrc)) {
                        break label152;
                    }

                    return false;
                }

                label145: {
                    String this$dianjiliang = this.getDianjiliang();
                    String other$dianjiliang = other.getDianjiliang();
                    if(this$dianjiliang == null) {
                        if(other$dianjiliang == null) {
                            break label145;
                        }
                    } else if(this$dianjiliang.equals(other$dianjiliang)) {
                        break label145;
                    }

                    return false;
                }

                String this$createdtime = this.getCreatedtime();
                String other$createdtime = other.getCreatedtime();
                if(this$createdtime == null) {
                    if(other$createdtime != null) {
                        return false;
                    }
                } else if(!this$createdtime.equals(other$createdtime)) {
                    return false;
                }

                String this$zhuangtai = this.getZhuangtai();
                String other$zhuangtai = other.getZhuangtai();
                if(this$zhuangtai == null) {
                    if(other$zhuangtai != null) {
                        return false;
                    }
                } else if(!this$zhuangtai.equals(other$zhuangtai)) {
                    return false;
                }

                label124: {
                    String this$classify = this.getClassify();
                    String other$classify = other.getClassify();
                    if(this$classify == null) {
                        if(other$classify == null) {
                            break label124;
                        }
                    } else if(this$classify.equals(other$classify)) {
                        break label124;
                    }

                    return false;
                }

                String this$iszancun = this.getIszancun();
                String other$iszancun = other.getIszancun();
                if(this$iszancun == null) {
                    if(other$iszancun != null) {
                        return false;
                    }
                } else if(!this$iszancun.equals(other$iszancun)) {
                    return false;
                }

                String this$updatetime = this.getUpdatetime();
                String other$updatetime = other.getUpdatetime();
                if(this$updatetime == null) {
                    if(other$updatetime != null) {
                        return false;
                    }
                } else if(!this$updatetime.equals(other$updatetime)) {
                    return false;
                }

                String this$style = this.getStyle();
                String other$style = other.getStyle();
                if(this$style == null) {
                    if(other$style != null) {
                        return false;
                    }
                } else if(!this$style.equals(other$style)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof SysNews;
    }

    public int hashCode() {
        boolean PRIME = true;
        byte result = 1;
        Integer $newsid = this.getNewsid();
        int result1 = result * 59 + ($newsid == null?43:$newsid.hashCode());
        String $newstitle = this.getNewstitle();
        result1 = result1 * 59 + ($newstitle == null?43:$newstitle.hashCode());
        String $synopsis = this.getSynopsis();
        result1 = result1 * 59 + ($synopsis == null?43:$synopsis.hashCode());
        String $starttime = this.getStarttime();
        result1 = result1 * 59 + ($starttime == null?43:$starttime.hashCode());
        String $endtime = this.getEndtime();
        result1 = result1 * 59 + ($endtime == null?43:$endtime.hashCode());
        String $newsbody = this.getNewsbody();
        result1 = result1 * 59 + ($newsbody == null?43:$newsbody.hashCode());
        String $newstype = this.getNewstype();
        result1 = result1 * 59 + ($newstype == null?43:$newstype.hashCode());
        String $tuijian = this.getTuijian();
        result1 = result1 * 59 + ($tuijian == null?43:$tuijian.hashCode());
        Integer $liulanliang = this.getLiulanliang();
        result1 = result1 * 59 + ($liulanliang == null?43:$liulanliang.hashCode());
        String $imgsrc = this.getImgsrc();
        result1 = result1 * 59 + ($imgsrc == null?43:$imgsrc.hashCode());
        String $dianjiliang = this.getDianjiliang();
        result1 = result1 * 59 + ($dianjiliang == null?43:$dianjiliang.hashCode());
        String $createdtime = this.getCreatedtime();
        result1 = result1 * 59 + ($createdtime == null?43:$createdtime.hashCode());
        String $zhuangtai = this.getZhuangtai();
        result1 = result1 * 59 + ($zhuangtai == null?43:$zhuangtai.hashCode());
        String $classify = this.getClassify();
        result1 = result1 * 59 + ($classify == null?43:$classify.hashCode());
        String $iszancun = this.getIszancun();
        result1 = result1 * 59 + ($iszancun == null?43:$iszancun.hashCode());
        String $updatetime = this.getUpdatetime();
        result1 = result1 * 59 + ($updatetime == null?43:$updatetime.hashCode());
        String $style = this.getStyle();
        result1 = result1 * 59 + ($style == null?43:$style.hashCode());
        return result1;
    }

    public String toString() {
        return "SysNews(newsid=" + this.getNewsid() + ", newstitle=" + this.getNewstitle() + ", synopsis=" + this.getSynopsis() + ", starttime=" + this.getStarttime() + ", endtime=" + this.getEndtime() + ", newsbody=" + this.getNewsbody() + ", newstype=" + this.getNewstype() + ", tuijian=" + this.getTuijian() + ", liulanliang=" + this.getLiulanliang() + ", imgsrc=" + this.getImgsrc() + ", dianjiliang=" + this.getDianjiliang() + ", createdtime=" + this.getCreatedtime() + ", zhuangtai=" + this.getZhuangtai() + ", classify=" + this.getClassify() + ", iszancun=" + this.getIszancun() + ", updatetime=" + this.getUpdatetime() + ", style=" + this.getStyle() + ")";
    }
}
