package com.kooking.dto.wrapper;

import java.util.List;

import com.kooking.dto.CommentDTO;
import com.kooking.dto.ImageDTO;
import com.kooking.dto.IngredientDTO;
import com.kooking.dto.PostDTO;
import com.kooking.dto.ProcessDTO;
import com.kooking.dto.RecipeDTO;
import com.kooking.dto.RecommendDTO;
import com.kooking.paging.Pagenation;

public class RecipeWrapper {
	private PostDTO post;
	private RecipeDTO recipe;
	private List<ProcessDTO> process;
	private List<IngredientDTO> ingredient;
	private List<ImageDTO> images;
	private List<CommentDTO> comments;
	private Pagenation page;

	public RecipeWrapper() {
		super();
	}

	public RecipeWrapper(PostDTO post, RecipeDTO recipe, List<ProcessDTO> process, List<IngredientDTO> ingredient,
			List<ImageDTO> images, List<CommentDTO> comments) {
		this.post = post;
		this.recipe = recipe;
		this.process = process;
		this.ingredient = ingredient;
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

	public List<ProcessDTO> getProcess() {
		return process;
	}

	public void setProcess(List<ProcessDTO> process) {
		this.process = process;
	}

	public List<IngredientDTO> getIngredient() {
		return ingredient;
	}

	public void setIgredients(List<IngredientDTO> ingredient) {
		this.ingredient = ingredient;
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

	@Override
	public String toString() {
		return "RecipeWrapper [post=" + post + ", recipe=" + recipe + ", process=" + process + ", ingredient="
				+ ingredient + ", images=" + images + ", comments=" + comments + "]";
	}

}
