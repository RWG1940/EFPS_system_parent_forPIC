package com.rs.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * 
 * @TableName menu
 */
@TableName(value ="menu")
@ApiModel(value = "菜单实体")
public class Menu implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer mId;

    /**
     * 
     */
    private String mUrl;

    /**
     * 
     */
    private String mName;

    /**
     * 
     */
    private String mSign;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getmId() {
        return mId;
    }

    /**
     * 
     */
    public void setmId(Integer mId) {
        this.mId = mId;
    }

    /**
     * 
     */
    public String getmUrl() {
        return mUrl;
    }

    /**
     * 
     */
    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    /**
     * 
     */
    public String getmName() {
        return mName;
    }

    /**
     * 
     */
    public void setmName(String mName) {
        this.mName = mName;
    }

    /**
     * 
     */
    public String getmSign() {
        return mSign;
    }

    /**
     * 
     */
    public void setmSign(String mSign) {
        this.mSign = mSign;
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
        Menu other = (Menu) that;
        return (this.getmId() == null ? other.getmId() == null : this.getmId().equals(other.getmId()))
            && (this.getmUrl() == null ? other.getmUrl() == null : this.getmUrl().equals(other.getmUrl()))
            && (this.getmName() == null ? other.getmName() == null : this.getmName().equals(other.getmName()))
            && (this.getmSign() == null ? other.getmSign() == null : this.getmSign().equals(other.getmSign()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getmId() == null) ? 0 : getmId().hashCode());
        result = prime * result + ((getmUrl() == null) ? 0 : getmUrl().hashCode());
        result = prime * result + ((getmName() == null) ? 0 : getmName().hashCode());
        result = prime * result + ((getmSign() == null) ? 0 : getmSign().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mId=").append(mId);
        sb.append(", mUrl=").append(mUrl);
        sb.append(", mName=").append(mName);
        sb.append(", mSign=").append(mSign);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}