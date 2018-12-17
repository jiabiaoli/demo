package com.example;

import com.example.validation.annotation.PhoneAnnotation;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @auther jiabiaoli@boco.com.cn
 * @date 2018/12/17 20:18
 */
public class User {
    public  static interface UpdateValid{};
    public  static interface InsertValid extends  UpdateValid{};

    private Long id;
    @NotEmpty(message = "名称不能为空",groups={InsertValid.class})
    private String name;
    @Min(value = 18, message = "年龄最小为18岁",groups={UpdateValid.class})
    @Max(value = 30, message = "年龄最大为30岁",groups={UpdateValid.class})
    @NotNull(message = "年龄为必填项",groups={UpdateValid.class})
    private Integer age;
    @NotEmpty(message="手机号为必填项",groups={InsertValid.class})
    @PhoneAnnotation(groups={InsertValid.class})
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
