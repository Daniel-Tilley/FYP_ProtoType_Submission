<?php
class Database{
  //----------------------------------
  //REST API Was created with the help of
  //https://www.codeofaninja.com/2017/02/create-simple-rest-api-in-php.html
  //----------------------------------

  //define variables
  private $host = "";
  private $user = "";
  private $pass = "";
  private $database = "";
  public $con;

  // get the database connection
  public function getConnection(){
    $this->con = new mysqli($this->host, $this->user, $this->pass, $this->database);

  	if ($this->con->connect_error) {
      trigger_error('Database connection failed: '  . $this->db->connect_error, E_USER_ERROR);
      exit();
  	}

    return $this->con;
  }
}
?>
