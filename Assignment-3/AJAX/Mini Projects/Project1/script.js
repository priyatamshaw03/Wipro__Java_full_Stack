$(document).ready(function() {
    // Show/hide forms
    $('#show-login').click(function(e) {
        e.preventDefault();
        $('#registration-form').hide();
        $('#login-form').show();
    });

    $('#show-register').click(function(e) {
        e.preventDefault();
        $('#login-form').hide();
        $('#registration-form').show();
    });

    // Email validation using AJAX
    $('#reg-email').on('blur', function() {
        const email = $(this).val();
        const emailValidationMsg = $('#email-validation-msg');
        
        // Basic email pattern validation
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailPattern.test(email)) {
            emailValidationMsg.text('invalid email-id!').show();
            return;
        }

        // AJAX call to check if email already exists
        $.ajax({
            url: 'register.php',
            type: 'POST',
            data: { email: email, check_email: true },
            success: function(response) {
                if (response.status === 'exists') {
                    emailValidationMsg.text('email already exists!').show();
                } else {
                    emailValidationMsg.text('').hide();
                }
            },
            error: function() {
                emailValidationMsg.text('Error checking email.').show();
            }
        });
    });

    // Handle Registration Form Submission
    $('#registerForm').submit(function(e) {
        e.preventDefault();
        
        const emailValidationMsg = $('#email-validation-msg');
        if (emailValidationMsg.text() !== '') {
            // Don't submit if email validation failed
            return;
        }

        const formData = $(this).serialize();
        
        $.ajax({
            url: 'register.php',
            type: 'POST',
            data: formData,
            success: function(response) {
                if (response.status === 'success') {
                    alert('Registration successful!');
                    window.location.href = 'login.html'; // Redirect to a separate login page
                    // Or, if login form is on same page:
                    // $('#registration-form').hide();
                    // $('#login-form').show();
                } else {
                    alert('Registration failed: ' + response.message);
                }
            },
            error: function() {
                alert('An error occurred during registration.');
            }
        });
    });

    // Handle Login Form Submission
    $('#loginForm').submit(function(e) {
        e.preventDefault();
        
        const formData = $(this).serialize();
        const loginErrorMsg = $('#login-error-msg');

        $.ajax({
            url: 'login.php',
            type: 'POST',
            data: formData,
            success: function(response) {
                if (response.status === 'success') {
                    window.location.href = 'home.html';
                } else {
                    loginErrorMsg.text('Invalid Credentials').show();
                }
            },
            error: function() {
                loginErrorMsg.text('An error occurred during login.').show();
            }
        });
    });
});