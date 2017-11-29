<?php
//----------------------------------
//REST API Was created with the help of
//https://www.codeofaninja.com/2017/02/create-simple-rest-api-in-php.html
//----------------------------------

// required headers
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: access");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Allow-Credentials: true");
header('Content-Type: application/json');

// include database and object files
include_once '../Config/Database.php';
include_once '../Objects/User.php';
include_once '../Objects/Response.php';

// instantiate database and product object
$database = new Database();
$db = $database->getConnection();

// initialize object
$user = new User($db);

// get id of product to be edited
$data = json_decode(file_get_contents("php://input"));

// set ID property of product to be edited
$user->id = $data->id;

// query users
$result = $user->GetUser();

if ($result != null){
  echo json_encode(new Response(200, "Ok", $result));
}
else{
  echo json_encode(new Response(404, "Error", $result));
}
?>
