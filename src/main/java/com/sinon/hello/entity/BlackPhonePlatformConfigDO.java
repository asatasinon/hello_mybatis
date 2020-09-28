package com.sinon.hello.entity;

import java.io.Serializable;

/**
 * @author 
 * 
 */
public class BlackPhonePlatformConfigDO implements Serializable {
    private Integer id;

    /**
     * 防骚扰平台名称
     */
    private String platformName;

    /**
     * 平台编号,和监控部分代码强相关
     */
    private String platformIdentity;

    /**
     * 最大推送数量
     */
    private Integer maxPushBatchSize;

    /**
     * 访问路径
     */
    private String url;

    /**
     * 请求头
     */
    private String requestHeader;

    /**
     * 请求模板
     */
    private String requestBodyTemplate;

    /**
     * 请求模板固定变量
     */
    private String requestValMap;

    /**
     * 响应解析类型: 0:json 1:xml
     */
    private Byte responseFormateType;

    /**
     * 响应手机号参数节点路径
     */
    private String responsePhoneNode;

    /**
     * 响应结果的参数节点路径
     */
    private String responseResultNode;

    /**
     * 禁用响应状态集合
     */
    private String forbidSymbolSet;

    /**
     * 通过响应状态集合
     */
    private String passSymbolSet;

    /**
     * 启用的最小批次的阈值
     */
    private Integer enableMinPackSize;

    /**
     * 是否启用这个平台
     */
    private Boolean enable;

    /**
     * 是否验证黑名单后插入本地黑名单(用于防止配置问题导致插了大量黑名单)，默认不开启，开启是确认配置正常
     */
    private Boolean enableInsertBlacklist;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformIdentity() {
        return platformIdentity;
    }

    public void setPlatformIdentity(String platformIdentity) {
        this.platformIdentity = platformIdentity;
    }

    public Integer getMaxPushBatchSize() {
        return maxPushBatchSize;
    }

