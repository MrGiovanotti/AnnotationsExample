# AnnotationsExample
Ejemplo de cómo crear anotaciones personalizadas en Java

En este ejemplo se crea una anotación que convierte un objeto a Json. La anotación es @JsonAttribute.

Cuando se crea una clase de la que se instanciará objetos para ser convertidos a Json, se debe anotar con @JsonAttribute los atributos que se quiere que vayan incluídos en el Json.

Si al anotar con @JsonAttribute, se incluye la propiedad "key"
Ejm:

@JsonAttribute(key = "description")
private String name;

el Json final utilizará este key:
Ejm:

{"description": "Este es el valor del atributo name"}

Y si no se incluye la propiedad "key", el Json final utilizará el nombre del atributo:
Ejm:

@JsonAttribute
private String name;

{"name": "Este es el valor del atributo name"}
