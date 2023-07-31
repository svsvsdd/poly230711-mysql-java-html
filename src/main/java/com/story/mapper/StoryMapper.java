package com.story.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.story.domain.StoryDTO;
import com.story.paging.Criteria;

@Mapper
public interface StoryMapper {
	public int insertStory(StoryDTO params);
	public StoryDTO selectStoryDetail(long num);
	public int updateStory(StoryDTO params);
	public int deleteStory(long num);
	public List<StoryDTO> selectStoryList(StoryDTO params);
	public int selectStoryTotalCount(StoryDTO params);
}
