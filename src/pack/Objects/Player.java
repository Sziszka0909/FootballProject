package pack.Objects;

public class Player {
	
	private int PlayerIndex;
	private String playerName;
	private String playerPosition;
	private String playerClub;
	
	public Player(int playerIndex, String playerName, String playerPosition, String playerClub) {
		super();
		PlayerIndex = playerIndex;
		this.playerName = playerName;
		this.playerPosition = playerPosition;
		this.playerClub = playerClub;
	}
	
	public Player(){
		
	}

	public int getPlayerIndex() {
		return PlayerIndex;
	}

	public String getPlayerName() {
		return playerName;
	}

	public String getPlayerPosition() {
		return playerPosition;
	}

	public String getPlayerClub() {
		return playerClub;
	}
	
	

	public void setPlayerIndex(int playerIndex) {
		PlayerIndex = playerIndex;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void setPlayerPosition(String playerPosition) {
		this.playerPosition = playerPosition;
	}

	public void setPlayerClub(String playerClub) {
		this.playerClub = playerClub;
	}

	@Override
	public String toString() {
		return "Player [PlayerIndex=" + PlayerIndex + ", PlayerName=" + playerName + ", PlayerPosition="
				+ playerPosition + ", PlayerClub=" + playerClub + "]";
	}
	
	

}
