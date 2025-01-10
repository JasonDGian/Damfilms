async function validarFormulario() {
  // Variable de tipo de documento para query
  const formulario = document.querySelector('.form');
  // Obtener los valores de los campos
  var email = document.getElementById('email').value;
  var nombre = document.getElementById('nombre').value;
  var password = document.getElementById('password').value;
  var confirmPassword = document.getElementById('password2').value;
  var tipoSuscripcion = document.getElementById('tipo-suscripcion').value;

  // Expresiones regulares para validaciones
  var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  var nombreRegex = /^[a-zA-Z]{3,}$/;
  var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[A-Za-z\d]{5,}$/;
  
  // Validar nombre
  if (!nombreRegex.test(nombre)) {
    document.getElementById('nombre-error').innerHTML = 'El nombre debe tener al menos 3 letras.';
    return false;
} else {
    document.getElementById('nombre-error').innerHTML = '';
}

  // Validar email
  if (!emailRegex.test(email)) {
      document.getElementById('email-error').innerHTML = 'Ingrese un email válido.';
      return false;
  } else {
      document.getElementById('email-error').innerHTML = '';
  }
  // Validar contraseña
  if (!passwordRegex.test(password)) {
      document.getElementById('password-error').innerHTML = 'La contraseña debe contener al menos una mayúscula, una minúscula, un número y un símbolo especial, y tener al menos 5 caracteres.';
      return false;
  } else {
      document.getElementById('password-error').innerHTML = '';
  }

  // Validar que las contraseñas coincidan
  if (password !== confirmPassword) {
    document.getElementById('password-error').innerHTML = 'Las contraseñas no coinciden.';
    return false;
  } else {
    document.getElementById('password-error').innerHTML = '';
  }
  
  // Crear un objeto JSON con los datos del formulario
  var data = {
    email: email,
    nombreUsuario: nombre,
    password: password,
    nombreSuscripcion: tipoSuscripcion
  };

  try {
    // Enviar los datos a la API
    const response = await fetch('http://localhost:8080/signup', { //Aqui faltaria la direccion de la API y ya intentar introducir usuarios
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    });

    if (!response.ok) {
      // Manejo de errores del servidor
      const errorData = await response.json();
      alert('Error al registrar: ' + (errorData.message || 'Error desconocido.'));
      return false;
    }

    // Si el envío fue exitoso, redirigir al usuario
    alert('Registro exitoso. Redirigiendo...');
    window.location.href = "home.html";
  } catch (error) {
    // Manejo de errores de red
    console.error('Error al conectarse a la API:', error);
    alert('Hubo un error al conectarse al servidor. Intenta nuevamente más tarde.');
    return false;
  }
}
//Boton para ocultar o ver la contraseña
function togglePasswordVisibility() {
  var passwordInput = document.getElementById('password');
  var showPasswordButton = document.getElementById('show-password');

  if (passwordInput.type === 'password') {
    passwordInput.type = 'text';
  } else {
    passwordInput.type = 'password';
  }
}
//Boton para ocultar o ver la contraseña en la confirmación de la misma durante el registro
function toggleConfirmPasswordVisibility() {
  var passwordInput = document.getElementById('password2');
  var showPasswordButton = document.getElementById('show-password2');

  if (passwordInput.type === 'password') {
    passwordInput.type = 'text';
  } else {
    passwordInput.type = 'password';
  }
}