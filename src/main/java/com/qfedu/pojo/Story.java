package com.qfedu.pojo;

import java.util.List;

public class Story {
    private Integer id;

    private String content;

    private Integer userid;

    private Integer sendtime;

    private String local;
    
    private StoryUser user;
    
    private List<StoryImg> imgs;
    
    

    public StoryUser getUser() {
		return user;
	}

	public void setUser(StoryUser user) {
		this.user = user;
	}

	public List<StoryImg> getImgs() {
		return imgs;
	}

	public void setImgs(List<StoryImg> imgs) {
		this.imgs = imgs;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getSendtime() {
        return sendtime;
    }

    public void setSendtime(Integer sendtime) {
        this.sendtime = sendtime;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local == null ? null : local.trim();
    }
}