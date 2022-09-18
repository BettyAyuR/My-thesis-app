<?php
require "conn.php";

$namaibu = $_POST["namaibu"];
$namaayah = $_POST["namaayah"];
$namabayi = $_POST["namabayi"];
$usiabayi = $_POST["usiabayi"];

$sql = "SELECT * FROM biodata";

$query = mysqli_query($conn,$sql);
$sql_biodata = "INSERT INTO `biodata`(`namaibu`,`namaayah`,`namabayi`,`usiabayi`) VALUES 
('$namaibu','$namaayah','$namabayi','$usiabayi')";
if(mysqli_query($conn,$sql_biodata)){
				echo"Successfully";
			}
			else{
				echo "Failed";
			}

?>