package pack;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;

import com.google.gson.annotations.JsonAdapter;

import pack.Objects.Player;

@Path("/ToDataBase")
public class ToDataBaseService {
	
	@POST
	@Path("/sendData")
	//@Consumes(MediaType.APPLICATION_JSON)
	public void sendDataToDataBase(Player player){
		System.out.println(player);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/footballproject", "root", "admin");
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO players VALUES(?, ?, ?, ?)");
			preparedStatement.setInt(1, 0);
			preparedStatement.setString(2, player.getPlayerName());
			preparedStatement.setString(3, player.getPlayerPosition());
			preparedStatement.setString(4, player.getPlayerClub());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Data updated to DB.");
	}

}
