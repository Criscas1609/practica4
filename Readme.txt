1.

@Dependent: Esta anotación se utiliza para definir un objeto con un alcance contextual dependiente. En este alcance, se crea
una instancia del objeto para cada objeto que lo inyecta. Esto significa que cada vez que se inyecta una instancia de un objeto
anotado con @Dependent en otra instancia, se producirá una nueva instancia del objeto.

@RequestScoped: Esta anotación se utiliza para definir un objeto con un alcance contextual de solicitud. En este alcance, se
crea una instancia del objeto para cada solicitud HTTP que llega al servidor. Esto significa que cada vez que se realiza una
solicitud HTTP, se genera una nueva instancia del objeto.

@SessionScoped: Esta anotación se utiliza para definir un objeto con un alcance contextual de sesión. En este alcance, se crea
una instancia del objeto para cada sesión HTTP que se inicia. Esto significa que todas las solicitudes realizadas dentro de la
misma sesión HTTP compartirán la misma instancia del objeto.

@ConversationScoped: Esta anotación se utiliza para definir un objeto con un alcance contextual de conversación. En este alcance,
se crea una instancia del objeto para cada conversación que se inicia. Una conversación es un conjunto de solicitudes HTTP
relacionadas que ocurren dentro de un tiempo determinado. Esto significa que todas las solicitudes realizadas dentro de la misma
conversación compartirán la misma instancia del objeto.

@ApplicationScoped: Esta anotación se utiliza para definir un objeto con un alcance contextual de aplicación. En este alcance, se
crea una instancia del objeto cuando se inicia la aplicación y se destruye cuando se detiene la aplicación. Esto significa que todas
las solicitudes realizadas dentro de la aplicación compartirán la misma instancia del objeto.

3.
@Qualifier: Esta anotación se utiliza para definir un identificador para un bean específico en un contenedor de CDI. Permite distinguir
entre beans con la misma interfaz y permite la inyección de beans específicos en los puntos de inyección correspondientes. Por ejemplo,
si hay varias implementaciones de una interfaz, se puede usar @Qualifier para identificar una implementación específica para su uso en
un punto de inyección.

@Alternative: Esta anotación se utiliza para marcar una implementación de una interfaz como una alternativa para la inyección de dependencias
en lugar de otra implementación de la misma interfaz. Si hay varias implementaciones de una interfaz, se puede usar @Alternative para especificar
una implementación alternativa para su uso en un punto de inyección.

@Named: Esta anotación se utiliza para dar un nombre específico a un bean. Permite la inyección de beans específicos en los puntos de inyección
correspondientes usando el nombre en lugar de la clase o la interfaz. Esta anotación es útil cuando se tienen varias implementaciones de una
interfaz y se desea seleccionar una implementación específica para la inyección en un punto de inyección correspondiente.