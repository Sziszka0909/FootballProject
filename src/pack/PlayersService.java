package pack;

import java.sql.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.NavigationFilter;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.codehaus.jettison.json.JSONObject;
import org.json.JSONArray;

import com.google.gson.Gson;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import pack.Objects.*;

@Path("/PlayersService")
public class PlayersService {
	
	@GET
	@Path("/AllPlayerFromDataBase")
	public String AllPlayerFromDataBase(){
		ArrayList<Player> players = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/footballproject", "root", "admin");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM players");
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
