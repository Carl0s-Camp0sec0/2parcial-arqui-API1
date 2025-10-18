package arquitectura._parcial.RespSerie_I;

public @interface PrimeraSerie {
    //Parcial II
    //
    //I Serie
    //1.¿Qué es la arquitectura en capas, y cómo puede diferenciarse del patrón MVC?
    //
    //Es un patrón arquitectónico que organiza el sistema en niveles horizontales, donde cada capa tiene responsabilidades específicas y bien definidas. Típicamente incluye capas como Presentación, Lógica de Negocio, Acceso a Datos y Persistencia. Cada capa solo puede comunicarse con la capa inmediatamente inferior
    //
    //se diferencia en que es un patrón de diseño enfocado principalmente en la capa de presentación, dividiendo la interfaz de usuario en tres componentes interconectados.
    //La arquitectura en capas es un patrón arquitectónico más amplio que abarca todo el sistema, mientras que MVC es específico para estructurar la interacción usuario-aplicación
    //
    //2.¿Cómo se puede aplicar un patrón de diseño para un proyecto de toma de datos meteorológicos?
    //Se puede aplicar el patrón Observer:
    //
    //Las estaciones meteorológicas actúan como el Sujeto que captura datos (temperatura, humedad, presión)
    //Las pantallas de visualización, sistemas de alertas y aplicaciones son los Observadores
    //Cuando cambian las condiciones climáticas, la estación notifica automáticamente a todos los observadores para que actualicen su información
    //
    //
    //3.Realice un diseño arquitectónico basado en la arquitectura orientada a capas para el sistema de la Universidad. El mismo debe tener la conexión con el sistema bancario externo con el que se conecta actualmente, aceptar pagos por medio de aplicación móvil e inscripciones en ambos campus
    //
    //Capa de Presentación
    //- Portal web, aplicación móvil, interfaces administrativas
    //
    //Capa de Lógica de Negocio
    //- Gestión de inscripciones (ambos campus)
    //- Procesamiento de pagos
    //- Validaciones académicas y financieras
    //
    //Capa de Servicios
    //- API para integración con sistema bancario externo
    //- Servicio de pagos móviles
    //- Sincronización entre campus
    //
    //Capa de Datos
    //- Base de datos de información académica
    //- Base de datos financiera
    //- Réplicas en ambos campus
}
