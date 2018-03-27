<head>
<link rel="shortcut icon" href="../images/vendor.png" />
</head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.navbar {
	overflow: hidden;
	background-color: #333;
	font-family: Arial;
}

.navbar a {
	float: right;
	font-size: 16px;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

.dropdown {
	float: left;
	overflow: hidden;
}

.dropdown .dropbtn {
	font-size: 16px;
	border: none;
	outline: none;
	color: white;
	padding: 14px 16px;
	background-color: inherit;
}

.navbar a:hover,.dropdown:hover .dropbtn {
	background-color: red;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: white;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}
</style>


<div class="navbar">

	<div class="dropdown">
		<button class="dropbtn">
			HOME 
		</button>
	</div>

	<!-- Location Menu options -->
	<div class="dropdown">
		<button class="dropbtn">
			Location <i class="fa fa-caret-down"></i>
		</button>
		<div class="dropdown-content">
			<a href="regLocation">Register</a> <a href="getLocations">View
				All</a> <a href="locReport">Charts</a>
		</div>
	</div>
	<!-- Location Menu END -->


	<!-- VENDOR Menu options -->
	<div class="dropdown">
		<button class="dropbtn">
			Vendor <i class="fa fa-caret-down"></i>
		</button>
		<div class="dropdown-content">
			<a href="regVendor">Register</a> <a href="getAll">View All</a>
		</div>
	</div>
	<!-- VENDOR Menu options END -->

	<div class="dropdown">
		<button class="dropbtn">
			Customer <i class="fa fa-caret-down"></i>
		</button>
		<div class="dropdown-content">
			<a href="regCustomer">Register</a> <a href="getAllCustomers">View
				All</a>
		</div>
	</div>

	<div class="dropdown">
		<button class="dropbtn">
			Items <i class="fa fa-caret-down"></i>
		</button>
		<div class="dropdown-content">
			<a href="regItem">Register</a> <a href="getAllItems">View All</a>
		</div>
	</div>

	<div class="dropdown">
		<button class="dropbtn">
			Orders <i class="fa fa-caret-down"></i>
		</button>
		<div class="dropdown-content">
			<a href="regOrder">Register</a> <a href="getAllOrders">View All</a>
		</div>
	</div>

	<div class="dropdown">
		<button class="dropbtn">
			Document <i class="fa fa-caret-down"></i>
		</button>
		<div class="dropdown-content">
			<a href="regDocument">Documents</a>
		</div>
	</div>

	<div align="right">
		<a href="logout">LogOut</a>
	</div>
	<div>
		<a href="getAllOrders">Profile</a>
	</div>
</div>
<div align="right">Current Logged in User: ${username}</div>