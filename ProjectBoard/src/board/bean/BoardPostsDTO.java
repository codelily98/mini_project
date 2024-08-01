package board.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BoardPostsDTO {
	private int boardPostsID;
    private int usersStatusID;
    private String title;
    private String content;
    private java.sql.Timestamp createdAt;
    private java.sql.Timestamp updatedAt;
}
