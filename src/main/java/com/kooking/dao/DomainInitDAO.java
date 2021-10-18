package com.kooking.dao;

import java.util.List;
import java.util.Map;

import com.kooking.dto.PostTypeDTO;
import com.kooking.dto.RecipeCategoryDTO;
import com.kooking.dto.RecipeDetailDTO;

public interface DomainInitDAO {
	List<RecipeDetailDTO> getRecipeDomains() throws Exception;
	List<PostTypeDTO> getPostTypes();
}
