var URL = "final.php"
var currentCartID = "";
var amtInCart = 0;

$(document).ready(function() {
	displayItems("/getProduct?title=%&subcategory=%&id=0&value=subcategory&min=0&max=%");
	makeCart();
	orderHistory('%', '', '', '');
	console.log("ready!");
});

function viewCart() {
	a = $.ajax({
		url: URL + "/getCartItems?cartId=" + currentCartID,
		method: "GET"
	}).done(function(data) {
		var len = data.cart.length;
		$("#itemsInCart").empty();
		
		var total = 0;
		amtInCart = 0;

		$("#itemsInCart").append("<table><th>Order #" + currentCartID + "</th></table>")
		$("#itemsInCart").append("<hr><table><tr><td id='itemName'><b>Item Name</b></td><td id='itemQty'><b>Quantity</b></td><td id='itemPrice'><b>Price</b></td><td id='rmButton'></td></tr></table>");

		for (var i = 0; i < len; i++) {
			var qtyPrice = (data.cart[i].price * data.cart[i].qty);
			$("#itemsInCart").append("<tr><td id='itemName'>" + data.cart[i].title + "</td><td id='itemQty'>" + data.cart[i].qty + "</td><td id='itemPrice'>" + qtyPrice.toFixed(2) + "</td><td id='rmButton'><button type='button' class='btn-sm' onclick='removeFromCart(" + data.cart[i].product_id + ")'>Remove</button></tr>");
			total += qtyPrice;
			amtInCart = amtInCart + parseInt(data.cart[i].qty);
		}
			
		$("#itemsInCart").append("</table><hr><table><tr><td id='itemName'></td><td id='itemQty'><b>Total</b></td><td id='itemPrice'><b>$" + total.toFixed(2) + "</b></td><td id='rmButton'></td></table>");

		if (len === 0) {
                        $("#itemsInCart").html("There are no items in your cart.");
                }
		
		$("#cartArea").html("<h4 class='my-1'>" + amtInCart + " item(s) in cart.</h4><button type='button' class='btn btn-info my-1 ms-auto' data-bs-toggle='modal' data-bs-target='#viewCart' onclick='viewCart()'>View Cart</button>");

	}).fail(function(error) {
		alert("A problem occurred when loading your cart.");
	});
}


// Function to print order history.
// Accepts a number input, number limit, after and before date.
function orderHistory(x, limit, after, before) {
	
	
	if (x === "") {
		x = "%";
	}

	a = $.ajax({
		url: URL + "/findClosedCarts?cartId=" + x,
		method: "GET"
	}).done(function(data) {
		
		$("#orderHistory").empty();
		
		if (limit === "") {
			limit = data.result.length;
		}
		
		$("#orderHistory").append("<h4 class='mb-4'>Results:</h4>");

		var yes;
		if (limit === 0) {
			yes = true;
			$("#orderHistory").append("<h4>No results found!</h4>");
		}

		for (var i = 0; i < limit; i++) {
				
				if (after != '' || before != '') {
					if (data.result[i].closedDateTime < after || data.result[i].closedDateTime > before) {
						continue;
					}
				}

				$("#orderHistory").append("<h4>Order #" + data.result[i].CartID + "</h4><p>Closed on " + data.result[i].closedDateTime + ".<button type='button' class='btn btn-secondary mx-5' data-bs-toggle='collapse' data-bs-target='#order" + data.result[i].CartID + "' aria-expanded='false' aria-controls='order" + data.result[i].CartID + "'>View Details</button></p><div class='collapse' id='order" + data.result[i].CartID + "'><div id='orderDetails" + data.result[i].CartID + "' class='card card-body mb-2'></div></div>");
				yes = true;	

		}

		if (!yes) {
			$("#orderHistory").append("<h4>No results found!</h4>");
		}

		var len = data.closedcart.length;
		var totalPrice = 0;
		var totalQty = 0;
		var prevId = data.closedcart[0].CartID;
		for (var i = 0; i < len; i++) {
			
			if (prevId != data.closedcart[i].CartID) {
				$("#orderDetails" + prevId).append("<p><b>Price: " + totalPrice.toFixed(2) + "</b><br><b># of Items: " + totalQty + "</b><p>");
                                prevId = data.closedcart[i].CartID;
                                totalPrice = 0;
                                totalQty = 0;
			}
			 console.log(totalPrice);
                         totalPrice += parseFloat(data.closedcart[i].price * data.closedcart[i].qty);
                         totalQty += parseInt(data.closedcart[i].qty);
		}

		$("#orderDetails" + prevId).append("<p><b>Price: " + totalPrice.toFixed(2) + "</b><br><b># of Items: " + totalQty + "</b><p>");

	}).fail(function(err) {
		alert("A problem occured while attempting to display order history.");
	});
}

