<?php
  //----------------------------------
  //REST API Was created with the help of
  //https://www.codeofaninja.com/2017/02/create-simple-rest-api-in-php.html
  //----------------------------------

  header("Access-Control-Allow-Origin: *");
  header("Content-Type: application/json; charset=UTF-8");
  header("Access-Control-Allow-Methods: POST");
  header("Access-Control-Max-Age: 3600");
  header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

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
  $user->updateList = json_decode(file_get_contents("php://input"));

  // query users
  $result = $user->UpdateUser();

  if ($result){
    echo json_encode(new Response(200, "Ok", "User Updated"));
  }
  else{
    echo json_encode(new Response(404, "Error", "User Not Updated"));
  }
?>
