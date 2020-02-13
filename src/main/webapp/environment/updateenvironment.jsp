<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
    import="it.contrader.dto.PacketDTO" import="it.contrader.dto.EnvironmentDTO" import="it.contrader.dto.CategoryDTO"%>
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
			EnvironmentDTO e = (EnvironmentDTO) request.getAttribute("dto");

			List<PacketDTO> listp = (List<PacketDTO>) request.getAttribute("listp");
			List<CategoryDTO> listc = (List<CategoryDTO>) request.getAttribute("listc");

		%>
		
		
		<form id="floatleft" action="EnvironmentServlet?mode=update&id=<%=e.getId_env()%>" method="post">
		
		  <div class="row">
		    <div class="col-25">
		      <label for="packet">Name</label>
		    </div>
		    
		    <div class="col-75">
		      <input type="text" id="environment" name="environmentName" value=<%=e.getName()%>>
		    </div>
		    
		  </div>
		  
		  <div class="row">
		    <div class="col-25">
		     <label for="description">Description</label>
		    </div>
		    
		    <div class="col-75">
		      <input
					type="text" id="description" name="environmentDescription" value=<%=e.getDescription()%>> 
		    </div>
		  </div>
		  
		  <select id="type" name="environmentPacket" required>
			<option value="" disabled selected>Choose your option</option>
			<%
				for (PacketDTO pdto : listp) {
			%>
  				<option value="<%=pdto.getName()%>"><%=pdto.getName()%></option> 
			<%
				}
			%>
		</select>
		
		
		  <select id="type" name="environmentCategory" required>
			<option value="" disabled selected>Choose your option</option>
			<%
				for (CategoryDTO cdto : listc) {
			%>
  				<option value="<%=cdto.getName()%>"><%=cdto.getName()%></option> 
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