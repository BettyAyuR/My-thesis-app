<?php
require "conn.php";

$get_namabayi = isset ($_POST['get_namabayi']) ? $_POST['get_namabayi'] : '';
$get_hasil_diagnosa = isset ($_POST['get_hasil_diagnosa']) ? $_POST['get_hasil_diagnosa'] : '';
$get_pengobatan = isset ($_POST['get_pengobatan']) ? $_POST['get_pengobatan'] : '';


if (empty ($get_namabayi) || empty($get_hasil_diagnosa) || empty($get_pengobatan)){
	echo "Kolom isian tidak boleh kosong";
} else {
	$query = mysqli_query ($conn, "INSERT INTO riwayat_penyakit (id, get_namabayi, get_hasil_diagnosa, get_pengobatan) 
		VALUES (0, '".$get_namabayi."','".$get_hasil_diagnosa."', '".$get_pengobatan."')");
	if ($query){
		echo "Data berhasil di simpan";
	} else {
		echo "Error simpan data";
	}
}
?>