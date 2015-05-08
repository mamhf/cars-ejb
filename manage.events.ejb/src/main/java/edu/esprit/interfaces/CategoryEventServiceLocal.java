package edu.esprit.interfaces;

import java.util.List;

import edu.esprit.entities.CategoryEvent;
import edu.esprit.entities.Event;

public interface CategoryEventServiceLocal {

	void addCategoryEvent(CategoryEvent categoryEvent);

	void deleteCategoryEvent(CategoryEvent categoryEvent);

	CategoryEvent findCategoryEventById(int id);

	CategoryEvent findCategoryEventByType(String type);

	List<CategoryEvent> findAllCategoryEvents();

	CategoryEvent updateCategoryEvent(CategoryEvent categoryEvent);

	List<Event> findAllEventsPerType(int id);
}
