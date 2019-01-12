package org.nix.zpbs.model;

import java.io.Serializable;

public class PhotoSort implements Serializable {
    /**
     * 相册ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 相册名
     *
     * @mbggenerated
     */
    private String sortImgName;

    /**
     * 展示方式 0->仅主人可见,1->输入密码即可查看,2->仅好友能查看,3->回答问题即可查看
     *
     * @mbggenerated
     */
    private String sortImgType;

    /**
     * 查看密码
     *
     * @mbggenerated
     */
    private String imgPassword;

    /**
     * 所属用户ID
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * 访问问题
     *
     * @mbggenerated
     */
    private String imgSortQuestion;

    /**
     * 访问问题的答案
     *
     * @mbggenerated
     */
    private String imgSortAnswer;

    /**
     * 默认1表示相册板块
     *
     * @mbggenerated
     */
    private Integer typeId;

    /**
     * 封面图片的路径
     *
     * @mbggenerated
     */
    private Long topPicSrc;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSortImgName() {
        return sortImgName;
    }

    public void setSortImgName(String sortImgName) {
        this.sortImgName = sortImgName;
    }

    public String getSortImgType() {
        return sortImgType;
    }

    public void setSortImgType(String sortImgType) {
        this.sortImgType = sortImgType;
    }

    public String getImgPassword() {
        return imgPassword;
    }

    public void setImgPassword(String imgPassword) {
        this.imgPassword = imgPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getImgSortQuestion() {
        return imgSortQuestion;
    }

    public void setImgSortQuestion(String imgSortQuestion) {
        this.imgSortQuestion = imgSortQuestion;
    }

    public String getImgSortAnswer() {
        return imgSortAnswer;
    }

    public void setImgSortAnswer(String imgSortAnswer) {
        this.imgSortAnswer = imgSortAnswer;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Long getTopPicSrc() {
        return topPicSrc;
    }

    public void setTopPicSrc(Long topPicSrc) {
        this.topPicSrc = topPicSrc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sortImgName=").append(sortImgName);
        sb.append(", sortImgType=").append(sortImgType);
        sb.append(", imgPassword=").append(imgPassword);
        sb.append(", userId=").append(userId);
        sb.append(", imgSortQuestion=").append(imgSortQuestion);
        sb.append(", imgSortAnswer=").append(imgSortAnswer);
        sb.append(", typeId=").append(typeId);
        sb.append(", topPicSrc=").append(topPicSrc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}