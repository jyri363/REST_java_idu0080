<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="uri" value="${req.requestURI}" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
         <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
        <script src="resources/app.js"></script>
    </head>
    <body>
        <h1>REST World!</h1>
        <a href=${uri}>Maalid</a>
      <form>
      <input type=button value="Koik maalid" onClick="javascript:get_paintings()">
      
      
      <br><br>
      <table bgcolor=000000>
      <tr><td bgcolor=cccccc>Teated</td></tr>
      <tr><td bgcolor=ffffff><div id="msg_text"> </div></td></tr>
      </table> 
      <br>
      <div id="one_painting"></div> 
      <br><br>
      <div id="paintings_table"></div>
      <br> 
      
      <br><br>
      <table bgcolor=eeeeee><tr><td>Lisamine:</td></tr>
		<tr><td>Maal:</td><td><input type=text name=new_painting_artname value=''></td></tr>
      	<tr><td>Autor:</td><td><input type=text name=new_painting_author value=''></td></tr>
      	<tr><td>Tehnima:</td><td><input type=text name=new_painting_techniques value=''></td></tr>
      	<tr><td>Aasta:</td><td><input type=text name=new_painting_year value=''></td></tr>
      	<tr><td><input type=button value="lisa" onClick="javascript:add_painting()"></td></tr>
	</table>	  
	  </form>

    </body>
</html>
