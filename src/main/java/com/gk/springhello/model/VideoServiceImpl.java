package com.gk.springhello.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;



public class VideoServiceImpl implements VideoService{
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private static final String VIDEO_TYPE = "twittvideo";
	private static final String VIDEO_ID = "videoid";
	private static final String VIDEO_NICKNAME = "nickname";
	
	
	public void insertVideo(Video video){
		Key key = KeyFactory.createKey(VIDEO_TYPE, video.getVideoId());
		Entity newVideo = new Entity(key);
		newVideo.setProperty(VIDEO_ID, video.getVideoId());
		newVideo.setProperty(VIDEO_NICKNAME, video.getNickName());
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.put(newVideo);
	}
	
	public void deleteVideo(String videoId){
		
	}
	
	public ArrayList<String> findVideo(String nickName){
		ArrayList<String> videoList = new ArrayList<String>();
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		Filter videoFilter = new FilterPredicate("nickname",
                FilterOperator.EQUAL,
                nickName);
		Query q = new Query("twittvideo").setFilter(videoFilter);
		PreparedQuery pq = datastore.prepare(q);
		
		for(Entity video:pq.asIterable()){
			videoList.add((String)video.getProperty("videoid"));
		}
		return videoList;
	}
	
}
