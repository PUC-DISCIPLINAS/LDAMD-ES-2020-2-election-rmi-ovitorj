import java.io.Serializable;

@SuppressWarnings("serial")
public class Result implements Serializable {
	
	String name;
	int votes;
	
	public Result() {
		super();
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	
	
}