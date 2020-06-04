package discussion.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Subreddit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Subreddit name is required")
	private String name;
	
	@NotBlank(message="Description is required")
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Post> posts;
	
	private Instant createDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
}
