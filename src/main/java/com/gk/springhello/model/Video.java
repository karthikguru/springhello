package com.gk.springhello.model;

import java.io.Serializable;

public class Video implements Serializable{
	
	private final String videoId;
	private final String nickName;
	
	
	public String getVideoId() {
		return videoId;
	}

	public String getNickName() {
		return nickName;
	}
	
	public Video(String videoID,String nickName){
		this.nickName = nickName;
		this.videoId = videoID;
	}
}
