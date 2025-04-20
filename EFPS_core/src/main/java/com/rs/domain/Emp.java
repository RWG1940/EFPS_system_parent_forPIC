package com.rs.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @TableName emp
 */
@NoArgsConstructor
@TableName(value ="emp")
@ApiModel(value = "员工实体")
public class Emp implements Serializable {

    @TableId
    private Integer id;

    private String eId;

    private String eUsername;

    private String ePassword;

    private String eName;

    private Integer eGender;

    private Integer eAge;

    private String ePhone;

    private String eAvatarpath;

    private Date eCreatetime;

    private Date eUpdatetime;

    private Integer eIsenabled;

    private Integer eDeptid;


    public Emp(String eUsername) {
        this.eUsername = eUsername;

    }

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String geteUsername() {
        return eUsername;
    }

    public void seteUsername(String eUsername) {
        this.eUsername = eUsername;
    }

    public String getePassword() {
        return ePassword;
    }

    public void setePassword(String ePassword) {
        this.ePassword = ePassword;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public Integer geteGender() {
        return eGender;
    }

    public void seteGender(Integer eGender) {
        this.eGender = eGender;
    }

    public Integer geteAge() {
        return eAge;
    }

    public void seteAge(Integer eAge) {
        this.eAge = eAge;
    }

    public String getePhone() {
        return ePhone;
    }

    public void setePhone(String ePhone) {
        this.ePhone = ePhone;
    }

    public String geteAvatarpath() {
        return eAvatarpath;
    }

    public void seteAvatarpath(String eAvatarpath) {
        this.eAvatarpath = eAvatarpath;
    }

    public Date geteCreatetime() {
        return eCreatetime;
    }

    public void seteCreatetime(Date eCreatetime) {
        this.eCreatetime = eCreatetime;
    }

    public Date geteUpdatetime() {
        return eUpdatetime;
    }

    public void seteUpdatetime(Date eUpdatetime) {
        this.eUpdatetime = eUpdatetime;
    }

    public Integer geteIsenabled() {
        return eIsenabled;
    }

    public void seteIsenabled(Integer eIsenabled) {
        this.eIsenabled = eIsenabled;
    }

    public Integer geteDeptid() {
        return eDeptid;
    }

    public void seteDeptid(Integer eDeptid) {
        this.eDeptid = eDeptid;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Emp other = (Emp) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.geteId() == null ? other.geteId() == null : this.geteId().equals(other.geteId()))
                && (this.geteUsername() == null ? other.geteUsername() == null : this.geteUsername().equals(other.geteUsername()))
                && (this.getePassword() == null ? other.getePassword() == null : this.getePassword().equals(other.getePassword()))
                && (this.geteName() == null ? other.geteName() == null : this.geteName().equals(other.geteName()))
                && (this.geteGender() == null ? other.geteGender() == null : this.geteGender().equals(other.geteGender()))
                && (this.geteAge() == null ? other.geteAge() == null : this.geteAge().equals(other.geteAge()))
                && (this.getePhone() == null ? other.getePhone() == null : this.getePhone().equals(other.getePhone()))
                && (this.geteAvatarpath() == null ? other.geteAvatarpath() == null : this.geteAvatarpath().equals(other.geteAvatarpath()))
                && (this.geteCreatetime() == null ? other.geteCreatetime() == null : this.geteCreatetime().equals(other.geteCreatetime()))
                && (this.geteUpdatetime() == null ? other.geteUpdatetime() == null : this.geteUpdatetime().equals(other.geteUpdatetime()))
                && (this.geteIsenabled() == null ? other.geteIsenabled() == null : this.geteIsenabled().equals(other.geteIsenabled()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((geteId() == null) ? 0 : geteId().hashCode());
        result = prime * result + ((geteUsername() == null) ? 0 : geteUsername().hashCode());
        result = prime * result + ((getePassword() == null) ? 0 : getePassword().hashCode());
        result = prime * result + ((geteName() == null) ? 0 : geteName().hashCode());
        result = prime * result + ((geteGender() == null) ? 0 : geteGender().hashCode());
        result = prime * result + ((geteAge() == null) ? 0 : geteAge().hashCode());
        result = prime * result + ((getePhone() == null) ? 0 : getePhone().hashCode());
        result = prime * result + ((geteAvatarpath() == null) ? 0 : geteAvatarpath().hashCode());
        result = prime * result + ((geteCreatetime() == null) ? 0 : geteCreatetime().hashCode());
        result = prime * result + ((geteUpdatetime() == null) ? 0 : geteUpdatetime().hashCode());
        result = prime * result + ((geteIsenabled() == null) ? 0 : geteIsenabled().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", eId=").append(eId);
        sb.append(", eUsername=").append(eUsername);
        sb.append(", ePassword=").append(ePassword);
        sb.append(", eName=").append(eName);
        sb.append(", eGender=").append(eGender);
        sb.append(", eAge=").append(eAge);
        sb.append(", ePhone=").append(ePhone);
        sb.append(", eDeptid=").append(eDeptid);
        sb.append(", eAvatarpath=").append(eAvatarpath);
        sb.append(", eCreatetime=").append(eCreatetime);
        sb.append(", eUpdatetime=").append(eUpdatetime);
        sb.append(", eIsenabled=").append(eIsenabled);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
