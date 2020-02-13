<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
    import="it.contrader.dto.PacketDTO" import="it.contrader.dto.OsTypeDTO"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="../css/vittoriostyle.css" rel="stylesheet">
		<title>Edit Packet</title>
	</head>
		
	<body>
		<%@ include file="../css/header.jsp" %>
	
		
		<br>
		
		<div class="main">
		
		<%
			PacketDTO p = (PacketDTO) request.getAttribute("dto");
			OsTypeDTO o = (OsTypeDTO) request.getAttribute("dtoos");
			List<OsTypeDTO> listos = (List<OsTypeDTO>) request.getAttribute("listos");
		%>
		
		
		<form id="floatleft" action="PacketServlet?mode=update&id=<%=p.getId_pack()%>" method="post">
		
		  <div class="row">
		    <div class="col-25">
		      <label for="packet">Name</label>
		    </div>
		    
		    <div class="col-75">
		      <input type="text" id="packet" name="packetName" value=<%=p.getName()%>>
		    </div>
		    
		  </div>
		  
		  <div class="row">
		    <div class="col-25">
		     <label for="description">Description</label>
		    </div>
		    
		    <div class="col-75">
		      <input
					type="text" id="description" name="packetDescription" value=<%=p.getDescription()%>> 
		    </div>
		  </div>
		  
		  <select id="type" name="packetOstype" required>
			<option value="" disabled selected>Choose your option</option>
			<%
				for (OsTypeDTO singleo : listos) {
			%>
  				<option value="<%=singleo.getName()%>"><%=singleo.getName()%></option> 
			<%
				}
			%>
		</select>

		  <button type="submit" >Edit</button>
		  
		</form>
		
			
		</div>
		<br>
		<%@ include file="../css/footer.jsp" %>	
	</body>
</html>