$(document).ready(function() {
	$.ajax({
		type: "GET",
		url: "/FootballProject/service/PlayersService/AllPlayerFromDataBase",
		success: function(data){
			var Json = jQuery.parseJSON(data);
			$.each(Json, function (ArrayId, Player){
				$(".players").append("<tr><td>" + Player.playerName + "</td><td>" + Player.playerClub + "</td><td>" + Player.playerPosition + "</td></tr>");
			})

		}
	})
})