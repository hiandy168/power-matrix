package com.matrix.pojo.view;

import java.util.Date;

public class McArticleInfoView {
	private Integer id;
    private String title;
    private String titlePic;
    private String source;
    private String author;
    private String authorId;
    private String editor;
    private String editorId;
    private String releaseType;
    private Date releaseTime;
    private Integer articleTypeId;
    private Integer readerCount;
    private Integer thumbsUpCount;
    private Integer sharCount;
    private String topType;
    private String sourceLink;
    private Date createTime;
    private Date updateTime;
    private String htmlContent;
    
    // 非实体类字段
    private String assort; // 文章分类名称  

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitlePic() {
		return titlePic;
	}

	public void setTitlePic(String titlePic) {
		this.titlePic = titlePic;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getEditorId() {
		return editorId;
	}

	public void setEditorId(String editorId) {
		this.editorId = editorId;
	}

	public String getReleaseType() {
		return releaseType;
	}

	public void setReleaseType(String releaseType) {
		this.releaseType = releaseType;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public Integer getArticleTypeId() {
		return articleTypeId;
	}

	public void setArticleTypeId(Integer articleTypeId) {
		this.articleTypeId = articleTypeId;
	}

	public Integer getReaderCount() {
		return readerCount;
	}

	public void setReaderCount(Integer readerCount) {
		this.readerCount = readerCount;
	}

	public Integer getThumbsUpCount() {
		return thumbsUpCount;
	}

	public void setThumbsUpCount(Integer thumbsUpCount) {
		this.thumbsUpCount = thumbsUpCount;
	}

	public Integer getSharCount() {
		return sharCount;
	}

	public void setSharCount(Integer sharCount) {
		this.sharCount = sharCount;
	}

	public String getTopType() {
		return topType;
	}

	public void setTopType(String topType) {
		this.topType = topType;
	}

	public String getSourceLink() {
		return sourceLink;
	}

	public void setSourceLink(String sourceLink) {
		this.sourceLink = sourceLink;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getHtmlContent() {
		return htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}

	public String getAssort() {
		return assort;
	}

	public void setAssort(String assort) {
		this.assort = assort;
	}
    
}
