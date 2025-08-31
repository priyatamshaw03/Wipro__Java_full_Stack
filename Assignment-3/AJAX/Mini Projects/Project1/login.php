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

$email = $_POST['email'];
$password = $_POST['password'];

// Fetch the user from the database
$sql = "SELECT Password FROM XYZ_PROFILE WHERE Email = ?";
$stmt = $conn->prepare($sql);
$stmt->bind_param("s", $email);
$stmt->execute();
$stmt->store_result();
$stmt->bind_result($hashed_password);
$stmt->fetch();

if ($stmt->num_rows > 0 && password_verify($password, $hashed_password)) {
    // Password matches, login successful
    echo json_encode(['status' => 'success']);
} else {
    // Invalid credentials
    echo json_encode(['status' => 'error', 'message' => 'Invalid credentials']);
}

$stmt->close();
$conn->close();
?>