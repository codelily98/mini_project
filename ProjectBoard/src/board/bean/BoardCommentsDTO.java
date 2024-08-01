package board.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BoardCommentsDTO {
	private int boardCommentsID;
    private int boardPostsID;
    private int usersStatusID;
    private String content;
    private java.sql.Timestamp createdAt;
}
