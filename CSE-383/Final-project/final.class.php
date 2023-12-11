<?php 
class final_rest {



/**
 * @api  /api/v1/setTemp/
 * @apiName setTemp
 * @apiDescription Add remote temperature measurement
 *
 * @apiParam {string} location
 * @apiParam {String} sensor
 * @apiParam {double} value
 *
 * @apiSuccess {Integer} status
 * @apiSuccess {string} message
 *
 * @apiSuccessExample Success-Response:
 *     HTTP/1.1 200 OK
 *     {
 *              "status":0,
 *              "message": ""
 *     }
 *
 * @apiError Invalid data types
 *
 * @apiErrorExample Error-Response:
 *     HTTP/1.1 200 OK
 *     {
 *              "status":1,
 *              "message":"Error Message"
 *     }
 *
 */
	
	public static function getProduct ($title, $subcategory, $id, $value, $min, $max) {
		try {
			if ($value == "priceASC") {
				$retData["result"] = GET_SQL("select * from product where upper(title) like upper(?) and subcategory like ? and (product_id = ? or ? = '0') and (price >= ?) and (price <= ?) order by cast(price as float)", $title, $subcategory, $id, $id, $min, $max);
			} else if ($value == "priceDESC") {
				$retData["result"] = GET_SQL("select * from product where upper(title) like upper(?) and subcategory like ? and (product_id = ? or ? = '0') and (price >= ?) and (price <= ?) order by cast(price as float) desc", $title, $subcategory, $id, $id, $min, $max);
			} else if ($value == "subcategory") {
				$retData["result"] = GET_SQL("select * from product where upper(title) like upper(?) and subcategory like ? and (product_id = ? or ? = '0') and (price >= ?) and (price <= ?) order by subcategory", $title, $subcategory, $id, $id, $min, $max);
			}

                        $retData["status"]=0;
                        $retData["message"]=`insert of ${title} for subcategory: ${subcategory} and id ${id} accepted`;
                } catch  (Exception $e) {
                        $retData["status"]=1;
                        $retData["message"]=$e->getMessage();
                }
               
                return json_encode ($retData);
	}

	public static function createShoppingCart() {
		EXEC_SQL("insert into cart (closedDateTime) values (null)");
		$retData["result"]=GET_SQL("select last_insert_rowid() as cartID");
		return json_encode ($retData);
	}

	public static function addItemToCart($cartId, $productId, $qty) {

		$CART=GET_SQL("select cart.CartID from cart where cart.CartID=? and cart.closedDateTime is null", $cartId);
		if (count($CART) > 0) {
			$ITEM=GET_SQL("select * from cartItems where CartID=? and product_id=?", $cartId, $productId);

			if (count($ITEM) > 0) {
				EXEC_SQL("update cartItems set qty=qty+? where CartID=? and product_id=?", $qty, $cartId, $productId);
				$retData["found"]=0;
				$retData["message"]="existing product $productId set to $qty";

			} else {
				EXEC_SQL("insert into cartItems (qty, CartID, product_id) values (?, ?, ?)", $qty, $cartId, $productId);
				$retData["found"]=0;
				$retData["message"]="product $productId added to cart = $qty";
			}
			
		} else {
			$retData["found"]=1;
			$retData["message"]="Cart not found or not available.";
		}
		return json_encode ($retData);
	}
	
	public static function removeCart($cartId, $productId) {
		$FOUND=GET_SQL("select cart.CartID from cart join cartItems using (CartID) where cart.CartID=? and product_id=? and cart.closedDateTime is null", $cartId, $productId);
		if (count($FOUND) > 0) {
			EXEC_SQL("delete from cartItems where CartID=? and product_id=?", $cartId, $productId);
			$retData["found"]=0;
			$retdata["message"]="found";
		} else {
			$retData["found"]=1;
			$retData["message"]="Not found";
		}
		return json_encode ($retData);
	}

	public static function getCartItems($cartId) {
		$retData["cart"]=GET_SQL("select * from cart join cartItems using (CartID) join product using (product_id) where cart.CartID=? and cart.closedDateTime is null order by category, subcategory, title", $cartId);

		$retdata["found"]=0;
		$retData["message"]="Returned all items in cart $cartId";
		return json_encode ($retData);
	}

	public static function makeSale($cartId) {
		$CART=GET_SQL("select cart.CartID from cart where cart.CartID=? and cart.closedDateTime is null", $cartId);
		if (count($CART) > 0) {
			EXEC_SQL("update cart set closedDateTime=CURRENT_TIMESTAMP where cartID=?", $cartId);
			$retData["found"]=0;
			$retData["message"]="closed cart $cartId";
		} else {
			$retdata["found"]=1;
			$retData["message"]="Cart not found or not available.";
		}
		return json_encode ($retData);
	}
	
	public static function findClosedCarts($cartId) {
		$retData["result"]=GET_SQL("select * from cart where CartID like ? and closedDateTime is not null order by closedDateTime desc", $cartId);
		$retData["closedcart"]=GET_SQL("select * from cart join cartItems using (CartID) join product using (product_id) where cart.CartID like ? and cart.closedDateTime is not null order by cart.closedDateTime desc", $cartId);
		return json_encode ($retData);
	}

	public static function setTemp ($location, $sensor, $value) {
		if (!is_numeric($value)) {
			$retData["status"]=1;
			$retData["message"]="'$value' is not numeric";
		}
		else {
			try {
				EXEC_SQL("insert into temperature (location, sensor, value, date) values (?,?,?,CURRENT_TIMESTAMP)",$location, $sensor, $value);
				$retData["status"]=0;
				$retData["message"]="insert of '$value' for location: '$location' and sensor '$sensor' accepted";
			}
			catch  (Exception $e) {
				$retData["status"]=1;
				$retData["message"]=$e->getMessage();
			}

		return json_encode ($retData);
		}
	}
}

