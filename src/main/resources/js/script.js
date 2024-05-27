document.getElementById('registrationForm').addEventListener('submit', function(event) {
    event.preventDefault();
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;

    fetch('/users/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: username,
            password: password
        })
    })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            // 这里可以添加注册成功后的逻辑，例如跳转到登录页面
            window.location.href = 'login.html';
        })
        .catch((error) => {
            console.error('Error:', error);
            // 这里可以添加错误处理逻辑
            alert('An error occurred: ' + error.message);
        });
});
