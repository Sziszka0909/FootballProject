package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;

import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;

import pack.Objects.Player;

@Path("/FromDataBase")
public class FromDataBaseService {
	
	@GET
	@Path("/GetAllPlayer")
	public String getDataFromDataBase(String position){
		ArrayList<Player> players = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/footballproject", "root", "admin");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM players WHERE PlayerPosition = " + position + "");
			while(resultSet.next()){
				players.add(new Player(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(players);
		return json;
	}
	
	

}