function makeCart() {
	a = $.ajax({
		url: URL + "/createShoppingCart?",
		method: "GET"
	}).done(function(data) {
		currentCartID = data.result[0].cartID;
	}).fail(function(error) {
		alert("A problem occurred when creating a new cart.");
	});
}

function addToCart(x) {
	document.getElementById("cartmsg").style.visibility = "visible";

	if (document.getElementById("cartmsg").style.visibility === "hidden") {
		document.getElementById("cartmsg").style.visibility = "visible";
	}

	a = $.ajax({
		url: URL + "/addItemToCart?",
		method: "POST",
		data: {
			cartId: currentCartID,
			productId: x,
			qty: 1
		}	
	}).done(function(data) {
		amtInCart++;
		$("#cartArea").html("<h4 class='my-1'>Added " + amtInCart + " item(s) to cart!</h4><button type='button' class='btn btn-info my-1 ms-auto' data-bs-toggle='modal' data-bs-target='#viewCart' onclick='viewCart()'>View Cart</button>");
	}).fail(function(err) {
		alert("A problem occured when adding item(s) to cart.");
	});
}

function removeFromCart(x) {
	
	a = $.ajax({
		url: URL + "/removeCart?",
		method: "POST",
		data: {
			cartId: currentCartID,
			productId: x
		}
	}).done(function(data) {
		amtInCart--;
		$("#cartArea").html("<h3 class='my-1'>" + amtInCart + " item(s) in cart.</h3><button type='button' class='btn btn-info my-1 ms-auto' data-bs-toggle='modal' data-bs-target='#viewCart' onclick='viewCart()'>View Cart</button>");
		viewCart();
	}).fail(function(err) {
		alert("A problem occured when adding item(s) to cart.");
	});
}

function closeSale() {
	
	a = $.ajax({
		url: URL + "/makeSale?",
		method: "POST",
		data: { cartId: currentCartID } 
	}).done(function(data) {
		var date = new Date();
		$("#itemsInCart").html("<h1>Order Placed, Thanks!</h1><p>Order processed on " + date + ".</p><br><p>Head over to <a href='myorders.html'>My Orders</a> to view your purchase.</p>");
		$("#orderSum").empty();
		$("#panel").html("<a class='btn btn-primary' href='myorders.html'>View My Orders</a>");
	}).fail(function(err) {
		alert("A problem occured when attempting to confirm your order.");
	});
}

function displayItems(appendURL) {
	a = $.ajax({
		url: URL + appendURL,
		method: "GET"
	}).done(function(data) {
		var len = data.result.length;
		$("#items").empty();

		for (var i = 0; i < len; i++) {
			var x = data.result[i].description;

			if (x === "") {
				x = "There is no description for this item.";	
			}

			$("#items").append("<div id='" + data.result[i].product_id + "'class='card my-2 me-3' style='width: 18rem;'><img class='card-img-top' src='" + data.result[i].image + "' alt='storeItem'><div class='card-body'><h5 class='card-title'>" + data.result[i].title + " (" + data.result[i].price + ")</h5><p class='card-text'>" + x + "</p><button type='button' class='btn btn-primary' onclick='addToCart(document.getElementById(" + data.result[i].product_id +").id)'>Add to Cart</button></div></div>");

		}
		if (len === 0) {
			$("#items").append("<h5>No Results Found!</h5>");
		}

	}).fail(function(error) {
		document.write("an error has occured.");
	});
}

function searchItem() {
	var i = 0;
	var x = document.getElementById("srch").value;
	var filter = document.getElementsByName("filter");
	var y = "%";
	
	for (var i = 0; i < filter.length; i++) {
		if (filter[i].checked) {
			y = filter[i].value;
		}
	}

	if (x === "") {
		x = "%";
	}

	var z = document.getElementById("sortBy").value;
	
	var mn = document.getElementById("min").value;
	var mx = document.getElementById("max").value;
	
	if (mn === "") {
		mn = "0";
	}

	if (mx === "") {
		mx = "%";
	}

	displayItems(`/getProduct?title=${x}&subcategory=${y}&id=0&value=${z}&min=${mn}&max=${mx}`);

}
