    public void setMaxPushBatchSize(Integer maxPushBatchSize) {
        this.maxPushBatchSize = maxPushBatchSize;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(String requestHeader) {
        this.requestHeader = requestHeader;
    }

    public String getRequestBodyTemplate() {
        return requestBodyTemplate;
    }

    public void setRequestBodyTemplate(String requestBodyTemplate) {
        this.requestBodyTemplate = requestBodyTemplate;
    }

    public String getRequestValMap() {
        return requestValMap;
    }

    public void setRequestValMap(String requestValMap) {
        this.requestValMap = requestValMap;
    }

    public Byte getResponseFormateType() {
        return responseFormateType;
    }

    public void setResponseFormateType(Byte responseFormateType) {
        this.responseFormateType = responseFormateType;
    }

    public String getResponsePhoneNode() {
        return responsePhoneNode;
    }

    public void setResponsePhoneNode(String responsePhoneNode) {
        this.responsePhoneNode = responsePhoneNode;
    }

    public String getResponseResultNode() {
        return responseResultNode;
    }

    public void setResponseResultNode(String responseResultNode) {
        this.responseResultNode = responseResultNode;
    }

    public String getForbidSymbolSet() {
        return forbidSymbolSet;
    }

    public void setForbidSymbolSet(String forbidSymbolSet) {
        this.forbidSymbolSet = forbidSymbolSet;
    }

    public String getPassSymbolSet() {
        return passSymbolSet;
    }

    public void setPassSymbolSet(String passSymbolSet) {
        this.passSymbolSet = passSymbolSet;
    }

    public Integer getEnableMinPackSize() {
        return enableMinPackSize;
    }

    public void setEnableMinPackSize(Integer enableMinPackSize) {
        this.enableMinPackSize = enableMinPackSize;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getEnableInsertBlacklist() {
        return enableInsertBlacklist;
    }

    public void setEnableInsertBlacklist(Boolean enableInsertBlacklist) {
        this.enableInsertBlacklist = enableInsertBlacklist;
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
        BlackPhonePlatformConfigDO other = (BlackPhonePlatformConfigDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlatformName() == null ? other.getPlatformName() == null : this.getPlatformName().equals(other.getPlatformName()))
            && (this.getPlatformIdentity() == null ? other.getPlatformIdentity() == null : this.getPlatformIdentity().equals(other.getPlatformIdentity()))
            && (this.getMaxPushBatchSize() == null ? other.getMaxPushBatchSize() == null : this.getMaxPushBatchSize().equals(other.getMaxPushBatchSize()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getRequestHeader() == null ? other.getRequestHeader() == null : this.getRequestHeader().equals(other.getRequestHeader()))
            && (this.getRequestBodyTemplate() == null ? other.getRequestBodyTemplate() == null : this.getRequestBodyTemplate().equals(other.getRequestBodyTemplate()))
            && (this.getRequestValMap() == null ? other.getRequestValMap() == null : this.getRequestValMap().equals(other.getRequestValMap()))
            && (this.getResponseFormateType() == null ? other.getResponseFormateType() == null : this.getResponseFormateType().equals(other.getResponseFormateType()))
            && (this.getResponsePhoneNode() == null ? other.getResponsePhoneNode() == null : this.getResponsePhoneNode().equals(other.getResponsePhoneNode()))
            && (this.getResponseResultNode() == null ? other.getResponseResultNode() == null : this.getResponseResultNode().equals(other.getResponseResultNode()))
            && (this.getForbidSymbolSet() == null ? other.getForbidSymbolSet() == null : this.getForbidSymbolSet().equals(other.getForbidSymbolSet()))
            && (this.getPassSymbolSet() == null ? other.getPassSymbolSet() == null : this.getPassSymbolSet().equals(other.getPassSymbolSet()))
            && (this.getEnableMinPackSize() == null ? other.getEnableMinPackSize() == null : this.getEnableMinPackSize().equals(other.getEnableMinPackSize()))
            && (this.getEnable() == null ? other.getEnable() == null : this.getEnable().equals(other.getEnable()))
            && (this.getEnableInsertBlacklist() == null ? other.getEnableInsertBlacklist() == null : this.getEnableInsertBlacklist().equals(other.getEnableInsertBlacklist()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPlatformName() == null) ? 0 : getPlatformName().hashCode());
        result = prime * result + ((getPlatformIdentity() == null) ? 0 : getPlatformIdentity().hashCode());
        result = prime * result + ((getMaxPushBatchSize() == null) ? 0 : getMaxPushBatchSize().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getRequestHeader() == null) ? 0 : getRequestHeader().hashCode());
        result = prime * result + ((getRequestBodyTemplate() == null) ? 0 : getRequestBodyTemplate().hashCode());
        result = prime * result + ((getRequestValMap() == null) ? 0 : getRequestValMap().hashCode());
        result = prime * result + ((getResponseFormateType() == null) ? 0 : getResponseFormateType().hashCode());
        result = prime * result + ((getResponsePhoneNode() == null) ? 0 : getResponsePhoneNode().hashCode());
        result = prime * result + ((getResponseResultNode() == null) ? 0 : getResponseResultNode().hashCode());
        result = prime * result + ((getForbidSymbolSet() == null) ? 0 : getForbidSymbolSet().hashCode());
        result = prime * result + ((getPassSymbolSet() == null) ? 0 : getPassSymbolSet().hashCode());
        result = prime * result + ((getEnableMinPackSize() == null) ? 0 : getEnableMinPackSize().hashCode());
        result = prime * result + ((getEnable() == null) ? 0 : getEnable().hashCode());
        result = prime * result + ((getEnableInsertBlacklist() == null) ? 0 : getEnableInsertBlacklist().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", platformName=").append(platformName);
        sb.append(", platformIdentity=").append(platformIdentity);
        sb.append(", maxPushBatchSize=").append(maxPushBatchSize);
        sb.append(", url=").append(url);
        sb.append(", requestHeader=").append(requestHeader);
        sb.append(", requestBodyTemplate=").append(requestBodyTemplate);
        sb.append(", requestValMap=").append(requestValMap);
        sb.append(", responseFormateType=").append(responseFormateType);
        sb.append(", responsePhoneNode=").append(responsePhoneNode);
        sb.append(", responseResultNode=").append(responseResultNode);
        sb.append(", forbidSymbolSet=").append(forbidSymbolSet);
        sb.append(", passSymbolSet=").append(passSymbolSet);
        sb.append(", enableMinPackSize=").append(enableMinPackSize);
        sb.append(", enable=").append(enable);
        sb.append(", enableInsertBlacklist=").append(enableInsertBlacklist);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}