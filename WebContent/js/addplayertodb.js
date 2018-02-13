$(document).ready(function(){
	$(".sendbutton").click(function() {
		var playerName = $(".playername").val();
		var playerClub = $(".playerclub").val();
		var playerPosition = $(".playerposition").val();
		$.ajax({
			method: "POST",
			url: "/FootballProject/service/ToDataBase/sendData",
			dataType : "application/json",
		    contentType: "application/json; charset=utf-8",
			data: JSON.stringify({playerName: playerName, playerPosition: playerPosition, playerClub :playerClub})
		})
		//$.post("/FootballProject/service/ToDataBase/sendData", {playerName, playerPosition, playerClub}, function(){}, "json")
		console.log("Data sent.")
	})
})