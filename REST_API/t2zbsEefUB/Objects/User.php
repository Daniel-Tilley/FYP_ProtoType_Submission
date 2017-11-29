<?php
class User{
    //----------------------------------
    //REST API Was created with the help of
    //https://www.codeofaninja.com/2017/02/create-simple-rest-api-in-php.html
    //----------------------------------

    // database connection and table name
    private $con;
    private $table_name = "Users";

    // object properties
    public $id;
    public $password;
    public $f_name;
    public $l_name;
    public $e_mail;
    public $phone_number;
    public $dob;
    public $type;
    public $bio;
    public $updateList;

    // constructor with $db as database connection
    public function __construct($db){
        $this->con = $db;
    }

    // read products
    function GetUser(){

      $sql = $this->con->prepare('SELECT * FROM ' . $this->table_name . ' WHERE Id LIKE ?');
      $sql->bind_param('s', $this->id);

      if(!$sql->execute()){
        $sql->close();
        $this->con->close();
    		die('Connect Error (' . $con->connect_errno . ') ');
    	}

      $result = $sql->get_result();
	    $sql->close();

      if($result){
    		if($result->num_rows != 0){

          $userArray["users"] = array();

    			while($data = $result->fetch_assoc()){
    				array_push($userArray["users"], $data);
    			}

          $this->con->close();
    			return $userArray;
    		}
        else{
          $this->con->close();
          return null;
        }
    	}
    }

    function CreateUser(){
      if ($this->dob != null){
        $this->dob = date("Y-m-d",strtotime($this->dob));
      }

      $sql = $this->con->prepare('INSERT INTO ' . $this->table_name . ' VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)');
      $sql->bind_param('sssssssss',
      $this->id,
      $this->password,
      $this->f_name,
      $this->l_name,
      $this->e_mail,
      $this->phone_number,
      $this->dob,
      $this->type,
      $this->bio);

      if(!$sql->execute()){
        $sql->close();
        $this->con->close();
    		return false;
    	}

      if($sql->affected_rows > 0){
        $sql->close();
        $this->con->close();
        return true;
    	}
      else{
        $sql->close();
        $this->con->close();
        return false;
      }
    }

    function UpdateUser(){
      $quer = "UPDATE " . $this->table_name . " SET";
      $comma = " ";

      $this->dob = date("Y-m-d",strtotime($this->dob));

      //----------------------------------------------
      // Idea for dynamic upating takin from:
      // https://stackoverflow.com/questions/25683760/how-to-dynamically-generate-mysql-update-statement-based-on-defined-variables-fr
      //----------------------------------------------
    
      foreach($this->updateList as $key => $val) {
        if ($key != "id"){
          if($key == "dob"){
            $val = date("Y-m-d",strtotime($val));
          }

          if(is_string($val)){
            if($val == "NULL"){
              $quer .= $comma . $key . " = " . $val . "";
            }
            else{
              $quer .= $comma . $key . " = '" . $val . "'";
            }
          }
          else{
            $quer .= $comma . $key . " = " . $val . "";
          }

          $comma = ", ";
        }
      }

      $quer .= " WHERE Id LIKE ? ";

      $sql = $this->con->prepare($quer);
      $sql->bind_param('s',$this->updateList->id);

      if(!$sql->execute()){
        $sql->close();
        $this->con->close();
    		return false;
    	}

      if($sql->affected_rows > 0){
        $sql->close();
        $this->con->close();
        return true;
    	}
      else{
        $sql->close();
        $this->con->close();
        return false;
      }
    }
}
?>
