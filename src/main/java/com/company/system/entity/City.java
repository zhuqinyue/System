//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_invite_nationality")
public class City {
    private Integer id;
    private String name;
    private Integer parentId;
    private String shortName;
    private String letter;
    private String cityCode;
    private String pinyin;

    public City() {
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public String getShortName() {
        return this.shortName;
    }

    public String getLetter() {
        return this.letter;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public String getPinyin() {
        return this.pinyin;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public boolean equals(Object o) {
        if(o == this) {
            return true;
        } else if(!(o instanceof City)) {
            return false;
        } else {
            City other = (City)o;
            if(!other.canEqual(this)) {
                return false;
            } else {
                label95: {
                    Integer this$id = this.getId();
                    Integer other$id = other.getId();
                    if(this$id == null) {
                        if(other$id == null) {
                            break label95;
                        }
                    } else if(this$id.equals(other$id)) {
                        break label95;
                    }

                    return false;
                }

                String this$name = this.getName();
                String other$name = other.getName();
                if(this$name == null) {
                    if(other$name != null) {
                        return false;
                    }
                } else if(!this$name.equals(other$name)) {
                    return false;
                }

                Integer this$parentId = this.getParentId();
                Integer other$parentId = other.getParentId();
                if(this$parentId == null) {
                    if(other$parentId != null) {
                        return false;
                    }
                } else if(!this$parentId.equals(other$parentId)) {
                    return false;
                }

                label74: {
                    String this$shortName = this.getShortName();
                    String other$shortName = other.getShortName();
                    if(this$shortName == null) {
                        if(other$shortName == null) {
                            break label74;
                        }
                    } else if(this$shortName.equals(other$shortName)) {
                        break label74;
                    }

                    return false;
                }

                label67: {
                    String this$letter = this.getLetter();
                    String other$letter = other.getLetter();
                    if(this$letter == null) {
                        if(other$letter == null) {
                            break label67;
                        }
                    } else if(this$letter.equals(other$letter)) {
                        break label67;
                    }

                    return false;
                }

                String this$cityCode = this.getCityCode();
                String other$cityCode = other.getCityCode();
                if(this$cityCode == null) {
                    if(other$cityCode != null) {
                        return false;
                    }
                } else if(!this$cityCode.equals(other$cityCode)) {
                    return false;
                }

                String this$pinyin = this.getPinyin();
                String other$pinyin = other.getPinyin();
                if(this$pinyin == null) {
                    if(other$pinyin != null) {
                        return false;
                    }
                } else if(!this$pinyin.equals(other$pinyin)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof City;
    }

    public int hashCode() {
        boolean PRIME = true;
        byte result = 1;
        Integer $id = this.getId();
        int result1 = result * 59 + ($id == null?43:$id.hashCode());
        String $name = this.getName();
        result1 = result1 * 59 + ($name == null?43:$name.hashCode());
        Integer $parentId = this.getParentId();
        result1 = result1 * 59 + ($parentId == null?43:$parentId.hashCode());
        String $shortName = this.getShortName();
        result1 = result1 * 59 + ($shortName == null?43:$shortName.hashCode());
        String $letter = this.getLetter();
        result1 = result1 * 59 + ($letter == null?43:$letter.hashCode());
        String $cityCode = this.getCityCode();
        result1 = result1 * 59 + ($cityCode == null?43:$cityCode.hashCode());
        String $pinyin = this.getPinyin();
        result1 = result1 * 59 + ($pinyin == null?43:$pinyin.hashCode());
        return result1;
    }

    public String toString() {
        return "City(id=" + this.getId() + ", name=" + this.getName() + ", parentId=" + this.getParentId() + ", shortName=" + this.getShortName() + ", letter=" + this.getLetter() + ", cityCode=" + this.getCityCode() + ", pinyin=" + this.getPinyin() + ")";
    }
}
