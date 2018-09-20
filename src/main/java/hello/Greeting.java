package hello;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting {

	private final long id;
	
	@JsonProperty(value = "greetingContent")
	private final String content;

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
