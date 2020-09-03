//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("sys_user")
public class SysUser {
    @TableId(
            value = "userid",
            type = IdType.AUTO
    )
    private Integer userid;
    private String username;
    private String password;
    private String createddate;
    private String updatedate;

    public SysUser() {
    }

    public Integer getUserid() {
        return this.userid;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getCreateddate() {
        return this.createddate;
    }

    public String getUpdatedate() {
        return this.updatedate;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

    public boolean equals(Object o) {
        if(o == this) {
            return true;
        } else if(!(o instanceof SysUser)) {
            return false;
        } else {
            SysUser other = (SysUser)o;
            if(!other.canEqual(this)) {
                return false;
            } else {
                label71: {
                    Integer this$userid = this.getUserid();
                    Integer other$userid = other.getUserid();
                    if(this$userid == null) {
                        if(other$userid == null) {
                            break label71;
                        }
                    } else if(this$userid.equals(other$userid)) {
                        break label71;
                    }

                    return false;
                }

                String this$username = this.getUsername();
                String other$username = other.getUsername();
                if(this$username == null) {
                    if(other$username != null) {
                        return false;
                    }
                } else if(!this$username.equals(other$username)) {
                    return false;
                }

                label57: {
                    String this$password = this.getPassword();
                    String other$password = other.getPassword();
                    if(this$password == null) {
                        if(other$password == null) {
                            break label57;
                        }
                    } else if(this$password.equals(other$password)) {
                        break label57;
                    }

                    return false;
                }

                String this$createddate = this.getCreateddate();
                String other$createddate = other.getCreateddate();
                if(this$createddate == null) {
                    if(other$createddate != null) {
                        return false;
                    }
                } else if(!this$createddate.equals(other$createddate)) {
                    return false;
                }

                String this$updatedate = this.getUpdatedate();
                String other$updatedate = other.getUpdatedate();
                if(this$updatedate == null) {
                    if(other$updatedate == null) {
                        return true;
                    }
                } else if(this$updatedate.equals(other$updatedate)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof SysUser;
    }

    public int hashCode() {
        boolean PRIME = true;
        byte result = 1;
        Integer $userid = this.getUserid();
        int result1 = result * 59 + ($userid == null?43:$userid.hashCode());
        String $username = this.getUsername();
        result1 = result1 * 59 + ($username == null?43:$username.hashCode());
        String $password = this.getPassword();
        result1 = result1 * 59 + ($password == null?43:$password.hashCode());
        String $createddate = this.getCreateddate();
        result1 = result1 * 59 + ($createddate == null?43:$createddate.hashCode());
        String $updatedate = this.getUpdatedate();
        result1 = result1 * 59 + ($updatedate == null?43:$updatedate.hashCode());
        return result1;
    }

    public String toString() {
        return "SysUser(userid=" + this.getUserid() + ", username=" + this.getUsername() + ", password=" + this.getPassword() + ", createddate=" + this.getCreateddate() + ", updatedate=" + this.getUpdatedate() + ")";
    }
}
