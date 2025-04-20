package com.rs.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @TableName dynamic_routes
 */
@Data
@TableName(value ="dynamic_routes")
public class DynamicRoutes implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 父路由id
     */
    private Integer parentrouteid;

    /**
     * 组件名
     */
    private String name;

    /**
     * 图标
     */
    private String icon;

    /**
     * 别名
     */
    private String alias;

    /**
     * “1”启用，“0”禁用
     */
    private Integer state;

    /**
     * 排序顺序，数字越小越靠前
     */
    private Integer sort;

    /**
     * 地址值
     */
    private String value;

    /**
     * 
     */
    private String redirect;

    /**
     * 类型
     */
    private String type;

    /**
     * 描述
     */
    private String discription;

    /**
     * 创建人
     */
    private Integer createuserid;

    private List<DynamicRoutes> children;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 父路由id
     */
    public Integer getParentrouteid() {
        return parentrouteid;
    }

    /**
     * 父路由id
     */
    public void setParentrouteid(Integer parentrouteid) {
        this.parentrouteid = parentrouteid;
    }

    /**
     * 组件名
     */
    public String getName() {
        return name;
    }

    /**
     * 组件名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 别名
     */
    public String getAlias() {
        return alias;
    }

    /**
     * 别名
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * “1”启用，“0”禁用
     */
    public Integer getState() {
        return state;
    }

    /**
     * “1”启用，“0”禁用
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 排序顺序，数字越小越靠前
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序顺序，数字越小越靠前
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 地址值
     */
    public String getValue() {
        return value;
    }

    /**
     * 地址值
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 
     */
    public String getRedirect() {
        return redirect;
    }

    /**
     * 
     */
    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    /**
     * 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 描述
     */
    public String getDiscription() {
        return discription;
    }

    /**
     * 描述
     */
    public void setDiscription(String discription) {
        this.discription = discription;
    }

    /**
     * 创建人
     */
    public Integer getCreateuserid() {
        return createuserid;
    }

    /**
     * 创建人
     */
    public void setCreateuserid(Integer createuserid) {
        this.createuserid = createuserid;
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
        DynamicRoutes other = (DynamicRoutes) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentrouteid() == null ? other.getParentrouteid() == null : this.getParentrouteid().equals(other.getParentrouteid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getAlias() == null ? other.getAlias() == null : this.getAlias().equals(other.getAlias()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getRedirect() == null ? other.getRedirect() == null : this.getRedirect().equals(other.getRedirect()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getDiscription() == null ? other.getDiscription() == null : this.getDiscription().equals(other.getDiscription()))
            && (this.getCreateuserid() == null ? other.getCreateuserid() == null : this.getCreateuserid().equals(other.getCreateuserid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentrouteid() == null) ? 0 : getParentrouteid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getAlias() == null) ? 0 : getAlias().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getRedirect() == null) ? 0 : getRedirect().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getDiscription() == null) ? 0 : getDiscription().hashCode());
        result = prime * result + ((getCreateuserid() == null) ? 0 : getCreateuserid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentrouteid=").append(parentrouteid);
        sb.append(", name=").append(name);
        sb.append(", icon=").append(icon);
        sb.append(", alias=").append(alias);
        sb.append(", state=").append(state);
        sb.append(", sort=").append(sort);
        sb.append(", value=").append(value);
        sb.append(", redirect=").append(redirect);
        sb.append(", type=").append(type);
        sb.append(", discription=").append(discription);
        sb.append(", createuserid=").append(createuserid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}