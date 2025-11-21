# **Actividad 1**

Aplicación **Android** que implementa un sistema básico de **registro** e **inicio de sesión** utilizando almacenamiento local seguro.  
La aplicación permite **registrar usuarios**, **validar credenciales** y **mostrar un saludo personalizado** al iniciar sesión.

Incluye las siguientes pantallas:

### **SplashScreen**
Pantalla de bienvenida con animación.
<div style="text-align:center;">
  <img src="README_images/splash.PNG" alt="Splash de la app" width="250">
</div>

### **RegistrarActivity**
Formulario de registro con validaciones.

<div style="display:flex; justify-content:center; gap:20px;">
  <img src="README_images/registro_normal.PNG" alt="Registro normal" width="250">
  <img src="README_images/registro_error.PNG" alt="Registro con error" width="250">
</div>

### **LoginActivity**
Pantalla de inicio de sesión con comprobación de datos guardados.

<div style="display:flex; justify-content:center; gap:20px;">
  <img src="README_images/login_normal.PNG" alt="Inicio de sesión normal" width="250">
  <img src="README_images/login_error.PNG" alt="Inicio de sesión con error" width="250">
</div>

Proyecto desarrollado como práctica para la **creación de interfaces**, **validación de datos** y **manejo de sesiones** en Android.

## **Selección de colores**

La aplicación utiliza una paleta basada en **tonos morados y rosas**, elegidos por su asociación con lo **mágico**, lo **especial** y lo **desconocido**.  
Estos colores buscan transmitir la idea de que **cada día puede ser algo místico, algo que vale la pena disfrutar y explorar**.  
El diseño visual refuerza así el propósito de la app: inspirar al usuario a vivir su rutina con un sentido de maravilla y descubrimiento.

---

# **Actualización de Main**

## **Vista general de la Pantalla Principal**

La pantalla principal ahora se divide en **dos columnas**:
- Una dedicada a las **tareas activas**.
- Otra para las **tareas que el usuario ya ha completado**.

<table>
  <tr>
    <td style="width:45%; text-align:center;">
      <strong>Tareas activas</strong><br><br>
      <img src="README_images/main_nuevo.PNG" alt="Pantalla principal con tareas" width="250">
    </td>

    <td style="width:2%; border-left: 2px solid #ccc;"></td>

    <td style="width:45%; text-align:center;">
      <strong>Tareas terminadas</strong><br><br>
      <img src="README_images/main_nuevo_tareas_terminadas.PNG" alt="Fragmento de tareas terminadas" width="250">
    </td>
  </tr>
</table>

### **Header con saludo personalizado**

La pantalla incluye un **header** que saluda al usuario utilizando el **nombre introducido en el login**.
