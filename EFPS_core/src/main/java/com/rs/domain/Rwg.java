package com.rs.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName rwg
 */
@TableName(value ="rwg")
public class Rwg implements Serializable {
    /**
     * 
     */
    private String milvusId;

    /**
     * 
     */
    private String imagePath;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public String getMilvusId() {
        return milvusId;
    }

    /**
     * 
     */
    public void setMilvusId(String milvusId) {
        this.milvusId = milvusId;
    }

    /**
     * 
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * 
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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
        Rwg other = (Rwg) that;
        return (this.getMilvusId() == null ? other.getMilvusId() == null : this.getMilvusId().equals(other.getMilvusId()))
            && (this.getImagePath() == null ? other.getImagePath() == null : this.getImagePath().equals(other.getImagePath()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMilvusId() == null) ? 0 : getMilvusId().hashCode());
        result = prime * result + ((getImagePath() == null) ? 0 : getImagePath().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", milvusId=").append(milvusId);
        sb.append(", imagePath=").append(imagePath);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}