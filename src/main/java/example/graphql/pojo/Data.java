package example.graphql.pojo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Data{

	@JsonProperty("exercises")
	private List<ExercisesItem> exercises;

	public void setExercises(List<ExercisesItem> exercises){
		this.exercises = exercises;
	}

	public List<ExercisesItem> getExercises(){
		return exercises;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"exercises = '" + exercises + '\'' + 
			"}";
		}
}