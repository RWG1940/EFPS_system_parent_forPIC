package com.rs.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 
 * @TableName role
 */
@NoArgsConstructor
@AllArgsConstructor
@TableName(value ="role")
@ApiModel(value = "角色实体")
public class Role implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer rId;

    /**
     * 
     */
    private String rName;

    /**
     * 
     */
    private String rInfo;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getrId() {
        return rId;
    }

    /**
     * 
     */
    public void setrId(Integer rId) {
        this.rId = rId;
    }

    /**
     * 
     */
    public String getrName() {
        return rName;
    }

    /**
     * 
     */
    public void setrName(String rName) {
        this.rName = rName;
    }

    /**
     * 
     */
    public String getrInfo() {
        return rInfo;
    }

    /**
     * 
     */
    public void setrInfo(String rInfo) {
        this.rInfo = rInfo;
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
        Role other = (Role) that;
        return (this.getrId() == null ? other.getrId() == null : this.getrId().equals(other.getrId()))
            && (this.getrName() == null ? other.getrName() == null : this.getrName().equals(other.getrName()))
            && (this.getrInfo() == null ? other.getrInfo() == null : this.getrInfo().equals(other.getrInfo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getrId() == null) ? 0 : getrId().hashCode());
        result = prime * result + ((getrName() == null) ? 0 : getrName().hashCode());
        result = prime * result + ((getrInfo() == null) ? 0 : getrInfo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rId=").append(rId);
        sb.append(", rName=").append(rName);
        sb.append(", rInfo=").append(rInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}