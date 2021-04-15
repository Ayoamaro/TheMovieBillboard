## Inicio de sesión

Al iniciar la aplicación, tendremos que introducir nuestro usuario y contraseña para poder pasar a la gestión de películas. A día de hoy, existen 2 tipos de usuarios, los cuáles son:

- **Admin**: es el rol más completo, ya que tiene todos los permisos de la aplicación y la gestión de la base de datos. Enfocado aquellos usuarios experimentas en el campo. Disponen de:

  - Creación de nuevos registros
  - Actualización de los registros ya existentes
  - Eliminación de los registros
  - Visualización de los detalles

- **User**: es un rol muy limitado ya que está pensado para usuarios con poco conocimiento en el campo y que solo buscan información sobre las películas. Se les permitirá:

  - Visualización de los detalles
  - Exportar los datos en formato PDF

  

![img](https://i.imgur.com/bguJrvh.gif)



## Crear registros

Al usuario **admin**, se le permitirá crear nuevos registros donde se le pedirá un **ID**, **Nombre**, **Año**, **País**, **Director** y **Género** (en este caso será por valor numérico). Tras rellenar los datos este podrá efectuar los cambios y el nuevo registro se añadirá a la *TableView* con el contenido de la base de datos.



![img](https://i.imgur.com/7oX2dKl.gif)



## Editar registros

Nuevamente el usuario **admin**, podrá seleccionar uno de los registros existentes y cambiarle sus parámetros ya establecidos. Tras hacerlo podrá introducir un nuevo **ID**, **Nombre**, **Año**, **País**, **Director** y **Género**, si lo ve oportuno. Estos cambios se reflejarán tanto en la *TableView* con en la base de datos de la aplicación.



![img](https://i.imgur.com/zf6tf5u.gif)



## Eliminar registros

Por último el usuario **admin**, tendrá el poder de borrar registros existentes en la base de datos. Esto permitirá eliminar todas aquellas películas que ya no necesite para así dar paso a nuevos estrenos. La eliminación de estos datos se realizará de manera inmediata tanto en la *TableView* con en la base de datos de la aplicación.



![img](https://imgur.com/3jdvpPj.gif)



## Ver detalles

Tanto a **user** como **admin**, tendrán esta opción disponible. Ambos podrá seleccionar un registro y consultar la información de este. Con esta opción tendremos la posibilidad de ver el género de la película en vez del "Tipo numérico" que se muestra en la *TableView* de nuestra aplicación.



![img](https://imgur.com/Msa1Q7a.gif)



## Otras funciones

Por último, en el menú principal de la barra superior tendremos las siguientes opciones: 

- Exportar a PDF: se creará un archivo PDF con todos los registros existentes de la base de datos al momento que la realicemos.
- Reportar un problema: nos redirigirá a la pestaña "Issues" del repositorio de GitHub de este proyecto
- Acerca de: dispondrá de las redes sociales del desarrollador de la aplicación
  - Github
  - LinkedIn