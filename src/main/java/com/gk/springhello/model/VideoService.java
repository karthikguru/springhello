package com.gk.springhello.model;

import java.util.ArrayList;

public interface VideoService {
	ArrayList<String> findVideo(String nickName);
	void insertVideo(Video video);
	void deleteVideo(String videoId);
}
