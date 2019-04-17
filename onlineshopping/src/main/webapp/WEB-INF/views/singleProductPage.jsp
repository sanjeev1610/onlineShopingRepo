<div class="container">

	<div class="row">

		<div class="col-xl-12">

			<ol class="breadcrumb">

				<li><a href="${contextRoot}/home">Home/</a>
				<li><a href="${contextRoot}/show/all/products">Products/</a></li>
				<li class="active">${product.name}</li>

			</ol>

		</div>

		<div class="row">

			<div class="col-xs-12 col-sm-4">

				<figure class="figure">

					<img src="${contextRoot}/resources/img/${product.code}.png"
						class="img-thumbnail" />
					<figcaption class="figure-caption text-center">${product.name}</figcaption>
				</figure>

			</div>


			<div class="col-xs-12 col-sm-8">

				<h3>${product.name}</h3>
				<hr>
				<p>${product.description}</p>
				<hr>
				<h4>Price: &#8377; ${product.unitPrice}</h4>

				<c:choose>

					<c:when test="${product.quantity<1}">

						<h6>
							Quantity Available: <span style="color: red">out of stock</span>
						</h6>


					</c:when>
					<c:otherwise>
						<h6>Quantity Available: ${product.quantity}</h6>

					</c:otherwise>

				</c:choose>

				<c:choose>

					<c:when test="${product.quantity<1}">

						<a href="javascript:void(0)" class="btn btn-success disabled"><strike>
								<i class="fas fa-cart-plus"></i>Add To Cart</strike></a>

					</c:when>
					<c:otherwise>
						<a href="${contextRoot}/cart/add/${product.id}/product"
							class="btn btn-success"> <i class="fas fa-cart-plus"></i>Add
							To Cart
						</a>
						<h6>Quantity Available: ${product.quantity}</h6>

					</c:otherwise>

				</c:choose>




				<a href="${contextRoot}/show/all/products" class="btn btn-success">Back</a>


			</div>

		</div>




	</div>










</div>