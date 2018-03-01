var painting_from_server;


function Painting()
{
this.author;
this.artname;
this.techniques;
this.year;
}

function get_paintings()
{

 
$.ajaxSetup({ cache: false });
$.ajax({

    url: 'service/paintings' ,
    type: "GET",
    dataType: 'json',
    success: function(data) {
    	display_paintings(data);
        console.log(JSON.stringify(data));

    }
  });


}


function get_painting(id)
{

 
$.ajaxSetup({ cache: false });
$.ajax({

    url: 'service/painting/' + id ,
    type: "GET",
    dataType: 'json',
    success: function(data) {
    	painting_from_server = data;
    	display_painting(data);
        console.log(JSON.stringify(data));

    }
  });


}

function delete_painting(id)
{
	$.ajaxSetup({ cache: false });
	$.ajax({
		url: 'service/painting/' + id,
		type: "DELETE",
		contentType: 'application/json',
		success: function(data) {
			show_message("Kustutatud");
			get_paintings();
			console.log(JSON.stringify(data));
		}
	});
}

function save_painting()
{
	
	painting_from_server.author=document.forms[0].author.value;
	painting_from_server.artname=document.forms[0].artname.value;
	painting_from_server.techniques=document.forms[0].techniques.value;
	painting_from_server.year=document.forms[0].year.value;
		
var jsonData = JSON.stringify(painting_from_server); 
$.ajaxSetup({ cache: false });
$.ajax({

    url: 'service/painting/' + painting_from_server.id ,
    type: "POST",
    data: jsonData,
    dataType: 'json',
    contentType : 'application/json',
    success: function(data) {
    	show_message("Salvestatud");
        console.log(JSON.stringify(data));

    }
  });


}


function add_painting()
{
	var painting_to_server = new Painting();
	painting_to_server.author=document.forms[0].new_painting_author.value;
	painting_to_server.artname=document.forms[0].new_painting_artname.value;
	painting_to_server.techniques=document.forms[0].new_painting_techniques.value;
	painting_to_server.year=document.forms[0].new_painting_year.value;
	show_message("ssaa");
	var jsonData = JSON.stringify(painting_to_server);
	$.ajaxSetup({ cache: false });
	$.ajax({
		url: 'service/painting/' ,
		type: "PUT",
		data: jsonData,
		dataType: 'json',
		contentType : 'application/json',
		success: function(data) {
			show_message("Sisestatud");
			console.log(JSON.stringify(data));
			get_paintings();
 }
 });
}




function display_painting(painting)
{
	 var out_data="";
	 out_data = out_data + "<table bgcolor=eeeeee><tr><td>Muutmine. id: <b>" + painting.id + "</b></td></tr>";

		out_data = out_data + "<tr><td>Autor:</td><td><input type=text name=author value='" + painting.author + "'></td></tr>";
		out_data = out_data + "<tr><td>Nimi:</td><td><input type=text name=artname value='" + painting.artname + "'></td></tr>";
		out_data = out_data + "<tr><td>Tehnika:</td><td><input type=text name=techniques value='" + painting.techniques + "'></td></tr>";
		out_data = out_data + "<tr><td>Aasta:</td><td><input type=text name=year value='" + painting.year + "'></td></tr>";
		out_data = out_data + "<tr><td><button type='button' class='btn'  onClick='javascript:save_painting()'>Salvesta</button></td>";
		out_data = out_data + "<td><button type='button' class='btn'  onClick='javascript:delete_painting(" + painting.id + ")'>Kustuta</button></td></tr>";
		out_data = out_data + "</table>";

	

	
	 $("#one_painting").html(out_data);
}




function display_paintings(data)
{
	var out_data="";
	 out_data = out_data + "<table bgcolor=eeeeee><tr><td colspan=4>Maale kokku: <b>" + data.length + "</b></td></tr>";
	 for(var  i in data) {
   	  var painting = data[i];
		out_data = out_data + "<tr><td>autor:</td><td bgcolor=ffffff>" + painting.author + "</td><td>Maali nimi:</td><td bgcolor=ffffff>" + painting.artname + "</td>";
		out_data = out_data + "<td><button type='button' class='btn'  onClick='javascript:get_painting(" + painting.id + ")'>Vali</button></td>";
		out_data = out_data + "<td><button type='button' class='btn'  onClick='javascript:delete_painting(" + painting.id + ")'>Kustuta</button></td></tr>";
		
	 }
	 out_data = out_data + "</table>";

	
	 $("#paintings_table").html(out_data);
}


function show_message(message)
{
	
	 $("#msg_text").html(message);
}
