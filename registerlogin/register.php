<?php 
require "conn.php";

$username = $_POST["username"];
$email = $_POST["email"];
$password = $_POST["psw"];
$mobile = $_POST["mobile"];
$gender = $_POST["gender"];

/*$username = "Dita";
$email = "Dita@gmail.com";
$password = "123456";
$mobile = "082178900000";
$gender = "Female";*/

$isValidEmail=filter_var($email, FILTER_VALIDATE_EMAIL);
if($conn){
	if (strlen($password)>40 || strlen($password)<6){
		echo "Password must be less than 40 and more than 6 charachters";
	}else if($isValidEmail === false){

		echo "This email is not valid";
	} 
	else{
		$sqlCheckUsername ="SELECT*FROM`users_table`WHERE`username`LIKE'$username'";
		$usernameQuery = mysqli_query($conn,$sqlCheckUsername);

		$sqlCheckEmail ="SELECT*FROM`users_table`WHERE`email` LIKE '$email'";
		$usernameQuery = mysqli_query($conn,$sqlCheckEmail);

		if (mysqli_num_rows($usernameQuery)>0){
			echo"Username is allready use, type another one";
		}else if(mysqli_num_rows($usernameQuery)>0){
			echo"This email is allready registered, Type another Email";
		}

		else{
			$sql_register = "INSERT INTO`users_table`(`username`,`email`,`password`,`mobile`,`gender`) VALUES
			('$username','$email','$password','$mobile','$gender')";

			if(mysqli_query($conn,$sql_register)){
				echo"Successfully Registered";
			}
			else{
				echo"Failed to Register";

			}
		}
	}
}

else{
	echo"Connection Error";
}

?>