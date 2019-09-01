<?php
$host = "localhost";
$user_name = "root";
$user_password = "";
$db_name = "MobcoursesAppdb";

$con = mysqli_connect($host,$username,$user_password,$db_name);

if($con)
echo "Connection success...";
else
echo "Connection Failed";


?>
