package example.graphql.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdvExerciseResult{

	@JsonProperty("data")
	private Data data;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"AdvExerciseResult{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}