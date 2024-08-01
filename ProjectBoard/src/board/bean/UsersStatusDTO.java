package board.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsersStatusDTO {
	private int usersStatusID;
	private String userID;
	private String password;
	private String username;
	java.sql.Timestamp createdAt;
}
