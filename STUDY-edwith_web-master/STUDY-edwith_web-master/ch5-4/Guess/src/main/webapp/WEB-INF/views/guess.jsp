<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>GUESS!</title>
		<style>
			*{
				position: relative;
				margin: 0;
				passing: 0;
				box-sizing: border-box;
			}
			
			body{
				background-color: #f4c900;
			}
			
			.container{
				margin: auto;
				text-align: center;
			}
			
			.outer{
				margin-top: 40px;
			}
			
			.outer > h1{
				font-size: 40px;
				color: white;
			}
			
			.inner{
				margin-top: 40px;
				padding: 40px;
				width: 300px;
				background-color: white;
				border: 1px solid gray;
			}
			
			.message{
				height: 200px;
				font-size: 60px;
				font-weight: bold;
				line-height: 200px;
			}
			
			.input{
				margin-top: 20px;
				height: 200px;
			}
			
			.input input{
				padding: 40px;
				width: 100%;
				height: 100%;
				color: gray;
				font-size: 60px;
				font-weight: bold;
				border: none;
				border-bottom: 2px solid black;	
				text-align: center;
			}
			
			.input input:focus{
				outline: none;
			}
		</style>
	</head>
	<body>
		<div class="container outer">
			<h1>[GUESS]</h1>
			<div class="container inner">
				<div class="container message">
					${message}
				</div>
				<div class="container input">
					<form action="submit" method="post">
						<input type="text" name="number" pattern="^\d+$" required autofocus/>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
