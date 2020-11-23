<html lang="en">
<head>
  <meta charset="utf-8">
	<title>custmer-form</title>
    <link rel="stylesheet" type="text/css"
            			  href="${pageContext.request.contextPath}/resource/css/form.css">
  </head>
<body>

		<div class="form-style">
		<div class="form-style-heading">Provide Item Details</div>

			<form action="${pageContext.request.contextPath}/updateItem?itemId=${item.id}&userId=${userId}" method="post">

                <label for="iimage"><span>Item image:</span>
                <input type="text" class="input-field"  name="url" value="${item.url}"><br>
				</label>

                <label for="iname"><span>Item name:</span>
                <input type="text" class="input-field"  name="name" value="${item.name}"><br>
				</label>

                <label for="iprice"><span>Item Price:</span>
                <input type="text" class="input-field"  name="price" value="${item.price}"><br><br>
				</label>

                <label><span> </span><input type="submit" value="Submit" />
				</label>

			</form>
		</div>
</body>
</html>