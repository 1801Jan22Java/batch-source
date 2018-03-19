package com.revature.beans;

import java.io.Serializable;
import java.util.Set;

public class Category implements Serializable {
	private static final long serialVersionUID = 3363756954535297728L;

	private Integer categoryId;
	private String skillCategory;
	private Boolean active;
	private Set<Assessment> assessments;

	/**
	 * Instantiates a new Category.
	 */
	public Category() {
		super();
	}

	/**
	 * Create new category
	 *
	 * @param skillCategory
	 * @param active
	 */
	public Category(String skillCategory, Boolean active) {
		this();
		this.skillCategory = skillCategory;
		this.active = active;
	}

	public Category(SimpleCategory simpleCategory){
		this();
		this.categoryId = simpleCategory.getCategoryId();
		this.skillCategory = simpleCategory.getSkillCategory();
		this.active = simpleCategory.isActive();
	}

	/**
	 * Gets category id.
	 *
	 * @return the category id
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * Sets category id.
	 *
	 * @param categoryId
	 *            the category id
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * Gets skill category.
	 *
	 * @return the skill category
	 */
	public String getSkillCategory() {
		return skillCategory;
	}

	/**
	 * Sets skill category.
	 *
	 * @param skillCategory
	 *            the skill category
	 */
	public void setSkillCategory(String skillCategory) {
		this.skillCategory = skillCategory;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * Gets assessments.
	 *
	 * @return the assessments
	 */
	public Set<Assessment> getAssessments() {
		return assessments;
	}

	/**
	 * Sets assessments.
	 *
	 * @param assessments
	 *            the assessments
	 */
	public void setAssessments(Set<Assessment> assessments) {
		this.assessments = assessments;
	}

	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((skillCategory == null) ? 0 : skillCategory.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (active != other.active)
			return false;
		if (skillCategory == null) {
			if (other.skillCategory != null)
				return false;
		} else if (!skillCategory.equals(other.skillCategory))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return skillCategory;
	}

}
