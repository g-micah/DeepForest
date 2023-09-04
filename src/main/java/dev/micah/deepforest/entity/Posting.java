package dev.micah.deepforest.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Posting {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String title;
	private String content;
	private LocalDateTime lastModified;
	private boolean enabled;
		  
	public Posting() {
		super();
	}

	public Posting(String title, String content, boolean enabled) {
		super();
		this.title = title;
		this.content = content;
		this.enabled = enabled;
		this.lastModified = LocalDateTime.now();
	}
	
	public long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public LocalDateTime getLastModified() {
		return lastModified;
	}
	public void setLastModified(LocalDateTime lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, enabled, id, lastModified, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posting other = (Posting) obj;
		return Objects.equals(content, other.content) && enabled == other.enabled && id == other.id
				&& Objects.equals(lastModified, other.lastModified) && Objects.equals(title, other.title);
	}
	
	@Override
	public String toString() {
		return "Posting [id=" + id + ", title=" + title + ", content=" + content + ", lastModified=" + lastModified
				+ ", enabled=" + enabled + "]";
	}
}
