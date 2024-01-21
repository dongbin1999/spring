package study.graduate.dto.post;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class PostAddResponseDTO {

    private Long postId;
    private Long userId;
    private String postTitle;
    private String postContent;
}