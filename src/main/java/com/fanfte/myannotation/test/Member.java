package com.fanfte.myannotation.test;

import com.fanfte.myannotation.annotation.*;

/**
 * Created by dell on 2018/5/23
 **/
@DBTable(name = "member")
public class Member {

    @SQLString(30)
    private String firstName;

    @SQLString(50)
    private String lastName;

    @SQLInteger
    private Integer age;

    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    private String handle;

    private int memberCount;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }
}
