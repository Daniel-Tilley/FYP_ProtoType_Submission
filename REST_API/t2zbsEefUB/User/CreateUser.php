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
  $data = json_decode(file_get_contents("php://input"));

  // set ID property of product to be edited
  $user->id = $data->Id;
  $user->password = $data->Password;
  $user->f_name = $data->F_Name;
  $user->l_name = $data->L_Name;
  $user->e_mail = $data->E_Mail;
  $user->phone_number = $data->Phone_Number;
  $user->dob = $data->DOB;
  $user->type = $data->Type;
  $user->bio = $data->Bio;

  // query users
  $result = $user->CreateUser();

  if ($result){
    echo json_encode(new Response(200, "Ok", "User Created"));
  }
  else{
    echo json_encode(new Response(404, "Error", "User Not Created"));
  }
?>
