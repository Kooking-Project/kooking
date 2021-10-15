package com.kooking.dto.wrapper;

import java.util.List;

import com.kooking.dto.CommentDTO;
import com.kooking.dto.ImageDTO;
import com.kooking.dto.IngredientDTO;
import com.kooking.dto.PostDTO;
import com.kooking.dto.RecipeDTO;

public class RecipeWrapper {
	private PostDTO post;
	private RecipeDTO recipe;
	private List<Process> process;
	private List<IngredientDTO> igredients;
	private List<ImageDTO> images;
	private List<CommentDTO> comments;
	
	public RecipeWrapper() {
		super();
	}
	
	public RecipeWrapper(PostDTO post, RecipeDTO recipe, List<Process> process, List<IngredientDTO> igredients,
			List<ImageDTO> images, List<CommentDTO> comments) {
		super();
		this.post = post;
		this.recipe = recipe;
		this.process = process;
		this.igredients = igredients;
		this.images = images;
		this.comments = comments;
	}

	public PostDTO getPost() {
		return post;
	}
	public void setPost(PostDTO post) {
		this.post = post;
	}
	public RecipeDTO getRecipe() {
		return recipe;
	}
	public void setRecipe(RecipeDTO recipe) {
		this.recipe = recipe;
	}
	public List<Process> getProcess() {
		return process;
	}
	public void setProcess(List<Process> process) {
		this.process = process;
	}
	public List<IngredientDTO> getIgredients() {
		return igredients;
	}
	public void setIgredients(List<IngredientDTO> igredients) {
		this.igredients = igredients;
	}
	public List<ImageDTO> getImages() {
		return images;
	}
	public void setImages(List<ImageDTO> images) {
		this.images = images;
	}
	public List<CommentDTO> getComments() {
		return comments;
	}
	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}
	
}
