//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("User")
public class User {
    @TableId(
            value = "id",
            type = IdType.AUTO
    )
    private Integer id;
    private String name;
    private Integer age;
    private String sex;

    public User() {
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public String getSex() {
        return this.sex;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean equals(Object o) {
        if(o == this) {
            return true;
        } else if(!(o instanceof User)) {
            return false;
        } else {
            User other = (User)o;
            if(!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Integer this$id = this.getId();
                    Integer other$id = other.getId();
                    if(this$id == null) {
                        if(other$id == null) {
                            break label59;
                        }
                    } else if(this$id.equals(other$id)) {
                        break label59;
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

                Integer this$age = this.getAge();
                Integer other$age = other.getAge();
                if(this$age == null) {
                    if(other$age != null) {
                        return false;
                    }
                } else if(!this$age.equals(other$age)) {
                    return false;
                }

                String this$sex = this.getSex();
                String other$sex = other.getSex();
                if(this$sex == null) {
                    if(other$sex != null) {
                        return false;
                    }
                } else if(!this$sex.equals(other$sex)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        boolean PRIME = true;
        byte result = 1;
        Integer $id = this.getId();
        int result1 = result * 59 + ($id == null?43:$id.hashCode());
        String $name = this.getName();
        result1 = result1 * 59 + ($name == null?43:$name.hashCode());
        Integer $age = this.getAge();
        result1 = result1 * 59 + ($age == null?43:$age.hashCode());
        String $sex = this.getSex();
        result1 = result1 * 59 + ($sex == null?43:$sex.hashCode());
        return result1;
    }

    public String toString() {
        return "User(id=" + this.getId() + ", name=" + this.getName() + ", age=" + this.getAge() + ", sex=" + this.getSex() + ")";
    }
}
