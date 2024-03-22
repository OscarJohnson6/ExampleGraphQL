package example.graphql.pojo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExercisesItem{

	@JsonProperty("instructions")
	private String instructions;

	@JsonProperty("primaryMuscles")
	private List<String> primaryMuscles;

	@JsonProperty("name")
	private String name;

	@JsonProperty("force")
	private String force;

	@JsonProperty("type")
	private String type;

	@JsonProperty("movement")
	private String movement;

	public void setInstructions(String instructions){
		this.instructions = instructions;
	}

	public String getInstructions(){
		return instructions;
	}

	public void setPrimaryMuscles(List<String> primaryMuscles){
		this.primaryMuscles = primaryMuscles;
	}

	public List<String> getPrimaryMuscles(){
		return primaryMuscles;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setForce(String force){
		this.force = force;
	}

	public String getForce(){
		return force;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setMovement(String movement){
		this.movement = movement;
	}

	public String getMovement(){
		return movement;
	}

	@Override
 	public String toString(){
		return 
			"ExercisesItem{" + 
			"instructions = '" + instructions + '\'' + 
			",primaryMuscles = '" + primaryMuscles + '\'' + 
			",name = '" + name + '\'' + 
			",force = '" + force + '\'' + 
			",type = '" + type + '\'' + 
			",movement = '" + movement + '\'' + 
			"}";
		}
}