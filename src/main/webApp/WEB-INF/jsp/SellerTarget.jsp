<html>
<head>
    <title>Seller Target</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/sellerTargetSubmit?user=${user}", method="post">
        <select>
         <c:forEach var="item" items="${itemList}">
            <option name="itemId" value=${item.id}>${item.name}</option>
             </c:forEach>
         </select>
        <label for="targetQuantity">Quantity: </label>
        <input type="number" id="quantity" name="targetQuantity">

        <button type="submit">Save</button>
    </form>
</body>
</html>