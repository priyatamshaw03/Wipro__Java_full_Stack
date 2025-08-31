<?php
header('Content-Type: application/json');

// Database credentials
$servername = "localhost";
$username = "your_username"; // Replace with your MySQL username
$password = "your_password"; // Replace with your MySQL password
$dbname = "your_database_name"; // Replace with your database name

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die(json_encode(['status' => 'error', 'message' => 'Connection failed: ' . $conn->connect_error]));
}

// Check if email already exists (AJAX validation)
if (isset($_POST['check_email'])) {
    $email = $_POST['email'];
    $sql = "SELECT Email FROM XYZ_PROFILE WHERE Email = ?";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("s", $email);
    $stmt->execute();
    $stmt->store_result();
    
    if ($stmt->num_rows > 0) {
        echo json_encode(['status' => 'exists']);
    } else {
        echo json_encode(['status' => 'not_exists']);
    }
    $stmt->close();
    $conn->close();
    exit;
}

// Handle full registration form submission
$email = $_POST['email'];
$password = password_hash($_POST['password'], PASSWORD_DEFAULT); // Hash the password for security
$name = $_POST['name'];
$dob = $_POST['dob'];
$gender = $_POST['gender'];
$occupation = $_POST['occupation'];
$city = $_POST['city'];
$mobile = $_POST['mobile'];

// Insert new user into the database
$sql = "INSERT INTO XYZ_PROFILE (Email, Password, Name, DateOfBirth, Gender, Occupation, City, Mobile) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
$stmt = $conn->prepare($sql);
$stmt->bind_param("ssssssss", $email, $password, $name, $dob, $gender, $occupation, $city, $mobile);

if ($stmt->execute()) {
    echo json_encode(['status' => 'success']);
} else {
    echo json_encode(['status' => 'error', 'message' => 'Execution failed: ' . $stmt->error]);
}

$stmt->close();
$conn->close();
?>