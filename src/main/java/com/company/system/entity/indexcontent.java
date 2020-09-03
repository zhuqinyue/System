//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("indexcontent")
public class indexcontent {
    @TableId("primarykey")
    private String primarykey;
    private String img1;
    private String img2;
    private String img3;

    public indexcontent() {
    }

    public String getPrimarykey() {
        return this.primarykey;
    }

    public String getImg1() {
        return this.img1;
    }

    public String getImg2() {
        return this.img2;
    }

    public String getImg3() {
        return this.img3;
    }

    public void setPrimarykey(String primarykey) {
        this.primarykey = primarykey;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public boolean equals(Object o) {
        if(o == this) {
            return true;
        } else if(!(o instanceof indexcontent)) {
            return false;
        } else {
            indexcontent other = (indexcontent)o;
            if(!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    String this$primarykey = this.getPrimarykey();
                    String other$primarykey = other.getPrimarykey();
                    if(this$primarykey == null) {
                        if(other$primarykey == null) {
                            break label59;
                        }
                    } else if(this$primarykey.equals(other$primarykey)) {
                        break label59;
                    }

                    return false;
                }

                String this$img1 = this.getImg1();
                String other$img1 = other.getImg1();
                if(this$img1 == null) {
                    if(other$img1 != null) {
                        return false;
                    }
                } else if(!this$img1.equals(other$img1)) {
                    return false;
                }

                String this$img2 = this.getImg2();
                String other$img2 = other.getImg2();
                if(this$img2 == null) {
                    if(other$img2 != null) {
                        return false;
                    }
                } else if(!this$img2.equals(other$img2)) {
                    return false;
                }

                String this$img3 = this.getImg3();
                String other$img3 = other.getImg3();
                if(this$img3 == null) {
                    if(other$img3 != null) {
                        return false;
                    }
                } else if(!this$img3.equals(other$img3)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof indexcontent;
    }

    public int hashCode() {
        boolean PRIME = true;
        byte result = 1;
        String $primarykey = this.getPrimarykey();
        int result1 = result * 59 + ($primarykey == null?43:$primarykey.hashCode());
        String $img1 = this.getImg1();
        result1 = result1 * 59 + ($img1 == null?43:$img1.hashCode());
        String $img2 = this.getImg2();
        result1 = result1 * 59 + ($img2 == null?43:$img2.hashCode());
        String $img3 = this.getImg3();
        result1 = result1 * 59 + ($img3 == null?43:$img3.hashCode());
        return result1;
    }

    public String toString() {
        return "indexcontent(primarykey=" + this.getPrimarykey() + ", img1=" + this.getImg1() + ", img2=" + this.getImg2() + ", img3=" + this.getImg3() + ")";
    }
}
