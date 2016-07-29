package com.geeku.model.innovative;

import java.util.Date;

public class MemberApply {
    private Integer id;
    private Integer projectId;
    private Integer memberType;
    private Integer userId;
    private Date applyTime;
    private String applyStatus;
    private Date statusUpTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus == null ? null : applyStatus.trim();
    }

    public Date getStatusUpTime() {
        return statusUpTime;
    }

    public void setStatusUpTime(Date statusUpTime) {
        this.statusUpTime = statusUpTime;
    }
}